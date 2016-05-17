src\main\resources\application.properties

这个文件包含了数据库的连接，需要修改成：

spring.datasource.url=jdbc:mysql://localhost:3306/{数据库名称}
spring.datasource.username={用户名}
spring.datasource.password={密码}