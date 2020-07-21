package model;
//班级分类管理
public class GradeType {
	private int id;
	private String gradeXue;
	private String gradeName;
	private String gradeDesc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGradeXue() {
		return gradeXue;
	}
	public void setGradeXue(String gradeXue) {
		this.gradeXue = gradeXue;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getGradeDesc() {
		return gradeDesc;
	}
	public void setGradeDesc(String gradeDesc) {
		this.gradeDesc = gradeDesc;
	}
	public GradeType() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public GradeType(String gradeXue, String gradeName, String gradeDesc) {
		super();
		this.gradeXue = gradeXue;
		this.gradeName = gradeName;
		this.gradeDesc = gradeDesc;
	}
	public GradeType(int id, String gradeXue, String gradeName, String gradeDesc) {
		super();
		this.id = id;
		this.gradeXue = gradeXue;
		this.gradeName = gradeName;
		this.gradeDesc = gradeDesc;
	}
	
	public String toString() {
		return gradeName;
	}
	
}
