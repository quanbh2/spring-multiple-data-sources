package net.friend.domain.mongodb;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "courses")
public class Course {

  @Id
  private ObjectId id;

  private String name;

  private Integer price;

  private String alias_name;
}

