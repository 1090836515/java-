package 计算机网络;

/**
 * ⑴物理层: 将数据转成比特，在链路上传输；物理层的任务就是透明地传送比特流，确定连接电缆插头的定义及连接法。
 * ⑵数据链路层: 物理地址相邻结点传输数据，两个主机之间的数据传输，总是在一段一段的链路上传送的，好比两个国家之间要来往需要先坐出租车再坐飞机再坐出租车；
 *      数据链路层的任务是在两个相邻结点间的线路上无差错地传送以帧（frame）为单位的数据。每一帧包括数据和必要的控制信息。
 * ⑶网络层: 封装成IP数据包，IP 协议【路由器转发数据】；网络层的任务就是要选择合适的路由，通过ARP协议找到MAC地址，使发送站的运输层所传下来的分组能够正确无误地
 *      按照地址找到目的站，并交付给目的站的运输层。
 * ⑷运输层:负责向两个主机中进程之间的通信提供服务，为应用层提供服务， TCP和UDP；运输层的任务是向上一层的进行通信的两个进程之间提供一个可靠的端到端服务，使它们看不见
 *      运输层以下的数据通信的细节。
 * ⑸应用层:应用层直接为用户的应用进程提供服务。在因特网中的应用层协议很多，如支持万维网应用的HTTP协议，支持电子邮件的SMTP协议，支持文件传送的FTP协议等等
 */
public class 网络分层 {
}
