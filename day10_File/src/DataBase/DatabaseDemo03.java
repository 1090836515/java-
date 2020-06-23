package DataBase;

/**
 * 1.多表查询：a.隐式内连接：隐式内连接：使用where条件消除无用数据; b.显示内连接:语法： select 字段列表 from 表名1 [inner] join 表名2 on 条件 SELECT * FROM emp JOIN dept ON emp.`dept_id` = dept.`id`;
 *            b.外连接(可以查出某些部分为空的字段)：左外连接：
 * 				* 语法：select 字段列表 from 表1 left [outer] join 表2 on 条件；
 * 				* 查询的是左表所有数据以及其交集部分
 * 			    右外连接：
 * 				* 语法：select 字段列表 from 表1 right [outer] join 表2 on 条件；
 * 				* 查询的是右表所有数据以及其交集部分
 * 			c.子查询：嵌套查询
 * 2.事务：如果一个包含多个步骤的业务操作，被事务管理，那么这些操作要么同时成功，要么同时失败。开启事务： start transaction;
 *  回滚：rollback;提交：commit; mysql就是自动提交的，一条DML(增删改)语句会自动提交一次事务;  Oracle 数据库默认是手动提交事务,需要先开启事务，再提交;
 *  查看事务的默认提交方式：SELECT @@autocommit; -- 1 代表自动提交  0 代表手动提交; 修改默认提交方式： set @@autocommit = 0;
 * 3.事务的四大特征：
 * 		1. 原子性：是不可分割的最小操作单位，要么同时成功，要么同时失败。
 * 		2. 持久性：当事务提交或回滚后，数据库会持久化的保存数据。
 * 		3. 隔离性：多个事务之间,相互独立。
 * 		4. 一致性：事务操作前后，数据总量不变
 * 4.事物的隔离级别:
 * 5.DCL(管理用户,授权)：1. 管理用户
 * 			a. 添加用户：
 * 				* 语法：CREATE USER '用户名'@'主机名' IDENTIFIED BY '密码';
 * 			b. 删除用户：
 * 				* 语法：DROP USER '用户名'@'主机名';
 * 			c. 修改用户密码：
 *              *UPDATE USER SET PASSWORD = PASSWORD('新密码') WHERE USER = '用户名';
 *          d. 查询用户：
 * 				-- 1. 切换到mysql数据库
 * 				USE myql;
 * 				-- 2. 查询user表
 * 				SELECT * FROM USER;
 *       2. 权限管理：
 * 			1. 查询权限：
 * 				-- 查询权限
 * 				SHOW GRANTS FOR '用户名'@'主机名';
 * 			2. 授予权限：
 * 				-- 授予权限
 * 				grant 权限列表 on 数据库名.表名 to '用户名'@'主机名';
 * 			3. 撤销权限：
 * 				-- 撤销权限：
 * 				revoke 权限列表 on 数据库名.表名 from '用户名'@'主机名';
 */
public class DatabaseDemo03 {
}
