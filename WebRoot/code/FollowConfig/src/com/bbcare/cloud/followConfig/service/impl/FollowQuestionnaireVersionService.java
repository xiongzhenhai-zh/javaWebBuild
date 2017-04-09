package com.bbcare.cloud.followConfig.service.impl;

import com.bbcare.cloud.followConfig.entry.FollowQuestionnaireVersion;
import com.bbcare.cloud.followConfig.dao.IFollowQuestionnaireVersionDAO;
import com.bbcare.cloud.followConfig.service.IFollowQuestionnaireVersionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.followConfig.entry.FollowQuestionnaire;
import com.bbcare.cloud.followConfig.dao.IFollowQuestionnaireDAO;
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
public class FollowQuestionnaireVersionService implements IFollowQuestionnaireVersionService {
	
	@Autowired
	private IFollowQuestionnaireVersionDAO followQuestionnaireVersionDAO;	
	
	@Autowired
	private IFollowQuestionnaireDAO followQuestionnaireDAO;
	
    public String add(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {
    	FollowQuestionnaireVersion tempFollowQuestionnaireVersion = new FollowQuestionnaireVersion();
		tempFollowQuestionnaireVersion.setNote(followQuestionnaireVersion.getNote());
		tempFollowQuestionnaireVersion.setStatus(followQuestionnaireVersion.getStatus());
		tempFollowQuestionnaireVersion.setJson(followQuestionnaireVersion.getJson());
		tempFollowQuestionnaireVersion.setCreateTime(followQuestionnaireVersion.getCreateTime());
		if(followQuestionnaireVersion.getFollowQuestionnaire()!=null&&followQuestionnaireVersion.getFollowQuestionnaire().getId()!=null&&followQuestionnaireVersion.getFollowQuestionnaire().getId().trim().length()>0){
			FollowQuestionnaire followQuestionnaireTemp = followQuestionnaireDAO.get(followQuestionnaireVersion.getFollowQuestionnaire().getId());
			if(followQuestionnaireTemp!=null){
				tempFollowQuestionnaireVersion.setFollowQuestionnaire(followQuestionnaireTemp);
				tempFollowQuestionnaireVersion.setFollowQuestionnaireName(followQuestionnaireTemp.getName());
			}
		}
		return followQuestionnaireVersionDAO.save(tempFollowQuestionnaireVersion);	
	}
	
    public void remove(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {	
		followQuestionnaireVersionDAO.delete(followQuestionnaireVersion.getId());	
	}
	
    public FollowQuestionnaireVersion modify(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {	
		FollowQuestionnaireVersion tempFollowQuestionnaireVersion = followQuestionnaireVersionDAO.get(followQuestionnaireVersion.getId());
		
		if(followQuestionnaireVersion.getNote()!=null){
			tempFollowQuestionnaireVersion.setNote(followQuestionnaireVersion.getNote());
		}
		if(followQuestionnaireVersion.getStatus()!=null){
			tempFollowQuestionnaireVersion.setStatus(followQuestionnaireVersion.getStatus());
		}
		if(followQuestionnaireVersion.getJson()!=null){
			tempFollowQuestionnaireVersion.setJson(followQuestionnaireVersion.getJson());
		}
		if(followQuestionnaireVersion.getCreateTime()!=null){
			tempFollowQuestionnaireVersion.setCreateTime(followQuestionnaireVersion.getCreateTime());
		}
		if(followQuestionnaireVersion.getFollowQuestionnaire()!=null&& followQuestionnaireVersion.getFollowQuestionnaire().getId()!=null&&followQuestionnaireVersion.getFollowQuestionnaire().getId().trim().length()>0){
			FollowQuestionnaire followQuestionnaireTemp = followQuestionnaireDAO.get(followQuestionnaireVersion.getFollowQuestionnaire().getId());
			if(followQuestionnaireTemp!=null){
				tempFollowQuestionnaireVersion.setFollowQuestionnaire(followQuestionnaireTemp);
				tempFollowQuestionnaireVersion.setFollowQuestionnaireName(followQuestionnaireTemp.getName());
			}
		}
		followQuestionnaireVersionDAO.update(tempFollowQuestionnaireVersion);	
		return tempFollowQuestionnaireVersion;	
	}
	
    public FollowQuestionnaireVersion read(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {	
		return followQuestionnaireVersionDAO.get(followQuestionnaireVersion.getId());	
	}	
	
    public List<FollowQuestionnaireVersion> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followQuestionnaireVersionDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followQuestionnaireVersionDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowQuestionnaireVersion> followQuestionnaireVersions = followQuestionnaireVersionDAO.list(dc, page, rows);
		for(FollowQuestionnaireVersion followQuestionnaireVersion:followQuestionnaireVersions){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followQuestionnaireVersion.getId());
			obj.put("text",followQuestionnaireVersion.getId());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {
    	if(followQuestionnaireVersion.getStatus()==null){
    		return false;
    	}
		FollowQuestionnaireVersion tempFollowQuestionnaireVersion = followQuestionnaireVersionDAO.get(followQuestionnaireVersion.getId());
		if(tempFollowQuestionnaireVersion!=null){
			tempFollowQuestionnaireVersion.setStatus(followQuestionnaireVersion.getStatus());
			followQuestionnaireVersionDAO.update(tempFollowQuestionnaireVersion);
			return true;
		}else{
			return false;
		}
	}
	
}