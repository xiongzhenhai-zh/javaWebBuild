package com.carejava.core.test;

import com.carejava.core.Build;
import com.carejava.core.entry.Project;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*String dataString="{\"Model\": [{\"modelName\": \"doctorQuestionModuleAdvice\",\"modelChinaName\":\"医生模块建议\",\"Attribute\": [{\"attributeName\":\"cordon\",\"attributeChinaName\": \"警戒值\",\"attributeType\":\"Integer\"},{\"attributeName\":\"average\",\"attributeChinaName\": \"平均分\",\"attributeType\":\"Integer\"},{\"attributeName\":\"score\",\"attributeChinaName\": \"获得分数\",\"attributeType\":\"Integer\"},{\"attributeName\":\"qoctorQuestionRecordId\",\"attributeChinaName\": \"记录Id\",\"attributeType\":\"String\"},{\"attributeName\":\"title\",\"attributeChinaName\": \"标题\",\"attributeType\":\"String\"},{\"attributeName\":\"title\",\"attributeChinaName\": \"标题\",\"attributeType\":\"String\"},{\"attributeName\":\"note\",\"attributeChinaName\": \"指导\",\"attributeType\":\"String\"}],\"OneToMany\":[],\"ManyToOne\":[]}]}";
		Project project = XzhTest.getProject("xzh", dataString);*/
		Project project = CareJava.getProject();
	//	Project project = XzhTest.getProject();
		//JsonConfig config = new JsonConfig(project,1,"1.0");
		//config.build();
		Build build = new Build(project);
		build.init();
	}
}