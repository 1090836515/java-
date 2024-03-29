package Map;

/**
 * 1.基本原理：内存地址V，旧的预期值A，要修改的新值B，更新一个变量的时候，只有当变量的旧的预期值A和内存地址V中的值相同的时候，才会将内存地址V中的值
 *      更新为新值B
 * 2.CAS机制的缺点：
 *      1.CPU开销过大：在并发量比较高的情况下，如果许多线程反复尝试去更新一个变量，却又一直更新失败，循环往复，会消耗CPU很多资源
 *      2.ABA问题：内存地址中V中的变量已经经历了A->B->A的改变；ABA问题解决的方案：在Compare阶段不仅比较预期值和此时内存中的值，还比较两个比较
 *          变量的版本号是否一致，只有当版本号一致才进行后续操作。
 *      3.不能保证代码块的原子性：CAS机制保证的是一个变量的原子性操作，若要保证多个变量的原子性操作，可以封装在一起，但是这样得不偿失，开销太大，
 *          还不如直接采用synchorized同步锁
 */
public class CAS {
}
