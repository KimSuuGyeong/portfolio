package com.company.biz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.common.JDBCConnection;

@WebServlet("/DeletePro")
public class DeletePro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = JDBCConnection.getConnection();
			String sql = "delete from ad where id=? and name=?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, name);

			int cnt = stmt.executeUpdate();

			System.out.println(cnt + "개 레코드 삭제");

			response.sendRedirect("SearchPro");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(stmt, conn);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
