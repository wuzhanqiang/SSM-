package com.nepharm5.apps.fpp.zjzlb;
/**
 * @author wuzhanqiang
 * @date 2019-1-3
 * 
 */

import java.util.List;
import com.actionsoft.bpms.bo.engine.BO;
import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.ExecuteListener;
import com.actionsoft.bpms.util.DBSql;
import com.actionsoft.sdk.local.SDK;

public class ZjzlbUpdateTzfw extends ExecuteListener {

	public ZjzlbUpdateTzfw() {
		setDescription("制剂质量部第5节点，更新主表通知范围");
	}
	public void execute(ProcessExecutionContext ctx) throws Exception {
		String bindid = ctx.getProcessInstance().getId();
		String sql;
		StringBuffer sb = new StringBuffer(" ");
		List<BO> formData = SDK.getBOAPI().query("BO_DY_ZJZLB_S").bindId(bindid).list();
		for(int i=0;i<formData.size();i++) {
			sb.append(formData.get(i).get("TJRZH")+"<"+formData.get(i).get("TJR").toString()+">"+' ');
		}
		sql = "update BO_DY_ZJZLB_P t set t.TZFW = '"+sb.substring(0,sb.length()-1)+"' where t.bindid = '"+bindid+"'";
		DBSql.update(sql);
	}

}
