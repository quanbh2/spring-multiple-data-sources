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
@Document(collection = "libraries")
public class Libraries {

  @Id
  private ObjectId id;

  private String key;

  private String link;
}
