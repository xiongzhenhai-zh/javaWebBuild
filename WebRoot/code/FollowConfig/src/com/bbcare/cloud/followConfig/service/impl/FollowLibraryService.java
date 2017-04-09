package com.bbcare.cloud.followConfig.service.impl;

import com.bbcare.cloud.followConfig.entry.FollowLibrary;
import com.bbcare.cloud.followConfig.dao.IFollowLibraryDAO;
import com.bbcare.cloud.followConfig.service.IFollowLibraryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访库	持久层接口
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
@Service
public class FollowLibraryService implements IFollowLibraryService {
	
	@Autowired
	private IFollowLibraryDAO followLibraryDAO;	
	
    public String add(FollowLibrary followLibrary) throws Exception {
    	FollowLibrary tempFollowLibrary = new FollowLibrary();
		tempFollowLibrary.setName(followLibrary.getName());
		tempFollowLibrary.setMasterType(followLibrary.getMasterType());
		tempFollowLibrary.setMasterId(followLibrary.getMasterId());
		tempFollowLibrary.setCreateTime(followLibrary.getCreateTime());
		if(followLibrary.getParent()!=null&&followLibrary.getParent().getId()!=null&&followLibrary.getParent().getId().trim().length()>0){
			FollowLibrary followLibraryTemp = followLibraryDAO.get(followLibrary.getParent().getId());
			if(followLibraryTemp!=null){
				tempFollowLibrary.setParent(followLibraryTemp);
				tempFollowLibrary.setParentName(followLibraryTemp.getName());
			}
		}
		return followLibraryDAO.save(tempFollowLibrary);	
	}
	
    public void remove(FollowLibrary followLibrary) throws Exception {	
		followLibraryDAO.delete(followLibrary.getId());	
	}
	
    public FollowLibrary modify(FollowLibrary followLibrary) throws Exception {	
		FollowLibrary tempFollowLibrary = followLibraryDAO.get(followLibrary.getId());
		
		if(followLibrary.getName()!=null){
			tempFollowLibrary.setName(followLibrary.getName());
		}
		if(followLibrary.getMasterType()!=null){
			tempFollowLibrary.setMasterType(followLibrary.getMasterType());
		}
		if(followLibrary.getMasterId()!=null){
			tempFollowLibrary.setMasterId(followLibrary.getMasterId());
		}
		if(followLibrary.getCreateTime()!=null){
			tempFollowLibrary.setCreateTime(followLibrary.getCreateTime());
		}
		if(followLibrary.getParent()!=null&& followLibrary.getParent().getId()!=null&&followLibrary.getParent().getId().trim().length()>0){
			FollowLibrary followLibraryTemp = followLibraryDAO.get(followLibrary.getParent().getId());
			if(followLibraryTemp!=null){
				tempFollowLibrary.setParent(followLibraryTemp);
				tempFollowLibrary.setParentName(followLibraryTemp.getName());
			}
		}
		followLibraryDAO.update(tempFollowLibrary);	
		return tempFollowLibrary;	
	}
	
    public FollowLibrary read(FollowLibrary followLibrary) throws Exception {	
		return followLibraryDAO.get(followLibrary.getId());	
	}	
	
    public List<FollowLibrary> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followLibraryDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followLibraryDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowLibrary> followLibrarys = followLibraryDAO.list(dc, page, rows);
		for(FollowLibrary followLibrary:followLibrarys){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followLibrary.getId());
			obj.put("text",followLibrary.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}