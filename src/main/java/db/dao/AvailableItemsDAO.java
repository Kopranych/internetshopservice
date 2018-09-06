package db.dao;

import db.dto.AvailableItemsDTO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

public class AvailableItemsDAO {
    private Session session;

    public AvailableItemsDAO(Session session) {
        this.session = session;
    }

    public AvailableItemsDTO getById(long id) throws HibernateException {
        return (AvailableItemsDTO) session.get(AvailableItemsDTO.class, id);
    }

    public Collection<AvailableItemsDTO> getAll(){
        Criteria criteria = session.createCriteria(AvailableItemsDTO.class);
        return (Collection<AvailableItemsDTO>)criteria.list();
    }

    public AvailableItemsDTO getByArticle(String article) throws HibernateException {
        Criteria criteria = session.createCriteria(AvailableItemsDTO.class);
        return ((AvailableItemsDTO) criteria.add(Restrictions.eq("article", article)).uniqueResult());
    }

    public long saveAvailableItem(AvailableItemsDTO availableItems) throws HibernateException {
        return (Long) session.save(availableItems);
    }

    //TODO public AvailableItemsDTO update(AvailableItemsDTO availableItems);
}
