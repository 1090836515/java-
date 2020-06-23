package DataBase;

/**
 * 1.约束：1. 主键约束：primary key; 2.非空约束：not null; 3.唯一约束：unique; 4.外键约束：foreign key; 5.自动增长：auto_increment
 *       ---删除name的非空约束
 * 			ALTER TABLE stu MODIFY NAME VARCHAR(20);
 * 		 ---删除自动增长
 * 			ALTER TABLE stu MODIFY id INT;
 * 		 ---删除唯一约束
 * 			ALTER TABLE stu DROP INDEX phone_number;
 * 		 ---删除主键
 * 			-- 错误 alter table stu modify id int ;
 * 			ALTER TABLE stu DROP PRIMARY KEY;
 * 		6.外键约束： foreign key (外键列名称) references 主表名称(主表列名称)
 * 		 ---删除外键
 * 			ALTER TABLE 表名 DROP FOREIGN KEY 外键名称;
 * 		 ---设置级联更新(删除)
 * 		    (dep_id) reference department(id) on update(DELETE) CASCADE;
 * 2.一对多的关系：在多的地方建立外键，指向一的一方的主键;  多对多的关系: 需要借助第三张中间表，中间表至少包含两个字段，
 * 这两个字段作为第三张表的外键，分别指向两张表的主键，这两个外键联合在一起又是一个联合主键;  一对一的关系：可以在任意一方添加唯一外键指向另一方的主键
 * 3.数据库设计的范式：第一范式（1NF）：每一列都是不可分割的原子数据项;  第二范式（2NF）：在1NF的基础上，非码属性必须完全依赖于码（在1NF基础上消除非主属性对主码的部分函数依赖）
 * 第三范式（3NF）：在2NF基础上，任何非主属性不依赖于其它非主属性（在2NF基础上消除传递依赖）; 码：如果在一张表中，一个属性或属性组，被其他所有属性所完全依赖，则称这个属性(属性组)为该表的码
 * 4.数据库的备份和还原:a.命令行：备份： mysqldump -u用户名 -p密码 数据库名称 > 保存的路径; 还原：使用数据库, 执行文件:source 文件路径
 */
public class DatabaseDemo02 {
}
