package com.nepharm5.apps.fpp.fwb;

import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.ExecuteListener;
import com.actionsoft.bpms.bpmn.engine.listener.ExecuteListenerInterface;

public class changeinfo1 extends ExecuteListener implements ExecuteListenerInterface {
	public changeinfo1(){
		this.setDescription("股份公司非示范文本合同评审流程第一个节点任务完成后被触发_wzq");
	}
	
	public void execute(ProcessExecutionContext ctx) throws Exception{
		ctx.setVariable("ZT","0");
	}
}
