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

import com.company.common.JDBCConnection;


@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/IdCheck");
		String id=request.getParameter("id");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		System.out.println("/IdCheck id값 확인 : "+id);
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCConnection.getConnection();
			String sql="select id from ad where id=?";
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			
			rs=stmt.executeQuery();
			String idExist;
			if(rs.next()) {
				idExist="yes";
			}else {
				idExist="no";
			}

			out.print(idExist);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
