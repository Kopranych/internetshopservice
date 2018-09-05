import db.DBConfig;
import db.dao.ItemDAO;
import db.dto.ItemDTO;

public class Main {
    public static void main(String[] args) {
        DBConfig dbConfig = new DBConfig();
        ItemDTO item = new ItemDTO();
        item.setDescription("Деревянный стол");
        item.setName("Стол");
        ItemDAO itemDAO = new ItemDAO(dbConfig.getSessionFactory().openSession());
        itemDAO.saveItem(item);
        ItemDTO temp = itemDAO.getByName("Стол");
        System.out.println(temp.getDescription());
    }
}
