package com.school.koren.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.koren.model.Post;
import com.school.koren.repository.AccountHome;
import com.school.koren.repository.CategoryHome;
import com.school.koren.repository.PostHome;

/**
 * Servlet implementation class SeteADez
 */
@WebServlet("/ZeroADois")
public class ZeroADois extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page="zeroAdois.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZeroADois() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// aqui fazer a operação de checar no banco de dados
		try {
			response.setContentType("text/html");
			PostHome postHome = new PostHome();
			Post post = new Post();
			CategoryHome categoryHome = new CategoryHome();
			AccountHome accountHome = new AccountHome();
			
			post.setCategoryId(categoryHome.findById(1));;
			
			List<Post> lista = postHome.findByExample(post);
			
			HttpSession session = request.getSession();
			session.setAttribute("data", lista);
			
			for(int i = 0; i < lista.size(); i++) {
				out.println(
						"Title: " + lista.get(i).getTitle() + "</br> createdBy: " + lista.get(i).getAccountId().getUsername());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
