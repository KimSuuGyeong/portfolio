package com.company.biz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.common.JDBCConnection;

@WebServlet("/UpdatePro")
public class UpdatePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/UpdatePro");
		request.setCharacterEncoding("utf-8");
		
		int custno=Integer.parseInt(request.getParameter("custno"));
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String grade=request.getParameter("grade");
		String note=request.getParameter("note");
		Date joindate=Date.valueOf(request.getParameter("joindate"));
		

		
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=JDBCConnection.getConnection();
			String sql="update ad set id=?,pw=?,name=?,phone=?,grade=?,joindate=?,note=? where custno=?";
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			stmt.setString(2, pw);
			stmt.setString(3,name);
			stmt.setString(4, phone);
			stmt.setString(5, grade);
			stmt.setDate(6, joindate);
			stmt.setString(7, note);
			stmt.setInt(8, custno);

			
			int cnt=stmt.executeUpdate();
			
			System.out.println(cnt+"개 레코드 수정");
			response.sendRedirect("adminPage.jsp");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(stmt, conn);
		}
	}

}
