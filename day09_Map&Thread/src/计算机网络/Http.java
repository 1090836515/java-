package 计算机网络;

/**
 * 1.HTTP1.0与HTTP1.1:
 *      HTTP/1.0：中默认使用短连接。HTTP 1.0规定浏览器与服务器只保持短暂的连接，浏览器的每次请求都需要与服务器建立一个TCP连接，
 *          服务器完成请求处理后立即断开TCP连接，服务器不跟踪每个客户也不记录过去的请求。
 *      HTTP/1.1：默认使用长连接，用以保持连接特性。HTTP 1.1支持持久连接（HTTP/1.1的默认模式使用带流水线的持久连接），在一个TCP连接上可以传送
 *          多个HTTP请求和响应，减少了建立和关闭连接的消耗和延迟。一个包含有许多图像的网页文件的多个请求和应答可以在一个连接中传输，但每个单独的网页文件
 *          的请求和应答仍然需要使用各自的连接。HTTP 1.1还允许客户端不用等待上一次请求结果返回，就可以发出下一次请求，但服务器端必须按照接收到客户端
 *          请求的先后顺序依次回送响应结果，以保证客户端能够区分出每次请求的响应内容，这样也显著地减少了整个下载过程所需要的时间。
 *      HTTP2.0:多路复用允许同时通过单一的 HTTP/2 连接发起多重的请求-响应消息。在 HTTP/1.1 协议中浏览器客户端在同一时间，针对同一域名下的请求
 *          有一定数量限制。超过限制数目的请求会被阻塞。HTTP/2 可以很容易的去实现多流并行而不用依赖建立多个 TCP 连接
 *      长连接:当一个网页打开完成后，客户端和服务器之间用于传输HTTP数据的TCP连接不会关闭，客户端再次访问这个服务器时，会继续使用这一条已经建立的连接。
 *          Keep-Alive不会永久保持连接，它有一个保持时间，可以在不同的服务器软件（如Apache）中设定这个时间。实现长连接需要客户端和服务端都支持长连接
 * 2.HTTP与HTTPS:
 *      1.HTTPS协议需要到CA申请证书，一般免费证书很少，需要交费。
 *      2.HTTP协议运行在TCP之上，所有传输的内容都是明文，HTTPS运行在SSL/TLS之上，SSL/TLS运行在TCP之上，所有传输的内容都经过加密的。
 *      3.HTTP和HTTPS使用的是完全不同的连接方式，用的端口也不一样，前者是80，后者是443。
 *      4.HTTPS可以有效的防止运营商劫持，解决了防劫持的一个大问题。
 * 3.Http协议与TCP/IP协议之间的关系：HTTP的长连接和短连接本质上是TCP长连接和短连接。HTTP属于应用层协议，在传输层使用TCP协议，在网络层使用IP协议。
 *      IP协议主要解决网络路由和寻址问题，TCP协议主要解决如何在IP层之上可靠地传递数据包，使得网络上接收端收到发送端所发出的所有包，并且顺序与发送顺序
 *      一致。TCP协议是可靠的、面向连接的。
 * 4.HTTP协议是无状态的，指的是协议对于事务处理没有记忆能力，服务器不知道客户端是什么状态。也就是说，打开一个服务器上的网页和上一次打开这个服务器上
 *      的网页之间没有任何联系。那么我们保存用户状态呢？Session 机制的存在就是为了解决这个问题，Session 的主要作用就是通过服务端记录用户的状态。
 *      典型的场景是购物车，当你要添加商品到购物车的时候，系统不知道是哪个用户操作的，因为 HTTP 协议是无状态的。服务端给特定的用户创建特定的 Session
 *      之后就可以标识这个用户并且跟踪这个用户了（一般情况下，服务器会在一定时间内保存这个 Session，过了时间限制，就会销毁这个Session）。
 * 5.HTTP协议的工作流程：DNS解析->TCP连接发送->HTTP请求服务器->服务器处理请求并返回HTTP报文->浏览器解析页面（HTML代码）并请求js、css、图片等
 *      资源进行页面渲染->连接结束（DNS解析的过程：查询浏览器自身缓存->查询OS自身缓存->读取hosts文件：C:\Windows\System32\drivers\etc\hosts
 *      ->向本地DNS服务器请求）
 * 6.HTTP连接使用的是“请求—响应”的方式，不仅在请求时需要先建立连接，而且需要客户端向服务器发出请求后，服务器端才能回复数据。HTTP使用TCP而不是UDP
 *      的原因在于（打开）一个网页必须传送很多数据，而TCP协议提供传输控制，按顺序组织数据，和错误纠正
 */
public class Http {
}
