package Map;

/**
 * 1. 乐观锁/悲观锁：
 *      乐观锁：总是认为不存在并发问题，每次去取数据的时候，总认为不会有其他线程对数据进行修改，因此不会上锁。
 *              但是在更新时会判断其他线程在这之前有没有对数据进行修改，一般会使用“数据版本机制”或“CAS操作”来实现。
 *      悲观锁：认为对于同一个数据的并发操作，一定会发生修改的，哪怕没有修改，也会认为修改。因此对于同一份数据的并发操作，
 *              悲观锁采取加锁的形式。悲观的认为，不加锁并发操作一定会出问题。
 * 2.独享锁（互斥锁）/共享锁：独享锁是指该锁一次只能被一个线程所持有。共享锁是指该锁可被多个线程所持有。对于
 *      Java ReentrantLock而言，其是独享锁。但是对于Lock的另一个实现类ReadWriteLock，其读锁是共享锁，其写锁是独享锁。
 *      读锁的共享锁可保证并发读是非常高效的，读写，写读，写写的过程是互斥的。独享锁与共享锁也是通过AQS来实现的，通过实现不
 *      同的方法，来实现独享或者共享。对于Synchronized而言，当然是独享锁。
 * 3.可重入锁：可重入锁又名递归锁，是指在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。对于ReetrantLock
 *      而言，从名字就可以看出是一个重入锁，Synchronized也是一个可重入锁。可重入锁的一个好处是可一定程度避免死锁。
 * 4.公平锁/非公平锁：公平锁是指多个线程按照申请锁的顺序来获取锁。非公平锁是指多个线程获取锁的顺序并不是按照申请锁的顺序。
 *      　Java ReetrantLock通过构造函数指定该锁是否是公平锁，默认是非公平锁。非公平锁的优点在于吞吐量比公平锁大。　
 *        Synchronized也是一种非公平锁。构造公平锁：new ReentrantLock(true)；
 * 5. 偏向锁/轻量级锁/重量级锁：这三种锁的状态是通过对象监视器在对象头中的字段来表明的。偏向锁是指一段同步代码一直被一个线程所
 *      访问，那么该线程会自动获取锁。降低获取锁的代价。轻量级锁是指当锁是偏向锁的时候，被另一个线程所访问，偏向锁就会升级为轻
 *      量级锁，其他线程会通过自旋的形式尝试获取锁，不会阻塞，提高性能。重量级锁是指当锁为轻量级锁的时候，另一个线程虽然是自旋，
 *      但自旋不会一直持续下去，当自旋一定次数的时候，还没有获取到锁，就会进入阻塞，该锁膨胀为重量级锁。重量级锁会让他申请的线
 *      程进入阻塞，性能降低。
 * 6.自旋锁：在Java中，自旋锁是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程上下文切换
 *      的消耗，缺点是循环会消耗CPU。
 * 7.AQS:AbstractQueuedSynchronized 抽象队列式的同步器,AQS定义了一套多线程访问共享资源的同步器框架，许多同步类实现都
 *      依赖于它，如常用的ReentrantLock/Semaphore/CountDownLatch…
 * 8.AQS维护了一个volatile int state(代表共享资源)和一个FIFO线程等待队列（多线程争用资源被阻塞时会进入此队列）,
 *      以ReentrantLock为例，state初始化为0，表示未锁定状态。A线程lock()时，会调用tryAcquire()独占该锁并将state+1。
 *      此后，其他线程再tryAcquire()时就会失败，直到A线程unlock()到state=0（即释放锁）为止，其他线程才有机会获取该锁。
 *      当然，释放锁之前，A线程自己是可以重复获取此锁的（state会累加），这就是可重入的概念。但要注意，获取多少次就要释放
 *      多少次，这样才能保证state是能回到零态的。
 * 9.再以CountDownLatch为例，任务分为N个子线程去执行，state为初始化为N（注意N要与线程个数一致）。这N个子线程是并行执行的，
 *      每个子线程执行完后countDown()一次，state会CAS减1。等到所有子线程都执行完后（即state=0）,会unpark()主调用线程
 * 10.AQS实现原理：AQS会把申请锁的线程封装成一个node类型的节点，加入到同步队列中。而且还有两个prev和next分别指向前驱节点和后继节点，也就说明了这是一个双向队列；
 *      节点是用来保存争夺锁失败的线程，然后把它们放到一个同步队列中，当锁被释放时，再从同步队列中依次取出线程获得锁。
 *      流程：线程获取锁，如果获取成功，就执行并且退出返回了。如果获取不成功，就把它封装成一个节点，放到同步队列的队尾，这个时候是需要CAS设置的。
 *      然后进入同步队列之后，就开始自旋，判断前驱节点是不是头结点，如果是就获取同步状态，获取失败或者前驱不是头结点，线程就继续等待。直到获取成功，
 *      然后当前节点设置为头节点。当一个节点放到尾节点的时候，需要用CAS，因为有可能是多个节点同时往尾节点上加，而设置头节点时却不需要，因为每次只有一个。
 * 11.独占模式下的获取：
 *      AQS的模板方法acquire通过调用子类自定义实现的tryAcquire获取同步状态失败后->将线程构造成Node节点(addWaiter)->将Node
 *          节点添加到同步队列对尾(addWaiter)->节点以自旋的方法获取同步状态(acquirQueued)，首先会判断当前节点的前驱节点是否为头节点，如果是才会尝试获取
 *          同步状态，但这个自旋的过程也不会一直进行，如果该节点的前驱不是头节点或者该节点的前驱节点是头节点单获取同步状态失败，则判断当前线程需要阻塞，如果
 *          需要阻塞则需要被唤醒过后才返回。（公平锁，非公平锁直接尝试获取锁，不进入等待队列）
 *    独占模式同步状态的释放：
 *          首先减去releases(一般为1)表示释放一个锁，如果释放后state=0表示释放锁成功，后续等待的节点可以获取该锁了。如果state!=0则表示该锁为重入锁，
 *          需要多次释放。当释放锁成功后(state=0)，会对头结点的后继节点进行unpark，唤醒后继节点,在唤醒的过程中,需要判断后继节点是否满足情况,如果后继节点
 *          不为且不是作废状态(排除掉状态为cancel即waitStatus > 0的节点),则唤醒这个后继节点,否则从tail（尾）节点向前寻找合适的节点,如果找到,则唤醒。
 *    可重入锁的实现：在获取锁的逻辑中首先是尝试以cas方式获取锁，如果获取失败则表示锁已经被线程持有。再判断持有该锁的线程是否为当前线程，如果是当前线程
 *          就将state的值加1，在释放锁是也需要释放多次。这就是可重入锁的实现。
 *    （非）公平锁的实现：方法逻辑很简单，就是如果等待队列还有节点并且排在首位的不是当前线程所处的节点返回true表示还有等待更长时间的节点。需要等这
 *          部分节点获取资源后才能获取
 */
public class 锁分类 {
}
