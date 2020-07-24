# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/#build-image)

#### Spring Boot 配置处理器
    编译项目时，会扫描 @ConfigurationProperties 注解，生成 spring-configuration-metadata.json 配置元数据文件给 IDEA。这样在 IDEA 中，可以带来两个好处：
	1. 在 application.yaml 配置文件，添加配置项时，IDEA 会给出提示。
	2. 点击配置项时，可以跳转到对应的 @ConfigurationProperties 注解的配置类