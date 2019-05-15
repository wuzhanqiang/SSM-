package com.dbzy.zjxs.cfba;

/**
 * @author Wuzhanqiang
 * @date 2019-1-4
 * @version 1.0.1
 * 
 */
import java.util.List;

import com.actionsoft.bpms.bo.engine.BO;
import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.InterruptListener;
import com.actionsoft.bpms.bpmn.engine.listener.InterruptListenerInterface;
import com.actionsoft.bpms.bpmn.engine.model.run.delegate.ProcessInstance;
import com.actionsoft.sdk.local.SDK;
import com.actionsoft.sdk.local.api.BOAPI;

public class Lccpzcbazy extends InterruptListener implements InterruptListenerInterface{
	
	public Lccpzcbazy() {
		setDescription("临床政策（自营）子表，差额计算流程事件");
	}
	
	public boolean execute(ProcessExecutionContext ctx) throws Exception {
		//获取当前流程
		ProcessInstance proIns = ctx.getProcessInstance();
		//获取流程ID
		String proInsId = proIns.getId();
		//BO操作
		BOAPI boapi = SDK.getBOAPI();
		//获取子表集合
		List<BO> datas = boapi.query("BO_DY_ZDZC_LCZCZY_S").addQuery("BINDID = ", proInsId).list();
		if(datas != null && !datas.isEmpty()) {
			for(BO data : datas) {
				String badj = data.getString("BADJ");
				String gsgdj = data.getString("GSGDJ");
				
				double dbadj = Double.parseDouble(badj);
				double dgsgdj = Double.parseDouble(gsgdj);
				double dce = dbadj - dgsgdj;
				
				data.set("CE", dce+"");
				
		        SDK.getBOAPI().update("BO_DY_ZDZC_LCZCZY_S", data);
	
			}
		}
		return true;
	}
}




