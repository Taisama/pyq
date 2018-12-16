package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dBCPUtlils.DBCPUtils;

public class MoodDao {

	public static String getMoods(String uname) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBCPUtils.getConn();
			String sql = "select pyqMood from usermood where uname=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("pyqMood");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.closeAll(conn, ps, rs);
		}
		return "";
	}

	public static boolean setNewCoustomerMoods(String uname) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBCPUtils.getConn();
			String sql = "insert into usermood(uname,pyqMood) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, "");
			int updateNum = ps.executeUpdate();

			if (updateNum > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.closeAll(conn, ps);
		}
		return false;

	}

	
	public static boolean setMoods(String uname, String newMoods) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBCPUtils.getConn();
			String sql = "update usermood set pyqMood=? where uname=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newMoods);
			ps.setString(2, uname);
			int updateNum = ps.executeUpdate();

			if (updateNum > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.closeAll(conn, ps);
		}
		return false;

	}
}
