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

import dao.FoodDAO;
import model.FoodModel;

public class FoodManageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!checkQueryString(request, response)) {
			System.out.println("Condition false");
			loadDataWeb(request, response);
		} else {
			System.out.println("Condition true");
		}

	}

	private void loadDataWeb(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String basePath = "food_manage.jsp";
		request.setAttribute("role_value", 2);
		FoodDAO dao = new FoodDAO();
		List<FoodModel> listFoot = dao.findListFood();
		request.setAttribute("listFood", listFoot);
		RequestDispatcher view = request.getRequestDispatcher(basePath);
		view.forward(request, response);
	}

	private boolean checkQueryString(HttpServletRequest request, HttpServletResponse response)
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
			deleteFood(mapQuery.get("id"), request, response);
		}
		if (mapQuery.get("action").toLowerCase().equals("add")) {
			addFood(request, response);
		}
		if (mapQuery.get("action").toLowerCase().equals("update")) {
			updateFood(mapQuery.get("id"), request, response);
		}
		return true;
	}

	private void updateFood(String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodDAO dao = new FoodDAO();
		FoodModel model = new FoodModel();
		dao.updateFood(model);
		;
		RequestDispatcher rd = request.getRequestDispatcher("food_manage_update.jsp");
		request.setAttribute("idFood", id);
		rd.forward(request, response);

	}

	private void addFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("food_manage_add.jsp");
		rd.forward(request, response);

	}

	private void deleteFood(String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		FoodDAO dao = new FoodDAO();
		dao.deleteFood(Integer.parseInt(id));
		response.sendRedirect(request.getRequestURL().toString());

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