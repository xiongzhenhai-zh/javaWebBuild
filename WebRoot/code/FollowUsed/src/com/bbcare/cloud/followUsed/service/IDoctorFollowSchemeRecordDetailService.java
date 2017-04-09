package com.bbcare.cloud.followUsed.service;

import com.bbcare.cloud.followUsed.entry.DoctorFollowSchemeRecordDetail;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:会员随访记录内容	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IDoctorFollowSchemeRecordDetailService {	
	
    /**	
	 * Name:保存会员随访记录内容	
	 * Params:	
	 *		doctorFollowSchemeRecordDetail:会员随访记录内容实例	
	 * Return:	
	 *		String:新增会员随访记录内容ID	
	 */	
	public String add(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception;
	
	/**	
	 * Name:删除会员随访记录内容	
	 * Params:	
	 *		id:会员随访记录内容ID	
	 */	
	public void remove(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception;
	
	/**	
	 * Name:修改会员随访记录内容	
	 * Params:	
	 *		doctorFollowSchemeRecordDetail:会员随访记录内容实例		
	 */	
	public DoctorFollowSchemeRecordDetail modify(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception;	
	
	/**	
	 * Name:查询会员随访记录内容	
	 * Params:	
	 *		doctorFollowSchemeRecordDetail:会员随访记录内容	
	 * Return:	
	 *		DoctorFollowSchemeRecordDetail:会员随访记录内容	
	 */	
	public DoctorFollowSchemeRecordDetail read(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception;
	
    /**	
	 * Name:查询会员随访记录内容列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<会员随访记录内容>:会员随访记录内容列表	
	 */	
	public List<DoctorFollowSchemeRecordDetail> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:会员随访记录内容数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:会员随访记录内容总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
    /**	
	 * Name:查询会员随访记录内容列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:会员随访记录内容列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核会员随访记录内容	
	 * Params:
	 *		doctorFollowSchemeRecordDetail:会员随访记录内容实例		
	 */	
	public Boolean review(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception;	
	
}