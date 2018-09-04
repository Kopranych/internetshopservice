package db.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "bucket")
public class BucketDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "customer")
    private UserDTO customer;
    @Column(name = "itemlist")
    private List<ItemDTO> itemList;
}
