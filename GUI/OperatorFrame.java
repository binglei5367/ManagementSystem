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
		
		btnUploadFile = new JButton("��  ��  ��  ��");
		
		btnDownloadFile = new JButton("��  ��  ��  ��");
		btnShowFileList = new JButton("��  ��  ��  ��");
		btnModiPsd = new JButton("��  ��  ��  ��");
		btnExit = new JButton("��  ��  ��  ½");
		
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
		
		// �����˳�����ť�¼�
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				OperatorFrame.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�
			}
		});
		
		// �����ϴ��ļ�����ť�¼�
//		btnUploadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new UploadFileFrame("", OperatorFrame.this, user);
//			}
//			
//		});

		// ���������ļ�����ť�¼�
//		btnDownloadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new DownLoadFileFrame("�����ļ�", OperatorFrame.this,user);
//			}
//		});

		// �����ļ��б���ť�¼�
//		btnShowFileList.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new ShowFileListFrame("�ļ��б�",OperatorFrame.this,user);
//			}
//		});

		// �����޸����롱��ť�¼�
		btnModiPsd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ModiPsdFrame("�޸�����", OperatorFrame.this, user);
			}
		});
		
		
	}
}





















