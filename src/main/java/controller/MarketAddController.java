package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.MarketDAO;
import model.MarketModel;

public class MarketAddController extends HttpServlet {
	
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
		String name = request.getParameter("nameMarket");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		MarketModel marketModel = new MarketModel(0, name, address, phone);
		MarketDAO dao = new MarketDAO();
		dao.addMarket(marketModel);
		response.sendRedirect("market");
	}

}
