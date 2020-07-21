package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import model.GradeType;
import util.StringUtil;

//�༶��𣬶԰༶����ӣ�ɾ�����޸ģ���ѯ����


public class GradeTypeDao {
	
	/*
	 * �༶���
	 */
	public int add(Connection con,GradeType gradeType) throws Exception{
		String sql="insert into stu_grade values(null,?,?,?)";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1,gradeType.getGradeXue());
		pstmt.setString(2,gradeType.getGradeName());
		pstmt.setString(3,gradeType.getGradeDesc());
		return pstmt.executeUpdate();
	}
	/*
	 * ��ѯ�༶����
	 */
	public ResultSet list(Connection con,GradeType gradeType) throws Exception{
		StringBuffer sb=new StringBuffer("select * from stu_grade");
		if(StringUtil.isNotEmpty(gradeType.getGradeName())) {
			sb.append(" where gradeName = '"+gradeType.getGradeName()+"'");
			//sb.append(" and gradeName like '"+gradeType.getGradeName()+"%'");
		}
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString().replaceFirst("and","where"));
	    return pstmt.executeQuery();
	}
	
	public ResultSet seek(Connection con,GradeType gradeType) throws Exception{
		String NAME=gradeType.getGradeName();
		String sql="select * from stu_grade where gradeName = '"+NAME+"'";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	
	/*
	 * �༶ɾ��
	 */
	public int delete(Connection con,String id) throws Exception{
		String sql="delete from stu_grade where id = ? ";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/*
	 * �༶�޸�
	 */
	public int update(Connection con,GradeType gradeType) throws Exception{
		String sql="update stu_grade set gradeXue=?,gradeName=?,gradeDesc=? where id=? ";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1, gradeType.getGradeXue());
		pstmt.setString(2, gradeType.getGradeName());
		pstmt.setString(3, gradeType.getGradeDesc());
		pstmt.setInt(4, gradeType.getId());
		return pstmt.executeUpdate();
	}
	
	
}
