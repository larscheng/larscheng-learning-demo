package com.larscheng.www;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器演示
 *
 * @author larscheng
 * @date 2019/12/5 19:06
 */

public class MpGenerator {
    public static void main(String[] args) {
        //创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //指定模板引擎  默认velocity

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOpen(false);
        /**换成你的目录*/
        gc.setOutputDir(System.getProperty("user.dir") + "\\BaseDemo\\springboot-mybatisplus-durid-mysql\\src\\main\\java");
        //是否覆盖已有文件
        gc.setFileOverride(true);
        //XML是否需要BaseResultMap
        gc.setBaseResultMap(true);
        //XML是否显示字段
        gc.setBaseColumnList(true);
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setAuthor("larscheng");
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&serverTimezone=UTC")
                .setUsername("root")
                .setPassword("123456");
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig sc = new StrategyConfig()
                /**表名*/
                .setInclude("lease_region_info")
                //表名前缀
                //.setTablePrefix("tab_")
                //表名生成策略
                .setNaming(NamingStrategy.underline_to_camel)
                .setEntityBuilderModel(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true);
        mpg.setStrategy(sc);
        //包配置
        PackageConfig pc = new PackageConfig()
                .setParent("com.larscheng.www").setEntity("domain")
                .setController("controller")
                .setService("service")
                .setServiceImpl("serviceImpl")
                .setMapper("dao")
                .setXml("mapper");
        mpg.setPackageInfo(pc);

        mpg.execute();
    }

}