package Reflect;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 1.Assert的assertEquals(result,3):比较结果值与断言的值是否一致
 * 2.@Before,@After
 *
 */
public class AssertCalculatorTest {
    /**
     * 初始化方法：
     *  用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
       System.out.println("init.....");
    }

    /**
     * 释放资源方法：
     *  在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("after.....");
    }


    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){
        System.out.println("testAdd....");
        Calculator calendar=new Calculator();
        int result=calendar.add(2,3);
        Assert.assertEquals(3,result);
    }

}
