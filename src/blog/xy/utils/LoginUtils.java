package blog.xy.utils;

import blog.xy.dao.UserDao;
import blog.xy.daoImpl.UserDaoImpl;
import blog.xy.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtils {

	public static void login(HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
			return;

		UserDao dao = UserDaoImpl.getInstance();
		System.out.println("1");

		User user = dao.login(username, password);
		System.out.println("2");
		if (user == null)
			return;

		// 写入session
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

	}

}
