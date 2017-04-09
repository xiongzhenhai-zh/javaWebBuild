package com.lechen.project.service;

import com.lechen.project.entry.DoctorQuestionModuleAdvice;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:医生模块建议	持久层接口
 * @author:	
 * @createTime: 2016-01-20 13:13:59
 */	
	
public interface IDoctorQuestionModuleAdviceService {	
	
    /**	
	 * Name:保存医生模块建议	
	 * Params:	
	 *		doctorQuestionModuleAdvice:医生模块建议实例	
	 * Return:	
	 *		String:新增医生模块建议ID	
	 */	
	public String add(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception;
	
	/**	
	 * Name:删除医生模块建议	
	 * Params:	
	 *		id:医生模块建议ID	
	 */	
	public void remove(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception;
	
	/**	
	 * Name:修改医生模块建议	
	 * Params:	
	 *		doctorQuestionModuleAdvice:医生模块建议实例		
	 */	
	public DoctorQuestionModuleAdvice modify(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception;	
	
	/**	
	 * Name:查询医生模块建议	
	 * Params:	
	 *		doctorQuestionModuleAdvice:医生模块建议	
	 * Return:	
	 *		DoctorQuestionModuleAdvice:医生模块建议	
	 */	
	public DoctorQuestionModuleAdvice read(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception;
	
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
	
	/**
	 * Name:根据hql查询
	 * @param hql
	 * @param value
	 * @param rows 
	 * @param page 
	 * @return
	 */
	 @SuppressWarnings("rawtypes")
	public List queryHQL(String hql,Map<String, Object> value, int page, int rows) throws Exception;
	
    /**	
	 * Name:查询医生模块建议列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:医生模块建议列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}