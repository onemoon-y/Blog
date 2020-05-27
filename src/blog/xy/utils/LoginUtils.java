package blog.xy.utils;

import blog.xy.dao.UserDao;
import blog.xy.daoImpl.UserDaoImpl;
import blog.xy.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtils {

	public static String login(HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msg;

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			msg="用户名或密码为空";
			return msg;
		}

		UserDao dao = UserDaoImpl.getInstance();

		User user = dao.login(username, password);
		if (user == null){
			msg="账户不存在，请重新输入!";
			return msg;
		}
		if(user.getUser_password().equals(password)){
			// 写入session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return null;
		}
		else {
			msg = "密码错误，请重新输入!";
			return msg;
		}
	}

}
