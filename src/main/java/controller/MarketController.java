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

import dao.MarketDAO;
import model.MarketModel;

public class MarketController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MarketController() {
		super();
	}

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
		String basePath = "market.jsp";
		MarketDAO dao = new MarketDAO();
		List<MarketModel> listMarket = dao.findListMarket();
		request.setAttribute("listMarket", listMarket);
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
			deleteMarket(mapQuery.get("id"), request, response);
		}
		if (mapQuery.get("action").toLowerCase().equals("add")) {
			addMarket(request, response);
		}
		if (mapQuery.get("action").toLowerCase().equals("update")) {
			updateMarket(mapQuery.get("id"), request, response);
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
	private void deleteMarket(String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MarketDAO dao = new MarketDAO();
		dao.deleteMarket(Integer.parseInt(id));
		System.out.println("delete oke !");
		response.sendRedirect(request.getRequestURL().toString());
	}

	private void updateMarket(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarketDAO dao = new MarketDAO();
		MarketModel model = new MarketModel();
		dao.updateMarket(model);;
		RequestDispatcher rd = request.getRequestDispatcher("market_update.jsp");
		request.setAttribute("idMarket", id);
		rd.forward(request, response);
	}

	private void addMarket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("market_add.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}