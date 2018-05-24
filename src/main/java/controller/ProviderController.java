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

import dao.ProviderDAO;
import model.ProviderModel;

public class ProviderController extends HttpServlet {

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
		String basePath = "provider.jsp";
		ProviderDAO dao = new ProviderDAO();
		List<ProviderModel> listProvider = dao.findListProvider();
		request.setAttribute("listProvider", listProvider);
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
			deleteProvider(mapQuery.get("id"), request, response);
		}
		if (mapQuery.get("action").toLowerCase().equals("add")) {
			addProvider(request, response);
		}
		if (mapQuery.get("action").toLowerCase().equals("update")) {
			updateProvider(mapQuery.get("id"), request, response);
		}
		return true;
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

	private void deleteProvider(String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProviderDAO dao = new ProviderDAO();
		dao.deleteProvider(Integer.parseInt(id));
		System.out.println("delete oke !");
		response.sendRedirect(request.getRequestURL().toString());
	}

	private void addProvider(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Chuyen sang trang provider_add
		RequestDispatcher rd = request.getRequestDispatcher("provider_add.jsp");
		rd.forward(request, response);
	}
	private void updateProvider(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProviderDAO dao = new ProviderDAO();
		ProviderModel model = new ProviderModel();
		dao.updateProvider(model);
		RequestDispatcher rd = request.getRequestDispatcher("provider_update.jsp");
		request.setAttribute("idProvider", id);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}