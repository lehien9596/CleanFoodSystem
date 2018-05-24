package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodDetailDAO;
import model.FoodDetailModel;

public class FoodDetailUpdateController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		Integer idFoodDetail = Integer.valueOf(request.getParameter("idFoodDetail"));
		System.out.println("idFoodDetail" + idFoodDetail);
		String name = request.getParameter("nameFoodDetail");
		String note = request.getParameter("note");
		Integer number = Integer.valueOf(request.getParameter("number"));
		String codeQR = request.getParameter("codeQR");
		Integer idProvider = Integer.valueOf(request.getParameter("idProvider"));
		Integer idManage = Integer.valueOf(request.getParameter("idManage"));
		Integer idMarket = Integer.valueOf(request.getParameter("idMarket"));
		Integer idFood = Integer.valueOf(request.getParameter("idFood"));
		String image = request.getParameter("image");

		FoodDetailModel foodDetailModel = new FoodDetailModel(idFoodDetail, name, note, number, codeQR, idProvider,
				idManage, idMarket, idFood, image);
		FoodDetailDAO dao = new FoodDetailDAO();

		dao.updateFoodDetail(foodDetailModel);
		response.sendRedirect("foodDetail" + "?id=" + idFood);

	}

}
