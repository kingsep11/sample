continuation of spring-boot-interview-questions.md...
# Spring Boot 2.0 features
  - Spring boot 2.0 need Java 8 as baseline, supports Java 9 also
  - Spring boot 2.0 need spring framework 5.0
  - Spring boot 2.0 supports Kotlin language
  - Enabled HTTP/2.0
  - Embedded Container updated to Tomcat 8.5 , Jetty 9.4
  - A brand new actuator architecture, with support for Spring MVC, WebFlux and Jersey.

# What is @SpringBootApplication annotation
  - Its an entry point for any spring boot application.
  - @SpringBootApplication is equivalant to  @Configuration, @EnableAutoConfigurationand @ComponentScan with their default attributes

# How to include custom static content ?
  - spring boot will look into /static, /public, /resources, /webapp /META-INF/resources in the class path or root of the ServletContext.
  - We can put our custom static content in any of the above folders. For example, put the custom.js file under  /resources/static/custom.js. To refer to this file in the view use the following code
  
        <script src = “/js/test.js”></script>

# How to use a profile with Spring Boot?
    application-{profile}.properties

# How to set the active profile in Spring Boot?
  - When starting the application:
  
        java -jar -Dspring.profiles.active=production application-1.0.0-RELEASE.jar //pass as command line argument
        
  - in properties file
  
         spring.profiles.active=production
         
# How to generate a WAR file with Spring Boot?
  - Set the packaging type as a war in our pom.xml file.
  - Mark the embedded container dependencies as “provided” (To build a war file that is both executable and deployable into an external container.)
  
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
           <!-- ... -->
           <packaging>war</packaging>
           <!-- ... -->
           <dependencies>
              <dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-web</artifactId>
              </dependency>
              <dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-tomcat</artifactId>
                 <scope>provided</scope>
              </dependency>
              <!-- ... -->
           </dependencies>
        </project>
        
 # How to disable the Web server configuration ?
   - Spring boot automatically start the web server if it finds the web module in class path
   - to disable the web server configuration, configure below property in application.properties
   
          spring.main.web-application-type=none
            
# How to create non web applications in spring boot ?
  - to create non-web application, we shouldnt add web dependencies in pom.xml
  
# How the ApplicationContext created by Spring Boot?
  - Spring boot creates ApplicationContext ahen SpringApplication.run() method gets executed.
  - there is ConfigurableApplicationContext which extends ApplicationContext
  
  public ConfigurableApplicationContext run(String...args) {
 //preparation
 ConfigurableApplicationContext context = null;

 //create and return application context
 context = createApplicationContext();
}

    protected ConfigurableApplicationContext createApplicationContext() {
     Class << ? > contextClass = this.applicationContextClass;
     if (contextClass == null) {
      try {
       switch (this.webApplicationType) {
        case SERVLET:
         contextClass = Class.forName(DEFAULT_SERVLET_WEB_CONTEXT_CLASS);
         break;
        case REACTIVE:
         contextClass = Class.forName(DEFAULT_REACTIVE_WEB_CONTEXT_CLASS);
         break;
        default:
         contextClass = Class.forName(DEFAULT_CONTEXT_CLASS);
       }
      } catch (ClassNotFoundException ex) {
       throw new IllegalStateException(
        "Unable create a default ApplicationContext, " +
        "please specify an ApplicationContextClass",
        ex);
      }
     }
     return (ConfigurableApplicationContext) BeanUtils.instantiateClass(contextClass);
    }

