package net.friend.service.mongodb;

import net.friend.domain.mongodb.Libraries;

public interface LibrariesService {

  Libraries findByKey(String key);
}
