package db.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "buckets")
public class BucketDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @OneToOne
    @JoinColumn(name = "customer")
    private UserDTO customer;
    @ManyToMany
    @JoinColumn(name = "itemlist")
    private List<ItemDTO> itemList;
}
