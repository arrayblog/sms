package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import dao.GradeTypeDao;
import model.GradeType;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class GradeTypeAddFrn extends JInternalFrame {
	private JTextField gradeXueTxt;
	private JTextField gradeNameTxt;
	private JTextField gradeDescTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private GradeTypeDao gradeTypeDao=new GradeTypeDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeTypeAddFrn frame = new GradeTypeAddFrn();
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
	public GradeTypeAddFrn() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u73ED\u7EA7\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		
		gradeXueTxt = new JTextField();
		gradeXueTxt.setColumns(10);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		
		gradeNameTxt = new JTextField();
		gradeNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u5907\u6CE8\uFF1A");
		
		gradeDescTxt = new JTextField();
		gradeDescTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeTypeAddActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					resetActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(gradeDescTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(gradeNameTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(gradeXueTxt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(82, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
							.addComponent(button_1)
							.addGap(58))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(gradeXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(gradeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(gradeDescTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(29))
		);
		getContentPane().setLayout(groupLayout);

		//优化文本域边框
		gradeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	
	//班级添加
		private void gradeTypeAddActionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			String gradeXue=this.gradeXueTxt.getText();
			String gradeName=this.gradeNameTxt.getText();
			String gradeDesc=this.gradeDescTxt.getText();
			
			if(StringUtil.isEmpty(gradeXue)) {
				JOptionPane.showMessageDialog(null,"学院名称不能为空");
				return;
			}
			if(StringUtil.isEmpty(gradeName)) {
				JOptionPane.showMessageDialog(null,"班级名称不能为空");
				return;
			}
			if(StringUtil.isEmpty(gradeDesc)) {
				JOptionPane.showMessageDialog(null,"班级备注不能为空");
				return;
			}
			GradeType gradeType=new GradeType(gradeXue,gradeName,gradeDesc);
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int n=gradeTypeDao.add(con, gradeType);
				if(n==1) {
					JOptionPane.showMessageDialog(null,"班级添加成功");
					resetValues();
				}else {
					JOptionPane.showMessageDialog(null,"班级添加失败");
				}
			}catch(Exception el) {
				el.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);//关闭数据库
				}catch(Exception el) {
					el.printStackTrace();
				}
			}
		}
	
	//重置操作
		private void resetActionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			this.resetValues();
		}
		private void resetValues() {
			this.gradeXueTxt.setText("");
			this.gradeNameTxt.setText("");
			this.gradeDescTxt.setText("");
		}
	
}
