package com.example.hbase.stater.configuration;//package com.example.hbase.stater.configuration;
//
//import com.example.hbase.stater.component.HBaseServiceWith1x;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import static com.example.hbase.stater.configuration.HBaseProperties.PREFIX;
//
///**
// * HBase配置
// * @author jackie wang
// * @since 2021/2/1 17:27
// */
//@Configuration
//@EnableConfigurationProperties(HBaseProperties.class) // 激活配置属性
//@ConditionalOnProperty(prefix = PREFIX, value = "zookeeper-quorum") // 条件加载配置属性，如果满足条件，实例化当前类
//public class HBase1xAutoConfiguration {
//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private HBaseProperties properties;
//
//    @Bean
//    public HBaseServiceWith1x getHbaseService() {
//        // 初始化hadoop home路径
//        System.setProperty("hadoop.home.dir", properties.getHadoopHome());
//
//        // configuration通过HBaseConfiguration.create()加装hbase-site.xml配置文件中的属性值
//        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
//        configuration.set("hbase.zookeeper.quorum", properties.getZookeeperQuorum());
//        configuration.set("hbase.master.port", properties.getClientPort());
//        configuration.set("hbase.rootdir", properties.getZnodeParent());
//        return new HBaseServiceWith1x(configuration);
//    }
//
//}
