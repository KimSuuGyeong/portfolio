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
import com.company.vo.MemberVO;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/Update");
		
		int custno=Integer.parseInt(request.getParameter("custno"));
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCConnection.getConnection();
			String sql="select * from ad where custno=?";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, custno);
			rs=stmt.executeQuery();
			MemberVO vo=null;
			
			if(rs.next()) {
				vo=new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setPhone(rs.getString("phone"));
				vo.setGrade(rs.getString("grade"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setNote(rs.getNote("note"));
			}
			
			request.setAttribute("vo",vo);
			RequestDispatcher dispatcher=request.getRequestDispatcher("update.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
