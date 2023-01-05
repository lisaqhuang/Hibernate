package tw.hibernatedemo.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.util.HibernateUtil;

public class TestCompanyDaoAction {

	public static void main(String[] args) {
		

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			CompanyDao comDao = new CompanyDao(session);
			CompanyBean com1 = new CompanyBean(1003,"CloudFlare");
			comDao.insert(com1);
			
//			CompanyBean result = comDao.select(1003);
//			if(result !=null) {
//				System.out.println("Name:"+ result.getCompanyId());
//			}else {
//				System.out.println("沒有這筆資料");
//			}
			
			session.getTransaction().commit();					
			
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
		
		   HibernateUtil.closeSessionFactory();
		}

	}

}
