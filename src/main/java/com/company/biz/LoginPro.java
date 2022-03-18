package com.company.biz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.common.JDBCConnection;

@WebServlet("/LoginPro")
public class LoginPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/LoginPro");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCConnection.getConnection();
			String sql="select * from ad where id=? and pw=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			rs=stmt.executeQuery();
			
			 if(id.equals("admin")){
				response.sendRedirect("adminPage.jsp");
				String name=rs.getString("name");
				HttpSession session=request.getSession();
				session.setAttribute("name", name); 
			}else if(rs.next()) { //로그인 성공
				String name=rs.getString("name");
				HttpSession session=request.getSession();
				session.setAttribute("name", name); 
				response.sendRedirect("picture.jsp");
			}else {
				PrintWriter out=response.getWriter();
				out.println("<script>alert('아이디나 비밀번호 확인해주세요.');location.href='index.html'</script>");
				response.sendRedirect("index.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs,stmt,conn);
		}
	}

}
