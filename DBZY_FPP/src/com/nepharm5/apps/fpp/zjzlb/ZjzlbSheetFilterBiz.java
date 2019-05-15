package com.nepharm5.apps.fpp.zjzlb;
/**
 * @author wuzhanqiang
 * @date 2019-1-3
 * 
 */
import java.util.List;
import com.actionsoft.bpms.bo.design.model.BOItemModel;
import com.actionsoft.bpms.bo.engine.BO;
import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.FormGridFilterListener;
import com.actionsoft.bpms.bpmn.engine.listener.FormGridRowLookAndFeel;
import com.actionsoft.bpms.bpmn.engine.listener.ListenerConst;
import com.actionsoft.bpms.bpmn.engine.listener.ValueListenerInterface;
import com.actionsoft.bpms.form.design.model.FormItemModel;
import com.actionsoft.bpms.server.UserContext;
import com.actionsoft.sdk.local.SDK;

public class ZjzlbSheetFilterBiz extends FormGridFilterListener implements ValueListenerInterface {
	public ZjzlbSheetFilterBiz() {
		setDescription("制剂质量部，子表过滤功能");
	}

	@Override
	public FormGridRowLookAndFeel acceptRowData(ProcessExecutionContext context, List<BOItemModel> boItemList, BO boData) {
		if (context.getParameterOfString(ListenerConst.FORM_EVENT_PARAM_BONAME).toString().equals("BO_DY_ZJZLB_S")) {
			StringBuffer productManagers = new StringBuffer();
			String bindid = context.getProcessInstance().getId();
			List<BO> formData = SDK.getBOAPI().query("BO_DY_ZJZLB_S").bindId(bindid).list();
			int i = 0;
			for (int count = formData.size(); i < count; i++)
		      {
		        BO record = (BO)formData.get(i);
		        productManagers.append(", ").append(record.get("TJR"));
		      }
			FormGridRowLookAndFeel diyLookAndFeel = new FormGridRowLookAndFeel();
			UserContext user = context.getUserContext();
			String productManager = boData.getString("TJR");
			String currentUser = user.getUserModel().getUserName();
			if (productManager.equals(currentUser)) {
		        diyLookAndFeel.setDisplay(true);
		      } else if ((!productManager.equals(currentUser)) && (productManagers.indexOf(currentUser) == -1)) {
		        diyLookAndFeel.setDisplay(true);
		      } else {
		        diyLookAndFeel.setDisplay(false);
		      }
		      return diyLookAndFeel;
		 }
		return null;
	}

	@Override
	public String getCustomeTableHeaderHtml(ProcessExecutionContext arg0, FormItemModel arg1, List<String> arg2) {
		return null;
	}

	@Override
	public String orderByStatement(ProcessExecutionContext arg0) {
		return null;
	}

}
