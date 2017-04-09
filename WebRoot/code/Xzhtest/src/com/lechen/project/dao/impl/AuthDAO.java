package com.lechen.project.dao.impl;

import com.lechen.project.entry.Auth;
import com.lechen.project.dao.IAuthDAO;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.Session;
import java.sql.SQLException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * @name:角色	持久层接口
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	
	
@Repository	
public class AuthDAO implements IAuthDAO {	
	
	@Autowired	
	private HibernateTemplate hibernateTemplate;	
	
	public String save(Auth auth) throws Exception {	
		return (String) hibernateTemplate.save(auth);	
	}
	  
    public void delete(String id) throws Exception {	
		hibernateTemplate.delete(hibernateTemplate.get(Auth.class, id));	
	}	
	
   	public void update(Auth auth) throws Exception {	
		hibernateTemplate.update(auth);	
	}
	
    public Auth get(String id) throws Exception {	
		return hibernateTemplate.get(Auth.class, id);	
	}
	
    @SuppressWarnings({"unchecked", "rawtypes" })	
	public List<Auth> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return hibernateTemplate.executeFind( new  HibernateCallback(){
			public List<Auth> doInHibernate(Session session)  throws  SQLException,
			HibernateException {
				Criteria criteria=dc.getExecutableCriteria(session);
				if(page!=0&&rows!=0){
					criteria.setFirstResult((page-1)*rows);
					criteria.setMaxResults(rows);
				}
				return (List<Auth>)criteria.list();
			}
		});	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return hibernateTemplate.execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = dc.getExecutableCriteria(session);
				CriteriaImpl impl=(CriteriaImpl)criteria;
				Projection projection=impl.getProjection();
				Long size = (Long)criteria.setProjection(Projections.rowCount()).uniqueResult();
				criteria.setProjection(projection);
				if (projection == null) {  
                    criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);  
                }  
				return size;
			}
		});	
	}	
	
}