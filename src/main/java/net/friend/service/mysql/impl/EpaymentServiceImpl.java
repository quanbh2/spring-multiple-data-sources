package net.friend.service.mysql.impl;

import net.friend.domain.mysql.epayment.EdmContact;
import net.friend.repository.mysql.epayment.EdmContactRepository;
import net.friend.service.mysql.EpaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpaymentServiceImpl implements EpaymentService {

  @Autowired
  EdmContactRepository edmContactRepository;

  @Override
  public EdmContact findContactById(Integer id) {
    return edmContactRepository.findById(id).orElse(new EdmContact());
  }

}
