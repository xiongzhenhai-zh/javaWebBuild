package com.careJava.code.service.impl;

import com.careJava.code.entry.Article;
import com.careJava.code.dao.IArticleDAO;
import com.careJava.code.service.IArticleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.careJava.code.entry.User;
import com.careJava.code.dao.IUserDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:文章	持久层接口
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	
	
@Service
public class ArticleService implements IArticleService {
	
	@Autowired
	private IArticleDAO articleDAO;	
	
	@Autowired
	private IUserDAO userDAO;
	
    public String add(Article article) throws Exception {
    	Article tempArticle = new Article();
		tempArticle.setTitle(article.getTitle());
		tempArticle.setCreateTime(article.getCreateTime());
		tempArticle.setKeyWord(article.getKeyWord());
		tempArticle.setContent(article.getContent());
		tempArticle.setStatus(article.getStatus());
		tempArticle.setType(article.getType());
		if(article.getUser()!=null&&article.getUser().getId()!=null&&article.getUser().getId().trim().length()>0){
			User userTemp = userDAO.get(article.getUser().getId());
			if(userTemp!=null){
				tempArticle.setUser(userTemp);
				tempArticle.setUserName(userTemp.getName());
			}
		}
		return articleDAO.save(tempArticle);	
	}
	
    public void remove(Article article) throws Exception {	
		articleDAO.delete(article.getId());	
	}
	
    public Article modify(Article article) throws Exception {	
		Article tempArticle = articleDAO.get(article.getId());
		
		if(article.getTitle()!=null){
			tempArticle.setTitle(article.getTitle());
		}
		if(article.getCreateTime()!=null){
			tempArticle.setCreateTime(article.getCreateTime());
		}
		if(article.getKeyWord()!=null){
			tempArticle.setKeyWord(article.getKeyWord());
		}
		if(article.getContent()!=null){
			tempArticle.setContent(article.getContent());
		}
		if(article.getStatus()!=null){
			tempArticle.setStatus(article.getStatus());
		}
		if(article.getType()!=null){
			tempArticle.setType(article.getType());
		}
		if(article.getUser()!=null&& article.getUser().getId()!=null&&article.getUser().getId().trim().length()>0){
			User userTemp = userDAO.get(article.getUser().getId());
			if(userTemp!=null){
				tempArticle.setUser(userTemp);
				tempArticle.setUserName(userTemp.getName());
			}
		}
		articleDAO.update(tempArticle);	
		return tempArticle;	
	}
	
    public Article read(Article article) throws Exception {	
		return articleDAO.get(article.getId());	
	}	
	
    public List<Article> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return articleDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return articleDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<Article> articles = articleDAO.list(dc, page, rows);
		for(Article article:articles){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",article.getId());
			obj.put("text",article.getId());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(Article article) throws Exception {
    	if(article.getStatus()==null){
    		return false;
    	}
		Article tempArticle = articleDAO.get(article.getId());
		if(tempArticle!=null){
			tempArticle.setStatus(article.getStatus());
			articleDAO.update(tempArticle);
			return true;
		}else{
			return false;
		}
	}
	
}