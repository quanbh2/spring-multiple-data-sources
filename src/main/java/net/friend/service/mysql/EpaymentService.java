package net.friend.service.mysql;

import net.friend.domain.mysql.epayment.EdmContact;

public interface EpaymentService {

  EdmContact findContactById(Integer id);
}