package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import common.User;

public class AdministratorFrame extends JFrame{

	private JFrame parentFrame;
	private User user;
	
	private JButton btnChangeUserInfo;
	private JButton btnChangeUser;
	private JButton btnAddUser;
	private JButton btnDeletUser;
	private JButton btnUploadFile;
	private JButton btnDownloadFile;
	private JButton btnShowFileList;
	private JButton btnModiPsd;
	private JButton btnExit;
	
	private JPanel panel;
	
	public AdministratorFrame(String frameTitle, JFrame parentframe, User user){
		super(frameTitle);
		this.parentFrame = parentFrame;
		this.user = user;
		
		btnChangeUser = new JButton("修  改  权  限");
		btnAddUser = new JButton("添  加  用  户");
		btnDeletUser = new JButton("删  除  用  户");
		
		btnUploadFile = new JButton("上  传  文  件");
		
		btnDownloadFile = new JButton("下  载  文  件");
		btnShowFileList = new JButton("文  件  列  表");
		btnModiPsd = new JButton("修  改  密  码");
		btnExit = new JButton("退  出  登  录");

		panel = new JPanel();
		panel.setLayout(new GridLayout(9, 1));
		panel.add(btnDownloadFile);
		panel.add(btnShowFileList);
		panel.add(btnModiPsd);
		panel.add(btnExit);

		getContentPane().add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AdministratorFrame.this.dispose();
				parentFrame.setVisible(true);
			}
		});
		
		
		//
		btnChangeUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ChangeUserFrame("", AdministratorFrame.this, user);
			}
			
		});
		
		
		btnAddUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddUserFrame("", AdministratorFrame.this, user);
			}
			
		});
		
		
		btnDeletUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new DeletUserFrame("", AdministratorFrame.this, user);
			}
			
		});
		
		
		// 处理“上传文件”按钮事件
//		btnUploadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new UploadFileFrame("", AdministratorFrame.this, user);
//			}
//			
//		});
		
		// 处理“下载文件”按钮事件
//		btnDownloadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new DownLoadFileFrame("下载文件",AdministratorFrame.this,user);
//			}
//		});

		// 处理“文件列表”按钮事件
//		btnShowFileList.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new ShowFileListFrame("文件列表",AdministratorFrame.this,user);
//			}
//		});

		// 处理“修改密码”按钮事件
		btnModiPsd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ModiPsdFrame("修改密码", AdministratorFrame.this, user);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
