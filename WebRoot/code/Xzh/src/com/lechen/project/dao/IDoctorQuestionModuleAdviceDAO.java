package com.lechen.project.dao;

import com.lechen.project.entry.DoctorQuestionModuleAdvice;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:医生模块建议	持久层接口
 * @author:	
 * @createTime: 2016-01-20 13:13:59
 */	
	
public interface IDoctorQuestionModuleAdviceDAO {	
	
    /**	
	 * Name:保存医生模块建议	
	 * Params:	
	 *		doctorQuestionModuleAdvice:医生模块建议实例	
	 * Return:	
	 *		String:新增医生模块建议ID	
	 */	
	public String save(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception;
	
	/**	
	 * Name:删除医生模块建议	
	 * Params:	
	 *		id:医生模块建议ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改医生模块建议	
	 * Params:	
	 *		doctorQuestionModuleAdvice:医生模块建议实例		
	 */	
	public void update(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception;	
	
	/**	
	 * Name:查询医生模块建议	
	 * Params:	
	 *		id:医生模块建议ID	
	 * Return:	
	 *		DoctorQuestionModuleAdvice:医生模块建议	
	 */	
	public DoctorQuestionModuleAdvice get(String id) throws Exception;
	
    /**	
	 * Name:查询医生模块建议列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<医生模块建议>:医生模块建议列表	
	 */	
	public List<DoctorQuestionModuleAdvice> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:医生模块建议数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:医生模块建议总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}