package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import common.DataProcessing;
import common.User;

public class ChangeUserFrame extends JFrame{
	
	JFrame parentFrame;
	User user;
	
	private JLabel lblUserName;
	private JLabel lblPsd;
	private JLabel lblRole;
	
	private JTextField txtUserName;
	private JPasswordField txtPsd;
	private JTextField txtRole;				// ���¸ĳ�Choice
	
	private JButton btnSure;
	private JButton btnReset;
	private JButton btnCancel;
	
	private JPanel pnlChangeUser;
	private JPanel pnlInput;
	private JPanel pnlButton;
	

	public ChangeUserFrame(String frameTitle, JFrame parentFrame, User user) {
		// TODO Auto-generated constructor stub
		super(frameTitle);
		
		this.parentFrame = parentFrame;
		this.user = user;
		
		lblUserName = new JLabel("�û�����");
		lblPsd = new JLabel("���룺");
		lblRole = new JLabel("�޸�Ȩ�ޣ�");
		
		txtUserName = new JTextField(10);
		txtPsd = new JPasswordField(10);
		txtRole = new JTextField(10);
		
		btnSure = new JButton("ȷ��");
		btnReset = new JButton("����");
		btnCancel = new JButton("ȡ��");
		
		pnlChangeUser = new JPanel();
		pnlChangeUser.setLayout(new BorderLayout());

		pnlInput = new JPanel();
		pnlInput.setLayout(new GridLayout(6, 1));
		pnlInput.add(lblUserName);
		pnlInput.add(txtUserName);
		pnlInput.add(lblPsd);
		pnlInput.add(txtPsd);
		pnlInput.add(lblRole);
		pnlInput.add(txtRole);
		
		pnlChangeUser.add(pnlInput, BorderLayout.CENTER);
		
		pnlButton = new JPanel();
		pnlButton.add(btnSure);
		pnlButton.add(btnReset);
		pnlButton.add(btnCancel);
		
		pnlChangeUser.add(pnlButton, BorderLayout.SOUTH);
		
		getContentPane().add(pnlChangeUser, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtUserName.setText("");
				txtPsd.setText("");
				txtRole.setText("");
			}
		});		
		
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeUserFrame.this.dispose();
				parentFrame.setVisible(true);
			}
		});		
		
		
		btnSure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try{
					String userName = txtUserName.getText().trim();
					String password = String.valueOf(txtPsd.getPassword()).trim();
					String role = txtRole.getText();
					if (DataProcessing.updateUser(userName, password, role)) {
						JOptionPane.showMessageDialog(ChangeUserFrame.this, "�޸ĳɹ�");
					} else {
						JOptionPane.showMessageDialog(ChangeUserFrame.this, "�޸�ʧ�ܣ��û�������");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(ChangeUserFrame.this, "���ݿ����" + e.getMessage(), "����",
							JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		
		
		
	}

}


















