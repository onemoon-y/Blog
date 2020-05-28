package blog.xy.servlet;

import blog.xy.service.ArticleService;
import blog.xy.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取的是所有分类 还是一个分类的文章
		String get = StringUtils.pareCode(request.getParameter("get"));
		// 初始化分类和文章
		ArticleService as = ArticleService.getInstance();
		request.setAttribute("sort_article_map", as.getSortAndAirticle(get));
		// 转发
		request.getRequestDispatcher("/page/sort.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
