package com.bbcare.cloud.followUsed.service;

import com.bbcare.cloud.followUsed.entry.BabyFollowScheme;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:宝宝随访方案	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IBabyFollowSchemeService {	
	
    /**	
	 * Name:保存宝宝随访方案	
	 * Params:	
	 *		babyFollowScheme:宝宝随访方案实例	
	 * Return:	
	 *		String:新增宝宝随访方案ID	
	 */	
	public String add(BabyFollowScheme babyFollowScheme) throws Exception;
	
	/**	
	 * Name:删除宝宝随访方案	
	 * Params:	
	 *		id:宝宝随访方案ID	
	 */	
	public void remove(BabyFollowScheme babyFollowScheme) throws Exception;
	
	/**	
	 * Name:修改宝宝随访方案	
	 * Params:	
	 *		babyFollowScheme:宝宝随访方案实例		
	 */	
	public BabyFollowScheme modify(BabyFollowScheme babyFollowScheme) throws Exception;	
	
	/**	
	 * Name:查询宝宝随访方案	
	 * Params:	
	 *		babyFollowScheme:宝宝随访方案	
	 * Return:	
	 *		BabyFollowScheme:宝宝随访方案	
	 */	
	public BabyFollowScheme read(BabyFollowScheme babyFollowScheme) throws Exception;
	
    /**	
	 * Name:查询宝宝随访方案列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<宝宝随访方案>:宝宝随访方案列表	
	 */	
	public List<BabyFollowScheme> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:宝宝随访方案数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:宝宝随访方案总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
    /**	
	 * Name:查询宝宝随访方案列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:宝宝随访方案列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}