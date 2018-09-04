package db.dto;

import db.PaymentType;
import db.ShippingMethod;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "customer")
    private UserDTO customer;
    @Column(name = "items")
    private List<ItemDTO> itemList;
    @Column(name = "shippingmethod")
    private ShippingMethod shippingMethod;
    @Column(name = "paymenttype")
    private PaymentType paymentType;

}
