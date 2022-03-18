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

@WebServlet("/JoinPro")
public class JoinPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("/JoinPro");
		int custno=Integer.parseInt(request.getParameter("custno"));
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		Date joindate=Date.valueOf(request.getParameter("joindate"));
		String grade=request.getParameter("grade");
		
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=JDBCConnection.getConnection();
			String sql="insert into ad values(?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, custno);
			stmt.setString(2, id);
			stmt.setString(3, pw);
			stmt.setString(4, name);
			stmt.setString(5, phone);
			stmt.setDate(6, joindate);
			stmt.setString(7, grade);
			
			int cnt=stmt.executeUpdate();
			
			System.out.println(cnt+"개 레코드 삽입");
			response.sendRedirect("index.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCConnection.close(stmt, conn);
		}
	}

}
