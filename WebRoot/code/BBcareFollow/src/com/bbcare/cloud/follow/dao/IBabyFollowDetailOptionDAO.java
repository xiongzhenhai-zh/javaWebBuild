package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.BabyFollowDetailOption;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:宝宝随访详情选项	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IBabyFollowDetailOptionDAO {	
	
    /**	
	 * Name:保存宝宝随访详情选项	
	 * Params:	
	 *		babyFollowDetailOption:宝宝随访详情选项实例	
	 * Return:	
	 *		String:新增宝宝随访详情选项ID	
	 */	
	public String save(BabyFollowDetailOption babyFollowDetailOption) throws Exception;
	
	/**	
	 * Name:删除宝宝随访详情选项	
	 * Params:	
	 *		id:宝宝随访详情选项ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改宝宝随访详情选项	
	 * Params:	
	 *		babyFollowDetailOption:宝宝随访详情选项实例		
	 */	
	public void update(BabyFollowDetailOption babyFollowDetailOption) throws Exception;	
	
	/**	
	 * Name:查询宝宝随访详情选项	
	 * Params:	
	 *		id:宝宝随访详情选项ID	
	 * Return:	
	 *		BabyFollowDetailOption:宝宝随访详情选项	
	 */	
	public BabyFollowDetailOption get(String id) throws Exception;
	
    /**	
	 * Name:查询宝宝随访详情选项列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<宝宝随访详情选项>:宝宝随访详情选项列表	
	 */	
	public List<BabyFollowDetailOption> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:宝宝随访详情选项数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:宝宝随访详情选项总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}