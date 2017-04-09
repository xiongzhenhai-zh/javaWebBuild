package com.bbcare.cloud.follow.dao.impl;

import com.bbcare.cloud.follow.entry.FollowTemplate;
import com.bbcare.cloud.follow.dao.IFollowTemplateDAO;
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
 * @name:随访模版	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Repository	
public class FollowTemplateDAO implements IFollowTemplateDAO {	
	
	@Autowired	
	private HibernateTemplate hibernateTemplate;	
	
	public String save(FollowTemplate followTemplate) throws Exception {	
		return (String) hibernateTemplate.save(followTemplate);	
	}
	  
    public void delete(String id) throws Exception {	
		hibernateTemplate.delete(hibernateTemplate.get(FollowTemplate.class, id));	
	}	
	
   	public void update(FollowTemplate followTemplate) throws Exception {	
		hibernateTemplate.update(followTemplate);	
	}
	
    public FollowTemplate get(String id) throws Exception {	
		return hibernateTemplate.get(FollowTemplate.class, id);	
	}
	
    @SuppressWarnings({"unchecked", "rawtypes" })	
	public List<FollowTemplate> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return hibernateTemplate.executeFind( new  HibernateCallback(){
			public List<FollowTemplate> doInHibernate(Session session)  throws  SQLException,
			HibernateException {
				Criteria criteria=dc.getExecutableCriteria(session);
				if(page!=0&&rows!=0){
					criteria.setFirstResult((page-1)*rows);
					criteria.setMaxResults(rows);
				}
				return (List<FollowTemplate>)criteria.list();
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List queryHQL(final String hql,final Map<String, Object> value,final int page,final int rows) throws Exception {
		return hibernateTemplate.executeFind( new  HibernateCallback(){
			public List doInHibernate(Session session)  throws  SQLException,
			HibernateException {
				Query query = session.createQuery(hql);
				if (value!=null) {
					Set<String> keySet = value.keySet();  
		            for (String string : keySet) {  
		                Object obj = value.get(string);  
		                //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		                if(obj instanceof Collection<?>){  
		                    query.setParameterList(string, (Collection<?>)obj);  
		                }else if(obj instanceof Object[]){  
		                    query.setParameterList(string, (Object[])obj);  
		                }else{  
		                    query.setParameter(string, obj);  
		                }  
		            }  
		        }  
				if (page!=0 && rows!=0) {
					query.setFirstResult((page-1)*rows);
					query.setMaxResults(rows);
					query.setResultTransformer(CriteriaSpecification.ROOT_ENTITY); 
				}
				List list = query.list();
				session.close();
				return list;
			}
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer queryUpdate(final String hql, final Map<String,Object> value)throws Exception {
		return hibernateTemplate.execute( new HibernateCallback(){
			public Integer doInHibernate(Session session)  throws  SQLException,
			HibernateException {
				Query query = session.createQuery(hql);
				if (value!=null) {
					Set<String> keySet = value.keySet();  
		            for (String string : keySet) {  
		                Object obj = value.get(string);  
		                //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		                if(obj instanceof Collection<?>){  
		                    query.setParameterList(string, (Collection<?>)obj);  
		                }else if(obj instanceof Object[]){  
		                    query.setParameterList(string, (Object[])obj);  
		                }else{  
		                    query.setParameter(string, obj);  
		                }  
		            }  
		        }  
				Integer result=query.executeUpdate();
				session.close();
				return result;
			}
		});
	}
	
}