package service.impl;

import db.DBConfig;
import db.dao.AvailableItemsDAO;
import db.dao.ItemDAO;
import db.dto.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.ShopService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private Session session;
    private DBConfig dbConfig;

    public ShopServiceImpl() {
        this.dbConfig = new DBConfig();
    }

    public List<ItemDTO> showAvailableItemList() {
        List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
        try {
            session = dbConfig.getSessionFactory().openSession();
            AvailableItemsDAO availableItemsDAO = new AvailableItemsDAO(session);
            List<AvailableItemsDTO> availableItemsDTOList = (List<AvailableItemsDTO>) availableItemsDAO.getAll();
            ItemDAO itemDAO = new ItemDAO(session);
            for (AvailableItemsDTO avaItem : availableItemsDTOList) {
                if (avaItem.getCount() > 0) {
                    ItemDTO itemDTO = itemDAO.getByArticle(avaItem.getArticle());
                    itemDTOList.add(itemDTO);
                    System.out.println(itemDTO.getId() + " name " + itemDTO.getName() + " description " + itemDTO.getDescription() + " count " + avaItem.getCount() + " price " + itemDTO.getPrice());
                }
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return itemDTOList;
    }

    public void addItemToBucket(UserDTO user, ItemDTO item) {

    }

    public void checkout(OrderDTO order) {

    }

    public List<ItemDTO> showItemInBucket(BucketDTO bucket) {
        return null;
    }

    public void updateAvailableItem() {

    }

    public long addItem(){

    }

    public void createTestItem(){
        List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
        List<AvailableItemsDTO> availableItemsDTOList = new ArrayList<AvailableItemsDTO>();
        itemDTOList.add(new ItemDTO("table", "", "", "1a", 100));
        availableItemsDTOList.add(new AvailableItemsDTO("1a", 2));
        itemDTOList.add(new ItemDTO("chair", "", "", "2a", 50));
        availableItemsDTOList.add(new AvailableItemsDTO("2a", 3));
        itemDTOList.add(new ItemDTO("bed", "", "", "3a", 200));
        availableItemsDTOList.add(new AvailableItemsDTO("3a", 1));
        itemDTOList.add(new ItemDTO("cupboard", "", "", "4a", 200));
        availableItemsDTOList.add(new AvailableItemsDTO("4a", 2));
        Iterator<ItemDTO> itrItem = itemDTOList.iterator();
        Iterator<AvailableItemsDTO> itrAvail = availableItemsDTOList.iterator();
        try {
            Session session1 = dbConfig.getSessionFactory().openSession();
            Session session2 = dbConfig.getSessionFactory().openSession();
            ItemDAO itemDAO = new ItemDAO(session1);
            AvailableItemsDAO availableItemsDAO = new AvailableItemsDAO(session2);
            while(itrItem.hasNext()) {
                Transaction transaction = session1.beginTransaction();
                itemDAO.saveItem(itrItem.next());
                transaction.commit();
            }
            while(itrAvail.hasNext()) {
                Transaction transaction2 = session2.beginTransaction();
                availableItemsDAO.saveAvailableItem(itrAvail.next());
                transaction2.commit();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
