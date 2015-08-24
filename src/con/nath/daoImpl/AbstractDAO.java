package con.nath.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO<T> {
	
	@Autowired
//	@Qualifier("sessionFactory")
	  private SessionFactory sessionFactory;
	
	private Class<T> entityClass;
	
	public AbstractDAO(Class <T> entityClass) {
		this.entityClass = (Class<T>) entityClass;
	}	
	
	
	public SessionFactory getSessionFactory() {
		return (SessionFactory)sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void save(final T object){
		((Session) getSessionFactory()).save(object);
	}
	
	public T getById(long id){
		return (T)((Session) this.getSessionFactory()).get(this.entityClass, id);
	}
	
	/*public T getByName(String nameValue){
		Criteria criteria =  getSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq("name", nameValue));
		return (T) criteria.uniqueResult();
	}
	
	public T getByProperty(String property, String propertyValue){
		Criteria criteria =  getSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq(property, propertyValue));
		return (T) criteria.uniqueResult();*/
}
