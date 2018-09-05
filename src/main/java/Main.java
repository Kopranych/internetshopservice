
import db.dto.BucketDTO;
import db.dto.ItemDTO;
import db.dto.UserDTO;
import service.impl.ShopServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDTO user = new UserDTO("User");
        BucketDTO bucket = new BucketDTO();
        bucket.setCustomer(user);
        ShopServiceImpl service = new ShopServiceImpl();
        service.createTestItem();
        while (true) {
            List<ItemDTO> itemDTOList = service.showAvailableItemList();
            System.out.println("Select item by number or enter \"0\" for exit");
            Scanner sc = new Scanner(System.in);
            int numberItem = sc.nextInt();
            if (numberItem == 0) {
                break;
            }
            if (numberItem > itemDTOList.size()) {
                System.out.println("No such item");
                continue;
            }

        }
    }
}
