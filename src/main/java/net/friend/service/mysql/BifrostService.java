package net.friend.service.mysql;

import java.util.List;
import net.friend.domain.mysql.bifrost.Buyer;

public interface BifrostService {

  Buyer findBuyerById(Integer id);

  List<Buyer> getListRandomBuyer(int quantity);
}
