package com.school.koren.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.koren.model.Post;
import com.school.koren.repository.CategoryHome;
import com.school.koren.repository.PostHome;

/**
 * Servlet implementation class TresACinco
 */
@WebServlet("/TresACinco")
public class TresACinco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page="tresAcinco.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TresACinco() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryHome categoryHome = new CategoryHome();
		PostHome postHome = new PostHome();
		try {
			Post post = new Post();
			
			post.setCategoryId(categoryHome.findById(2));
			
			List<Post> postagens = new ArrayList<>();
			
			for (Post postagem : postHome.findByExample(post)) {
				postagens.add(postagem);
			}
						
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("/tresAcinco.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			categoryHome.terminate();
			postHome.terminate();
		}
		
	}
}
