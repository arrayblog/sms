package view;
/*
 * �༶ά������
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
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.GradeTypeDao;
import model.GradeType;
import util.DbUtil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GradeTypeManageFrn extends JInternalFrame {
	private JTextField s_gradeNameTxt;
	private JTable gradeTypeTable;
	
	private DbUtil dbUtil=new DbUtil();
	private GradeTypeDao gradeTypeDao=new GradeTypeDao();
	private JTextField gradeIdTxt;
	private JTextField gradeXueTxt;
	private JTextField gradeNameTxt;
	private JTextArea gradeDescTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeTypeManageFrn frame = new GradeTypeManageFrn();
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
	public GradeTypeManageFrn() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u73ED\u7EA7\u7EF4\u62A4");
		setBounds(100, 100, 578, 469);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		
		JScrollPane scrollPane = new JScrollPane();
		
		s_gradeNameTxt = new JTextField();
		s_gradeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeNameSearchActionPerformed(e);
			}

			
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeTypeUpdateActionEvent(e);
			}

		});
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeTypeDeleteActionPerformed(e);
			}

		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_gradeNameTxt, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))))
					.addContainerGap(88, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(113)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(132))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(s_gradeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u7F16\u53F7\uFF1A");
		
		gradeIdTxt = new JTextField();
		gradeIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		
		gradeXueTxt = new JTextField();
		gradeXueTxt.setColumns(10);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		
		gradeNameTxt = new JTextField();
		gradeNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u5907\u6CE8\uFF1A");
		
		gradeDescTxt = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(gradeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(gradeNameTxt)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeDescTxt, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(gradeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(gradeXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(gradeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(gradeDescTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		gradeTypeTable = new JTable();
		gradeTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				gradeTypeTableMousePressed(arg0);
			}
			
		});
		gradeTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B66\u9662\u540D\u79F0", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(gradeTypeTable);
		getContentPane().setLayout(groupLayout);
		
		//���ñ��
		this.fillTable(new GradeType());
		//�Ż��ı���߿�
		gradeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

	}
	
	/*
	 * �༶ɾ��
	 */
	private void gradeTypeDeleteActionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		String id=gradeIdTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫɾ���ļ�¼��");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��������¼��");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				//���ж��Ƿ��иð༶ѧ��
				int deleteNum=gradeTypeDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null,"ɾ���ɹ���");
					resetValue();
					fillTable(new GradeType());
				}else {
					JOptionPane.showMessageDialog(null,"ɾ��ʧ�ܣ�");
				}
			} catch (Exception ev) {
				// TODO �Զ����ɵ� catch ��
				ev.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				}catch (Exception ev) {
					// TODO �Զ����ɵ� catch ��
					ev.printStackTrace();
				}
			}
		}
	}
	
	
	/*
	 * �༶�޸�
	 */
	private void gradeTypeUpdateActionEvent(ActionEvent e) {
		// TODO �Զ����ɵķ������
		String id=gradeIdTxt.getText();
		String gradeXue=gradeXueTxt.getText();
		String gradeName=gradeNameTxt.getText();
		String gradeDesc=gradeDescTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼��");
			return;
		}
		if(StringUtil.isEmpty(gradeXue)) {
			JOptionPane.showMessageDialog(null,"ѧԺ���Ʋ���Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(gradeName)) {
			JOptionPane.showMessageDialog(null,"�༶���Ʋ���Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(gradeDesc)) {
			JOptionPane.showMessageDialog(null,"�༶��ע����Ϊ�գ�");
			return;
		}
		GradeType gradeType=new GradeType(Integer.parseInt(id),gradeXue,gradeName,gradeDesc);
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=gradeTypeDao.update(con, gradeType);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null,"�޸ĳɹ���");
				resetValue();
				fillTable(new GradeType());
			}else {
				JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�");
			}
		} catch (Exception ev) {
			// TODO �Զ����ɵ� catch ��
			ev.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch (Exception ev) {
				// TODO �Զ����ɵ� catch ��
				ev.printStackTrace();
			}
		}
		
	}
	
	private void resetValue() {
		// TODO �Զ����ɵķ������
		this.gradeIdTxt.setText("");
		this.gradeXueTxt.setText("");
		this.gradeNameTxt.setText("");
		this.gradeDescTxt.setText("");
	}

	/*
	 * ���ĵ����¼�
	 */
	private void gradeTypeTableMousePressed(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		int row=gradeTypeTable.getSelectedRow();
		gradeIdTxt.setText((String)gradeTypeTable.getValueAt(row, 0));
		gradeXueTxt.setText((String)gradeTypeTable.getValueAt(row, 1));
		gradeNameTxt.setText((String)gradeTypeTable.getValueAt(row, 2));
		gradeDescTxt.setText((String)gradeTypeTable.getValueAt(row, 3));
	}
	
	
	/*
	 * �༶��ѯ
	 */
	private void gradeNameSearchActionPerformed(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		String s_gradeName=this.s_gradeNameTxt.getText();
		GradeType gradeType=new GradeType();
		gradeType.setGradeName(s_gradeName);
		//this.fillTable(gradeType);
		
		DefaultTableModel dtm=(DefaultTableModel)gradeTypeTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=gradeTypeDao.seek(con, gradeType);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("gradeXue"));
				v.add(rs.getString("gradeName"));
				v.add(rs.getString("gradeDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
	
	
	/*
	 * ��ʼ���
	 */
	private void fillTable(GradeType gradeType) {
		
		DefaultTableModel dtm=(DefaultTableModel)gradeTypeTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=gradeTypeDao.list(con, gradeType);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("gradeXue"));
				v.add(rs.getString("gradeName"));
				v.add(rs.getString("gradeDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
