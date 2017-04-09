package com.bbcare.cloud.followUsed.service;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeRecord;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:会员随访记录	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IBabyFollowSchemeRecordService {	
	
    /**	
	 * Name:保存会员随访记录	
	 * Params:	
	 *		babyFollowSchemeRecord:会员随访记录实例	
	 * Return:	
	 *		String:新增会员随访记录ID	
	 */	
	public String add(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception;
	
	/**	
	 * Name:删除会员随访记录	
	 * Params:	
	 *		id:会员随访记录ID	
	 */	
	public void remove(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception;
	
	/**	
	 * Name:修改会员随访记录	
	 * Params:	
	 *		babyFollowSchemeRecord:会员随访记录实例		
	 */	
	public BabyFollowSchemeRecord modify(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception;	
	
	/**	
	 * Name:查询会员随访记录	
	 * Params:	
	 *		babyFollowSchemeRecord:会员随访记录	
	 * Return:	
	 *		BabyFollowSchemeRecord:会员随访记录	
	 */	
	public BabyFollowSchemeRecord read(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception;
	
    /**	
	 * Name:查询会员随访记录列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<会员随访记录>:会员随访记录列表	
	 */	
	public List<BabyFollowSchemeRecord> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:会员随访记录数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:会员随访记录总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
    /**	
	 * Name:查询会员随访记录列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:会员随访记录列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核会员随访记录	
	 * Params:
	 *		babyFollowSchemeRecord:会员随访记录实例		
	 */	
	public Boolean review(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception;	
	
}