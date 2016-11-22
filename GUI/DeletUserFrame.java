package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import common.DataProcessing;
import common.User;

public class DeletUserFrame extends JFrame{
	
	JFrame parentFrame;
	User user;
	
	private JLabel lblUserName;
	
	private JTextField txtUserName;
	
	private JButton btnSure;
	private JButton btnReset;
	private JButton btnCancel;
	
	private JPanel pnlChangeUser;
	private JPanel pnlInput;
	private JPanel pnlButton;
	

	public DeletUserFrame(String frameTitle, JFrame parentFrame, User user) {
		// TODO Auto-generated constructor stub
		super(frameTitle);
		
		this.parentFrame = parentFrame;
		this.user = user;
		
		lblUserName = new JLabel("�û�����");
		
		txtUserName = new JTextField(10);
		
		btnSure = new JButton("ȷ��");
		btnReset = new JButton("����");
		btnCancel = new JButton("ȡ��");
		
		pnlChangeUser = new JPanel();
		pnlChangeUser.setLayout(new BorderLayout());

		pnlInput = new JPanel();
		pnlInput.setLayout(new GridLayout(2, 1));
		pnlInput.add(lblUserName);
		pnlInput.add(txtUserName);
		
		pnlChangeUser.add(pnlInput, BorderLayout.CENTER);
		
		pnlButton = new JPanel();
		pnlButton.add(btnSure);
		pnlButton.add(btnReset);
		pnlButton.add(btnCancel);
		
		pnlChangeUser.add(pnlButton, BorderLayout.SOUTH);
		
		getContentPane().add(pnlChangeUser, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtUserName.setText("");
			}
		});		
		
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DeletUserFrame.this.dispose();
				parentFrame.setVisible(true);
			}
		});		
		
		
		btnSure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try{
					String userName = txtUserName.getText().trim();
					if (DataProcessing.deleteUser(userName)) {
						JOptionPane.showMessageDialog(DeletUserFrame.this, "ɾ���ɹ�");
					} else {
						JOptionPane.showMessageDialog(DeletUserFrame.this, "ɾ��ʧ�ܣ��û����ܲ�����");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(DeletUserFrame.this, "���ݿ����" + e.getMessage(), "����",
							JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		
		
		
	}

}


















