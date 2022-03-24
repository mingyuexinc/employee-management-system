# employee-management-system

##  **介绍**

基于springboot和mybatis的员工管理系统，并整合Shiro框架。

## **所用技术**

- SpringBoot
- MyBatis
- Shiro
- MySQL

## 使用说明

- 根据导入db文件夹中的db.sql，先创建对应的数据库，并自行修改数据库路径
- 根据自己电脑的环境修改application.yml(application.properties)文件
- 浏览器访问：http://localhost 输入账号：admin 密码：123456

## 实现功能

- 用户登录系统，包括用户认证和访问拦截

- 对员工和部门信息的增、删、查、改
- 通过对不同角色分别授权，实现不同的访问权限