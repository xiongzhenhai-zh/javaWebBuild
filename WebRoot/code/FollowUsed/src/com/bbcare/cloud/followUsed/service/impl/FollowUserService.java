package com.bbcare.cloud.followUsed.service.impl;

import com.bbcare.cloud.followUsed.entry.FollowUser;
import com.bbcare.cloud.followUsed.dao.IFollowUserDAO;
import com.bbcare.cloud.followUsed.service.IFollowUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访用户	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Service
public class FollowUserService implements IFollowUserService {
	
	@Autowired
	private IFollowUserDAO followUserDAO;	
	
    public String add(FollowUser followUser) throws Exception {
    	FollowUser tempFollowUser = new FollowUser();
		tempFollowUser.setAccountName(followUser.getAccountName());
		tempFollowUser.setBabyId(followUser.getBabyId());
		tempFollowUser.setBabyName(followUser.getBabyName());
		tempFollowUser.setGender(followUser.getGender());
		tempFollowUser.setBirthday(followUser.getBirthday());
		tempFollowUser.setPregnancyWeek(followUser.getPregnancyWeek());
		tempFollowUser.setInpatientNum(followUser.getInpatientNum());
		tempFollowUser.setIdCard(followUser.getIdCard());
		tempFollowUser.setStatus(followUser.getStatus());
		tempFollowUser.setType(followUser.getType());
		tempFollowUser.setCreateTime(followUser.getCreateTime());
		return followUserDAO.save(tempFollowUser);	
	}
	
    public void remove(FollowUser followUser) throws Exception {	
		followUserDAO.delete(followUser.getId());	
	}
	
    public FollowUser modify(FollowUser followUser) throws Exception {	
		FollowUser tempFollowUser = followUserDAO.get(followUser.getId());
		
		if(followUser.getAccountName()!=null){
			tempFollowUser.setAccountName(followUser.getAccountName());
		}
		if(followUser.getBabyId()!=null){
			tempFollowUser.setBabyId(followUser.getBabyId());
		}
		if(followUser.getBabyName()!=null){
			tempFollowUser.setBabyName(followUser.getBabyName());
		}
		if(followUser.getGender()!=null){
			tempFollowUser.setGender(followUser.getGender());
		}
		if(followUser.getBirthday()!=null){
			tempFollowUser.setBirthday(followUser.getBirthday());
		}
		if(followUser.getPregnancyWeek()!=null){
			tempFollowUser.setPregnancyWeek(followUser.getPregnancyWeek());
		}
		if(followUser.getInpatientNum()!=null){
			tempFollowUser.setInpatientNum(followUser.getInpatientNum());
		}
		if(followUser.getIdCard()!=null){
			tempFollowUser.setIdCard(followUser.getIdCard());
		}
		if(followUser.getStatus()!=null){
			tempFollowUser.setStatus(followUser.getStatus());
		}
		if(followUser.getType()!=null){
			tempFollowUser.setType(followUser.getType());
		}
		if(followUser.getCreateTime()!=null){
			tempFollowUser.setCreateTime(followUser.getCreateTime());
		}
		followUserDAO.update(tempFollowUser);	
		return tempFollowUser;	
	}
	
    public FollowUser read(FollowUser followUser) throws Exception {	
		return followUserDAO.get(followUser.getId());	
	}	
	
    public List<FollowUser> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followUserDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followUserDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowUser> followUsers = followUserDAO.list(dc, page, rows);
		for(FollowUser followUser:followUsers){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followUser.getId());
			obj.put("text",followUser.getId());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(FollowUser followUser) throws Exception {
    	if(followUser.getStatus()==null){
    		return false;
    	}
		FollowUser tempFollowUser = followUserDAO.get(followUser.getId());
		if(tempFollowUser!=null){
			tempFollowUser.setStatus(followUser.getStatus());
			followUserDAO.update(tempFollowUser);
			return true;
		}else{
			return false;
		}
	}
	
}