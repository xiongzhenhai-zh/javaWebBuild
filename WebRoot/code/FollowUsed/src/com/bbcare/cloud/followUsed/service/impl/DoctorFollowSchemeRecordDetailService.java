package com.bbcare.cloud.followUsed.service.impl;

import com.bbcare.cloud.followUsed.entry.DoctorFollowSchemeRecordDetail;
import com.bbcare.cloud.followUsed.dao.IDoctorFollowSchemeRecordDetailDAO;
import com.bbcare.cloud.followUsed.service.IDoctorFollowSchemeRecordDetailService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.followUsed.entry.DoctorFollowSchemeRecord;
import com.bbcare.cloud.followUsed.dao.IDoctorFollowSchemeRecordDAO;
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
public class DoctorFollowSchemeRecordDetailService implements IDoctorFollowSchemeRecordDetailService {
	
	@Autowired
	private IDoctorFollowSchemeRecordDetailDAO doctorFollowSchemeRecordDetailDAO;	
	
	@Autowired
	private IDoctorFollowSchemeRecordDAO doctorFollowSchemeRecordDAO;
	
    public String add(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {
    	DoctorFollowSchemeRecordDetail tempDoctorFollowSchemeRecordDetail = new DoctorFollowSchemeRecordDetail();
		tempDoctorFollowSchemeRecordDetail.setName(doctorFollowSchemeRecordDetail.getName());
		tempDoctorFollowSchemeRecordDetail.setBabyFollowSchemeRecordDetailId(doctorFollowSchemeRecordDetail.getBabyFollowSchemeRecordDetailId());
		tempDoctorFollowSchemeRecordDetail.setQuestionId(doctorFollowSchemeRecordDetail.getQuestionId());
		tempDoctorFollowSchemeRecordDetail.setType(doctorFollowSchemeRecordDetail.getType());
		tempDoctorFollowSchemeRecordDetail.setAnswer(doctorFollowSchemeRecordDetail.getAnswer());
		tempDoctorFollowSchemeRecordDetail.setStatus(doctorFollowSchemeRecordDetail.getStatus());
		tempDoctorFollowSchemeRecordDetail.setFollowSchemeVersionId(doctorFollowSchemeRecordDetail.getFollowSchemeVersionId());
		tempDoctorFollowSchemeRecordDetail.setCreateTime(doctorFollowSchemeRecordDetail.getCreateTime());
		if(doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord()!=null&&doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId()!=null&&doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId().trim().length()>0){
			DoctorFollowSchemeRecord doctorFollowSchemeRecordTemp = doctorFollowSchemeRecordDAO.get(doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId());
			if(doctorFollowSchemeRecordTemp!=null){
				tempDoctorFollowSchemeRecordDetail.setDoctorFollowSchemeRecord(doctorFollowSchemeRecordTemp);
				tempDoctorFollowSchemeRecordDetail.setDoctorFollowSchemeRecordName(doctorFollowSchemeRecordTemp.getName());
			}
		}
		return doctorFollowSchemeRecordDetailDAO.save(tempDoctorFollowSchemeRecordDetail);	
	}
	
    public void remove(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {	
		doctorFollowSchemeRecordDetailDAO.delete(doctorFollowSchemeRecordDetail.getId());	
	}
	
    public DoctorFollowSchemeRecordDetail modify(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {	
		DoctorFollowSchemeRecordDetail tempDoctorFollowSchemeRecordDetail = doctorFollowSchemeRecordDetailDAO.get(doctorFollowSchemeRecordDetail.getId());
		
		if(doctorFollowSchemeRecordDetail.getName()!=null){
			tempDoctorFollowSchemeRecordDetail.setName(doctorFollowSchemeRecordDetail.getName());
		}
		if(doctorFollowSchemeRecordDetail.getBabyFollowSchemeRecordDetailId()!=null){
			tempDoctorFollowSchemeRecordDetail.setBabyFollowSchemeRecordDetailId(doctorFollowSchemeRecordDetail.getBabyFollowSchemeRecordDetailId());
		}
		if(doctorFollowSchemeRecordDetail.getQuestionId()!=null){
			tempDoctorFollowSchemeRecordDetail.setQuestionId(doctorFollowSchemeRecordDetail.getQuestionId());
		}
		if(doctorFollowSchemeRecordDetail.getType()!=null){
			tempDoctorFollowSchemeRecordDetail.setType(doctorFollowSchemeRecordDetail.getType());
		}
		if(doctorFollowSchemeRecordDetail.getAnswer()!=null){
			tempDoctorFollowSchemeRecordDetail.setAnswer(doctorFollowSchemeRecordDetail.getAnswer());
		}
		if(doctorFollowSchemeRecordDetail.getStatus()!=null){
			tempDoctorFollowSchemeRecordDetail.setStatus(doctorFollowSchemeRecordDetail.getStatus());
		}
		if(doctorFollowSchemeRecordDetail.getFollowSchemeVersionId()!=null){
			tempDoctorFollowSchemeRecordDetail.setFollowSchemeVersionId(doctorFollowSchemeRecordDetail.getFollowSchemeVersionId());
		}
		if(doctorFollowSchemeRecordDetail.getCreateTime()!=null){
			tempDoctorFollowSchemeRecordDetail.setCreateTime(doctorFollowSchemeRecordDetail.getCreateTime());
		}
		if(doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord()!=null&& doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId()!=null&&doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId().trim().length()>0){
			DoctorFollowSchemeRecord doctorFollowSchemeRecordTemp = doctorFollowSchemeRecordDAO.get(doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId());
			if(doctorFollowSchemeRecordTemp!=null){
				tempDoctorFollowSchemeRecordDetail.setDoctorFollowSchemeRecord(doctorFollowSchemeRecordTemp);
				tempDoctorFollowSchemeRecordDetail.setDoctorFollowSchemeRecordName(doctorFollowSchemeRecordTemp.getName());
			}
		}
		doctorFollowSchemeRecordDetailDAO.update(tempDoctorFollowSchemeRecordDetail);	
		return tempDoctorFollowSchemeRecordDetail;	
	}
	
    public DoctorFollowSchemeRecordDetail read(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {	
		return doctorFollowSchemeRecordDetailDAO.get(doctorFollowSchemeRecordDetail.getId());	
	}	
	
    public List<DoctorFollowSchemeRecordDetail> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return doctorFollowSchemeRecordDetailDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return doctorFollowSchemeRecordDetailDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<DoctorFollowSchemeRecordDetail> doctorFollowSchemeRecordDetails = doctorFollowSchemeRecordDetailDAO.list(dc, page, rows);
		for(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail:doctorFollowSchemeRecordDetails){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",doctorFollowSchemeRecordDetail.getId());
			obj.put("text",doctorFollowSchemeRecordDetail.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {
    	if(doctorFollowSchemeRecordDetail.getStatus()==null){
    		return false;
    	}
		DoctorFollowSchemeRecordDetail tempDoctorFollowSchemeRecordDetail = doctorFollowSchemeRecordDetailDAO.get(doctorFollowSchemeRecordDetail.getId());
		if(tempDoctorFollowSchemeRecordDetail!=null){
			tempDoctorFollowSchemeRecordDetail.setStatus(doctorFollowSchemeRecordDetail.getStatus());
			doctorFollowSchemeRecordDetailDAO.update(tempDoctorFollowSchemeRecordDetail);
			return true;
		}else{
			return false;
		}
	}
	
}