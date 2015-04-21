package pl.obj.dynamodb.configuration;


import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.apache.commons.lang3.StringUtils;
import org.socialsignin.spring.data.dynamodb.core.DynamoDBOperations;
import org.socialsignin.spring.data.dynamodb.core.DynamoDBTemplate;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.obj.dynamodb.properties.AwsProperties;


@Configuration
@EnableConfigurationProperties(AwsProperties.class)
@EnableDynamoDBRepositories(basePackages = "pl.obj.dynamodb.repository", amazonDynamoDBRef = "amazonDynamoDB")
public class DynamoDBConfig {
  @Autowired
  AwsProperties awsProperties;

  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    ClientConfiguration clientConfiguration = new ClientConfiguration();
    clientConfiguration.withProtocol(Protocol.HTTP);

    AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials(), clientConfiguration);
    if (StringUtils.isNotEmpty(awsProperties.getUrl())) {
      amazonDynamoDB.setEndpoint(awsProperties.getUrl());
    }
    return amazonDynamoDB;
  }

  @Bean
  public DynamoDBOperations dynamoDBOperations() {
    return new DynamoDBTemplate(amazonDynamoDB());
  }

  @Bean
  public AWSCredentials amazonAWSCredentials() {
    return new BasicAWSCredentials(awsProperties.getAccessKey(), awsProperties.getSecretKey());
  }
}
