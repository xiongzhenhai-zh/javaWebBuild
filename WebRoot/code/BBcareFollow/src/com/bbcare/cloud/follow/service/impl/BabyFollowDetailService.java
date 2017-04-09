package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.BabyFollowDetail;
import com.bbcare.cloud.follow.dao.IBabyFollowDetailDAO;
import com.bbcare.cloud.follow.service.IBabyFollowDetailService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.BabyFollowRecord;
import com.bbcare.cloud.follow.dao.IBabyFollowRecordDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访情况	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class BabyFollowDetailService implements IBabyFollowDetailService {
	
	@Autowired
	private IBabyFollowDetailDAO babyFollowDetailDAO;	
	
	@Autowired
	private IBabyFollowRecordDAO babyFollowRecordDAO;
	
    public String add(BabyFollowDetail babyFollowDetail) throws Exception {
    	BabyFollowDetail tempBabyFollowDetail = new BabyFollowDetail();
		tempBabyFollowDetail.setFollowContenId(babyFollowDetail.getFollowContenId());
		tempBabyFollowDetail.setNote(babyFollowDetail.getNote());
		tempBabyFollowDetail.setContentType(babyFollowDetail.getContentType());
		tempBabyFollowDetail.setContentClass(babyFollowDetail.getContentClass());
		tempBabyFollowDetail.setContentUnit(babyFollowDetail.getContentUnit());
		tempBabyFollowDetail.setSort(babyFollowDetail.getSort());
		if(babyFollowDetail.getBabyFollowRecord()!=null&&babyFollowDetail.getBabyFollowRecord().getId()!=null&&babyFollowDetail.getBabyFollowRecord().getId().trim().length()>0){
			BabyFollowRecord babyFollowRecordTemp = babyFollowRecordDAO.get(babyFollowDetail.getBabyFollowRecord().getId());
			if(babyFollowRecordTemp!=null){
				tempBabyFollowDetail.setBabyFollowRecord(babyFollowRecordTemp);
				tempBabyFollowDetail.setBabyFollowRecordName(babyFollowRecordTemp.getId());
			}
		}
		return babyFollowDetailDAO.save(tempBabyFollowDetail);	
	}
	
    public void remove(BabyFollowDetail babyFollowDetail) throws Exception {	
		babyFollowDetailDAO.delete(babyFollowDetail.getId());	
	}
	
    public BabyFollowDetail modify(BabyFollowDetail babyFollowDetail) throws Exception {	
		BabyFollowDetail tempBabyFollowDetail = babyFollowDetailDAO.get(babyFollowDetail.getId());
		
		if(babyFollowDetail.getFollowContenId()!=null){
			tempBabyFollowDetail.setFollowContenId(babyFollowDetail.getFollowContenId());
		}
		if(babyFollowDetail.getNote()!=null){
			tempBabyFollowDetail.setNote(babyFollowDetail.getNote());
		}
		if(babyFollowDetail.getContentType()!=null){
			tempBabyFollowDetail.setContentType(babyFollowDetail.getContentType());
		}
		if(babyFollowDetail.getContentClass()!=null){
			tempBabyFollowDetail.setContentClass(babyFollowDetail.getContentClass());
		}
		if(babyFollowDetail.getContentUnit()!=null){
			tempBabyFollowDetail.setContentUnit(babyFollowDetail.getContentUnit());
		}
		if(babyFollowDetail.getSort()!=null){
			tempBabyFollowDetail.setSort(babyFollowDetail.getSort());
		}
		if(babyFollowDetail.getBabyFollowRecord()!=null&& babyFollowDetail.getBabyFollowRecord().getId()!=null&&babyFollowDetail.getBabyFollowRecord().getId().trim().length()>0){
			BabyFollowRecord babyFollowRecordTemp = babyFollowRecordDAO.get(babyFollowDetail.getBabyFollowRecord().getId());
			if(babyFollowRecordTemp!=null){
				tempBabyFollowDetail.setBabyFollowRecord(babyFollowRecordTemp);
				tempBabyFollowDetail.setBabyFollowRecordName(babyFollowRecordTemp.getId());
			}
		}
		babyFollowDetailDAO.update(tempBabyFollowDetail);	
		return tempBabyFollowDetail;	
	}
	
    public BabyFollowDetail read(BabyFollowDetail babyFollowDetail) throws Exception {	
		return babyFollowDetailDAO.get(babyFollowDetail.getId());	
	}	
	
    public List<BabyFollowDetail> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return babyFollowDetailDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return babyFollowDetailDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<BabyFollowDetail> babyFollowDetails = babyFollowDetailDAO.list(dc, page, rows);
		for(BabyFollowDetail babyFollowDetail:babyFollowDetails){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",babyFollowDetail.getId());
			obj.put("text",babyFollowDetail.getId());
			list.add(obj);
		}
		return list;	
	}	
	
}