package com.study.logstudy.jul;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

/**
 * @Author cuiyubao
 * @Date 2021/11/24 10:48 上午
 */
public class JULTest {

    @Test
    public void testQuick() {
        //1. 创建日志记录器对象
        Logger logger = Logger.getLogger("com.study.logstudy.jul.JULTest");
        //2. 日志记录输出
        logger.info("hello jul");
        logger.log(Level.INFO, "info msg");
        String name = "jack";
        Integer age = 18;
        logger.log(Level.INFO, "用户信息:{0},{1}", new Object[]{name, age});
    }

    @Test
    public void testLogLevel() {
        //1. 创建日志记录器对象
        Logger logger = Logger.getLogger("com.study.logstudy.jul.JULTest");

        //2. 日志记录输出   默认值输出info以上的级别
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testLogConfig() throws IOException {
        //1. 创建日志记录器对象
        Logger logger = Logger.getLogger("com.study.logstudy.jul.JULTest");

        //一. 自定义日志级别
        //a. 关闭系统默认配置
        logger.setUseParentHandlers(false);
        //b.创建handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //c.创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        //d.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        //e.设置日志级别
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        //二. 输出到日志文件
        FileHandler fileHandler = new FileHandler("/Users/cuiyubao/IdeaProjects/study_record/src/main/java/com/study/logstudy/jul/jul.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        //2. 日志记录输出   默认值输出info以上的级别
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
     public void testProperties() throws IOException {
        //读取自定义配置文件
        InputStream in = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        //获取日志管理器对象
        LogManager logManager = LogManager.getLogManager();
        //通过日志管理器加载配置文件
        logManager.readConfiguration(in);

        //1. 创建日志记录器对象
        Logger logger = Logger.getLogger("com.study.logstudy.jul.JULTest");

        //2. 日志记录输出   默认值输出info以上的级别
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }



}
