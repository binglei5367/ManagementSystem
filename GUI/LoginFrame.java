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
	private JTextField txtUserName; // “用户名”文本框
	private JPasswordField txtPassword;// “密码”文本框

	private JButton btnLogin; // “登录”按钮
	private JButton btnReset; // “重置”按钮

	private JPanel pnlLogin; // 登录面板
	private JPanel pnlInput; // 放置“用户名”和“密码"文本框的面板
	private JPanel pnlButton; // 放置“登录”和“重置”按钮的面板

	public LoginFrame(String frameTitle) {
		// TODO Auto-generated constructor stub
		super(frameTitle);

		lblUserName = new JLabel("用       户:  ");
		lblPassword = new JLabel("口       令:  ");

		txtUserName = new JTextField(10);
		txtPassword = new JPasswordField(10);

		btnLogin = new JButton("登录");
		btnReset = new JButton("重置");

		pnlLogin = new JPanel(); // 登录面板
		pnlLogin.setLayout(new BorderLayout());// 设置“登录面板”的布局

		pnlInput = new JPanel(); // 放置“用户名”和“密码"文本框的面板

		pnlInput.add(lblUserName);
		pnlInput.add(txtUserName);
		pnlInput.add(lblPassword);
		pnlInput.add(txtPassword);

		pnlLogin.add(pnlInput, BorderLayout.CENTER); // 将面板pnlInput放置在“登录面板”的中间

		pnlButton = new JPanel(); // 放置“登录”和“重置”按钮的面板
		pnlButton.add(btnLogin);
		pnlButton.add(btnReset);
		pnlLogin.add(pnlButton, BorderLayout.SOUTH); // 将面板pnlButton放置在“登录面板”的南面

		getContentPane().add(pnlLogin, BorderLayout.CENTER); // 将“登录面板”放置在窗口的内容面板的中间
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置当点击窗口右上角的“关闭”图标后，退出应用程序
		setSize(440, 240); // 设置窗口的大小
		setResizable(false); // 设置不可调整窗口的大小
		setLocationRelativeTo(null); // 设置窗口的显示位置为屏幕的中间
		setVisible(true); // 设置窗口可见

		// 处理“重置”按钮上的事件
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtUserName.setText("");
				txtPassword.setText("");
			}
		});

		// 处理“登录”按钮上的事件
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
						LoginFrame.this.setVisible(false); // 设置窗口不可见
					} else {
						JOptionPane.showMessageDialog(LoginFrame.this, "用户名或口令错误", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(LoginFrame.this, "数据库错误" + ex.getMessage(), "错误",
							JOptionPane.ERROR_MESSAGE); // 弹出出错信息提示框
				}
			}
		});
	}
}
