package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import dao.FoodDetailDAO;
import model.FoodDetailModel;
import model.GetLinkImageResponse;
import utils.MultipartUtility;
import utils.Utils;

@MultipartConfig
public class FoodDetailAddController extends HttpServlet {

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
		 String name = request.getParameter("nameFoodDetail");
		 String note = request.getParameter("note");
		 Integer number = Integer.valueOf(request.getParameter("number"));
		 String codeQR = request.getParameter("codeQR");
		 Integer idProvider = Integer.valueOf(request.getParameter("idProvider"));
		 Integer idManage = Integer.valueOf(request.getParameter("idManage"));
		 Integer idMarket = Integer.valueOf(request.getParameter("idMarket"));
		 Integer idFood = Integer.valueOf(request.getParameter("idFood"));
		 String imageUrl = "";

		Part filePart = request.getPart("fileImage"); // Retrieves <input type="file" name="file">
		if (filePart != null) {
			InputStream fileContent = filePart.getInputStream();
			String fileName = getFileName(filePart);
			byte[] buffer = new byte[fileContent.available()];
			fileContent.read(buffer);

			File targetFile = new File("F:/" + fileName);
			OutputStream outStream = new FileOutputStream(targetFile);
			outStream.write(buffer);
			outStream.close();

			String base64 = Utils.imgToBase64StringCore(Utils.readFileImage("F:/" + fileName), "jpg");
			try {

				MultipartUtility multipartUtility = new MultipartUtility("https://api.imgur.com/3/upload", "UTF-8");
				multipartUtility.addFormField("type", "base64");
				multipartUtility.addFormField("image", base64);
				List<String> listResponse = multipartUtility.finish();

				if (!listResponse.isEmpty()) {
					GetLinkImageResponse obj = new Gson().fromJson(listResponse.get(0), GetLinkImageResponse.class);
					imageUrl = obj.getData().getLink();
				}
			} catch (Exception e) {
				System.out.println("Error upload image");
			}
			System.out.println("File name image: " + fileName);
		} else {
			System.out.println("File part null");
		}

		 FoodDetailModel foodDetailModel = new FoodDetailModel(0, name, note, number,
		 codeQR, idProvider, idManage,
		 idMarket, idFood,imageUrl);
		 FoodDetailDAO dao = new FoodDetailDAO();
		 dao.addFoodDetail(foodDetailModel);

		response.sendRedirect("foodDetail" + "?id=" +idFood);
	}

	private String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
