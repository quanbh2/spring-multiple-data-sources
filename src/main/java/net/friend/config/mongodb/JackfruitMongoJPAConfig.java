package net.friend.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "net.friend.repository.mongodb.jackfruit", mongoTemplateRef = JackfruitMongoJPAConfig.MONGO_TEMPLATE)
public class JackfruitMongoJPAConfig {
  protected static final String MONGO_TEMPLATE = "jacfruitMongoTemplate";

}
