package br.edu.ifsp.arq.controller.news;

import br.edu.ifsp.arq.model.dao.CategoryDAO;
import br.edu.ifsp.arq.model.dao.NewsArticleDAO;
import br.edu.ifsp.arq.model.entity.NewsArticle;
import br.edu.ifsp.arq.model.entity.NewsArticleCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateNewsArticle")
public class UpdateNewsArticle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static NewsArticleDAO newsArticleDAO;
    private static CategoryDAO categoryDAO;

    public UpdateNewsArticle() {
        super();
        newsArticleDAO = NewsArticleDAO.getInstance();
        categoryDAO = CategoryDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String url = "/news/updateNewsArticle.jsp";
        request.setAttribute("newsArticle", newsArticleDAO.getById(id));
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.jsp";
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publishDate = request.getParameter("publishDate");
        String source = request.getParameter("source");
        String summary = request.getParameter("summary");
        String text = request.getParameter("text");
        Long category = Long.parseLong(request.getParameter("category"));
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");

        try {
            NewsArticleCategory newsArticleCategory = categoryDAO.getById(category);
            List<String> imageList = new ArrayList<>();
            imageList.add(image1);
            imageList.add(image2);
            NewsArticle newsArticle = new NewsArticle(title, author, publishDate, source, summary, text, newsArticleCategory, imageList);
            newsArticleDAO.editNewsArticle(newsArticle);

        } catch (Exception e) {
            url = "/news/updateNewsArticle.jsp";
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}