package net.friend.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "net.friend.repository.mongodb.kelly", mongoTemplateRef = KellyMongoJPAConfig.MONGO_TEMPLATE)
public class KellyMongoJPAConfig {
  protected static final String MONGO_TEMPLATE = "kellyMongoTemplate";

}
