package com.bbcare.cloud.followConfig.service;

import com.bbcare.cloud.followConfig.entry.FollowQuestionnaire;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访问卷版本	持久层接口
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
public interface IFollowQuestionnaireService {	
	
    /**	
	 * Name:保存随访问卷版本	
	 * Params:	
	 *		followQuestionnaire:随访问卷版本实例	
	 * Return:	
	 *		String:新增随访问卷版本ID	
	 */	
	public String add(FollowQuestionnaire followQuestionnaire) throws Exception;
	
	/**	
	 * Name:删除随访问卷版本	
	 * Params:	
	 *		id:随访问卷版本ID	
	 */	
	public void remove(FollowQuestionnaire followQuestionnaire) throws Exception;
	
	/**	
	 * Name:修改随访问卷版本	
	 * Params:	
	 *		followQuestionnaire:随访问卷版本实例		
	 */	
	public FollowQuestionnaire modify(FollowQuestionnaire followQuestionnaire) throws Exception;	
	
	/**	
	 * Name:查询随访问卷版本	
	 * Params:	
	 *		followQuestionnaire:随访问卷版本	
	 * Return:	
	 *		FollowQuestionnaire:随访问卷版本	
	 */	
	public FollowQuestionnaire read(FollowQuestionnaire followQuestionnaire) throws Exception;
	
    /**	
	 * Name:查询随访问卷版本列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访问卷版本>:随访问卷版本列表	
	 */	
	public List<FollowQuestionnaire> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访问卷版本数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访问卷版本总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
    /**	
	 * Name:查询随访问卷版本列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访问卷版本列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核随访问卷版本	
	 * Params:
	 *		followQuestionnaire:随访问卷版本实例		
	 */	
	public Boolean review(FollowQuestionnaire followQuestionnaire) throws Exception;	
	
}