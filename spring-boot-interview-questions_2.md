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
  - this is question about spring-boot-starter-parent POM is a convenient way of dependency management.
  - First add spring-boot-starter-parent as parent and 
  - version of other dependencies is automatically inherited by spring boot from parent version
  
        <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.1.1.RELEASE</version>
        </parent>
        
# How to access a value defined in the application.properties file in Spring Boot?
 
      @Value("${property.name}")
      String variableName;

# What is relaxed binding in Spring Boot?
  - When binding properties from application.properties to @ConfigurationProperties beans, spring boot uses relaxed binding
    which means it doesn't look for exact match for properties .
  - we can write such properties in camelCase,snake_case, or in uppercase, below is the example
  
        @ConfigurationProperties(prefix="javadevjournal.demoapplication-project.person")
        public class CustomerProperties {

          private String firstName;

          public String getFirstName() {
            return this.firstName;
          }

          public void setFirstName(String firstName) {
            this.firstName = firstName;
          }
        }
        
    - the relaxed binding for the above bean, firstname can be configured as below 
    
            javadevjournal.demoapplication-project.person.first-name
            javadevjournal.demoApplication.person.firstName
            javadevjournal.demo_application.person.first_name
            JAVADEVJOURNAL_DEMOAPPLICATION_PERSON_FIRSTNAME
            
   # How to set up Spring Boot application using maven?
       - First create a Maven project
       - in the pom.xml add spring-boot-startert-parent as below will make the dependency management all the dependencies inherited from parent POM
       - if doesnt want to inherit from spring-boot-startert-parent use spring-boot dependency management as alternate way
       
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.1.4.RELEASE</version>
      </parent>
      
      alternate option configuring spring-boot dependencies if we do not want to inherit from parent POM
      
      <dependencyManagement>
          <dependencies>
              <dependency>
                  <!-- Import dependency management from Spring Boot -->
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-dependencies</artifactId>
                  <version>2.1.4.RELEASE</version>
                  <type>pom</type>
                  <scope>import</scope>
              </dependency>
          </dependencies>
      </dependencyManagement>    
      
      
       
       
