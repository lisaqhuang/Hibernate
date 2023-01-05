package tw.hibernatedemo.model;

import java.util.List;

import org.hibernate.Session;

public class CompanyDao implements CompanyDaoInterface {
	
	private Session session;
	
	//依賴注入Dependency Injection
	public CompanyDao(Session session) {
		this.session = session;
	}
	
	
	@Override
	public CompanyBean insert(CompanyBean comBean) {
		
		CompanyBean companyBean = session.get(CompanyBean.class, comBean.getCompanyId());
		if(companyBean == null) {
			session.save(comBean);
			return comBean;
		}
		return null;
	}

	@Override
	public CompanyBean select(int comId) {
		// TODO Auto-generated method stub
		session.get(CompanyBean.class, comId);
		
		return null;
	}

	@Override
	public List<CompanyBean> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyBean updateOne(int comId, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOne(int comId) {
		// TODO Auto-generated method stub
		return false;
	}

}
