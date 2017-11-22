### 一、简介

```text
1 可用于API等微服务
2 封装了hbase等接口操作
```

### 二、运行测试

* [测试](./doc/test.md)

### 三、zookeeper + hadoop + Hbase搭建参考

* [参考](./doc/doc.md)

### 四、遇到问题

* 错误: 找不到或无法加载主 类似这种问题一般是habse的HBASE_HOME有问题
* Hbase自带zookeeper与独立zookeeper会冲突，二者选一
* 在/etc/hosts中需要映射zookeeper的hostname与主机ip

### 五、参考

* https://mvnrepository.com
* http://abloz.com/hbase/book.html#schema.creation
