package com.dbzy.zjxs.bhwy;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.actionsoft.bpms.bo.engine.BO;
import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.InterruptListener;
import com.actionsoft.bpms.bpmn.engine.model.run.delegate.ProcessInstance;
import com.actionsoft.bpms.util.DBSql;
import com.actionsoft.exception.BPMNError;
import com.actionsoft.sdk.local.SDK;
import com.actionsoft.sdk.local.api.BOAPI;
import com.dbzy.zjxs.po.TslckpjPO;

public class TslckpjCheck2 extends InterruptListener  {
	public TslckpjCheck2() {
		setDescription("特殊临床开票价备案校验2_wzq");
	}
	
	public boolean execute(ProcessExecutionContext ctx) throws Exception{
		ProcessInstance proIns = ctx.getProcessInstance();
		String proInsId = proIns.getId();
		BOAPI boapi = SDK.getBOAPI();
		List<BO> datas = boapi.query("BO_DY_ZDZC_TSLCKPJ_S").addQuery("BINDID=", proInsId).list();
		List<TslckpjPO> kpjList = new ArrayList<>();
		if(datas != null && !datas.isEmpty()) {
			for(BO b : datas) {
				TslckpjPO bp = new TslckpjPO();
				String khmc = b.getString("KHMC");
				String bzpg = b.getString("BZPG");
				String zbjg = b.getString("ZBJG");
				String gsgdj = b.getString("GSGDJ");
				bp.setKhmc(khmc);
				bp.setBzpg(bzpg);
				bp.setZbjg(zbjg);
				bp.setGsgdj(gsgdj);
				kpjList.add(bp);
			}
		}
		String sql = null;
		int cnt = 0;
		Connection conn = null;
//=========================校验开票公司==================================
		StringBuffer errKHMC = new StringBuffer();
		try {
			conn = DBSql.open();
			for(TslckpjPO p : kpjList) {
				sql = "select count(SYGS) cnt from BO_DY_YJSYGS_S2 where SYGS='"+p.getKhmc()+"'";
				cnt = DBSql.getInt(conn, sql,"cnt");
				if(cnt == 0) {
					errKHMC.append(p.getKhmc());
					errKHMC.append(",");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBSql.close(conn);
		}
		if (errKHMC.toString().length() > 0) {
			throw new BPMNError("ERR_KHMC","请按照要求填写开票公司，问题开票公司为：" + errKHMC.toString());			
		}
		
//=========================校验标准品规==================================
		StringBuffer errBZPG = new StringBuffer();
		try {
			conn = DBSql.open();
			for(TslckpjPO p1 : kpjList) {
				sql = "select count(LCPZ) cnt from BO_DY_KC_BZPG_S where LCPZ='"+p1.getBzpg()+"'";
				cnt = DBSql.getInt(conn, sql,"cnt");
				if(cnt == 0) {
					errBZPG.append(p1.getBzpg());
					errBZPG.append(",");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBSql.close(conn);
		}
		if (errBZPG.toString().length() > 0) {
			throw new BPMNError("ERR_BZPG","请按照要求填写标准品规，问题标准品规为：" + errBZPG.toString());			
		}
		
//=========================校验中标价格==================================
		StringBuffer errZBJG = new StringBuffer();
		try {
			conn = DBSql.open();
			for(TslckpjPO p2 : kpjList) {
				sql = "select count(ZBJG) cnt from BO_DY_KC_BZPG_S where ZBJG='"+p2.getZbjg()+"'";
				cnt = DBSql.getInt(conn, sql,"cnt");
				if(cnt == 0) {
					errZBJG.append(p2.getZbjg());
					errZBJG.append(",");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBSql.close(conn);
			}
		if (errZBJG.toString().length() > 0) {
			throw new BPMNError("err_ZBJG","您填写的中标价格与公司规定的中标价格不一致，问题中标价格为：" + errZBJG.toString());			
		}
		
//=========================校验公司规定价==================================
		StringBuffer errGSGDJ = new StringBuffer();
		try {
		conn = DBSql.open();
		for(TslckpjPO p3 : kpjList) {
			sql = "select count(GSGDJ) cnt from BO_DY_KC_BZPG_S where GSGDJ='"+p3.getGsgdj()+"'";
			cnt = DBSql.getInt(conn, sql,"cnt");
			if(cnt == 0) {
				errGSGDJ.append(p3.getGsgdj());
				errGSGDJ.append(",");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBSql.close(conn);
			}
			if (errGSGDJ.toString().length() > 0) {
				throw new BPMNError("err_GSGDJ","您填写的公司规定价与公司的规定价格不一致，问题数据为：" + errGSGDJ.toString());			
			}		
			
		return true;
	}
}
