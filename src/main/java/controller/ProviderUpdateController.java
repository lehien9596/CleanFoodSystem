package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProviderDAO;
import model.ProviderModel;

public class ProviderUpdateController extends HttpServlet {
	
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
		int id = Integer.valueOf(request.getParameter("idProvider"));
		String nameProvider = request.getParameter("nameProvider");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		ProviderModel providerModel = new ProviderModel(id, nameProvider, address, phone);
		ProviderDAO dao = new ProviderDAO();
		dao.updateProvider(providerModel);
		response.sendRedirect("provider");
		
	}

}
