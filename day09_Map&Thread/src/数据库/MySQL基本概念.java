package 数据库;

import java.util.ArrayList;

/**
 * 1.存储过程：存储过程就像我们编程语言中的函数一样，优点：封装了我们的代码。能够将代码封装起来保存在数据库之中让编程语言进行调用，存储过程
 *      是一个预编译的代码块，执行效率比较高。缺点：每个数据库的存储过程语法几乎都不一样，十分难以维护（不通用）；业务逻辑放在数据库上，难以
 *      迭代。
 * 2.三大范式：第一范式：字段是最小的的单元不可再分。第二范式：满足第一范式,表中的字段必须完全依赖于全部主键而非部分主键。
 *      第三范式（3NF）：在2NF的基础上，任何的非主属性不依赖于其他非主属性 （在第二范式基础上消除传递依赖）
 * 3.事务四大特性：
 *      1.原子性（Atomicity）： 事务是最小的执行单位，不允许分割。事务的原子性确保动作要么全部完成，要么完全不起作用；
 *      2.一致性（Consistency）： 执行事务前后，数据保持一致，多个事务对同一个数据读取的结果是相同的；
 *      3.隔离性（Isolation）： 并发访问数据库时，一个用户的事务不被其他事务所干扰，各并发事务之间数据库是独立的；
 *      4.持久性（Durability）： 一个事务被提交之后。它对数据库中数据的改变是持久的，即使数据库发生故障也不应该对其有任何影响。
 * 4.并发事务带来的问题：
 *      脏读：一个事务读取到另外一个事务未提交的数据
 *      不可重复读：一个事务读取到另外一个事务已经提交的数据，也就是说一个事务可以看到其他事务所做的修改
 *      虚读(幻读)：与不可重复读类似是指在一个事务内读取到了别的事务插入的数据，第一个事务（T1）就会发现多了一些原本不存在的记录，就好像发生
 *      了幻觉一样。
 * 5.事务隔离级别：
 *      READ-UNCOMMITTED(读取未提交)： 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读。
 *      READ-COMMITTED(读取已提交)： 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生。
 *      REPEATABLE-READ(可重复读)： 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，
 *          但幻读仍有可能发生。
 *      SERIALIZABLE(可串行化)： 最高的隔离级别，完全服从ACID的隔离级别。所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，
 *      也就是说，该级别可以防止脏读、不可重复读以及幻读。
 * 6.drop,delete,truncate的使用区别：
 *      不再需要一张表的时候，用drop
 *      想删除部分数据行时候，用delete，并且带上where子句
 *      保留表而删除所有数据的时候用truncate
 * 7.数据库的存储引擎：
 *      （1）MyISAM:是MySQL的默认数据库引擎（5.5版之前），查询与添加不用支持事务所以速度快，支持表级锁，不支持外键，不支持MVCC多版
 *          本控制，支持全文索引但不支持哈希索引，存储容量没有上限；存储结构为B+树，B+树的数据结构中存储的内容实际上是实际数据的地址值，
 *          也就是说它的索引和实际数据是分开的，只不过使用索引指向了实际数据。这种索引的模式被称为非聚集索引。
 *      （2）InnoDB:MySQL 5.5版本后默认的存储引擎为InnoDB,事务安全，支持行和表级锁，支持哈希索引但不支持全文索引，支持外键，存储容量
 *          64TB,唯一支持MVCC，应对高并发事务, MVCC比单纯的加锁更高效;MVCC只在 READ COMMITTED 和 REPEATABLE READ两个隔离级别
 *          下工作;MVCC可以使用乐观(optimistic)锁和悲观(pessimistic)锁来实现;各数据库中MVCC实现并不统一；存储结构为B+树，只不过
 *          数据结构中存储的都是实际的数据，这种索引有被称为聚集索引；另外也支持哈希索引
 *      （3）MEMORY引擎：所有的数据都在内存中，数据的处理速度快，但是安全性不高
 * 8.redo log与binlog（binary）的区别：
 *      1.redo log 是物理日志，记录的是“在某个数据页上做了什么修改”；binlog 是逻辑日志，记录的是这个语句的原始逻辑，statement格式记录的是sql语句，
 *              row格式记录的是行的内容，记两条，更新前和更新后的都有，记录的是比如“给 ID=2 这一行的 c 字段加 1 ”。
 *      2.redo log 是循环写的，，不持久保存，空间固定会用完；binlog 是可以追加写入的。“追加写”是指 binlog 文件写到一定大小后会切换到下一个，并不会覆盖以前的日志。
 *      3.redo log 是 InnoDB 引擎特有的；binlog 是 MySQL 的 Server 层实现的，所有引擎都可以使用。
 */
public class MySQL基本概念 {
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(input, k);
        for(int i : arrayList) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < input.length - 1; i++) {
            for(int j = 0; j < input.length - i - 1; j++) {
                if(input[j] > input[j+1]) {
                    int tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
        }
        for(int m = 0; m < k; m++) {
            res.add(input[m]);
        }
        return res;
    }
}
