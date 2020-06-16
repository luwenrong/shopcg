# shopcg
基于SpringBoot、SpringCloud 构建的商城系统，发布上来供学习java和微服务的同学一起交流学习。
此系统采用微服务结构，前后端分离技术，使用canal进行数据同步，fastdfs 进行分布式文件存储，
elasticsearch进行数据检索。还在开发中，持续更新ing。

运行所需数据库请邮件联系 luwenrong.01@gmail.com

觉得有用的可以点个 star  ^-^

##运行所需环境
1. JDK1.8 MySQL5.7
2. canal(需要下载开源文件，在本地maven进行 install)
3. elasticsearch
4. fastdfs
5. rabbitmq
6. redis
7. kibana

##启动步骤
1. 启动eureka
2. 启动所有service微服务

### 微服务网关

基于springcloud-gateway 组件实现微服务网关，并使用Redis实现令牌桶算法对网关请求限流。
