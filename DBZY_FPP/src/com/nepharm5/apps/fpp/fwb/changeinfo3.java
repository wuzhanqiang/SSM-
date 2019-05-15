package com.nepharm5.apps.fpp.fwb;

import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.ExecuteListener;
import com.actionsoft.bpms.bpmn.engine.listener.ExecuteListenerInterface;

public class changeinfo3 extends ExecuteListener implements ExecuteListenerInterface {
	public changeinfo3(){
		this.setDescription("股份公司非示范文本合同评审流程5人节点任务完成后被触发_wzq");
	}
	
	public void execute(ProcessExecutionContext ctx) throws Exception{
		boolean sh = ctx.isChoiceActionMenu("驳回修改");
		if(sh) {
		    ctx.setVariable("ZT","1");
		}
		
	}
}
