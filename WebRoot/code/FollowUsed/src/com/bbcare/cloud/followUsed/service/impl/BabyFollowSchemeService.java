package com.bbcare.cloud.followUsed.service.impl;

import com.bbcare.cloud.followUsed.entry.BabyFollowScheme;
import com.bbcare.cloud.followUsed.dao.IBabyFollowSchemeDAO;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.followUsed.entry.FollowUser;
import com.bbcare.cloud.followUsed.dao.IFollowUserDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:宝宝随访方案	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Service
public class BabyFollowSchemeService implements IBabyFollowSchemeService {
	
	@Autowired
	private IBabyFollowSchemeDAO babyFollowSchemeDAO;	
	
	@Autowired
	private IFollowUserDAO followUserDAO;
	
    public String add(BabyFollowScheme babyFollowScheme) throws Exception {
    	BabyFollowScheme tempBabyFollowScheme = new BabyFollowScheme();
		tempBabyFollowScheme.setName(babyFollowScheme.getName());
		tempBabyFollowScheme.setUserId(babyFollowScheme.getUserId());
		tempBabyFollowScheme.setFollowSchemeId(babyFollowScheme.getFollowSchemeId());
		tempBabyFollowScheme.setFollowSchemeVersion(babyFollowScheme.getFollowSchemeVersion());
		tempBabyFollowScheme.setFollowSchemeVersionId(babyFollowScheme.getFollowSchemeVersionId());
		tempBabyFollowScheme.setCreateTime(babyFollowScheme.getCreateTime());
		if(babyFollowScheme.getFollowUser()!=null&&babyFollowScheme.getFollowUser().getId()!=null&&babyFollowScheme.getFollowUser().getId().trim().length()>0){
			FollowUser followUserTemp = followUserDAO.get(babyFollowScheme.getFollowUser().getId());
			if(followUserTemp!=null){
				tempBabyFollowScheme.setFollowUser(followUserTemp);
				tempBabyFollowScheme.setFollowUserName(followUserTemp.getId());
			}
		}
		return babyFollowSchemeDAO.save(tempBabyFollowScheme);	
	}
	
    public void remove(BabyFollowScheme babyFollowScheme) throws Exception {	
		babyFollowSchemeDAO.delete(babyFollowScheme.getId());	
	}
	
    public BabyFollowScheme modify(BabyFollowScheme babyFollowScheme) throws Exception {	
		BabyFollowScheme tempBabyFollowScheme = babyFollowSchemeDAO.get(babyFollowScheme.getId());
		
		if(babyFollowScheme.getName()!=null){
			tempBabyFollowScheme.setName(babyFollowScheme.getName());
		}
		if(babyFollowScheme.getUserId()!=null){
			tempBabyFollowScheme.setUserId(babyFollowScheme.getUserId());
		}
		if(babyFollowScheme.getFollowSchemeId()!=null){
			tempBabyFollowScheme.setFollowSchemeId(babyFollowScheme.getFollowSchemeId());
		}
		if(babyFollowScheme.getFollowSchemeVersion()!=null){
			tempBabyFollowScheme.setFollowSchemeVersion(babyFollowScheme.getFollowSchemeVersion());
		}
		if(babyFollowScheme.getFollowSchemeVersionId()!=null){
			tempBabyFollowScheme.setFollowSchemeVersionId(babyFollowScheme.getFollowSchemeVersionId());
		}
		if(babyFollowScheme.getCreateTime()!=null){
			tempBabyFollowScheme.setCreateTime(babyFollowScheme.getCreateTime());
		}
		if(babyFollowScheme.getFollowUser()!=null&& babyFollowScheme.getFollowUser().getId()!=null&&babyFollowScheme.getFollowUser().getId().trim().length()>0){
			FollowUser followUserTemp = followUserDAO.get(babyFollowScheme.getFollowUser().getId());
			if(followUserTemp!=null){
				tempBabyFollowScheme.setFollowUser(followUserTemp);
				tempBabyFollowScheme.setFollowUserName(followUserTemp.getId());
			}
		}
		babyFollowSchemeDAO.update(tempBabyFollowScheme);	
		return tempBabyFollowScheme;	
	}
	
    public BabyFollowScheme read(BabyFollowScheme babyFollowScheme) throws Exception {	
		return babyFollowSchemeDAO.get(babyFollowScheme.getId());	
	}	
	
    public List<BabyFollowScheme> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return babyFollowSchemeDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return babyFollowSchemeDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<BabyFollowScheme> babyFollowSchemes = babyFollowSchemeDAO.list(dc, page, rows);
		for(BabyFollowScheme babyFollowScheme:babyFollowSchemes){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",babyFollowScheme.getId());
			obj.put("text",babyFollowScheme.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}