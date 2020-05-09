continuation of spring-boot-interview-questions_1.md

# How can we externalize SpringApplication configuration?
  - SpringApplication provides setter method to externalize / customize the configuration.
  -  For example, to switch off the banner (displaying on startup), we can use the .bannelMode(boolean) method.
  
                          new SpringApplicationBuilder()
                          .bannerMode(Banner.Mode.OFF)
                          .run(args);

# How to enable HTTP response compression in spring boot ?
  - spring.compression.enabled = true in application property can enable the compression
  -  server.compression.min-response-size property to set the compression length. 
  - by default below content types are compressed
    
        text/html
        text/xml
        text/plain
        text/css
        text/javascript
        application/javascript
        application/json
        application/xml
        
 # What is Spring-Boot Admin ?
   - Soring-Boot-Admin is community application that helps to monitor and manage the Spring-Boot client applications
   - the client applications register themselves with minimal configuration in properties file
   - every client application needs have actuator depedencies, where the actautor metrics end points are polled by Soring-Boot-Admin
   - examples provided in "spring-boot-admin" application.
   
# Can we configure Spring Boot to use multiple data sources?
    Yes ! please check 
    https://www.javadevjournal.com/spring-boot/multiple-data-sources-with-spring-boot/
    
# What is the use of starter POM in our Spring Boot application?
  - this is question about spring boot starter parent is a convenient way of dependency management
  - version of other dependencies is automatically handled by spring boot based on parent version
  
        <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.1.1.RELEASE</version>
        </parent>
        
# How to access a value defined in the application.properties file in Spring Boot?
 
      @Value("${property.name}")
      String variableName;
