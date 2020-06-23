package DataBase;

/**
 * 1.数据库是持久化存储的，就是一个文件系统
 * 2.卸载干净：a.卸载软件;b.my.ini文件下找到datadir="C:/ProgramData/MySQL/MySQL Server 5.5/Data/"，按照目录删除对应下的文件数据
 * 3.net start(stop) mysql：启动或关闭mysql服务(需要以管理员身份运行); mysql -h127.0.0.1 -uroot -p8252560登录对应数据库
 * 4.show database:显示所有的数据库(不区分大小写); 单行注释：-- "xxxxx"
 * 5.1.DDL(Definition):操作数据库，表; 2.DML(Manipulation):对数据库表中的数据进行增删改; 3.DQL(Query):数据查询; 4.DCL(Control):定义数据库的访问级别和权限
 * 6.DDL: a.操作数据库：CRUD:  1.创建数据库：create database 数据库名称;2. (retrieve)查询所有数据库的名称: show databases; 3.修改数据库的字符集: alter database 数据库名称 character set 字符集名称;4. 删除数据库:drop database if exists 数据库名称;
 *        b.操作表：CRUD:  1.创建表:create table 表名(.....); 2.查询某个数据库中所有的表:show tables;
 *        3.修改表：
 *              1. 修改表名
 * 				    alter table 表名 rename to 新的表名;
 * 			    2. 修改表的字符集
 * 				    alter table 表名 character set 字符集名称;
 * 			    3. 添加一列
 * 				    alter table 表名 add 列名 数据类型;
 * 			    4. 修改列名称 类型
 * 				    alter table 表名 change 列名 新列别 新数据类型;
 * 				    alter table 表名 modify 列名 新数据类型;
 * 			    5. 删除列
 * 				    alter table 表名 drop 列名;
 * 		    4.删除表:drop table  if exists 表名 ;
 * 7.datetime:日期，包含时分秒; date:不包含时分秒; timestamp：与datetime类似,区别是若不赋值,则默认赋值当前时间
 * 8. DML：增删改表中数据： insert into 表名(列名1,列名2,...列名n) values(值1,值2,...值n); delete from 表名 [where 条件]; update 表名 set 列名1 = 值1, 列名2 = 值2,... [where 条件];
 * 9.DQL：查询表中的记录:
 *           where 和 having 的区别？
 * 				1. where 在分组之前进行限定，如果不满足条件，则不参与分组。having在分组之后进行限定，如果不满足结果，则不会被查询出来
 * 				2. where 后不可以跟聚合函数，having可以进行聚合函数的判断。
 * 			    3.进行分组之后,前面的查询只能查询分组的标签或者聚合函数
 *          -- 查询年龄22岁，18岁，25岁的信息
 * 				SELECT * FROM student WHERE age = 22 OR age = 18 OR age = 25
 * 				SELECT * FROM student WHERE age IN (22,18,25);
 * 			-- 查询姓名第二个字是化的人的名字,去除重复
 * 				SELECT distinct name FROM student WHERE NAME LIKE "_化%";
 * 			--按年龄的顺序排列
 * 		        SELECT * FROM student ORDER BY age ASC(DESC);
 * 		    -- 按照性别分组。分别查询男、女同学的平均分,人数
 * 			SELECT sex , AVG(math),COUNT(id) FROM student GROUP BY sex;
 * 			--  按照性别分组。分别查询男、女同学的平均分,人数 要求：分数低于70分的人，不参与分组
 * 			SELECT sex , AVG(math),COUNT(id) FROM student WHERE math > 70 GROUP BY sex;
 * 			--  按照性别分组。分别查询男、女同学的平均分,人数 要求：分数低于70分的人，不参与分组,分组之后。人数要大于2个人
 * 			SELECT sex , AVG(math),COUNT(id) FROM student WHERE math > 70 GROUP BY sex HAVING COUNT(id) > 2;
 * 			SELECT sex , AVG(math),COUNT(id) 人数 FROM student WHERE math > 70 GROUP BY sex HAVING 人数 > 2;
 * 		    -- 每页显示3条记录
 * 			SELECT * FROM student LIMIT 0,3; -- 第1页
 * 			SELECT * FROM student LIMIT 3,3; -- 第2页
 * 			SELECT * FROM student LIMIT 6,3; -- 第3页
 */
public class DatabaseDemo01 {
    public static void main(String[] args){

    }
}
