package net.friend.repository.mongodb.kelly;

import net.friend.domain.mongodb.Libraries;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrariesRepository extends MongoRepository<Libraries, String> {

  Libraries findByKey(String key);
}
