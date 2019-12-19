package net.friend.service.mysql.impl;

import java.util.List;
import net.friend.domain.mysql.bifrost.Buyer;
import net.friend.repository.mysql.bifrost.BuyerRepository;
import net.friend.service.mysql.BifrostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BifrostServiceImpl implements BifrostService {

  @Autowired
  BuyerRepository buyerRepository;

  @Override
  public Buyer findBuyerById(Integer id) {
    return buyerRepository.findById(id).orElse(new Buyer());
  }

  @Override
  public List<Buyer> getListRandomBuyer(int quantity) {
    return buyerRepository.getListRandom(quantity);
  }
}
