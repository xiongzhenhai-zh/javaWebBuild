package com.careJava.code.service;

import com.careJava.code.entry.Article;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:文章	持久层接口
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	
	
public interface IArticleService {	
	
    /**	
	 * Name:保存文章	
	 * Params:	
	 *		article:文章实例	
	 * Return:	
	 *		String:新增文章ID	
	 */	
	public String add(Article article) throws Exception;
	
	/**	
	 * Name:删除文章	
	 * Params:	
	 *		id:文章ID	
	 */	
	public void remove(Article article) throws Exception;
	
	/**	
	 * Name:修改文章	
	 * Params:	
	 *		article:文章实例		
	 */	
	public Article modify(Article article) throws Exception;	
	
	/**	
	 * Name:查询文章	
	 * Params:	
	 *		article:文章	
	 * Return:	
	 *		Article:文章	
	 */	
	public Article read(Article article) throws Exception;
	
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
	 * Name:查询文章列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:文章列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核文章	
	 * Params:
	 *		article:文章实例		
	 */	
	public Boolean review(Article article) throws Exception;	
	
}