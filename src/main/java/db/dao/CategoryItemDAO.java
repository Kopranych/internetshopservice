package db.dao;

import db.dto.CategoryItemDTO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

public class CategoryItemDAO {
    private Session session;

    public CategoryItemDAO(Session session) {
        this.session = session;
    }

    public CategoryItemDTO getById(long id) throws HibernateException {
        return (CategoryItemDTO) session.get(CategoryItemDTO.class, id);
    }

    public Collection<CategoryItemDTO> getAll(){
        Criteria criteria = session.createCriteria(CategoryItemDTO.class);
        return (Collection<CategoryItemDTO>)criteria.list();
    }

    public long getByName(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(CategoryItemDTO.class);
        return ((CategoryItemDTO) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }

    public long saveItem(CategoryItemDTO item) throws HibernateException {
        return (Long) session.save(item);
    }
}
