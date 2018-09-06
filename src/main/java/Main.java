
import db.PaymentType;
import db.ShippingMethod;
import db.dto.BucketDTO;
import db.dto.ItemDTO;
import db.dto.UserDTO;
import service.impl.ShopServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopServiceImpl service = new ShopServiceImpl();
        UserDTO user = new UserDTO("User");
        service.saveCustomer(user);
        BucketDTO bucket = new BucketDTO();
        Scanner sc = new Scanner(System.in);
        bucket.setCustomer(user);
        service.createTestItem();
        while (true) {
            List<ItemDTO> itemDTOList = service.showAvailableItemList();
            System.out.println("Select item by number or enter \"0\" for exit");

            int numberItem = sc.nextInt();
            if (numberItem == 0) {
                break;
            }
            if (numberItem > itemDTOList.size()) {
                System.out.println("No such item");
                continue;
            }
            ItemDTO selectedItemDTO = null;
            for (ItemDTO item : itemDTOList) {
                if(item.getId() == numberItem){
                    service.updateAvailableItem(numberItem, false);
                    selectedItemDTO = item;
                }
            }
            System.out.println("Add item to bucket");
            bucket.getItemList().add(selectedItemDTO);
        }
        long bucketId = service.saveBucket(bucket);
        System.out.println("List items in the basket");
        for (ItemDTO item : bucket.getItemList()) {
            System.out.println(item.getId() + " name " + item.getName() + " description " + item.getDescription()  + " price " + item.getPrice());
        }
        System.out.println("If you want to place an order, enter 1, else 0");
        int selectUser = sc.nextInt();
        ShippingMethod shippingMethod;
        PaymentType paymentType;
        if(selectUser>0){
            System.out.println("Select shipping method 0 - POST, 1 - COURIER");
            int shippingMethodSelected = sc.nextInt();
            if(shippingMethodSelected>0){
                shippingMethod = ShippingMethod.COURIER;
            }else{
                shippingMethod = ShippingMethod.POST;
            }
            System.out.println("Select payment type 0 - CASH, 1 - CREDIT CARD");
            int paymentTypeSelected = sc.nextInt();
            if(paymentTypeSelected>0){
                paymentType = PaymentType.CREDIT_CARDS;
            }else{
                paymentType = PaymentType.CASH;
            }
            service.checkout(bucket, user, shippingMethod, paymentType);
            System.out.println("Order successfully registered!");
            System.out.println("Good by!");
        }else {
            System.out.println("Good by!");
        }
    }
}
