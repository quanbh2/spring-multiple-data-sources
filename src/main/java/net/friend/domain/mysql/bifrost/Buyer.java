package net.friend.domain.mysql.bifrost;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "buyers")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "mobile")
  private String mobile;

  @Column(name = "updated_at")
  private Date updated_at;
}
