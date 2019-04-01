package bysj.net.manager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bysj.net.model.User;
import bysj.net.util.HibernateUtils;
import bysj.net.util.PageModel;


@SuppressWarnings("unchecked")
public class ObjectManagerImpl implements ObjectManager {

	public void saveObject(Object object) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	public void saveOrUpdateObject(Object object) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	public void updateObject(Object object) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	public void deleteObject(Object object) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	public List getObjectList(Object object) {
		Session session = null;
		List list = null;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from "
					+ object.getClass().getName());
			list = query.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public Object getObject(Object object, int i) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		object = session.load(object.getClass(), i);
		session.getTransaction().commit();
		return object;
	}

	public List getUtil(String hql) {
		Session session = null;
		List list = null;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean checkUser(User user) {
		Session session = null;
		List list = null;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session
					.createQuery("from User where s_0 = ? and s_1 = ? and s_11 = ?");
			query.setString(0, user.getS_0());
			query.setString(1, user.getS_1());
			query.setString(2, user.getS_11());
			list = query.list();
			session.getTransaction().commit();
			if (null != list && list.size() > 0) {
				User tmp = (User) list.get(0);
				user.setId(tmp.getId());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkUsername(User user) {
		Session session = null;
		List list = null;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from User where s_1 = ?");
			query.setString(0, user.getS_1());
			list = query.list();
			session.getTransaction().commit();
			if (null != list && list.size() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public PageModel getUtil(String hql, int currentPageNo) {
		Session session = null;
		List itemList = null;
		int pageSize = PageModel.PAGE_SIZE;
		try {
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setFirstResult((currentPageNo - 1) * pageSize); // 从第0条开始
			query.setMaxResults(pageSize); // 取出10条
			itemList = query.list();
			session.getTransaction().commit();

			PageModel pageModel = new PageModel();
			pageModel.setCurrentPageNo(currentPageNo);
			pageModel.setList(itemList);
			int totalRecords = this.getUtil(hql).size();
			pageModel.setTotalRecords(totalRecords);
			return pageModel;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

}
