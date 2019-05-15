package com.nepharm.apps.fpp.extra;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.actionsoft.bpms.commons.formfile.model.delegate.FormFile;
import com.actionsoft.bpms.schedule.IJob;
import com.actionsoft.sdk.local.SDK;
import com.actionsoft.sdk.local.api.BOAPI;

public class FjJob implements IJob {

	public FjJob() {
		
	}	

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		BOAPI boApi = SDK.getBOAPI();
		/*删除目标附件 */
		//BO表记录id
		String boId = "62928857-9c8a-4978-838a-2ecacb889990";
		//字段名称
		String fieldName = "FJ";
		//附件列表
		List<FormFile> fjList = boApi.getFiles(boId, fieldName);
		//遍历附件列表，删除“股份合同3.jpg”，“一药合同3.jpg”
		for(FormFile formFile : fjList) {
			String fileName = formFile.getFileName();
			//"股份合同3.jpg".equals(fileName) || "一药合同3.jpg".equals(fileName)
			if("全流程系统新增流程-投资发展部.xlsx".equals(fileName) || "岗位级别奖惩设置单.xls".equals(fileName)) {
				String fileId = formFile.getId();
				boApi.removeFile(fileId);
			}
		}
		
		/* 复制附件*/
		//源BO表记录id
		String sourceBoId = "0b834b04-27e4-4a93-a31e-42baa613d5f6";
		//源BO表附件字段名
		String sourceFieldName = "FJ";
		//目标BO表记录id
		String targetBoId = boId;
		//目标BO表名
		String targetBOName = "BO_DY_NEPG_BPMLCXG";
		//目标BO表附件字段名
		String targetFieldName = fieldName;
		//目标流程实例id
		String targetProcessInstId = "4146802d-b9af-466a-aeb0-bfb99a643fe0";
		//目标任务实例id
		String targetTaskInstId = null;
		boApi.copyFileTo(sourceBoId, sourceFieldName, targetBoId, targetBOName, targetFieldName, targetProcessInstId, targetTaskInstId);
	}

}
