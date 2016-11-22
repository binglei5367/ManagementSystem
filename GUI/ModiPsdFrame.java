package GUI;

import common.User;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class ModiPsdFrame extends JFrame{
	
	JFrame parentFrame;
	User user;
	
	private JLabel lblOddPsd;
	private JLabel lblNewPsd;
	
	private JPasswordField txtOddPsd;
	private JTextField txtNewPsd;
	
	private JButton btnSure;
	private JButton btnReset;
	private JButton btnCancel;
	
	private JPanel pnlModi;
	private JPanel pnlInput;
	private JPanel pnlButton;
	
	public ModiPsdFrame(String frameTitle, JFrame parentFrame, User user) {
		// TODO Auto-generated constructor stub
		super(frameTitle);
		
		this.parentFrame = parentFrame;
		this.user = user;
		
		lblOddPsd = new JLabel("旧密码：");
		lblNewPsd = new JLabel("新密码");
		
		txtOddPsd = new JPasswordField(10);
		txtNewPsd = new JTextField(10);
		
		btnSure = new JButton("确定");
		btnReset = new JButton("重置");
		btnCancel = new JButton("取消");
		
		pnlModi = new JPanel();
		pnlModi.setLayout(new BorderLayout());
		
		pnlInput = new JPanel();
		pnlInput.add(lblOddPsd);
		pnlInput.add(txtOddPsd);
		pnlInput.add(lblNewPsd);
		pnlInput.add(txtNewPsd);
		
		pnlModi.add(pnlInput, BorderLayout.CENTER);
		
		pnlButton = new JPanel();
		pnlButton.add(btnSure);
		pnlButton.add(btnReset);
		pnlButton.add(btnCancel);
		
		pnlModi.add(pnlButton, BorderLayout.SOUTH);
		
		getContentPane().add(pnlModi, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 240);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtOddPsd.setText("");
				txtNewPsd.setText("");
			}
		});
		
		btnSure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String oddPsd = String.valueOf(txtOddPsd.getPassword());
					String newPsd = String.valueOf(txtNewPsd.getText());
					if (oddPsd == user.getPassword()) {
						user.changeUserInfo(newPsd);
					} else {
						JOptionPane.showMessageDialog(ModiPsdFrame.this, "口令错误", "错误", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(ModiPsdFrame.this, "数据库错误" + ex.getMessage(), "错误",
							JOptionPane.ERROR_MESSAGE); // 弹出出错信息提示框
				}
			}	
		});
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ModiPsdFrame.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见
			}
		});
		
		
	}

}



















