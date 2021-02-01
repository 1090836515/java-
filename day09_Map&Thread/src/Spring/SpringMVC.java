package Spring;

/**
 * 1.Spring MVC是Spring的一个模块，式一个web框架。通过Dispatcher Servlet, ModelAndView 和 View Resolver，Controller，开发web应用
 *      变得很容易。解决的问题领域是网站应用程序或者服务开发——URL路由、Session、模板引擎、静态Web资源等等。
 * 2.springMVC执行流程：
 *      （1）客户端（浏览器）发送请求，直接请求到 DispatcherServlet。
 *      （2）DispatcherServlet 根据请求信息调用 HandlerMapping，解析请求对应的 Handler。
 *      （3）解析到对应的 Handler（也就是我们平常说的 Controller 控制器）后，开始由 HandlerAdapter 适配器处理。
 *      （4）HandlerAdapter 会根据 Handler 来调用真正的处理器开处理请求，并处理相应的业务逻辑。
 *      （5）处理器处理完业务后，会返回一个 ModelAndView 对象，Model 是返回的数据对象，View 是个逻辑上的 View。
 *      （6）ViewResolver 会根据逻辑 View 查找实际的 View,解析。
 *      （7）DispaterServlet 把返回的 Model 传给 View（视图渲染），对View视图进行渲染。
 *      （8）把 View 返回给请求者（浏览器）
 * 3.SpringMVC与SpringBoot的区别：
 *      （1）springboot是约定大于配置，可以简化spring的配置流程；springmvc是基于servlet的mvc框架。
 *      （2）以前web应用要使用到tomcat服务器启动，而springboot内置服务器容器，通过@SpringBootApplication中注解类中main函数启动即可。
 *      （4）Spring MVC 是基于Spring的一个 MVC 框架 ；Spring Boot 是基于Spring4的条件注册的一套快速开发整合包。
 * 4.servlet的生命周期：
 *      1.创建实例：在默认情况下Servlet实例是在第一个请求到来的时候创建，通过服务器反射机制创建，以后复用（单例）。
 *      2.初始化： 一旦Servlet实例被创建，Web服务器会自动调用init(ServletConfig config)方法来初始化该Servlet。其中方法参数config中包含了
 *          Servlet的配置信息，比如初始化参数，该对象由服务器创建；在Servlet的生命周期中，该方法执行一次；该方法执行在单线程的环境下，因此开发者
 *          不用考虑线程安全的问题，在执行过程中可以抛出ServletException来通知Web服务器Servlet实例初始化失败。一旦ServletException抛出，
 *          Web服务器不会将客户端请求交给该Servlet实例来处理，而是报告初始化失败异常信息给客户端，该Servlet实例将被从内存中销毁。如果在来新的请求，
 *          Web服务器会创建新的Servlet实例，并执行新实例的初始化操作。
 *      3.服务：一旦Servlet实例成功创建及初始化，该Servlet实例就可以被服务器用来服务于客户端的请求并生成响应。在服务阶段Web服务器会调用该实例的
 *              service(ServletRequest request, ServletResponse response)方法，request对象和response对象有服务器创建并传给Servlet
 *              实例。request对象封装了客户端发往服务器端的信息，response对象封装了服务器发往客户端的信息；为了提高效率，Servlet规范要求一个
 *              Servlet实例必须能够同时服务于多个客户端请求，即service()方法运行在多线程的环境下，Servlet开发者必须保证该方法的线程安全性，
 *              只是访问各自的成员变量的话不需要考虑线程安全问题。
 *      4.销毁：当Web服务器认为Servlet实例没有存在的必要了，比如应用重新装载，或服务器关闭，以及Servlet很长时间都没有被访问过。服务器可以从内存
 *              中销毁（也叫卸载）该实例。Web服务器必须保证在卸载Servlet实例之前调用该实例的destroy()方法，一旦destroy()方法已经执行，Web服务器
 *              将拒绝所有的新到来的对该Servlet实例的请求以便回收Servlet申请的资源或进行其它的重要的处理。
 * 5.SpringMVC 重要组件说明
 *      1、前端控制器DispatcherServlet（不需要工程师开发）,由框架提供（重要）
 *          作用：Spring MVC 的入口函数。接收请求，响应结果，相当于转发器，中央处理器。有了 DispatcherServlet 减少了其它组件之间的耦合度。
 *          用户请求到达前端控制器，它就相当于mvc模式中的c，DispatcherServlet是整个流程控制的中心，由它调用其它组件处理用户的请求，
 *          DispatcherServlet的存在降低了组件之间的耦合性。
 *      2、处理器映射器HandlerMapping(不需要工程师开发),由框架提供
 *          作用：根据请求的url查找Handler。HandlerMapping负责根据用户请求找到Handler即处理器（Controller），SpringMVC提供了不同的映射
 *          器实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等。
 *      3、处理器适配器HandlerAdapter
 *          作用：按照特定规则（HandlerAdapter要求的规则）去执行Handler 通过HandlerAdapter对处理器进行执行，这是适配器模式的应用，通过扩展
 *          适配器可以对更多类型的处理器进行执行。
 *      4、处理器Handler(需要工程师开发)
 *          注意：编写Handler时按照HandlerAdapter的要求去做，这样适配器才可以去正确执行Handler Handler 是继DispatcherServlet前端控制器
 *          的后端控制器，在DispatcherServlet的控制下Handler对具体的用户请求进行处理。 由于Handler涉及到具体的用户业务请求，所以一般情况需
 *          要工程师根据业务需求开发Handler。
 *      5、视图解析器View resolver(不需要工程师开发),由框架提供
 *          作用：进行视图解析，根据逻辑视图名解析成真正的视图（view） View Resolver负责将处理结果生成View视图，View Resolver首先根据逻辑视
 *          图名解析成物理视图名即具体的页面地址，再生成View视图对象，最后对View进行渲染将处理结果通过页面展示给用户。 springmvc框架提供了很多
 *          的View视图类型，包括：jstlView、freemarkerView、pdfView等。 一般情况下需要通过页面标签或页面模版技术将模型数据通过页面展示给用户，需要由工程师根据业务需求开发具体的页面。
 *      6、视图View(需要工程师开发)
 *          View是一个接口，实现类支持不同的View类型（jsp、freemarker、pdf...）
 *          注意：处理器Handler（也就是我们平常说的Controller控制器）以及视图层view都是需要我们自己手动开发的。其他的一些组件比如：前端控制
 *          器DispatcherServlet、处理器映射器HandlerMapping、处理器适配器HandlerAdapter等等都是框架提供给我们的，不需要自己手动开发。
 */
public class SpringMVC {
}
