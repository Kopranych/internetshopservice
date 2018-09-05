package service;

import db.dto.BucketDTO;
import db.dto.ItemDTO;
import db.dto.OrderDTO;
import db.dto.UserDTO;

import java.util.List;

public interface ShopService {

    List<ItemDTO> showAvailableItemList();
    void addItemToBucket(UserDTO user, ItemDTO item);
    void checkout(OrderDTO order);
    List<ItemDTO> showItemInBucket(BucketDTO bucket);
    void updateAvailableItem();
}
