### spring-boot + zookeeper + hadoop + Hbase环境搭建说明

环境依赖: Mac Jdk-1.8 (自选)

先安装hadoop

```bash
brew intall hadoop
vim ~/.bash_profile
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home
export HADOOP_HOME=/usr/local/Cellar/hadoop/2.8.1
export HADOOP_CONF_DIR=/usr/local/Cellar/hadoop/2.8.1/libexec/etc/hadoop
export HBASE_HOME=/usr/local/Cellar/hbase/1.2.6/libexec
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$HBASE_HOME/bin:$HBASE_HOME/libexec/conf

```
