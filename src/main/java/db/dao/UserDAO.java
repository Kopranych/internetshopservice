package db.dao;

import db.dto.UserDTO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public UserDTO getById(long id) throws HibernateException {
        return (UserDTO) session.get(UserDTO.class, id);
    }

    public Collection<UserDTO> getAll(){
        Criteria criteria = session.createCriteria(UserDTO.class);
        return (Collection<UserDTO>)criteria.list();
    }

    public UserDTO getByName(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UserDTO.class);
        return ((UserDTO) criteria.add(Restrictions.eq("name", name)));
    }

    public long saveItem(UserDTO user) throws HibernateException {
        return (Long) session.save(user);
    }
}
