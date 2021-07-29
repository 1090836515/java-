package 计算机网络;

/**
 * 1.每发送一个http请求就创建一个线程，HTTP是为进程服务的，不同的进程之间进行通讯要建立TCP连接，比如前端与后端各自有自己的端口号，属于不同的进程，
 *      每次发送http请求时会创建一个线程请求资源，http1.0时时短链接，每次http请求都要重新建立tcp连接，http1.1时是长连接，多次http请求都通过同一个tcp
 *      连接通讯，而且不必等上一个http请求结果返回就可以发送下一次http请求，但请求结果最终必须按请求顺序返回，而且长连接也对同一域名下的请求数量有着限制，
 *      http请求太多也会让未处理的请求进行排队，而http2.0可以实现多路复用，在一个TCP连接同时进行多个http请求。
 *
 */
public class 进程与线程与TCP连接 {
}
