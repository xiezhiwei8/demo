package com.xzw.controller.Generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorController {

    public void generator() throws Exception{
        String configFilePath = System.getProperty("user.dir").concat("/src/main/java/com/xzw/controller/Generator/generatorConfig.xml");
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File(configFilePath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {
        try {
            GeneratorController generatorController = new GeneratorController();
            generatorController.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}