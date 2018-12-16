package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----接收请求-----");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User user = UserDao.findUserByUnameAndPassword(uname, pwd);
		if (user != null) {
			System.out.println("登录成功");
			resp.getWriter().write("yes");
		} else {
			resp.getWriter().write("no");
			System.out.println("登录失败");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
