package model;
/*
 * 学生模板
 */
public class Student {
	private int id;
	private String stuName;
	private String stuXue;
	private String stuIdcard;
	private String stuSex;
	private String stuAge;
	private String stuGrade;
	private String stuPhone;
	private Integer stuTypeid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuXue() {
		return stuXue;
	}
	public void setStuXue(String stuXue) {
		this.stuXue = stuXue;
	}
	public String getStuIdcard() {
		return stuIdcard;
	}
	public void setStuIdcard(String stuIdcard) {
		this.stuIdcard = stuIdcard;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuAge() {
		return stuAge;
	}
	public void setStuAge(String stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public Integer getStuTypeid() {
		return stuTypeid;
	}
	public void setStuTypeid(Integer stuTypeid) {
		this.stuTypeid = stuTypeid;
	}
	public Student() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Student(String stuName, String stuXue, String stuIdcard, String stuSex, String stuAge, String stuGrade,
			String stuPhone, Integer stuTypeid) {
		super();
		this.stuName = stuName;
		this.stuXue = stuXue;
		this.stuIdcard = stuIdcard;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuGrade = stuGrade;
		this.stuPhone = stuPhone;
		this.stuTypeid = stuTypeid;
	}
	public Student(int id, String stuName, String stuXue, String stuIdcard, String stuSex, String stuAge,
			String stuGrade, String stuPhone, int stuTypeid) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.stuXue = stuXue;
		this.stuIdcard = stuIdcard;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuGrade = stuGrade;
		this.stuPhone = stuPhone;
		this.stuTypeid = stuTypeid;
	}
	
	
	
}
