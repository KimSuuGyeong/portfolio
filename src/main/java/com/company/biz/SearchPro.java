package com.company.biz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.common.JDBCConnection;
import com.company.vo.MemberVO;

@WebServlet("/SearchPro")
public class SearchPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/SearchPro");
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
				
		try {
			conn=JDBCConnection.getConnection();
			String sql="select * from ad order by custno";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			ArrayList<MemberVO> memberList=new ArrayList<MemberVO>();
			while(rs.next()) {
				MemberVO mem=new MemberVO();
				mem.setCustno(rs.getInt("custno"));
				mem.setId(rs.getString("id"));
				mem.setPw(rs.getString("pw"));
				mem.setName(rs.getString("name"));
				mem.setPhone(rs.getString("phone"));
				mem.setJoindate(rs.getDate("joindate"));
				mem.setGrade(rs.getString("grade"));
				
				memberList.add(mem);
			}
			request.setAttribute("memberList",memberList);
			RequestDispatcher dispatcher=request.getRequestDispatcher("searchResult.jsp");
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
