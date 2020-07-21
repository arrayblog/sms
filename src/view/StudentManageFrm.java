package view;
/*
 * 学生维护窗口
 */
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.GradeTypeDao;
import dao.StudentDao;
import model.GradeType;
import model.Student;
import util.DbUtil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;

public class StudentManageFrm extends JInternalFrame {
	private JTextField s_studentNameTxt;
	private JTable StudentTable;
	private DbUtil dbUtil=new DbUtil();
	private StudentDao studentDao=new StudentDao();
	private JTextField studentNameTxt;
	private JTextField studentXueTxt;
	private JTextField studentIdcardTxt;
	private JTextField studentSexTxt;
	private JTextField studentAgeTxt;
	private JTextField studentGradeTxt;
	private JTextField studentPhoneTxt;
	private JTextField studentTypeidTxt;
	private JTextField studentIdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManageFrm frame = new StudentManageFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentManageFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u751F\u7EF4\u62A4");
		setBounds(100, 100, 978, 486);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		
		s_studentNameTxt = new JTextField();
		s_studentNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentNameSearchActionPerformed(e);
			}

		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentUpdateActionEvent(e);
			}
		});
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentDeleteActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(266)
					.addComponent(button_1)
					.addGap(255)
					.addComponent(button_2)
					.addContainerGap(315, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(s_studentNameTxt, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(button))))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(s_studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(button))
						.addComponent(label))
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2)
						.addComponent(button_1))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		
		studentNameTxt = new JTextField();
		studentNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u5B66\u9662\uFF1A");
		
		studentXueTxt = new JTextField();
		studentXueTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		
		studentIdcardTxt = new JTextField();
		studentIdcardTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		
		studentSexTxt = new JTextField();
		studentSexTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5B66\u751F\u5E74\u9F84\uFF1A");
		
		studentAgeTxt = new JTextField();
		studentAgeTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5B66\u751F\u6210\u7EE9\uFF1A");
		
		studentGradeTxt = new JTextField();
		studentGradeTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		
		studentPhoneTxt = new JTextField();
		studentPhoneTxt.setColumns(10);
		
		JLabel label_8 = new JLabel("\u4E13\u4E1A\u73ED\u7EA7\uFF1A");
		
		studentTypeidTxt = new JTextField();
		studentTypeidTxt.setColumns(10);
		
		JLabel label_9 = new JLabel("\u5B66\u751F\u7F16\u53F7\uFF1A");
		
		studentIdTxt = new JTextField();
		studentIdTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(studentIdcardTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_4))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label_6)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(studentGradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(154)
								.addComponent(label_7)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
							.addComponent(label_1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(studentSexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(143)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label_5)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(studentAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label_8)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(studentTypeidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(studentXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(studentPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(103)
					.addComponent(label_7)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9)
						.addComponent(studentIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(studentXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(studentAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(studentSexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentIdcardTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(studentGradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(studentTypeidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		StudentTable = new JTable();
		StudentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				studentTableMousePressed(e);
			}
		});
		StudentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u5B66\u751F\u5B66\u9662", "\u5B66\u751F\u5B66\u53F7", "\u5B66\u751F\u6027\u522B", "\u5B66\u751F\u5E74\u9F84", "\u5B66\u751F\u6210\u7EE9", "\u624B\u673A\u53F7\u7801", "\u4E13\u4E1A\u73ED\u7EA7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(StudentTable);
		getContentPane().setLayout(groupLayout);

		//调用表格
		this.fillTable(new Student());
		
	}
	
	/*
	 * 班级删除
	 */
	private void studentDeleteActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String id=studentIdTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"请选择要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null,"确定要删除该条记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				//先判断是否有该班级学生
				int deleteNum=studentDao.deletestudent(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null,"删除成功！");
					resetValue();
					fillTable(new Student());
				}else {
					JOptionPane.showMessageDialog(null,"删除失败！");
				}
			} catch (Exception ev) {
				// TODO 自动生成的 catch 块
				ev.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				}catch (Exception ev) {
					// TODO 自动生成的 catch 块
					ev.printStackTrace();
				}
			}
		}
	}
	
	
	/*
	 * 学生修改
	 */
	private void studentUpdateActionEvent(ActionEvent e) {
		// TODO 自动生成的方法存根
		String id=studentIdTxt.getText();
		String studentName=studentNameTxt.getText();
		String studentXue=studentXueTxt.getText();
		String studentIdcard=studentIdcardTxt.getText();
		String studentSex=studentSexTxt.getText();
		String studentAge=studentAgeTxt.getText();
		String studentGrade=studentGradeTxt.getText();
		String studentPhone=studentPhoneTxt.getText();
		String studentTypeids=studentTypeidTxt.getText();
		String studentTypeid=null;
		Connection conn=null;
		try {
			conn=dbUtil.getCon();
			ResultSet rss=studentDao.classidstudent(conn, studentTypeids);
				rss.next();
				studentTypeid=rss.getString("id");

		} catch (Exception ev) {
			// TODO 自动生成的 catch 块
			ev.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(conn);
			}catch (Exception ev) {
				// TODO 自动生成的 catch 块
				ev.printStackTrace();
			}
		}
		
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"请选择要修改的记录！");
			return;
		}
		if(StringUtil.isEmpty(studentName)) {
			JOptionPane.showMessageDialog(null,"学生姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentXue)) {
			JOptionPane.showMessageDialog(null,"学院名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentIdcard)) {
			JOptionPane.showMessageDialog(null,"学生学号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentSex)) {
			JOptionPane.showMessageDialog(null,"学生性别不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentAge)) {
			JOptionPane.showMessageDialog(null,"学生年龄不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentGrade)) {
			JOptionPane.showMessageDialog(null,"学生成绩不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentPhone)) {
			JOptionPane.showMessageDialog(null,"手机号码不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentTypeids)) {
			JOptionPane.showMessageDialog(null,"班级名称不能为空！");
			return;
		}
		Student student=new Student(Integer.parseInt(id),studentName,studentXue,studentIdcard,studentSex,studentAge,studentGrade,studentPhone,Integer.parseInt(studentTypeid));
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=studentDao.updatestudent(con, student);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null,"修改成功！");
				resetValue();
				fillTable(new Student());
			}else {
				JOptionPane.showMessageDialog(null,"修改失败！");
			}
		} catch (Exception ev) {
			// TODO 自动生成的 catch 块
			ev.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch (Exception ev) {
				// TODO 自动生成的 catch 块
				ev.printStackTrace();
			}
		}
		
	}
	/*
	 * 重置操作
	 */
	private void resetValue() {
		// TODO 自动生成的方法存根
		this.studentIdTxt.setText("");
		this.studentNameTxt.setText("");
		this.studentXueTxt.setText("");
		this.studentIdcardTxt.setText("");
		this.studentSexTxt.setText("");
		this.studentAgeTxt.setText("");
		this.studentGradeTxt.setText("");
		this.studentPhoneTxt.setText("");
		this.studentTypeidTxt.setText("");
	}
	
	/*
	 * 表格的单击事件
	 */
	private void studentTableMousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int row=StudentTable.getSelectedRow();
		studentIdTxt.setText((String)StudentTable.getValueAt(row, 0));
		studentNameTxt.setText((String)StudentTable.getValueAt(row, 1));
		studentXueTxt.setText((String)StudentTable.getValueAt(row, 2));
		studentIdcardTxt.setText((String)StudentTable.getValueAt(row, 3));
		studentSexTxt.setText((String)StudentTable.getValueAt(row, 4));
		studentAgeTxt.setText((String)StudentTable.getValueAt(row, 5));
		studentGradeTxt.setText((String)StudentTable.getValueAt(row, 6));
		studentPhoneTxt.setText((String)StudentTable.getValueAt(row, 7));
		studentTypeidTxt.setText((String)StudentTable.getValueAt(row, 8));
	}
	
	/*
	 * 学生查询
	 */
	private void studentNameSearchActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String s_studentName=this.s_studentNameTxt.getText();
		Student student=new Student();
		student.setStuName(s_studentName);
		
		DefaultTableModel dtm=(DefaultTableModel)StudentTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=studentDao.seekstudent(con, student);
			ResultSet rss=studentDao.classstudent(con, student);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("stuName"));
				v.add(rs.getString("stuXue"));
				v.add(rs.getString("stuIdcard"));
				v.add(rs.getString("stuSex"));
				v.add(rs.getString("stuAge"));
				v.add(rs.getString("stuGrade"));
				v.add(rs.getString("stuPhone"));
				rss.next();
				v.add(rss.getString("gradeName"));
				dtm.addRow(v);
			}
		} catch (Exception ev) {
			// TODO 自动生成的 catch 块
			ev.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch (Exception ev) {
				// TODO 自动生成的 catch 块
				ev.printStackTrace();
			}
		}
	}
	
	/*
	 * 初始化表格
	 */
	private void fillTable(Student student) {
		DefaultTableModel dtm=(DefaultTableModel)StudentTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=studentDao.liststudent(con, student);
			ResultSet rss=studentDao.classstudent(con, student);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("stuName"));
				v.add(rs.getString("stuXue"));
				v.add(rs.getString("stuIdcard"));
				v.add(rs.getString("stuSex"));
				v.add(rs.getString("stuAge"));
				v.add(rs.getString("stuGrade"));
				v.add(rs.getString("stuPhone"));
				rss.next();
				v.add(rss.getString("gradeName"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}





