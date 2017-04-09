package com.bbcare.cloud.followConfig.service.impl;

import com.bbcare.cloud.followConfig.entry.FollowQuestionnaire;
import com.bbcare.cloud.followConfig.dao.IFollowQuestionnaireDAO;
import com.bbcare.cloud.followConfig.service.IFollowQuestionnaireService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.followConfig.entry.FollowLibrary;
import com.bbcare.cloud.followConfig.dao.IFollowLibraryDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访问卷版本	持久层接口
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
@Service
public class FollowQuestionnaireService implements IFollowQuestionnaireService {
	
	@Autowired
	private IFollowQuestionnaireDAO followQuestionnaireDAO;	
	
	@Autowired
	private IFollowLibraryDAO followLibraryDAO;
	
    public String add(FollowQuestionnaire followQuestionnaire) throws Exception {
    	FollowQuestionnaire tempFollowQuestionnaire = new FollowQuestionnaire();
		tempFollowQuestionnaire.setType(followQuestionnaire.getType());
		tempFollowQuestionnaire.setStatus(followQuestionnaire.getStatus());
		tempFollowQuestionnaire.setName(followQuestionnaire.getName());
		tempFollowQuestionnaire.setCreateTime(followQuestionnaire.getCreateTime());
		if(followQuestionnaire.getFollowLibrary()!=null&&followQuestionnaire.getFollowLibrary().getId()!=null&&followQuestionnaire.getFollowLibrary().getId().trim().length()>0){
			FollowLibrary followLibraryTemp = followLibraryDAO.get(followQuestionnaire.getFollowLibrary().getId());
			if(followLibraryTemp!=null){
				tempFollowQuestionnaire.setFollowLibrary(followLibraryTemp);
				tempFollowQuestionnaire.setFollowLibraryName(followLibraryTemp.getName());
			}
		}
		return followQuestionnaireDAO.save(tempFollowQuestionnaire);	
	}
	
    public void remove(FollowQuestionnaire followQuestionnaire) throws Exception {	
		followQuestionnaireDAO.delete(followQuestionnaire.getId());	
	}
	
    public FollowQuestionnaire modify(FollowQuestionnaire followQuestionnaire) throws Exception {	
		FollowQuestionnaire tempFollowQuestionnaire = followQuestionnaireDAO.get(followQuestionnaire.getId());
		
		if(followQuestionnaire.getType()!=null){
			tempFollowQuestionnaire.setType(followQuestionnaire.getType());
		}
		if(followQuestionnaire.getStatus()!=null){
			tempFollowQuestionnaire.setStatus(followQuestionnaire.getStatus());
		}
		if(followQuestionnaire.getName()!=null){
			tempFollowQuestionnaire.setName(followQuestionnaire.getName());
		}
		if(followQuestionnaire.getCreateTime()!=null){
			tempFollowQuestionnaire.setCreateTime(followQuestionnaire.getCreateTime());
		}
		if(followQuestionnaire.getFollowLibrary()!=null&& followQuestionnaire.getFollowLibrary().getId()!=null&&followQuestionnaire.getFollowLibrary().getId().trim().length()>0){
			FollowLibrary followLibraryTemp = followLibraryDAO.get(followQuestionnaire.getFollowLibrary().getId());
			if(followLibraryTemp!=null){
				tempFollowQuestionnaire.setFollowLibrary(followLibraryTemp);
				tempFollowQuestionnaire.setFollowLibraryName(followLibraryTemp.getName());
			}
		}
		followQuestionnaireDAO.update(tempFollowQuestionnaire);	
		return tempFollowQuestionnaire;	
	}
	
    public FollowQuestionnaire read(FollowQuestionnaire followQuestionnaire) throws Exception {	
		return followQuestionnaireDAO.get(followQuestionnaire.getId());	
	}	
	
    public List<FollowQuestionnaire> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followQuestionnaireDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followQuestionnaireDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowQuestionnaire> followQuestionnaires = followQuestionnaireDAO.list(dc, page, rows);
		for(FollowQuestionnaire followQuestionnaire:followQuestionnaires){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followQuestionnaire.getId());
			obj.put("text",followQuestionnaire.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(FollowQuestionnaire followQuestionnaire) throws Exception {
    	if(followQuestionnaire.getStatus()==null){
    		return false;
    	}
		FollowQuestionnaire tempFollowQuestionnaire = followQuestionnaireDAO.get(followQuestionnaire.getId());
		if(tempFollowQuestionnaire!=null){
			tempFollowQuestionnaire.setStatus(followQuestionnaire.getStatus());
			followQuestionnaireDAO.update(tempFollowQuestionnaire);
			return true;
		}else{
			return false;
		}
	}
	
}