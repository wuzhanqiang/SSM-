package com.dbzy.zjxs.bhwy;

import java.math.BigDecimal;
import java.util.List;
import com.actionsoft.bpms.bo.engine.BO;
import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.ExecuteListener;
import com.actionsoft.bpms.util.DBSql;
import com.actionsoft.sdk.local.SDK;
import com.actionsoft.sdk.local.api.BOAPI;

public class BzlckpjCheck1 extends ExecuteListener {
	public BzlckpjCheck1() {
		setDescription("标准临床开票价备案校验1_wzq");
	}
	
	public void execute(ProcessExecutionContext ctx) throws Exception{
		//定义流程的bindid
		String bindid = ctx.getProcessInstance().getId();
		//定义子表集合
		List<BO> list = SDK.getBOAPI().query("BO_DY_ZDZC_BZLCKPJ_S").bindId(bindid).list();
		if(list.size() > 0) {
			for(int i = 0;i < list.size();i++) {
				BO bo = list.get(i);
				String LCKPJBH = bo.getString("LCKPJBH");
				String sqlCheck = "select count(*) from BO_DY_ZDZC_BZLCKPJ_S where LCKPJBH = '"+LCKPJBH+"' ";
				String flagStr = DBSql.getString(sqlCheck);
				int flag = 0;
				if("".equals(flagStr) && flagStr!= null) {
					flag = Integer.parseInt(flagStr);
				}
				if(flag != 1) {
					String a = SDK.getRuleAPI().executeAtScript("lckpjbh@sequenceYear(CRM_CUSTOMER,8,0)");
					bo.set("LCKPJBH", a);
					SDK.getBOAPI().update("BO_DY_ZDZC_BZLCKPJ_S", bo);
				}
			}
		}
		
		//BO操作
		BOAPI boapi = SDK.getBOAPI();
		//获取子表集合
		List<BO> datas = boapi.query("BO_DY_ZDZC_BZLCKPJ_S").addQuery("BINDID = ", bindid).list();
		if(datas != null && !datas.isEmpty()) {
			for(BO d : datas) {
				String kpj = d.getString("KPJ");
				String zbjg = d.getString("ZBJG");
				
				if(zbjg.equals("无")) {
					d.set("KL", "无");
				}else {
					double dkpj = Double.parseDouble(kpj);
					double dzbjg = Double.parseDouble(zbjg);

					if(dzbjg !=0) {
						double f = new BigDecimal((float)dkpj/dzbjg).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
						d.set("KL",f*100 +"%");
					}else {
						d.set("KL", 0);
					}
				}
			
				SDK.getBOAPI().update("BO_DY_ZDZC_BZLCKPJ_S", d);
				
			}
		}		
	}
}
