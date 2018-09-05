package db.dao;

import db.dto.ItemDTO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;


public class ItemDAO {
    private Session session;

    public ItemDAO(Session session) {
        this.session = session;
    }

    public ItemDTO getById(long id) throws HibernateException {
        return (ItemDTO) session.get(ItemDTO.class, id);
    }

    public Collection<ItemDTO> getAll(){
        Criteria criteria = session.createCriteria(ItemDTO.class);
        return (Collection<ItemDTO>)criteria.list();
    }

    public ItemDTO getByName(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(ItemDTO.class);
        return ((ItemDTO) criteria.add(Restrictions.eq("name", name)));
    }

    public long saveItem(ItemDTO item) throws HibernateException {
        return (Long) session.save(item);
    }
}
