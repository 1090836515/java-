package Spring;

/**
 * 1.Spring Boot本身并不提供Spring框架的核心特性以及扩展功能，只是用于快速、敏捷地开发新一代基于Spring框架的应用程序；它并不是用来替代Spring的
 *      解决方案，而是和Spring框架紧密结合用于提升Spring开发者体验的工具，Spring框架需要进行大量的配置，Spring Boot引入自动配置的概念，让项目
 *      设置变得很容易；Spring Boot只是承载者，辅助你简化项目搭建过程的。如果承载的是WEB项目，使用Spring MVC作为MVC框架，那么工作流程和你上面
 *      描述的是完全一样的，因为这部分工作是Spring MVC做的而不是Spring Boot；同时它集成了大量常用的第三方库配置(例如Jackson, JDBC, Mongo,
 *      Redis, Mail等等)，Spring Boot应用中这些第三方库几乎可以零配置的开箱即用(out-of-the-box)。
 * 2.常用注解：
 *      @SpringBootApplication： 这个注解是 Spring Boot 项目的基石，创建 SpringBoot 项目之后会默认在主类加上；@SpringBootApplication可以
 *          看作是 @SpringBootConfiguration、@EnableAutoConfiguration、@ComponentScan 注解的集合。
 *      @SpringBootConfiguration: 标注当前类是配置类，这个注解继承自@Configuration。并会将当前类内声明的一个或多个以@Bean注解标记的方法的
 *          实例纳入到srping容器中，并且实例名就是方法名。
 *      @EnableAutoConfiguration： 启用 SpringBoot 的自动配置机制
 *      @ComponentScan： 扫描被@Component (@Service,@Controller)注解的 bean，注解默认会扫描该类所在的包下所有的类。
 *      @Autowired： 自动导入对象到类中，被注入进的类同样要被 Spring 容器管理比如：Service 类注入到 Controller 类中。
 *      @Component ：通用的注解，可标注任意类为 Spring 组件。如果一个 Bean 不知道属于哪个层，可以使用@Component 注解标注。
 *      @Repository : 对应持久层即 Dao 层，主要用于数据库相关操作。
 *      @Service : 对应服务层，主要涉及一些复杂的逻辑，需要用到 Dao 层。
 *      @Controller : 对应 Spring MVC 控制层，主要用户接受用户请求并调用 Service 层返回数据给前端页面。
 *      @RestController： 是@Controller和@ResponseBody的合集,表示这是个控制器 bean,并且是将函数的返回值直 接填入 HTTP 响应体中,是 REST 风格的控制器。
 *      @Scope： 声明 Spring Bean 的作用域，singleton : 唯一 bean 实例，Spring中的bean 默认都是单例的；prototype : 每次请求都会创建一个新的bean实例。
 *      @Configuration: 一般用来声明配置类，可以使用 @Component注解替代，不过使用Configuration注解声明配置类更加语义化。
 *      @GetMapping("users") 等价于@RequestMapping(value="/users",method=RequestMethod.GET)
 *      @PathVariable用于获取路径参数，@RequestParam用于获取查询参数, 如/klasses/{123456}/teachers?type=web，前为路径参数，后为查询参数
 *      @Value("${user}") :读取比较简单的配置信息
 *      @ConfigurationProperties(prefix = "user"): 读取配置信息并与 bean 绑定
 *      @PropertySource("classpath:website.properties"): 读取指定 properties 文件
 * 3.5种常见的请求类型：
 *      GET ：请求从服务器获取特定资源。举个例子：GET /users（获取所有学生）
 *      POST ：在服务器上创建一个新的资源。举个例子：POST /users（创建学生）
 *      PUT ：更新服务器上的资源（客户端提供更新后的整个资源）。举个例子：PUT /users/12（更新编号为 12 的学生）
 *      DELETE ：从服务器删除特定的资源。举个例子：DELETE /users/12（删除编号为 12 的学生）
 *      PATCH ：更新服务器上的资源（客户端提供更改的属性，可以看做作是部分更新），使用的比较少，这里就不举例子了。
 */
public class SpringBoot {
}
