package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("password");
		String phone = req.getParameter("phone");
		boolean b = UserDao.insertUser(uname, pwd, phone);
		if (b) {
			System.out.println("×¢²á³É¹¦");
			resp.getWriter().write("yes");
		} else {
			System.out.println("×¢²áÊ§°Ü");
			resp.getWriter().write("no");
		}

	}

}
