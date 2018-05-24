package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodDAO;
import model.FoodModel;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		//ở đây lấy parameter như bt rồi thưực hiện update là ok
		//thì vẫn phải dùng post đaỷ data vào  chứ.
		//cậu hiểu sai vêề nó rồi. Dao là tâầng để làm .controller đêể điều khiên
		//các bưoớc tiếp theo nhá.
		//1.lấy ra id từ url -> lấy đối tượng theo id nhá
		
		//2.đóng gói dữ liệu vào obj để hiện thị lên view update.
		
		//3.view update có method thì viêết trong post
		int id = Integer.valueOf(request.getParameter("idFood"));
		System.out.println(id);
		String name = request.getParameter("nameFood");
		String note = request.getParameter("note");
		FoodModel foodModel = new FoodModel(id, name, note);
		//tầng này nó xử lý nhá.
		FoodDAO dao = new FoodDAO();
		dao.updateFood(foodModel);
		response.sendRedirect("food");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//giả sưử nó ddẩy vào đây.
		//4. get paramet như bthuong.
		
		//5.đóng gói vào obj rồi update theo Dao nhá -> kết thúc.
		
		//chỗ nào ko hiểu k?
		// do get với do post giống nhau mà
		// phần post thì thêm cái dao để sendRedirect đúng ko: ok 
		// vì cái thể <a> măặc định vào get vì vậy mk phải vào get để lấy/
		//hiểu chưa...các bước nó như thế thhooi
		//thế chuyên sang button đc ko
		//hôm trc t ko dùng button nên mới nhét vào <a>
		//button thì làm sao mà link tới trang khác đk..làm button đk nhưng cậu ko biết dùng javaScirp với jQuery 
		//uh. ở đây tool này t thấy hạn chế. bt tớ đang code 
		//js với typescript rồi. ngôn ngữ mới . maasyc ái cho vào đây nó ko nhận
		//hôm trc t get bên kia luôn. rồi dùng post thôi.
		//thôi mai nghiên cuwus lại chút. thanks c nhé. nghỉ đi mai đi làm :))
	}

}
