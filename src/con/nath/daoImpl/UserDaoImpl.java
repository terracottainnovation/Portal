package con.nath.daoImpl;

import com.nath.dao.IUserDao;
import com.nath.model.User;

public class UserDaoImpl extends AbstractDAO<User> implements IUserDao {
	
	public UserDaoImpl() {
		super(User.class);
	}
	@Override
	public User getUserByName(String userName) {
		User user = new User();
		user.setId(1l);
		user.setUserLogin("tejas.mahajan");
//		getSessionFactory()..save(user);
		return getById(user.getId());
	}

	
}
