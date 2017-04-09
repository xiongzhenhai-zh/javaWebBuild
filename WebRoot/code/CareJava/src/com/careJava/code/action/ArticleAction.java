package com.careJava.code.action;

import java.util.Date;
import java.util.Map;
import com.careJava.code.entry.Article;
import com.careJava.code.util.MyActionSupport;
import com.careJava.code.service.IArticleService;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:文章控制层实现
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	

@Controller	
public class ArticleAction extends BBcareControl<Article> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IArticleService articleService;
	
    @RequestMapping("/private/article/add")	
    @ResponseBody
	public JsonResult<Article> add(Article article) throws Exception {
		JsonResult<Article> result = new JsonResult<Article>();
		String id = articleService.add(article);	
		article.setId(id);
		result.setSuccess(true);
		result.setData(article);
		return result;
	}	
	
	@RequestMapping("/private/article/remove")	
	@ResponseBody
	public JsonResult<Article> remove(Article article) throws Exception {	
		JsonResult<Article> result = new JsonResult<Article>();
		articleService.remove(article);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/article/modify")
    @ResponseBody	
	public JsonResult<Article> modify(Article article) throws Exception {
		JsonResult<Article> result = new JsonResult<Article>();
		Article data = articleService.modify(article);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/article/read")	
    @ResponseBody
	public JsonResult<Article> read(Article article) throws Exception {
		JsonResult<Article> result = new JsonResult<Article>();	
		Article data = articleService.read(article);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/article/list")
    @ResponseBody	
	public JsonResult<Article> list(Article article ,int page,int rows) throws Exception {	
		JsonResult<Article> result = new JsonResult<Article>();
		DetachedCriteria dc = DetachedCriteria.forClass(Article.class);
		dc.addOrder(Order.desc("id"));
		if(article.getTitle()!=null){
			dc.add(Restrictions.like("title",article.getTitle(),MatchMode.ANYWHERE));
		}
		if(article.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",article.getCreateTime()));
		}
		if(article.getKeyWord()!=null){
			dc.add(Restrictions.like("keyWord",article.getKeyWord(),MatchMode.ANYWHERE));
		}
		if(article.getContent()!=null){
			dc.add(Restrictions.like("content",article.getContent(),MatchMode.ANYWHERE));
		}
		if(article.getStatus()!=null){
			dc.add(Restrictions.like("status",article.getStatus(),MatchMode.ANYWHERE));
		}
		if(article.getType()!=null){
			dc.add(Restrictions.like("type",article.getType(),MatchMode.ANYWHERE));
		}
		if(article.getUser()!=null&&article.getUser().getId()!=null&&article.getUser().getId().trim().length()>0){
			dc.add(Restrictions.eq("user",article.getUser()));
		}
		
		Long size = articleService.getSize(dc);
		List<Article> list = articleService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/article/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(Article article ,int page,int rows) throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Article.class);
		if(article.getTitle()!=null){
			dc.add(Restrictions.like("title",article.getTitle(),MatchMode.ANYWHERE));
		}
		if(article.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",article.getCreateTime()));
		}
		if(article.getKeyWord()!=null){
			dc.add(Restrictions.like("keyWord",article.getKeyWord(),MatchMode.ANYWHERE));
		}
		if(article.getContent()!=null){
			dc.add(Restrictions.like("content",article.getContent(),MatchMode.ANYWHERE));
		}
		if(article.getStatus()!=null){
			dc.add(Restrictions.like("status",article.getStatus(),MatchMode.ANYWHERE));
		}
		if(article.getType()!=null){
			dc.add(Restrictions.like("type",article.getType(),MatchMode.ANYWHERE));
		}
		if(article.getUser()!=null&&article.getUser().getId()!=null&&article.getUser().getId().trim().length()>0){
			dc.add(Restrictions.eq("user",article.getUser()));
		}
		Long size = articleService.getSize(dc);
		List<Map<String, String>> list = articleService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/article/review")	
    @ResponseBody	
	public JsonResult<Article> review(Article article) throws Exception {
		JsonResult<Article> result = new JsonResult<Article>();
		Boolean success = articleService.review(article);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}