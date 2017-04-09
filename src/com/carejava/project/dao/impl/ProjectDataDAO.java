package com.carejava.project.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.carejava.project.dao.IProjectDataDAO;
import com.carejava.project.entry.ProjectData;

/**
 * @name:项目数据	持久层接口
 * @author:	
 * @createTime: 2016-01-10 19:30:30
 */	
	
@Repository	
public class ProjectDataDAO implements IProjectDataDAO {	
	
	@Autowired	
	private HibernateTemplate hibernateTemplate;	
	
	public String save(ProjectData projectData) throws Exception {	
		return (String) hibernateTemplate.save(projectData);	
	}
	  
    public void delete(String id) throws Exception {	
		hibernateTemplate.delete(hibernateTemplate.get(ProjectData.class, id));	
	}	
	
   	public void update(ProjectData projectData) throws Exception {	
		hibernateTemplate.update(projectData);	
	}
	
    public ProjectData get(String id) throws Exception {	
		return hibernateTemplate.get(ProjectData.class, id);	
	}
	
    @SuppressWarnings({"unchecked", "rawtypes" })	
	public List<ProjectData> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return hibernateTemplate.executeFind( new  HibernateCallback(){
			public List<ProjectData> doInHibernate(Session session)  throws  SQLException,
			HibernateException {
				Criteria criteria=dc.getExecutableCriteria(session);
				if(page!=0&&rows!=0){
					criteria.setFirstResult((page-1)*rows);
					criteria.setMaxResults(rows);
				}
				return (List<ProjectData>)criteria.list();
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