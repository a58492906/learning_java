package com.example.boot.JDBC;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-06-29 21:29
 */

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis自动代码生成
 */
public class Generator {

    public static void main(String[] args) throws Exception {

        List<String> warnings = new ArrayList<String>();
        // 当生成的代码重复时覆盖
        boolean overwrite = true;
        // 读取资源配置文件
        InputStream is = Generator.class.getResourceAsStream("/mysql-generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        // 生成代码
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        // 输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}

