continuation of spring-boot-interview-questions_1.md

# How can we externalize SpringApplication configuration?
  - SpringApplication provides setter method to externalize / customize the configuration.
  -  For example, to switch off the banner (displaying on startup), we can use the .bannelMode(boolean) method.
  
                          new SpringApplicationBuilder()
                          .bannerMode(Banner.Mode.OFF)
                          .run(args);
