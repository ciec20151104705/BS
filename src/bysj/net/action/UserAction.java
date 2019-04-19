package bysj.net.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import bysj.net.manager.ObjectManager;
import bysj.net.model.User;
import bysj.net.util.PageModel;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("unchecked")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String errMsg;
	private String field;
	private String fieldValue;

	private ObjectManager objectManager;

	private PageModel<User> pageModel;

	private User util;

	public String deleteManyUtil() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids[] = request.getParameterValues("id");
		User util = null;
		for (String id : ids) {
			util = new User();
			util.setId(Integer.parseInt(id));
			objectManager.deleteObject(util);
		}
		util = null;
		return getAllUtil();
	}

	public String deleteUtil() throws Exception {
		objectManager.deleteObject(util);
		util = null;
		return getAllUtil();
	}

	public String getAllUtil() throws Exception {
		if (null == pageModel) {
			pageModel = new PageModel<User>();
		}
		if (0 == pageModel.getCurrentPageNo()) {
			pageModel.setCurrentPageNo(1);
		}
		StringBuilder _sql = new StringBuilder();
		_sql.append(" from User ");
		if (null != field && field.trim().length() > 0) {
			fieldValue = new String(fieldValue.getBytes("iso-8859-1"), "utf-8");
			_sql.append(" where " + field + " like '%" + fieldValue + "%'");
		}
		pageModel = objectManager.getUtil(_sql.toString(), pageModel
				.getCurrentPageNo());
		errMsg = null;
		return "find";
	}

	public String getErrMsg() {
		return errMsg;
	}

	public String getField() {
		return field;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public ObjectManager getObjectManager() {
		return objectManager;
	}

	public PageModel<User> getPageModel() {
		return pageModel;
	}

	public User getUtil() {
		return util;
	}

	public String saveOrUpdateObject() throws Exception {
		if (null != util && 0 == util.getId()) {
			String sql = "from User where s_0 = '" + util.getS_0() + "'";
			List list = objectManager.getUtil(sql);
			if (null != list && list.size() > 0) {
				errMsg = "该用户名已被使用";
				return "saveOrUpdate";
			}
		}
		objectManager.saveOrUpdateObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}

	public String selectUtil() throws Exception {
		util = (User) objectManager.getObject(new User(), util.getId());
		errMsg = null;
		return "saveOrUpdate";
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public void setObjectManager(ObjectManager objectManager) {
		this.objectManager = objectManager;
	}

	public void setPageModel(PageModel<User> pageModel) {
		this.pageModel = pageModel;
	}

	public void setUtil(User util) {
		this.util = util;
	}

}
