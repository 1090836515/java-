package OperatingSystem;

/**
 * 1.IO的两个阶段：
 *      1.数据准备阶段
 *      2.内核空间复制回用户进程缓冲区阶段
 * 2.同步IO与异步IO:区别在于IO的两个阶段需要等待（可能只是其中一个阶段需要等待），同步非阻塞也需要不断地系统调用来直到数据是否准备好，只有知道数据没
 *      准备好之后才是非阻塞；异步不需要等待，可以一边等数据准备好一边做别的事。
 * 3.同步和异步的概念描述的是用户线程与内核的交互方式：同步是指用户线程发起IO请求后需要等待或者轮询内核IO操作完成后才能继续执行；
 *      而异步是指用户线程发起IO请求后仍继续执行，当内核IO操作完成后会通知用户线程，或者调用用户线程注册的回调函数。
 * 4.IO多路复用：通过select函数，用户可以注册多个Socket,达到一个线程可以处理多个IO请求。
 * 5.（1）传统IO模型一个连接一个线程处理，然后遍历连接，CPU光遍历连接就已经满负荷。耗费大量线程，频繁切换线程环境，只适合低并发应用。
 *   （2）进一步，可以一个线程管理多个socket(也就是多个fd)，这也是NIO中的select机制。虽然降低了线程数，提高了并发能力，但遍历的瓶颈一直都在。
 *   （3）问题最终由异步机制搞定。linux内核2.6版本提出了新的多路复用机制 epoll，套接字提供了回调函数，内核从网卡读取数据后就会回调该函数。
 * 6.Linux下的select、poll和epoll就是干这个的。将用户socket对应的fd注册进epoll，然后epoll帮你监听哪些socket上有消息到达，这样就避免了大量
 *      的无用操作。此时的socket应该采用非阻塞模式。这样，整个过程只在调用select、poll、epoll这些调用的时候才会阻塞，收发客户消息是不会阻塞的，
 *      整个进程或者线程就被充分利用起来，这就是事件驱动，所谓的reactor模式。
 */
public class IO {
}