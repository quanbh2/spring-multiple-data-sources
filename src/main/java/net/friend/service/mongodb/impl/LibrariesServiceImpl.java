package net.friend.service.mongodb.impl;

import net.friend.domain.mongodb.Libraries;
import net.friend.repository.mongodb.kelly.LibrariesRepository;
import net.friend.service.mongodb.LibrariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrariesServiceImpl implements LibrariesService {

  @Autowired
  LibrariesRepository librariesRepository;

  @Override
  public Libraries findByKey(String key) {
    return librariesRepository.findByKey(key);
  }
}
