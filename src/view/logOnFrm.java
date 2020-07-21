package view;
//登录界面
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;
import util.DbUtil;
import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class logOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passWord;
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logOnFrm frame = new logOnFrm();
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
	public logOnFrm() {
		setResizable(false);
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801");
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 15));
		
		userName = new JTextField();
		userName.setColumns(10);
		
		passWord = new JPasswordField();
		
		JButton loginBut = new JButton("\u767B\u5F55");
		loginBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		loginBut.setFont(new Font("楷体", Font.BOLD, 18));
		
		JButton resetBut = new JButton("\u91CD\u7F6E");
		resetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		resetBut.setFont(new Font("楷体", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passWord, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(userName, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(140, Short.MAX_VALUE)
							.addComponent(lblNewLabel)))
					.addGap(149))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addComponent(loginBut)
					.addGap(43)
					.addComponent(resetBut)
					.addGap(133))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(lblNewLabel)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBut)
						.addComponent(resetBut))
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
		//设置窗口居中
		this.setLocationRelativeTo(null);
	}

	//登录操作
	private void loginActionPerformed(ActionEvent e) {
		String userName=this.userName.getText();
		String passWord=new String(this.passWord.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null,"用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null,"密码不能为空");
			return;
		}
		User user=new User(userName,passWord);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currenUser=userDao.login(con,user);
			if(currenUser!=null) {
				JOptionPane.showMessageDialog(null,"登录成功");
				dispose();//销毁当前窗口
				new MainFrm().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"用户名或密码错误");
			}
		}catch(Exception el) {
			el.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			}catch(Exception el) {
				el.printStackTrace();
			}
		}
		
	}

	//重置操作
	private void resetActionPerformed(ActionEvent e) {
		this.userName.setText("");
		this.passWord.setText("");
	}
}
