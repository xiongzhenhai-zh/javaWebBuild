package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.BabyFollowRecord;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访记录	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IBabyFollowRecordDAO {	
	
    /**	
	 * Name:保存随访记录	
	 * Params:	
	 *		babyFollowRecord:随访记录实例	
	 * Return:	
	 *		String:新增随访记录ID	
	 */	
	public String save(BabyFollowRecord babyFollowRecord) throws Exception;
	
	/**	
	 * Name:删除随访记录	
	 * Params:	
	 *		id:随访记录ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改随访记录	
	 * Params:	
	 *		babyFollowRecord:随访记录实例		
	 */	
	public void update(BabyFollowRecord babyFollowRecord) throws Exception;	
	
	/**	
	 * Name:查询随访记录	
	 * Params:	
	 *		id:随访记录ID	
	 * Return:	
	 *		BabyFollowRecord:随访记录	
	 */	
	public BabyFollowRecord get(String id) throws Exception;
	
    /**	
	 * Name:查询随访记录列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访记录>:随访记录列表	
	 */	
	public List<BabyFollowRecord> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访记录数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访记录总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}