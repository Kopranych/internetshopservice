package db.dao;

import db.dto.ItemDTO;
import db.dto.OrderDTO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Collection;

public class OrderDAO {
    private Session session;

    public OrderDAO(Session session) {
        this.session = session;
    }

    public OrderDTO getById(long id) throws HibernateException {
        return (OrderDTO) session.get(OrderDTO.class, id);
    }

    public Collection<ItemDTO> getAll(){
        Criteria criteria = session.createCriteria(ItemDTO.class);
        return (Collection<ItemDTO>)criteria.list();
    }

/*    public Collection<OrderDTO> getByUserId(String userId) throws HibernateException {
        Criteria criteria = session.createCriteria(OrderDTO.class);
        return ((OrderDTO) criteria.add(Restrictions.eq("customer_id", userId)));
    }*/

    public long saveOrder(OrderDTO order) throws HibernateException {
        return (Long) session.save(order);
    }
}
