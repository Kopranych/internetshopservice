package db.dao;

import db.dto.BucketDTO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

public class BucketDAO {
    private Session session;

    public BucketDAO(Session session) {
        this.session = session;
    }

    public BucketDTO getById(long id) throws HibernateException {
        return (BucketDTO) session.get(BucketDTO.class, id);
    }

    public BucketDTO getByUserId(long user_id){
        Criteria criteria = session.createCriteria(BucketDTO.class);
        return ((BucketDTO) criteria.add(Restrictions.eq("customer", user_id)));
    }

    public Collection<BucketDTO> getAll(){
        Criteria criteria = session.createCriteria(BucketDTO.class);
        return (Collection<BucketDTO>)criteria.list();
    }


    public long saveBucket(BucketDTO bucket) throws HibernateException {
        return (Long) session.save(bucket);
    }
}
