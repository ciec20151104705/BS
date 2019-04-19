package bysj.net.action;

import java.util.*;
import bysj.net.model.*;
import bysj.net.manager.ObjectManager;
import com.opensymphony.xwork2.*;

import bysj.net.util.PageModel;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings({ "unchecked", "serial" })
public class UserLeaveAction extends ActionSupport {
	private UserLeave util;
	private PageModel<UserLeave> pageModel;
	private List<User> listUser;
	private List<User> listUser1;
	private String errMsg;
	private String field;
	private String fieldValue;
	private ObjectManager objectManager;

	public String initUtil() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String type = (String) session.get("type");
		int id = (Integer) session.get("id");
		if ("user".equals(type)) {
			listUser = objectManager
					.getUtil("from User where s_11 = 'user' and id = " + id);
		} else {
			listUser = objectManager.getUtil("from User where s_11 = 'user'");
		}

		listUser1 = objectManager.getUtil("from User");
		util = null;
		return "saveOrUpdate";
	}

	public String saveOrUpdateObject() throws Exception {
		
		if("".equals(util.getS_5()) || null == util.getS_5()){
			util.setS_5("申请中");
		}
		
		objectManager.saveOrUpdateObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}
	
	public String fdytyUtil() throws Exception {
		util = (UserLeave) objectManager.getObject(new UserLeave(), util.getId());
		util.setS_5("辅导员同意");
		
		objectManager.saveOrUpdateObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}
	
	public String fdybhUtil() throws Exception {
		util = (UserLeave) objectManager.getObject(new UserLeave(), util.getId());
		util.setS_5("辅导员拒绝");
		
		objectManager.saveOrUpdateObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}
	
	public String lstyUtil() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int id = (Integer) session.get("id");
		util = (UserLeave) objectManager.getObject(new UserLeave(), util.getId());
		util.setS_5("老师同意");
		User u = new User();
		u.setId(id);
		util.setUser1(u);
		objectManager.saveOrUpdateObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}
	
	public String lsbhUtil() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int id = (Integer) session.get("id");
		util = (UserLeave) objectManager.getObject(new UserLeave(), util.getId());
		util.setS_5("老师拒绝");
		util.setS_5("老师同意");
		User u = new User();
		u.setId(id);
		util.setUser1(u);
		objectManager.saveOrUpdateObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}

	public String deleteManyUtil() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids[] = request.getParameterValues("id");
		UserLeave util = null;
		for (String id : ids) {
			util = new UserLeave();
			util.setId(Integer.parseInt(id));
			objectManager.deleteObject(util);
		}
		util = null;
		return getAllUtil();
	}

	public String deleteUtil() throws Exception {
		objectManager.deleteObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}

	public String selectUtil() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String type = (String) session.get("type");
		int id = (Integer) session.get("id");
		if ("user".equals(type)) {
			listUser = objectManager
					.getUtil("from User where s_11 = 'user' and id = " + id);
		} else {
			listUser = objectManager.getUtil("from User where s_11 = 'user'");
		}
		listUser1 = objectManager.getUtil("from User");
		util = (UserLeave) objectManager.getObject(new UserLeave(),
				util.getId());
		return "saveOrUpdate";
	}

	public String getAllUtil() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String type = (String) session.get("type");
		int id = (Integer) session.get("id");
		if (null == pageModel) {
			pageModel = new PageModel<UserLeave>();
		}
		if (0 == pageModel.getCurrentPageNo()) {
			pageModel.setCurrentPageNo(1);
		}
		StringBuilder _sql = new StringBuilder();
		_sql.append(" from UserLeave where 1 = 1 ");
		if ("user".equals(type)) {
			_sql.append(" and user.id = " + id);
		}
		if (null != field && field.trim().length() > 0) {
			fieldValue = new String(fieldValue.getBytes("iso-8859-1"), "utf-8");
			_sql.append(" and " + field + " like '%" + fieldValue + "%'");
		}
		pageModel = objectManager.getUtil(_sql.toString(),
				pageModel.getCurrentPageNo());
		errMsg = null;
		return "find";
	}

	public UserLeave getUtil() {
		return util;
	}

	public void setUtil(UserLeave util) {
		this.util = util;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public ObjectManager getObjectManager() {
		return objectManager;
	}

	public void setObjectManager(ObjectManager objectManager) {
		this.objectManager = objectManager;
	}

	public PageModel<UserLeave> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<UserLeave> pageModel) {
		this.pageModel = pageModel;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public List<User> getListUser1() {
		return listUser1;
	}

	public void setListUser1(List<User> listUser1) {
		this.listUser1 = listUser1;
	}

}
