package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserModel;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//checkQueryString(request, response);
		if (!checkQueryString(request, response)) {
			System.out.println("Condition false");
			loadDataWeb(request, response);
		} else {
			System.out.println("Condition true");
		}

	}

	private void loadDataWeb(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String basePath = "listuser.jsp";
		UserDAO dao = new UserDAO();
		List<UserModel> listUser = dao.findUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher view = request.getRequestDispatcher(basePath);
		view.forward(request, response);

	}

	private Boolean checkQueryString(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String queryString = request.getQueryString();
		if (queryString == null) {
			return false;
		}
		String arr[] = queryString.split("&");
		Map<String, String> mapQuery = new HashMap<>();
		for (String s : arr) {
			String arr2[] = s.split("=");
			if (arr2.length == 2) {
				mapQuery.put(arr2[0], arr2[1]);
			}
		}

		if (!checkCondition(mapQuery)) {
			return false;
		}

		if (mapQuery.get("action").toLowerCase().equals("delete")) {
			deleteUser(mapQuery.get("id"), request, response);
		}
		if (mapQuery.get("action").toLowerCase().equals("add")) {
			addUser(request, response);
		}
		if (mapQuery.get("action").toLowerCase().equals("update")) {
			updatetUser(mapQuery.get("id"),request, response);
		}
		return true;
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("user_add.jsp");
		rd.forward(request, response);
	}

	private void deleteUser(String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		dao.deleteUser(Integer.parseInt(id));
		System.out.println("delete oke !");
		response.sendRedirect(request.getRequestURL().toString());

	}
	private void updatetUser(String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDAO dao = new UserDAO();
		UserModel model = new UserModel();
		dao.updateUser(model);
		RequestDispatcher rd = request.getRequestDispatcher("user_update.jsp");
		request.setAttribute("idUser", id);
		rd.forward(request, response);
	}

	private boolean checkCondition(Map<String, String> mapQuery) {
		if (mapQuery.get("id") == null && mapQuery.get("action") != null
				&& mapQuery.get("action").toLowerCase().equals("add")) {
			return true;
		}

		if (mapQuery.get("action") == null || mapQuery.get("id") == null) {
			return false;
		}

		return true;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
