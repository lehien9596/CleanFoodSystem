package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodDAO;
import model.FoodModel;

public class FoodManageAddController extends HttpServlet{
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
		String name = request.getParameter("nameFood");
		String note = request.getParameter("note");
		FoodModel foodModel = new FoodModel(0, name, note);
		FoodDAO dao = new FoodDAO();
		dao.addFood(foodModel);
		response.sendRedirect("food_manage");
	}
}
