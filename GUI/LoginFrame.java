package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.DataProcessing;
import common.User;

public class LoginFrame extends JFrame {

	private JLabel lblUserName;
	private JLabel lblPassword;
	private JTextField txtUserName; // ���û������ı���
	private JPasswordField txtPassword;// �����롱�ı���

	private JButton btnLogin; // ����¼����ť
	private JButton btnReset; // �����á���ť

	private JPanel pnlLogin; // ��¼���
	private JPanel pnlInput; // ���á��û������͡�����"�ı�������
	private JPanel pnlButton; // ���á���¼���͡����á���ť�����

	public LoginFrame(String frameTitle) {
		// TODO Auto-generated constructor stub
		super(frameTitle);

		lblUserName = new JLabel("��       ��:  ");
		lblPassword = new JLabel("��       ��:  ");

		txtUserName = new JTextField(10);
		txtPassword = new JPasswordField(10);

		btnLogin = new JButton("��¼");
		btnReset = new JButton("����");

		pnlLogin = new JPanel(); // ��¼���
		pnlLogin.setLayout(new BorderLayout());// ���á���¼��塱�Ĳ���

		pnlInput = new JPanel(); // ���á��û������͡�����"�ı�������

		pnlInput.add(lblUserName);
		pnlInput.add(txtUserName);
		pnlInput.add(lblPassword);
		pnlInput.add(txtPassword);

		pnlLogin.add(pnlInput, BorderLayout.CENTER); // �����pnlInput�����ڡ���¼��塱���м�

		pnlButton = new JPanel(); // ���á���¼���͡����á���ť�����
		pnlButton.add(btnLogin);
		pnlButton.add(btnReset);
		pnlLogin.add(pnlButton, BorderLayout.SOUTH); // �����pnlButton�����ڡ���¼��塱������

		getContentPane().add(pnlLogin, BorderLayout.CENTER); // ������¼��塱�����ڴ��ڵ����������м�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���õ�����������Ͻǵġ��رա�ͼ����˳�Ӧ�ó���
		setSize(440, 240); // ���ô��ڵĴ�С
		setResizable(false); // ���ò��ɵ������ڵĴ�С
		setLocationRelativeTo(null); // ���ô��ڵ���ʾλ��Ϊ��Ļ���м�
		setVisible(true); // ���ô��ڿɼ�

		// �������á���ť�ϵ��¼�
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtUserName.setText("");
				txtPassword.setText("");
			}
		});

		// ������¼����ť�ϵ��¼�
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String name = txtUserName.getText().trim();
					String password = String.valueOf(txtPassword.getPassword()).trim();
					User user = DataProcessing.searchUser(name, password);
					if (user != null) {
						user.showFrame(LoginFrame.this);
						LoginFrame.this.setVisible(false); // ���ô��ڲ��ɼ�
					} else {
						JOptionPane.showMessageDialog(LoginFrame.this, "�û�����������", "����", JOptionPane.ERROR_MESSAGE);// ����������Ϣ��ʾ��
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(LoginFrame.this, "���ݿ����" + ex.getMessage(), "����",
							JOptionPane.ERROR_MESSAGE); // ����������Ϣ��ʾ��
				}
			}
		});
	}
}
