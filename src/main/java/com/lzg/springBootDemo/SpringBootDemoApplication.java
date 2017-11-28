package com.lzg.springBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Desc: Spring Boot 应用启动类
 * @Author  liuzg
 * @Date  2017/9/3 8:58
 */
//Spring Boot应用的标识
@SpringBootApplication
//mapper接口类扫描包配置
//@MapperScan("com.lzg.springBootDemo.dao")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(SpringBootDemoApplication.class, args);



	}
}
