package net.friend.config.mongodb;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {
  private MongoProperties jackfruit = new MongoProperties(); // must be same name in file yml

  private MongoProperties kelly = new MongoProperties();
}
