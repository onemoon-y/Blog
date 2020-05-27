package blog.xy.junit;

import blog.xy.dao.ArticleDao;
import blog.xy.daoImpl.ArticleDaoImpl;
import blog.xy.model.Article;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class ArticleTest {

	// @Test
	public void testGetArticleByColumn() {

		ArticleDao dao = ArticleDaoImpl.getInstance();
		List<Article> articleBySort = dao.getArticleByColumn("id", "2");
		for (Article a : articleBySort) {
			System.out.println(a.toString());
		}

	}

	@Test
	public void testSplit() {
		String str = " ea eeare ear erae";
		String[] s = str.split(" ");
		for (String s1 : s) {
			System.out.println(s1);
		}
	}

	// @Test
	public void testGetArticle() {

		ArticleDao dao = ArticleDaoImpl.getInstance();
		try {
			List allArticle = dao.getAllArticle();
			if (allArticle.size() > 0) {

				Iterator it = allArticle.iterator();
				while (it.hasNext()) {
					Article at = (Article) it.next();
					System.out.println(at.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
