package com.lechen.project.service.impl;

import com.lechen.project.entry.Auth;
import com.lechen.project.dao.IAuthDAO;
import com.lechen.project.service.IAuthService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lechen.project.entry.User;
import com.lechen.project.dao.IUserDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:角色	持久层接口
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	
	
@Service
public class AuthService implements IAuthService {
	
	@Autowired
	private IAuthDAO authDAO;	
	
	@Autowired
	private IUserDAO userDAO;
	
    public String add(Auth auth) throws Exception {
    	Auth tempAuth = new Auth();
		tempAuth.setName(auth.getName());
		if(auth.getUser()!=null&&auth.getUser().getId()!=null&&auth.getUser().getId().trim().length()>0){
			User userTemp = userDAO.get(auth.getUser().getId());
			if(userTemp!=null){
				tempAuth.setUser(userTemp);
				tempAuth.setUserName(userTemp.getName());
			}
		}
		return authDAO.save(tempAuth);	
	}
	
    public void remove(Auth auth) throws Exception {	
		authDAO.delete(auth.getId());	
	}
	
    public Auth modify(Auth auth) throws Exception {	
		Auth tempAuth = authDAO.get(auth.getId());
		
		if(auth.getName()!=null){
			tempAuth.setName(auth.getName());
		}
		if(auth.getUser()!=null&& auth.getUser().getId()!=null&&auth.getUser().getId().trim().length()>0){
			User userTemp = userDAO.get(auth.getUser().getId());
			if(userTemp!=null){
				tempAuth.setUser(userTemp);
				tempAuth.setUserName(userTemp.getName());
			}
		}
		authDAO.update(tempAuth);	
		return tempAuth;	
	}
	
    public Auth read(Auth auth) throws Exception {	
		return authDAO.get(auth.getId());	
	}	
	
    public List<Auth> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return authDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return authDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<Auth> auths = authDAO.list(dc, page, rows);
		for(Auth auth:auths){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",auth.getId());
			obj.put("text",auth.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}