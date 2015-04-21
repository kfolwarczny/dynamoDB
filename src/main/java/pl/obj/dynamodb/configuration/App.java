package pl.obj.dynamodb.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan(basePackages = "pl.obj.dynamodb")
@Configuration
@EnableAutoConfiguration
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
