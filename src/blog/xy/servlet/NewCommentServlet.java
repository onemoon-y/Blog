package blog.xy.servlet;

import blog.xy.model.Comment;
import blog.xy.service.CommentService;
import blog.xy.utils.DateUtils;
import blog.xy.utils.FailException;
import blog.xy.utils.Form2Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class NewCommentServlet
 */
@WebServlet("/NewCommentServlet")
public class NewCommentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cookie_name = "comment_cookie" + request.getParameter("id");

		// 判断是否恶意提交
		boolean isRpeat = false;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookie_name)) {
					isRpeat = true;
					break;
				}
			}
		}

		// 返回的信息
		String info;
		if (!isRpeat) {
			Comment cm;
			// 获取对象
			try {
				cm = Form2Bean.commentForm2Bean(request);
				CommentService cs = CommentService.getInstance();
				boolean result = cs.addComment(cm);
				if (!result) {
					info = "comment failed!";
				} else {
					info = "comment success!";
				}
			} catch (FailException e) {
				e.printStackTrace();
				info = "comment failed!";
			}
		} else {
			info = "repeat submit comment!";
		}

		// 发送新的cookie
		Cookie c = new Cookie(cookie_name, DateUtils.getFormatDate(new Date()));
		c.setMaxAge(60 * 60);
		c.setPath("/Blog");
		response.addCookie(c);

		request.setAttribute("info", info);
		request.getRequestDispatcher("/ArticleServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
