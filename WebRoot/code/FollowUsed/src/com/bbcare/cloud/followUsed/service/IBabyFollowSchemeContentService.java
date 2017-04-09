package com.bbcare.cloud.followUsed.service;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeContent;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:宝宝随访任务内容	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IBabyFollowSchemeContentService {	
	
    /**	
	 * Name:保存宝宝随访任务内容	
	 * Params:	
	 *		babyFollowSchemeContent:宝宝随访任务内容实例	
	 * Return:	
	 *		String:新增宝宝随访任务内容ID	
	 */	
	public String add(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception;
	
	/**	
	 * Name:删除宝宝随访任务内容	
	 * Params:	
	 *		id:宝宝随访任务内容ID	
	 */	
	public void remove(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception;
	
	/**	
	 * Name:修改宝宝随访任务内容	
	 * Params:	
	 *		babyFollowSchemeContent:宝宝随访任务内容实例		
	 */	
	public BabyFollowSchemeContent modify(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception;	
	
	/**	
	 * Name:查询宝宝随访任务内容	
	 * Params:	
	 *		babyFollowSchemeContent:宝宝随访任务内容	
	 * Return:	
	 *		BabyFollowSchemeContent:宝宝随访任务内容	
	 */	
	public BabyFollowSchemeContent read(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception;
	
    /**	
	 * Name:查询宝宝随访任务内容列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<宝宝随访任务内容>:宝宝随访任务内容列表	
	 */	
	public List<BabyFollowSchemeContent> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:宝宝随访任务内容数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:宝宝随访任务内容总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
    /**	
	 * Name:查询宝宝随访任务内容列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:宝宝随访任务内容列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核宝宝随访任务内容	
	 * Params:
	 *		babyFollowSchemeContent:宝宝随访任务内容实例		
	 */	
	public Boolean review(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception;	
	
}