package GUI;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.User;

public class BrowserFrame extends JFrame {

	private JFrame parentFrame; // 父窗口
	private User user;  //当前用户
	
	private JButton btnDownloadFile; // 下载文件按钮
	private JButton btnShowFileList; // 显示文件列表按钮
	private JButton btnModiPsd; // 修改密码按钮
	private JButton btnExit; // 退出按钮

	private JPanel panel; // 面板

	public BrowserFrame(String frameTitle, JFrame parentframe, User user) {
		// TODO Auto-generated constructor stub
		super(frameTitle);
		this.parentFrame = parentframe;
		this.user = user;

		btnDownloadFile = new JButton("下  载  文  件");
		btnShowFileList = new JButton("文  件  列  表");
		btnModiPsd = new JButton("修  改  密  码");
		btnExit = new JButton("退  出  登  录");

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1)); // 设置面板布局为网格布局，即4行1列
		panel.add(btnDownloadFile);
		panel.add(btnShowFileList);
		panel.add(btnModiPsd);
		panel.add(btnExit);

		getContentPane().add(panel, BorderLayout.CENTER);// 将panel放置在窗口的内容面板的中间
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置当点击窗口右上角的“关闭”图标后，退出应用程序
		setSize(600, 400);// 设置窗口的大小
		this.setResizable(false);// 设置不可调整窗口的大小
		this.setLocationRelativeTo(null);// 设置窗口的显示位置为屏幕的中间
		this.setVisible(true);// 设置窗口可见

		// 处理“退出”按钮事件
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BrowserFrame.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见
			}
		});

		// 处理“下载文件”按钮事件
//		btnDownloadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new DownLoadFileFrame("下载文件",BrowserFrame.this,user);
//			}
//		});

		// 处理“文件列表”按钮事件
//		btnShowFileList.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new ShowFileListFrame("文件列表",BrowserFrame.this,user);
//			}
//		});

		// 处理“修改密码”按钮事件
		btnModiPsd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ModiPsdFrame("修改密码", BrowserFrame.this, user);
			}
		});
	}
}
