package com.bbcare.cloud.followUsed.service.impl;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeContent;
import com.bbcare.cloud.followUsed.dao.IBabyFollowSchemeContentDAO;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeContentService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeTask;
import com.bbcare.cloud.followUsed.dao.IBabyFollowSchemeTaskDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:宝宝随访任务内容	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Service
public class BabyFollowSchemeContentService implements IBabyFollowSchemeContentService {
	
	@Autowired
	private IBabyFollowSchemeContentDAO babyFollowSchemeContentDAO;	
	
	@Autowired
	private IBabyFollowSchemeTaskDAO babyFollowSchemeTaskDAO;
	
    public String add(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {
    	BabyFollowSchemeContent tempBabyFollowSchemeContent = new BabyFollowSchemeContent();
		tempBabyFollowSchemeContent.setStatus(babyFollowSchemeContent.getStatus());
		tempBabyFollowSchemeContent.setName(babyFollowSchemeContent.getName());
		tempBabyFollowSchemeContent.setSort(babyFollowSchemeContent.getSort());
		tempBabyFollowSchemeContent.setSourceId(babyFollowSchemeContent.getSourceId());
		tempBabyFollowSchemeContent.setSourceType(babyFollowSchemeContent.getSourceType());
		tempBabyFollowSchemeContent.setUserType(babyFollowSchemeContent.getUserType());
		tempBabyFollowSchemeContent.setType(babyFollowSchemeContent.getType());
		tempBabyFollowSchemeContent.setData(babyFollowSchemeContent.getData());
		tempBabyFollowSchemeContent.setFirstRecord(babyFollowSchemeContent.getFirstRecord());
		tempBabyFollowSchemeContent.setCreateTime(babyFollowSchemeContent.getCreateTime());
		if(babyFollowSchemeContent.getBabyFollowSchemeTask()!=null&&babyFollowSchemeContent.getBabyFollowSchemeTask().getId()!=null&&babyFollowSchemeContent.getBabyFollowSchemeTask().getId().trim().length()>0){
			BabyFollowSchemeTask babyFollowSchemeTaskTemp = babyFollowSchemeTaskDAO.get(babyFollowSchemeContent.getBabyFollowSchemeTask().getId());
			if(babyFollowSchemeTaskTemp!=null){
				tempBabyFollowSchemeContent.setBabyFollowSchemeTask(babyFollowSchemeTaskTemp);
				tempBabyFollowSchemeContent.setBabyFollowSchemeTaskName(babyFollowSchemeTaskTemp.getName());
			}
		}
		return babyFollowSchemeContentDAO.save(tempBabyFollowSchemeContent);	
	}
	
    public void remove(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {	
		babyFollowSchemeContentDAO.delete(babyFollowSchemeContent.getId());	
	}
	
    public BabyFollowSchemeContent modify(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {	
		BabyFollowSchemeContent tempBabyFollowSchemeContent = babyFollowSchemeContentDAO.get(babyFollowSchemeContent.getId());
		
		if(babyFollowSchemeContent.getStatus()!=null){
			tempBabyFollowSchemeContent.setStatus(babyFollowSchemeContent.getStatus());
		}
		if(babyFollowSchemeContent.getName()!=null){
			tempBabyFollowSchemeContent.setName(babyFollowSchemeContent.getName());
		}
		if(babyFollowSchemeContent.getSort()!=null){
			tempBabyFollowSchemeContent.setSort(babyFollowSchemeContent.getSort());
		}
		if(babyFollowSchemeContent.getSourceId()!=null){
			tempBabyFollowSchemeContent.setSourceId(babyFollowSchemeContent.getSourceId());
		}
		if(babyFollowSchemeContent.getSourceType()!=null){
			tempBabyFollowSchemeContent.setSourceType(babyFollowSchemeContent.getSourceType());
		}
		if(babyFollowSchemeContent.getUserType()!=null){
			tempBabyFollowSchemeContent.setUserType(babyFollowSchemeContent.getUserType());
		}
		if(babyFollowSchemeContent.getType()!=null){
			tempBabyFollowSchemeContent.setType(babyFollowSchemeContent.getType());
		}
		if(babyFollowSchemeContent.getData()!=null){
			tempBabyFollowSchemeContent.setData(babyFollowSchemeContent.getData());
		}
		if(babyFollowSchemeContent.getFirstRecord()!=null){
			tempBabyFollowSchemeContent.setFirstRecord(babyFollowSchemeContent.getFirstRecord());
		}
		if(babyFollowSchemeContent.getCreateTime()!=null){
			tempBabyFollowSchemeContent.setCreateTime(babyFollowSchemeContent.getCreateTime());
		}
		if(babyFollowSchemeContent.getBabyFollowSchemeTask()!=null&& babyFollowSchemeContent.getBabyFollowSchemeTask().getId()!=null&&babyFollowSchemeContent.getBabyFollowSchemeTask().getId().trim().length()>0){
			BabyFollowSchemeTask babyFollowSchemeTaskTemp = babyFollowSchemeTaskDAO.get(babyFollowSchemeContent.getBabyFollowSchemeTask().getId());
			if(babyFollowSchemeTaskTemp!=null){
				tempBabyFollowSchemeContent.setBabyFollowSchemeTask(babyFollowSchemeTaskTemp);
				tempBabyFollowSchemeContent.setBabyFollowSchemeTaskName(babyFollowSchemeTaskTemp.getName());
			}
		}
		babyFollowSchemeContentDAO.update(tempBabyFollowSchemeContent);	
		return tempBabyFollowSchemeContent;	
	}
	
    public BabyFollowSchemeContent read(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {	
		return babyFollowSchemeContentDAO.get(babyFollowSchemeContent.getId());	
	}	
	
    public List<BabyFollowSchemeContent> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return babyFollowSchemeContentDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return babyFollowSchemeContentDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<BabyFollowSchemeContent> babyFollowSchemeContents = babyFollowSchemeContentDAO.list(dc, page, rows);
		for(BabyFollowSchemeContent babyFollowSchemeContent:babyFollowSchemeContents){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",babyFollowSchemeContent.getId());
			obj.put("text",babyFollowSchemeContent.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {
    	if(babyFollowSchemeContent.getStatus()==null){
    		return false;
    	}
		BabyFollowSchemeContent tempBabyFollowSchemeContent = babyFollowSchemeContentDAO.get(babyFollowSchemeContent.getId());
		if(tempBabyFollowSchemeContent!=null){
			tempBabyFollowSchemeContent.setStatus(babyFollowSchemeContent.getStatus());
			babyFollowSchemeContentDAO.update(tempBabyFollowSchemeContent);
			return true;
		}else{
			return false;
		}
	}
	
}