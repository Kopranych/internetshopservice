package db.dto;

import db.PaymentType;
import db.ShippingMethod;

import java.util.List;

public class OrderDTO {
    private long id;
    private UserDTO customer;
    private List<ItemDTO> itemList;
    private ShippingMethod shippingMethod;
    private PaymentType paymentType;

}
