package pl.obj.dynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamoDbLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamoDbLocalApplication.class, args);
    }
}
