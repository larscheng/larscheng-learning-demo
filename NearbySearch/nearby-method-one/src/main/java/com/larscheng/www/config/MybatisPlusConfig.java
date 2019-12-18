//
//package com.nature.edu.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
//
// * 读取druid连接池配置初始化datasource
//
// *
//
// * @author wangck
//
// * @date 2019/8/6
//
// */
//
//@Configuration
//
//@ServletComponentScan
//
//@MapperScan("com.larscheng.www.dao")
//
//public class MybatisPlusConfig{
//
//    /**
//
//     * 加载时读取指定的配置信息,前缀为spring.datasource.druid
//
//     *
//
//     * @return
//
//     */
//
//    @Bean("dataSource")
//
//    @ConfigurationProperties(prefix ="spring.datasource.druid")
//
//    public DataSource druidDataSource() {
//
//        return new DruidDataSource();
//
//    }
//
//    /**
//
//     * 分页插件
//
//     */
//
//    @Bean
//
//    public PaginationInterceptor paginationInterceptor() {
//
//// paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
//
//        PaginationInterceptor paginationInterceptor =new PaginationInterceptor();
//
//        return paginationInterceptor;
//
//    }
//
//}
