package ErrorException;

/**
 * 1.自定义异常必须继承Exception或RuntimeException
 *          若是继承Exception:那方法内部抛出编译期异常就必须处理
 *          若继承RuntimeException：无需处理
 * 2.标准的自定义异常
 */
public class RegisterException extends Exception {
    public RegisterException(){
        super();
    }
    public RegisterException(String message){
        super(message);
    }
}
