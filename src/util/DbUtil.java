package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil{
	
	private String dbUrl="jdbc:mysql:///sms";
	private String dbUserName="root";
	private String dbPassWord="0204";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	//���ݿ�����
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
		return con;
	}
	//���ݿ�ر�
	public void closeCon(Connection con) throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	//������ݿ��Ƿ�����
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}