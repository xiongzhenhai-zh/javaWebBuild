package com.careJava.code.dao;

import com.careJava.code.entry.Article;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:文章	持久层接口
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	
	
public interface IArticleDAO {	
	
    /**	
	 * Name:保存文章	
	 * Params:	
	 *		article:文章实例	
	 * Return:	
	 *		String:新增文章ID	
	 */	
	public String save(Article article) throws Exception;
	
	/**	
	 * Name:删除文章	
	 * Params:	
	 *		id:文章ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改文章	
	 * Params:	
	 *		article:文章实例		
	 */	
	public void update(Article article) throws Exception;	
	
	/**	
	 * Name:查询文章	
	 * Params:	
	 *		id:文章ID	
	 * Return:	
	 *		Article:文章	
	 */	
	public Article get(String id) throws Exception;
	
    /**	
	 * Name:查询文章列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<文章>:文章列表	
	 */	
	public List<Article> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:文章数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:文章总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;
	
	/**
	 * Name:根据hql查询
	 * @param hql
	 * @param value
	 * @param rows 
	 * @param page 
	 * @return
	 */
	 @SuppressWarnings("rawtypes")
	public List queryHQL(String hql,Map<String, Object> value, int page, int rows) throws Exception;
	
	/**
	 * Name:根据hql删除或更新
	 * @param hql
	 * @param value2
	 * @return
	 * @throws Exception
	 */
	public Integer queryUpdate(String hql, Map<String, Object> value) throws Exception;	
	
	/**
	 * Name:根据sql返回List<Map>
	 * @param hql
	 * @param value
	 * @param rows 
	 * @param page 
	 * @return
	 * @throws Exception
	 */
	public List querySQLMap(final String sql,final Map<String, Object> value,final int page,final int rows)  throws Exception
	
	public List querySQL(final String sql,final Map<String, Object> value,final int page,final int rows) throws Exception;
	
	public int queryUpdateSQL( final String sql)throws Exception;
	
}