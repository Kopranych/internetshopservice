package db.dto;

import db.PaymentType;
import db.ShippingMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @OneToOne
    @JoinColumn(name = "customer")
    private UserDTO customer;
    @OneToMany
    @JoinColumn(name = "items")
    private List<ItemDTO> itemList;
    @Column(name = "shippingmethod")
    private ShippingMethod shippingMethod;
    @Column(name = "paymenttype")
    private PaymentType paymentType;

    public OrderDTO(UserDTO customer, List<ItemDTO> itemList, ShippingMethod shippingMethod, PaymentType paymentType){
        this.customer = customer;
        this.itemList = itemList;
        this.shippingMethod = shippingMethod;
        this.paymentType = paymentType;
    }

}
