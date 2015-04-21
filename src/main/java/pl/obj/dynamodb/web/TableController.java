package pl.obj.dynamodb.web;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@RestController
public class TableController {
  @Autowired
  AmazonDynamoDB dynamoDB;

  @RequestMapping(value = "/createTable", method = RequestMethod.GET)
  public void createTable(String tableName) {
    ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<>();
    attributeDefinitions.add(new AttributeDefinition().withAttributeName("id").withAttributeType("S"));

    ArrayList<KeySchemaElement> keySchema = new ArrayList<>();
    keySchema.add(new KeySchemaElement().withAttributeName("id").withKeyType(KeyType.HASH));


    CreateTableRequest request = new CreateTableRequest().withTableName(tableName)
      .withKeySchema(keySchema)
      .withAttributeDefinitions(attributeDefinitions)
      .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(6L));

    System.out.println("Issuing CreateTable request for " + tableName);

    dynamoDB.createTable(request);
  }
}
