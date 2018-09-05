package service;

import db.dto.BucketDTO;
import db.dto.ItemDTO;
import db.dto.OrderDTO;

import java.util.List;

public interface ItemService {
    void showAvailableItemList();
    void addItemToBucket(ItemDTO item);
    void checkout(OrderDTO order);
    List<ItemDTO> showItemInBucket(BucketDTO bucket);
}
