package blog.xy.servlet;

import blog.xy.db.VisitorDB;
import blog.xy.service.ArticleService;
import blog.xy.service.TagService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 传所有的文章
		ArticleService as = ArticleService.getInstance();
		request.setAttribute("articles", as.getArticle());
		// 传所有的分类
		request.setAttribute("sort", as.getAllSort());
		// 传所有的标签
		TagService ts = TagService.getInstance();
		request.setAttribute("tags", ts.getAllTag());
		// 传网站的统计数据
		request.setAttribute("visited", VisitorDB.totalVisit());
		request.setAttribute("member", VisitorDB.totalMember());

		// 转发
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
