package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import model.GradeType;
import model.Student;
import util.StringUtil;

/*
 * 对学生的添加，删除，修改，查询操作
 */
public class StudentDao {

	/*
	 * 学生添加
	 */
	public int addstudent(Connection con,Student student) throws Exception{
		String sql="insert into stu_student values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1,student.getStuName());
		pstmt.setString(2,student.getStuXue());
		pstmt.setString(3,student.getStuIdcard());
		pstmt.setString(4,student.getStuSex());
		pstmt.setString(5,student.getStuAge());
		pstmt.setString(6,student.getStuGrade());
		pstmt.setString(7,student.getStuPhone());
		pstmt.setInt(8,student.getStuTypeid());
		return pstmt.executeUpdate();
	}
	
	
	/*
	 * 查询学生集合
	 */
	public ResultSet liststudent(Connection con,Student student) throws Exception{
		StringBuffer sb=new StringBuffer("select * from stu_student");
		if(StringUtil.isNotEmpty(student.getStuName())) {
			sb.append(" where stuName = '"+student.getStuName()+"'");
			//sb.append(" and stuName like '"+stuType.getStuName()+"%'");
		}
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString().replaceFirst("and","where"));
	    return pstmt.executeQuery();
	}
	
	public ResultSet classstudent(Connection con,Student student) throws Exception{
		Integer ID=student.getStuTypeid();
		String sql="select stu_grade.gradeName from stu_student,stu_grade where stu_student.stuTypeid = stu_grade.id";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	public ResultSet seekstudent(Connection con,Student student) throws Exception{
		String NAME=student.getStuName();
		String sql="select * from stu_student where stuName = '"+NAME+"'";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	
	/*
	 * 学生删除
	 */
	public int deletestudent(Connection con,String id) throws Exception{
		String sql="delete from stu_student where id = ? ";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/*
	 * 学生修改
	 */
	public int updatestudent(Connection con,Student student) throws Exception{
		String sql="update stu_student set stuName=?,stuXue=?,stuIdcard=?,stuSex=?,stuAge=?,stuGrade=?,stuPhone=?,stuTypeid=? where id=? ";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1, student.getStuName());
		pstmt.setString(2, student.getStuXue());
		pstmt.setString(3, student.getStuIdcard());
		pstmt.setString(4, student.getStuSex());
		pstmt.setString(5, student.getStuAge());
		pstmt.setString(6, student.getStuGrade());
		pstmt.setString(7, student.getStuPhone());
		pstmt.setInt(8, student.getStuTypeid());
		pstmt.setInt(9, student.getId());
		return pstmt.executeUpdate();
	}
	public ResultSet classidstudent(Connection con,String studentTypeids) throws Exception{
		String sql="select stu_grade.id from stu_grade where stu_grade.gradeName='"+studentTypeids+"'";
		PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
}
