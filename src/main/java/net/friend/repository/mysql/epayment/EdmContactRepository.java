package net.friend.repository.mysql.epayment;

import java.util.Optional;
import net.friend.domain.mysql.epayment.EdmContact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdmContactRepository extends PagingAndSortingRepository<EdmContact, Integer> {

  Optional<EdmContact> findById(Integer id);
}
