package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import model.UserModel;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("aaaaaaaaaa");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("aaaa" + username + password );
		UserModel userModel = new UserModel();
		userModel.setNameUser(username);
		userModel.setPassword(password);
		boolean check = new LoginDAO().isLogin(userModel);
		if (check) {
			RequestDispatcher rd2 = request.getRequestDispatcher("trangchu.jsp");
			rd2.forward(request, response);
		} else {
			RequestDispatcher rd3 = request.getRequestDispatcher("erorr_login.jsp");
			rd3.forward(request, response);
		}

	}

}
