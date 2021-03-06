//package com.example.hbase.stater.configuration;
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
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import static com.example.hbase.stater.configuration.HBaseProperties.PREFIX;
//
///**
// * HBase配置
// *
// * @author jackie wang
// * @since 2021/2/1 17:27
// */
//@Configuration
//@EnableConfigurationProperties(HBaseProperties.class) // 激活配置属性
//@AutoConfigureOrder(Integer.MIN_VALUE+1) // 为了让kerberos自动配置先初始化bean
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
//        if (properties.getHadoopHome() != null && properties.getHadoopHome().trim().length() > 0) {
//            System.setProperty("hadoop.home.dir", properties.getHadoopHome());
//        } else {
//            String hadoopHome = System.getenv("HADOOP_HOME");
//            if (StringUtils.isNotBlank(hadoopHome)) {
//                System.setProperty("hadoop.home.dir", hadoopHome);
//            } else {
//                throw new RuntimeException("The current project environment variable 'Hadoop Home' cannot be empty.");
//            }
//        }
//
//        // configuration通过HBaseConfiguration.create()加装hbase-site.xml配置文件中的属性值
//        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
//        configuration.set("hbase.zookeeper.quorum", properties.getZookeeperQuorum());
//        configuration.set("hbase.master.port", properties.getClientPort());
//        configuration.set("hbase.rootdir", properties.getZnodeParent());
//
//        if (properties != null && properties.getSecurityAuthentication() != null
//                && properties.getSecurityAuthentication().equals("kerberos")) {
//                configuration.set("hbase.security.authentication", "kerberos");
//                configuration.set("hbase.master.kerberos.principal", properties.getMasterKerberosPrincipal());
//                configuration.set("hbase.regionserver.kerberos.principal", properties.getRegionserverKerberosPrincipal());
//                }
//        return new HBaseServiceWith1x(configuration);
//    }
//
//}
