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
import javax.servlet.http.HttpSession;

import com.school.koren.model.Account;
import com.school.koren.model.Post;
import com.school.koren.repository.AccountHome;
import com.school.koren.repository.PostHome;

/**
 * Servlet implementation class UserPosts
 */
@WebServlet("/UserPosts")
public class UserPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPosts() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		
		Account conta = (Account) session.getAttribute("conta");
		Account findConta = new Account();
		PostHome postHome = new PostHome();
		AccountHome accountHome = new AccountHome();
		findConta.setUsername(conta.getUsername());
		
		try {			
			Post post = new Post();
			
			post.setAccountId(accountHome.findByExample(findConta).get(0));
			
			List<Post> postagens = new ArrayList<>();
			
			for (Post postagem : postHome.findByExample(post)) {
				postagens.add(postagem);
			}
			
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("/userPost.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			// TODO: handle exception
		}finally {
			accountHome.terminate();
			postHome.terminate();
		}
		
	}

}
