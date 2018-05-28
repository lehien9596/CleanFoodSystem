package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManageDAO;
import model.ManageModel;

public class ManageAddController extends HttpServlet {

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
		String name = request.getParameter("nameManage");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		ManageModel manageModel = new ManageModel(0, name, address, phone);
		ManageDAO dao = new ManageDAO();
		int idUser = Integer.parseInt(request.getSession().getAttribute("id_user").toString());
		dao.addManage(manageModel, idUser);
		response.sendRedirect("manage");
	}

}
