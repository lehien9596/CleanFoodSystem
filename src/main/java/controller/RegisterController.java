package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserModel;

public class RegisterController extends  HttpServlet {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		}
		
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf8");
			String name = request.getParameter("nameUser");
			String pass = request.getParameter("password");
			String email = request.getParameter("email");
			int role  = Integer.valueOf(request.getParameter("role"));
			UserModel userModel = new UserModel(0, name, pass, email, role);
			UserDAO dao = new UserDAO();
			dao.addUser(userModel);
			response.sendRedirect("register_success.jsp");
			
		}
	
	}
