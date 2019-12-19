package net.friend.domain.mysql.epayment;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "edm_contact")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EdmContact {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "email")
  private String email;

  @Column(name = "updated_at")
  private Date updated_at;
}
