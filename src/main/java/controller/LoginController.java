package controller;

import java.io.IOException;
import java.util.Map;

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
		System.out.println("aaaa" + username + password);
		UserModel userModel = new UserModel();
		userModel.setNameUser(username);
		userModel.setPassword(password);
		Map<Integer, Integer> map = new LoginDAO().login(userModel);
		if (!map.isEmpty()) {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int idUser = entry.getKey();
				int role = entry.getValue();
				RequestDispatcher rd2 = null;
				switch (role) {
				case 0:
					rd2 = request.getRequestDispatcher("trangchu.jsp");
					break;
				case 1:
					rd2 = request.getRequestDispatcher("food_provider");
					request.setAttribute("role_value", 1);
					break;
				case 2:
					rd2 = request.getRequestDispatcher("food_manage");
					request.setAttribute("role_value", 2);
					break;
				default:
					rd2 = request.getRequestDispatcher("food");
					request.setAttribute("role_value", 0);
					break;
				}
				request.getSession().setAttribute("id_user", idUser);
				rd2.forward(request, response);
			}
		} else {
			RequestDispatcher rd3 = request.getRequestDispatcher("erorr_login.jsp");
			rd3.forward(request, response);
		}

	}

}
