package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GradeTypeAddFrn gradeTypeAddFrn=new GradeTypeAddFrn();
				gradeTypeAddFrn.setVisible(true);
				table.add(gradeTypeAddFrn);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u73ED\u7EA7\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GradeTypeManageFrn gradeTypeManageFrn=new GradeTypeManageFrn();
				gradeTypeManageFrn.setVisible(true);
				table.add(gradeTypeManageFrn);
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentAddFrm studentAddFrm=new StudentAddFrm();
				studentAddFrm.setVisible(true);
				table.add(studentAddFrm);
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5B66\u751F\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentManageFrm studentManageFrm=new StudentManageFrm();
				studentManageFrm.setVisible(true);
				table.add(studentManageFrm);
			}
		});
		menu_1.add(menuItem_3);
		
		JMenu menu_2 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8BFE\u7A0B\u8BBE\u8BA1");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutFrm about=new aboutFrm();
				about.setVisible(true);
				table.add(about);
				
			}
		});
		menu_2.add(menuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.LIGHT_GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
