##项目说明

```text
    1 可用于server api等微服务
    2 封装了hbase等接口操作, 附带简要的安装配置说明
    3 采用约定大于配置及Restful
```

### spring-boot + zookeeper + hadoop + Hbase环境搭建说明

环境依赖: Mac Jdk-1.8 (自选)

#### 一、安装配置hadoop

```bash
brew intall hadoop
vim ~/.bash_profile
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home
export HADOOP_HOME=/usr/local/Cellar/hadoop/2.8.1
export HADOOP_CONF_DIR=/usr/local/Cellar/hadoop/2.8.1/libexec/etc/hadoop
export HBASE_HOME=/usr/local/Cellar/hbase/1.2.6/libexec
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$HBASE_HOME/bin:$HBASE_HOME/libexec/conf

vim etc/hadoop/core-site.xml

<configuration>
    <!--设置临时目录-->
    <property>
        <name>hadoop.tmp.dir</name>
        <value>/Users/dreamboad/Test/big_data/hadoop</value>
    </property>
    <!--设置文件系统-->
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://localhost:9000</value>
    </property>
</configuration>

vim etc/hadoop/hadoop-env.sh

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home

vim etc/hadoop/hdfs-site.xml

<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
</configuration>
```

启动hadoop

```
start-all.sh
```

进入web:http://localhost:50070/dfshealth.html#tab-overview


#### 二、安装zookeeper(TODO)

```
brew install zookeeper

```
启动

```
zkServer start
```
停止

```
zkServer stop
```

#### 三、安装Hbase

```text
brew intall hbase

vim ../libexec/conf/hbase-env.sh

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home
export HBASE_HOME=/usr/local/Cellar/hbase/1.2.6/libexec
export HADOOP_HOME=/usr/local/Cellar/hadoop/2.8.1
export HBASE_MANAGES_XK=true
export HBASE_MANAGES_ZK=false // 不使用自带zookeeper

vim ../libexec/conf/hbase-site.xml

<configuration>
  <property>
    <name>hbase.rootdir</name>
    <value>file:///Users/dreamboad/Test/big_data/hadoop</value>
    <description>如果启动hadoop集群，此处需要换成hdfs的地址，如:hdfs://localhost:9000</description>
  </property>
  <property>
    <name>hbase.zookeeper.property.clientPort</name>
    <value>2181</value>
    <description>zookeeper端口号</description>
  </property>
  <property>
  	<name>hbase.master.info.bindAddress</name>
    <value>hbase</value>
    <description>zookeeper端口号</description>
  </property>
  <property>
  	<name>hbase.master.info.port</name>
    <value>60010</value>
    <description>hbase master端口号</description>
  </property>
  <property>
    <name>hbase.master</name>
    <value>master:60000</value>
    <description>The host and port that the HBase master runs at.</description>
  </property>
  <property>
    <name>hbase.zookeeper.property.dataDir</name>
    <value>/usr/local/var/run/zookeeper/data</value>
    <description>zookeeper数据暂存</description>
  </property>
  <property>
    <name>hbase.zookeeper.quorum</name>
    <value>master:2181</value>
    <description>zookeeper服务，master是zookeeper host</description>
  </property>

</configuration>

```
启动hhbase:

```
./start-hbase.sh
./stop-hbase.sh
```

jps查看

```jps
23505 sbt-launch.jar
77828 GradleMain
72743 Main
24119 sbt-launch.jar
75446 HMaster
69161 DataNode
69257 SecondaryNameNode
78104 Jps
69083 NameNode
62043 JournalNode
77839 Application
77838 GradleDaemon
```
有HMaster说明安装成功

或: ./hbase shell 进入交互模式查看

#### 四、遇到问题

* 错误: 找不到或无法加载主 类似这种问题一般是habse的HBASE_HOME有问题
* Hbase自带zookeeper与独立zookeeper会冲突，二者选一

#### 五、参考

* https://mvnrepository.com
* http://abloz.com/hbase/book.html#schema.creation
