package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil{
	
	private String dbUrl="jdbc:mysql:///sms";
	private String dbUserName="root";
	private String dbPassWord="0204";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	//数据库连接
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
		return con;
	}
	//数据库关闭
	public void closeCon(Connection con) throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	//检查数据库是否连接
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}