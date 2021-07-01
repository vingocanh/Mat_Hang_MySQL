package conn;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.MatHang;

/**
 * Servlet implementation class QuanLyMatHang
 */
@WebServlet(urlPatterns = {"/", "/create", "/edit", "/delete"})
//@WebServlet("/QuanLyMatHang")
public class QuanLyMatHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DatabaseController database;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyMatHang() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	String url = "jdbc:mysql://localhost:3306/qlcuahang";
        String user = "root";
        String pass = "";
    	database = new DatabaseController(url,user , pass);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String luaChon = request.getServletPath();
		System.out.print(luaChon);
		try {
			
			switch (luaChon) {
			case "/insert":	
				insert(request,response);
				break;
			case "/create":
				newForm(request, response);
				break;
			case "/update":
				uppdateThuoc(request,response);
				break;
			case "/edit":
				edit(request,response);
				break;
			case "/delete":
				delete(request,response);
				break;
			default:
				list(request, response);
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
//	Chuyển đến fom thêm 
	private void newForm(HttpServletRequest request, HttpServletResponse response){
		try
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("ThemMH.jsp");
			dispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
//	Thêm dữ liệu vào trong csdl
	private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String ten = request.getParameter("tenMH");
		String motA = request.getParameter("moTa");
		String chatLieu = request.getParameter("chatLieu");
		String noiSX = request.getParameter("noiSX");
		String hangSX = request.getParameter("hangSX");
		String ngaySX = request.getParameter("ngaySX");
		Date date = Date.valueOf(ngaySX);
		
		MatHang mh = new MatHang(ten, motA, chatLieu, noiSX, hangSX, date);
		database.insertMatHang(mh);
		response.sendRedirect("mathang");
	}
//	Chuyển đến form sửa và hiển thị thông tin cần sửa
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.print("::"+id);
		MatHang mh = database.getAllMHID(id);
		request.setAttribute("mathang", mh);
		RequestDispatcher dispatcher=request.getRequestDispatcher("SuaMH.jsp");
		dispatcher.forward(request, response);
	}
//	Sửa dữ liệu trong csdl
	private void uppdateThuoc(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
		
		
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Ma: "+ id);
		MatHang mh = new MatHang(id);
		database.deleteMH(mh);
		response.sendRedirect("mathang");
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response)  {	
		try {
			ArrayList<MatHang> listThuoc = database.getAllMH();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("DanhSach.jsp");
			request.setAttribute("mathang", listThuoc);
			requestDispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
