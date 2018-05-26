package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodDetailDAO;
import model.FoodDetailModel;
import utils.Utils;

public class FoodDetailManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FoodDetailManageController() {
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
		int id = Integer.parseInt(request.getParameter("id").toString());
		String basePath = "foodDetailManage.jsp";
		FoodDetailDAO dao = new FoodDetailDAO();
		List<FoodDetailModel> listFootDetail = dao.getFoodDetail(id);
		request.setAttribute("listFoodDetail", listFootDetail);
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
			deleteFoodDetail(mapQuery.get("idFoodDetail"), mapQuery.get("id"), request, response);
			return true;
		}
		if (mapQuery.get("action").toLowerCase().equals("add")) {
			addFootDetail(mapQuery.get("id"), request, response);
			return true;
		}
		if (mapQuery.get("action").toLowerCase().equals("update")) {
			updatetFoodDetail(mapQuery.get("idFoodDetail"), mapQuery.get("id"), request, response);
			return true;
		}
		if (mapQuery.get("action").toLowerCase().equals("showtem")) {
			showTem(mapQuery.get("idFoodDetail"), mapQuery.get("id"), request, response);
			return true;
		}
		return true;
	}

	private void showTem(String idFoodDetail, String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("#Show tem");
		FoodDetailDAO dao = new FoodDetailDAO();

		FoodDetailModel model = dao.getFoodDetailById(Integer.parseInt(idFoodDetail));

		// URL url = ImageUtil.class.getResource("image/bapcai.jpg");
		// BufferedImage imageProduct = ImageIO.read(url);
		// String imageProductCode = Utils.imgToBase64String(imageProduct, "jpg");
		//
		// String detail = model.getInfo();
		// detail = detail.concat("image : ").concat(imageProductCode);

		System.out.println("Model Infor: \n" + model.getInfo());
		BufferedImage bufferedImage = Utils.createQRCode(model.getInfo(), 256, 256);
		if (bufferedImage == null) {
			return;
		}

		String imgBase64String = Utils.imgToBase64String(bufferedImage, "png");
		RequestDispatcher rd = request.getRequestDispatcher("tem.jsp");
		request.setAttribute("imgBase64String", imgBase64String);
		rd.forward(request, response);

	}

	private void updatetFoodDetail(String idFootDetail, String id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FoodDetailDAO dao = new FoodDetailDAO();
		FoodDetailModel model = new FoodDetailModel();
		dao.updateFoodDetail(model);
		RequestDispatcher rd = request.getRequestDispatcher("food_detail_update.jsp");
		request.setAttribute("idFootDetail", idFootDetail);
		rd.forward(request, response);

	}

	private void addFootDetail(String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("food_detail_add.jsp");
		rd.forward(request, response);
	}

	private void deleteFoodDetail(String idFootDetail, String id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FoodDetailDAO dao = new FoodDetailDAO();
		dao.deleteFoodDetail(Integer.parseInt(idFootDetail));
		System.out.println("delete oke !" + id + " - " + idFootDetail);
		response.sendRedirect(request.getRequestURL() + "?id=" + id);

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
