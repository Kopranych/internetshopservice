package service;

import db.PaymentType;
import db.ShippingMethod;
import db.dto.BucketDTO;
import db.dto.ItemDTO;
import db.dto.UserDTO;

import java.util.List;

public interface ShopService {

    List<ItemDTO> showAvailableItemList();
    long saveBucket(BucketDTO busket);
    long checkout(BucketDTO bucket, UserDTO user, ShippingMethod shippingMethod, PaymentType paymentType);
    List<ItemDTO> showItemInBucket(BucketDTO bucket);
    void updateAvailableItem(long itemId, boolean add);
    long saveCustomer(UserDTO user);
}
