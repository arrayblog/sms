package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;
import model.User;

public class UserDao {
	public User login (Connection con,User user) throws Exception{
		User resultUser=null;
		String sql="select * from stu_user where username=? and password=?";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2,user.getPassWord());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassWord(rs.getString("passWord"));
		}
		return resultUser;
	}
}
