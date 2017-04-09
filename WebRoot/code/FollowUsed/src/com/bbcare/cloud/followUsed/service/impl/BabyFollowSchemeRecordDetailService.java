package com.bbcare.cloud.followUsed.service.impl;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeRecordDetail;
import com.bbcare.cloud.followUsed.dao.IBabyFollowSchemeRecordDetailDAO;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeRecordDetailService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeRecord;
import com.bbcare.cloud.followUsed.dao.IBabyFollowSchemeRecordDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:会员随访记录内容	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Service
public class BabyFollowSchemeRecordDetailService implements IBabyFollowSchemeRecordDetailService {
	
	@Autowired
	private IBabyFollowSchemeRecordDetailDAO babyFollowSchemeRecordDetailDAO;	
	
	@Autowired
	private IBabyFollowSchemeRecordDAO babyFollowSchemeRecordDAO;
	
    public String add(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {
    	BabyFollowSchemeRecordDetail tempBabyFollowSchemeRecordDetail = new BabyFollowSchemeRecordDetail();
		tempBabyFollowSchemeRecordDetail.setName(babyFollowSchemeRecordDetail.getName());
		tempBabyFollowSchemeRecordDetail.setQuestionId(babyFollowSchemeRecordDetail.getQuestionId());
		tempBabyFollowSchemeRecordDetail.setType(babyFollowSchemeRecordDetail.getType());
		tempBabyFollowSchemeRecordDetail.setAnswer(babyFollowSchemeRecordDetail.getAnswer());
		tempBabyFollowSchemeRecordDetail.setStatus(babyFollowSchemeRecordDetail.getStatus());
		tempBabyFollowSchemeRecordDetail.setFollowSchemeVersionId(babyFollowSchemeRecordDetail.getFollowSchemeVersionId());
		tempBabyFollowSchemeRecordDetail.setCreateTime(babyFollowSchemeRecordDetail.getCreateTime());
		if(babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord()!=null&&babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId()!=null&&babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId().trim().length()>0){
			BabyFollowSchemeRecord babyFollowSchemeRecordTemp = babyFollowSchemeRecordDAO.get(babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId());
			if(babyFollowSchemeRecordTemp!=null){
				tempBabyFollowSchemeRecordDetail.setBabyFollowSchemeRecord(babyFollowSchemeRecordTemp);
				tempBabyFollowSchemeRecordDetail.setBabyFollowSchemeRecordName(babyFollowSchemeRecordTemp.getName());
			}
		}
		return babyFollowSchemeRecordDetailDAO.save(tempBabyFollowSchemeRecordDetail);	
	}
	
    public void remove(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {	
		babyFollowSchemeRecordDetailDAO.delete(babyFollowSchemeRecordDetail.getId());	
	}
	
    public BabyFollowSchemeRecordDetail modify(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {	
		BabyFollowSchemeRecordDetail tempBabyFollowSchemeRecordDetail = babyFollowSchemeRecordDetailDAO.get(babyFollowSchemeRecordDetail.getId());
		
		if(babyFollowSchemeRecordDetail.getName()!=null){
			tempBabyFollowSchemeRecordDetail.setName(babyFollowSchemeRecordDetail.getName());
		}
		if(babyFollowSchemeRecordDetail.getQuestionId()!=null){
			tempBabyFollowSchemeRecordDetail.setQuestionId(babyFollowSchemeRecordDetail.getQuestionId());
		}
		if(babyFollowSchemeRecordDetail.getType()!=null){
			tempBabyFollowSchemeRecordDetail.setType(babyFollowSchemeRecordDetail.getType());
		}
		if(babyFollowSchemeRecordDetail.getAnswer()!=null){
			tempBabyFollowSchemeRecordDetail.setAnswer(babyFollowSchemeRecordDetail.getAnswer());
		}
		if(babyFollowSchemeRecordDetail.getStatus()!=null){
			tempBabyFollowSchemeRecordDetail.setStatus(babyFollowSchemeRecordDetail.getStatus());
		}
		if(babyFollowSchemeRecordDetail.getFollowSchemeVersionId()!=null){
			tempBabyFollowSchemeRecordDetail.setFollowSchemeVersionId(babyFollowSchemeRecordDetail.getFollowSchemeVersionId());
		}
		if(babyFollowSchemeRecordDetail.getCreateTime()!=null){
			tempBabyFollowSchemeRecordDetail.setCreateTime(babyFollowSchemeRecordDetail.getCreateTime());
		}
		if(babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord()!=null&& babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId()!=null&&babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId().trim().length()>0){
			BabyFollowSchemeRecord babyFollowSchemeRecordTemp = babyFollowSchemeRecordDAO.get(babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId());
			if(babyFollowSchemeRecordTemp!=null){
				tempBabyFollowSchemeRecordDetail.setBabyFollowSchemeRecord(babyFollowSchemeRecordTemp);
				tempBabyFollowSchemeRecordDetail.setBabyFollowSchemeRecordName(babyFollowSchemeRecordTemp.getName());
			}
		}
		babyFollowSchemeRecordDetailDAO.update(tempBabyFollowSchemeRecordDetail);	
		return tempBabyFollowSchemeRecordDetail;	
	}
	
    public BabyFollowSchemeRecordDetail read(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {	
		return babyFollowSchemeRecordDetailDAO.get(babyFollowSchemeRecordDetail.getId());	
	}	
	
    public List<BabyFollowSchemeRecordDetail> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return babyFollowSchemeRecordDetailDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return babyFollowSchemeRecordDetailDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<BabyFollowSchemeRecordDetail> babyFollowSchemeRecordDetails = babyFollowSchemeRecordDetailDAO.list(dc, page, rows);
		for(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail:babyFollowSchemeRecordDetails){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",babyFollowSchemeRecordDetail.getId());
			obj.put("text",babyFollowSchemeRecordDetail.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {
    	if(babyFollowSchemeRecordDetail.getStatus()==null){
    		return false;
    	}
		BabyFollowSchemeRecordDetail tempBabyFollowSchemeRecordDetail = babyFollowSchemeRecordDetailDAO.get(babyFollowSchemeRecordDetail.getId());
		if(tempBabyFollowSchemeRecordDetail!=null){
			tempBabyFollowSchemeRecordDetail.setStatus(babyFollowSchemeRecordDetail.getStatus());
			babyFollowSchemeRecordDetailDAO.update(tempBabyFollowSchemeRecordDetail);
			return true;
		}else{
			return false;
		}
	}
	
}