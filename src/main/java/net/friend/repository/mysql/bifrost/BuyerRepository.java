package net.friend.repository.mysql.bifrost;

import java.util.List;
import java.util.Optional;
import net.friend.domain.mysql.bifrost.Buyer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends PagingAndSortingRepository<Buyer, Integer> {

  @Query(value = "select * from buyers order by rand() limit ?1", nativeQuery = true)
  List<Buyer> getListRandom(int quantity);

  Optional<Buyer> findById(Integer id);
}
