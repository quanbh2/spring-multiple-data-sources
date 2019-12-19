package net.friend.config.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {

  private final MultipleMongoProperties mongoProperties;

  // Jackfruit
  @Bean(name = JackfruitMongoJPAConfig.MONGO_TEMPLATE)
  public MongoTemplate jacfruitMongoTemplate() throws Exception {

    @SuppressWarnings("deprecation")
    MappingMongoConverter converter = new MappingMongoConverter(
        jackfruitFactory(this.mongoProperties.getJackfruit()), new MongoMappingContext());
    converter.setTypeMapper(new DefaultMongoTypeMapper(null));

    return new MongoTemplate(jackfruitFactory(this.mongoProperties.getJackfruit()), converter);
  }

  @Bean
  public MongoDbFactory jackfruitFactory(final MongoProperties mongo) throws Exception {
    return buildMongoFactory(mongo);
  }

  // Kelly
  @Bean(name = KellyMongoJPAConfig.MONGO_TEMPLATE)
  public MongoTemplate kellyMongoTemplate() throws Exception {

    @SuppressWarnings("deprecation")
    MappingMongoConverter converter = new MappingMongoConverter(
        jackfruitFactory(this.mongoProperties.getKelly()), new MongoMappingContext());
    converter.setTypeMapper(new DefaultMongoTypeMapper(null));

    return new MongoTemplate(kellyFactory(this.mongoProperties.getKelly()), converter);
  }

  @Bean
  public MongoDbFactory kellyFactory(final MongoProperties mongo) throws Exception {
    return buildMongoFactory(mongo);
  }


  private MongoDbFactory buildMongoFactory(final MongoProperties mongo) throws Exception {
    MongoCredential credential = MongoCredential.createCredential(mongo.getUsername(), mongo.getDatabase(),
        String.valueOf(mongo.getPassword()).toCharArray());
    return new SimpleMongoDbFactory(new MongoClient(new ServerAddress(mongo.getHost(), mongo.getPort()), credential,
        MongoClientOptions.builder().build()), mongo.getDatabase());
  }
}
