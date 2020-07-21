package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.GradeTypeDao;
import dao.StudentDao;
import model.GradeType;
import model.Student;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAddFrm extends JInternalFrame {
	private JTextField stuNameTxt;
	private JTextField stuXueTxt;
	private JTextField stuIdcardTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField stuAgeTxt;
	private JTextField stuPhoneTxt;
	private JTextField stuGradesTxt;
	private JComboBox stuGradeTxt;
	private JRadioButton manJcb;
	private JRadioButton femaleJcb;
	
	private DbUtil dbUtil=new DbUtil();
	private GradeTypeDao gradeTypeDao=new GradeTypeDao();
	private StudentDao studentDao=new StudentDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAddFrm frame = new StudentAddFrm();
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
	public StudentAddFrm() {
		//setIcon(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5B66\u751F\u6DFB\u52A0");
		setBounds(100, 100, 499, 414);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		
		stuNameTxt = new JTextField();
		stuNameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u5B66\u751F\u5B66\u9662\uFF1A");
		
		stuXueTxt = new JTextField();
		stuXueTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u73ED\u7EA7\uFF1A");
		
		stuGradeTxt = new JComboBox();
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		
		stuIdcardTxt = new JTextField();
		stuIdcardTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		
		manJcb = new JRadioButton("\u7537");
		buttonGroup.add(manJcb);
		manJcb.setSelected(true);
		
		femaleJcb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJcb);
		
		JLabel label_4 = new JLabel("\u5B66\u751F\u5E74\u9F84\uFF1A");
		
		stuAgeTxt = new JTextField();
		stuAgeTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		
		stuPhoneTxt = new JTextField();
		stuPhoneTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5B66\u751F\u6210\u7EE9\uFF1A");
		
		stuGradesTxt = new JTextField();
		stuGradesTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentAddActionPerformed(e);
			}

		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentResetActionPerformed(e);
			}

		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_6)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(lblNewLabel))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_5)
								.addComponent(label_3))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(stuGradesTxt)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(manJcb)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(femaleJcb))
						.addComponent(stuNameTxt, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(stuGradeTxt, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(stuPhoneTxt))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stuAgeTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stuXueTxt, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stuIdcardTxt)))
					.addContainerGap(47, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(113)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(94))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stuNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(stuXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(stuGradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(stuIdcardTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(stuAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(manJcb)
						.addComponent(label_3)
						.addComponent(femaleJcb))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(stuPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(stuGradesTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		/*
		 * ���ó�ʼ���༶������
		 */
		this.fillGradeType();
		
	}
	
	/*
	 * ѧ����Ӳ���
	 */
	private void studentAddActionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		String stuName=this.stuNameTxt.getText();
		String stuXue=this.stuXueTxt.getText();
		String stuIdcard=this.stuIdcardTxt.getText();
		String stuAge=this.stuAgeTxt.getText();
		String stuGrades=this.stuGradesTxt.getText();
		String stuPhone=this.stuPhoneTxt.getText();
		
		//�ж��Ƿ�Ϊ��
		if(StringUtil.isEmpty(stuName)) {
			JOptionPane.showMessageDialog(null,"ѧ�����Ʋ���Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(stuXue)) {
			JOptionPane.showMessageDialog(null,"ѧ��ѧԺ���Ʋ���Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(stuIdcard)) {
			JOptionPane.showMessageDialog(null,"ѧ��ѧ�Ų���Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(stuAge)) {
			JOptionPane.showMessageDialog(null,"ѧ�����䲻��Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(stuGrades)) {
			JOptionPane.showMessageDialog(null,"ѧ���ɼ�����Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(stuPhone)) {
			JOptionPane.showMessageDialog(null,"ѧ���绰����Ϊ��");
			return;
		}
		
		//�ж��û�������Ա�
		String stuSex=null;
		if(manJcb.isSelected()) {
			stuSex="��";
		}else if(femaleJcb.isSelected()) {
			stuSex="Ů";
		}
		//��ȡ�༶
		GradeType gradeType=(GradeType)stuGradeTxt.getSelectedItem();
		int stuTypeid=gradeType.getId();
		//����ȫ���û����룬������д洢
		Student student=new Student(stuName,stuXue,stuIdcard,stuSex,stuAge,stuGrades,stuPhone,stuTypeid);
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addNum=studentDao.addstudent(con, student);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null,"ѧ����ӳɹ�");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null,"ѧ�����ʧ��");
			}
		}catch(Exception en) {
			en.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch (Exception en) {
				// TODO �Զ����ɵ� catch ��
				en.printStackTrace();
			}
		}
		
	}
	
	
	/*
	 * ���ò���
	 */
	private void studentResetActionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		this.resetValue();
	}
	public void resetValue() {
		this.stuNameTxt.setText("");
		this.stuXueTxt.setText("");
		this.stuGradesTxt.setText("");
		this.stuIdcardTxt.setText("");
		this.stuAgeTxt.setText("");
		this.stuPhoneTxt.setText("");
	}
	
	
	/*
	 * ��ʼ���༶������
	 */
	private void fillGradeType() {
		Connection con=null;
		GradeType gradeType=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=gradeTypeDao.list(con,new GradeType());
			while(rs.next()) {
				gradeType=new GradeType();
				gradeType.setId(rs.getInt("id"));
				gradeType.setGradeName(rs.getString("gradeName"));
				this.stuGradeTxt.addItem(gradeType);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
