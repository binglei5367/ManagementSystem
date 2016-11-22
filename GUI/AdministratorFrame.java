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
		
		btnChangeUser = new JButton("��  ��  Ȩ  ��");
		btnAddUser = new JButton("��  ��  ��  ��");
		btnDeletUser = new JButton("ɾ  ��  ��  ��");
		
		btnUploadFile = new JButton("��  ��  ��  ��");
		
		btnDownloadFile = new JButton("��  ��  ��  ��");
		btnShowFileList = new JButton("��  ��  ��  ��");
		btnModiPsd = new JButton("��  ��  ��  ��");
		btnExit = new JButton("��  ��  ��  ¼");

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
		
		
		// �����ϴ��ļ�����ť�¼�
//		btnUploadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new UploadFileFrame("", AdministratorFrame.this, user);
//			}
//			
//		});
		
		// ���������ļ�����ť�¼�
//		btnDownloadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new DownLoadFileFrame("�����ļ�",AdministratorFrame.this,user);
//			}
//		});

		// �����ļ��б���ť�¼�
//		btnShowFileList.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new ShowFileListFrame("�ļ��б�",AdministratorFrame.this,user);
//			}
//		});

		// �����޸����롱��ť�¼�
		btnModiPsd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ModiPsdFrame("�޸�����", AdministratorFrame.this, user);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
