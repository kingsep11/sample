# What is Spring Boot ?
  - Spring-Boot helps to create stand-alone and production ready application, with a very minimal configuration
  - Advantages are :
    - Stand alone and production ready application
    - Enabling auto configuration
    - Embedded container (tomcat, Jetty, under-tow)
    - CLI, initializer to quick start the projects
    - starter parent libraries.

# Spring Vs Spring-Boot:
   - Spring is a framework to create stand-alone / web applications, which has lots of modules core, MVC, ORM, Data etc, to do all these developer needs to write lot of configuration code.
   - Spring Boot - helps to manage the configuration and bioler plate code automatically , and production ready application embedded (tomcat, Undertow, Jetty) container inside.

# Spring MVC Vs Spring-Boot:
  - Spring MVC is a spring module to create web based applications
  - Spring MVC : manual configuration needed (boiler plate code )
  - Spring MVC : deployment descriptor(web.xml) needed
  - Spring MVC : add needed dependencies seperately
  
  ~ Spring-Boot : helps to quick bootstrap the spring application of any module
  ~ Spring-Boot : auto confugured (no manual configuration needed)
  ~ Spring-Boot : dependencies are wrapped up with parent

# Different components of spring boot:
  -spring boot initializer,
  - Cli
  - starter parents
  - Auto configuration
  - Actuators
  
# Spring-Boot starters:
    - convenient dependencies can be inclluded in the spring boot application
    - Spring Boot Starters are just JAR files used by Spring Boot for auto-dependency

# what sring-boot starters are available ?
   - Web
   - Jdbc
   - JPA
   - security
   - webservice etc.,

# Usage of spring boot cli
   - a command line interface tool that helps to create / quick start the spring boot application using groovy script.
   
# How to enable custom Auto-configuration in spring boot
  - in jar file META-INF/spring.properties we should use a fully qualified name of the class under the EnableAutoConfiguration in the spring.factories property file.below is the example
  - org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.javadevjournal.config.HelloServiceAutoConfiguration

# Can we use the spring-boot for non spring application ?
  - No
  
# in spring-boot how to reload the changes without restarting the server ?
  - using spring-boot dev tools dependency in the pom.xml
  - below is the example
  
          <dependencies>
              <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
              </dependency>
          </dependencies>

# What is spring-boot actuator ?
  -  the actuator helps to monitor and manage the applications in the production environment.
  -  with this we can monitor /beans, /health, /metrics, /logging, /auditingevents, /environment, /threaddump etc.,
  
# Why do we need maven plugin in spring-boot ?
  - This provide maven support in spring-boot applocation
  - spring-boot:run to run the application
  - spring-boot:repackage to rebuild the application
  - spring-boot:start or spring-boot:stop  to manage  the lifecycle of the application (when integration test)
  - spring-boot:build-inf will generate the build information than can be used with actuator.
  
         <plugins>
          <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <version>2.0.5.RELEASE</version> <!--optional-->
            <executions> <!--optional-->
              <execution>
                <goals>
                  <goal>repackage</goal>
                </goals>
              </execution>
            </executions>
          </plugin>
        </plugins>

# How to disable the specific auto-configuration ?

    @Configuration
    @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
    public class CustomConfiguration {
    }
    
    or with @SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
    
    or configure in properties file 
    spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

# What is the use of YAML file
  - YAML is a superset of JSON
  - Spring-boot supports snakeYAML (application.yml) as an alternate to application.properties
  - Let’s take the following example of the application.properties file.
  
        environments.dev.url=https://dev.javadevjournal.com
        environments.dev.name=Developer Setup
        
  It can represent the YAML files as follows.
  
    environments:
       dev:
           url: https://dev.javadevjournal.com
           name: Developer Setup    
  
   
