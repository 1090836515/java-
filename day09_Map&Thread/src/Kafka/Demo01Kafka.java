package Kafka;

/**
 * 1.Kafka是一个消息队列，把消息放到队列里边的叫生产者，从队列里边消费的叫消费者。一个消息中间件，队列不单单只有一个，
 *      我们往往会有多个队列,队列叫做topic
 * 2.使用消息队列不可能是单机的（必然是分布式or集群）
 * 3.天然分布式：为了提高吞吐量，Kafka会把topic进行分区(Partition)，Kafka集群是由多台Kafka服务器组成，每台服务器
 *      又叫做Broker,一个队列的多个分区分布在多个Broker里，由此得知：Kafka是天然分布式的
 * 4.高可用：每个partition都会备份，这些备份散落在不同的broker上，生产者往topic丢数据，是与主分区交互，消费者消费topic
 *      的数据，也是与主分区交互。备份分区仅仅用作于备份，不做读写。如果某个Broker挂了，那就会选举出其他Broker的
 *      partition来作为主分区，这就实现了高可用。
 * 5.消息的持久化：Kafka是将partition的数据写在磁盘的(消息日志)，不过Kafka只允许追加写入(IO顺序访问)，避免缓慢的随机
 *      I/O 操作。Kafka也不是partition一有数据就立马将数据写到磁盘上，它会先缓存一部分，等到足够多数据量或等待一定的
 *      时间再批量写入(flush)。
 * 6.多个消费者可以组成一个消费者组,允许consumer group（包含多个consumer，如一个集群同时消费）对一个topic进行消费，
 *      不同的consumer group之间独立消费,一个partition只能被组里的一个消费者消费（一个消费者可以同时消费多个partition）
 * 7.Kafka就是用offset来表示消费者的消费进度到哪了，每个消费者会都有自己的offset。说白了offset就是表示消费者的消费进度，
 *      offset在broker以内部topic(__consumer_offsets)的方式来保存起来。每次消费者消费的时候，都会提交这个offset，
 *      Kafka可以让你选择是自动提交还是手动提交。如果一个消费者组中的某个消费者挂了，那挂掉的消费者所消费的分区可能就由
 *      存活的消费者消费。
 * 8.Zookeeper负责维护所有partition的领导者/从属者关系（主分区和备份分区），如果主分区挂了，需要选举出备份分区作为主分区；
 *      探测broker和consumer的添加或移除；维护topic、partition等元配置信息
 *
 */
public class Demo01Kafka {
}
