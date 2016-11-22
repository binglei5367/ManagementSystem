package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import common.User;

public class OperatorFrame extends JFrame{

	private JFrame parentFrame;
	private User user;
	
	private JButton btnUploadFile;
	private JButton btnDownloadFile;
	private JButton btnShowFileList;
	private JButton btnModiPsd;
	private JButton btnExit;
	
	private JPanel panel;
	
	public OperatorFrame(String frameTitle, JFrame parentFrame, User user){
		super(frameTitle);
		this.parentFrame = parentFrame;
		this.user = user;
		
		btnUploadFile = new JButton("上  传  文  件");
		
		btnDownloadFile = new JButton("下  载  文  件");
		btnShowFileList = new JButton("文  件  列  表");
		btnModiPsd = new JButton("修  改  密  码");
		btnExit = new JButton("退  出  登  陆");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		panel.add(btnUploadFile);
		panel.add(btnDownloadFile);
		panel.add(btnShowFileList);
		panel.add(btnModiPsd);
		panel.add(btnExit);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		// 处理“退出”按钮事件
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				OperatorFrame.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见
			}
		});
		
		// 处理“上传文件”按钮事件
//		btnUploadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new UploadFileFrame("", OperatorFrame.this, user);
//			}
//			
//		});

		// 处理“下载文件”按钮事件
//		btnDownloadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new DownLoadFileFrame("下载文件", OperatorFrame.this,user);
//			}
//		});

		// 处理“文件列表”按钮事件
//		btnShowFileList.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new ShowFileListFrame("文件列表",OperatorFrame.this,user);
//			}
//		});

		// 处理“修改密码”按钮事件
		btnModiPsd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ModiPsdFrame("修改密码", OperatorFrame.this, user);
			}
		});
		
		
	}
}





















