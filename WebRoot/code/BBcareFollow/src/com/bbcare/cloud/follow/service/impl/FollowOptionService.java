package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.FollowOption;
import com.bbcare.cloud.follow.dao.IFollowOptionDAO;
import com.bbcare.cloud.follow.service.IFollowOptionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.FollowContent;
import com.bbcare.cloud.follow.dao.IFollowContentDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访选项	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class FollowOptionService implements IFollowOptionService {
	
	@Autowired
	private IFollowOptionDAO followOptionDAO;	
	
	@Autowired
	private IFollowContentDAO followContentDAO;
	
    public String add(FollowOption followOption) throws Exception {
    	FollowOption tempFollowOption = new FollowOption();
		tempFollowOption.setName(followOption.getName());
		if(followOption.getFollowContent()!=null&&followOption.getFollowContent().getId()!=null&&followOption.getFollowContent().getId().trim().length()>0){
			FollowContent followContentTemp = followContentDAO.get(followOption.getFollowContent().getId());
			if(followContentTemp!=null){
				tempFollowOption.setFollowContent(followContentTemp);
				tempFollowOption.setFollowContentName(followContentTemp.getName());
			}
		}
		return followOptionDAO.save(tempFollowOption);	
	}
	
    public void remove(FollowOption followOption) throws Exception {	
		followOptionDAO.delete(followOption.getId());	
	}
	
    public FollowOption modify(FollowOption followOption) throws Exception {	
		FollowOption tempFollowOption = followOptionDAO.get(followOption.getId());
		
		if(followOption.getName()!=null){
			tempFollowOption.setName(followOption.getName());
		}
		if(followOption.getFollowContent()!=null&& followOption.getFollowContent().getId()!=null&&followOption.getFollowContent().getId().trim().length()>0){
			FollowContent followContentTemp = followContentDAO.get(followOption.getFollowContent().getId());
			if(followContentTemp!=null){
				tempFollowOption.setFollowContent(followContentTemp);
				tempFollowOption.setFollowContentName(followContentTemp.getName());
			}
		}
		followOptionDAO.update(tempFollowOption);	
		return tempFollowOption;	
	}
	
    public FollowOption read(FollowOption followOption) throws Exception {	
		return followOptionDAO.get(followOption.getId());	
	}	
	
    public List<FollowOption> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followOptionDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followOptionDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowOption> followOptions = followOptionDAO.list(dc, page, rows);
		for(FollowOption followOption:followOptions){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followOption.getId());
			obj.put("text",followOption.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}