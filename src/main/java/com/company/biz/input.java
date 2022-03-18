package com.company.biz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.common.JDBCConnection;

@WebServlet("/input")
public class input extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/input");
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCConnection.getConnection();
			String sql="select max(CUSTNO)+1 as maxnum from ad";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			int maxNum=1001;
			if(rs.next()) {
				maxNum=rs.getInt(1)+1;
				System.out.println(maxNum);
			}
			request.setAttribute("maxNum", maxNum);
			RequestDispatcher dispatcher=request.getRequestDispatcher("join.jsp");
			dispatcher.forward(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
