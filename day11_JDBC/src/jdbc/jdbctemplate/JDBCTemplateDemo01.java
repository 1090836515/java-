package jdbc.jdbctemplate;

import jdbc.domain.Emp;
import jdbc.util.JDBCUtils01;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 1.调用JdbcTemplate的方法来完成CRUD的操作
 * 			* update():执行DML语句。增、删、改语句
 * 			* queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
 * 				* 注意：这个方法只能查一条记录
 * 			* queryForList():查询结果将结果集封装为list集合
 * 				* 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
 * 			* query():查询结果，将结果封装为JavaBean对象
 * 				* query的参数：RowMapper
 * 					* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
 * 					* new BeanPropertyRowMapper<类型>(类型.class)
 * 			* queryForObject：查询结果，将结果封装为对象:template.queryForObject(sql, Long.class)
 * 				* 一般用于聚合函数的查询,或者用于单个对象的查询(用法与query相同)
 */
public class JDBCTemplateDemo01 {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils01.getDataSource());
    public static void main(String[] args){

    }
    //1. 修改1号数据的 salary 为 10000
    @Test
    public void test01(){
        String sql="update emp set salary=10000 where id=?";
        int count = template.update(sql, 1001);
        System.out.println(count);
    }

    //2. 添加一条记录
    @Test
    public void test02(){
        String sql="insert into emp(id,ename,dept_id) values(?,?,?) ";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    //3. 删除刚才添加的记录
    @Test
    public void test03(){
        String sql="delete from emp where id=?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    //4. 查询id为1001的记录，将其封装为Map集合
    @Test
    public void test04(){
        String sql="select * from emp where id=?";
        Map<String, Object> map = template.queryForMap(sql, 1001);//只能查一条记录
        System.out.println(map);//{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
    }

    //5. 查询所有记录，将其封装为List
    @Test
    public void test05(){
        String sql="select * from emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for(Map<String,Object> map:maps){
            System.out.println(map);
        }
    }

    //6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test06(){
        String sql="select * from emp";
        List<Emp> emps = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for(Emp emp:emps){
            System.out.println(emp);
        }
    }

    //7. 查询总记录数
    @Test
    public void test07(){
        String sql="select count(id) from emp";
        Long count = template.queryForObject(sql, Long.class);//通常查聚合函数
        System.out.println(count);
    }
}
