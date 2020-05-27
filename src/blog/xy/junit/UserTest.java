package blog.xy.junit;

import blog.xy.dao.UserDao;
import blog.xy.daoImpl.UserDaoImpl;
import blog.xy.model.User;
import org.junit.Test;

public class UserTest {

	@Test
	public void testLogin() throws Exception {
		// String name="myblog";
		// String password="123";
		String name = "my";
		String password = "1234";

		UserDao userDao = UserDaoImpl.getInstance();
		User user = userDao.login(name, password);
		if (user != null) {
			System.out.println(user.getUser_id());
			System.out.println(user.getUser_name());
			System.out.println(user.getUser_password());
		} else {
			System.out.println("Login failed");
		}

	}
}
