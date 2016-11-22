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

	private JFrame parentFrame; // ������
	private User user;  //��ǰ�û�
	
	private JButton btnDownloadFile; // �����ļ���ť
	private JButton btnShowFileList; // ��ʾ�ļ��б�ť
	private JButton btnModiPsd; // �޸����밴ť
	private JButton btnExit; // �˳���ť

	private JPanel panel; // ���

	public BrowserFrame(String frameTitle, JFrame parentframe, User user) {
		// TODO Auto-generated constructor stub
		super(frameTitle);
		this.parentFrame = parentframe;
		this.user = user;

		btnDownloadFile = new JButton("��  ��  ��  ��");
		btnShowFileList = new JButton("��  ��  ��  ��");
		btnModiPsd = new JButton("��  ��  ��  ��");
		btnExit = new JButton("��  ��  ��  ¼");

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1)); // ������岼��Ϊ���񲼾֣���4��1��
		panel.add(btnDownloadFile);
		panel.add(btnShowFileList);
		panel.add(btnModiPsd);
		panel.add(btnExit);

		getContentPane().add(panel, BorderLayout.CENTER);// ��panel�����ڴ��ڵ����������м�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���õ�����������Ͻǵġ��رա�ͼ����˳�Ӧ�ó���
		setSize(600, 400);// ���ô��ڵĴ�С
		this.setResizable(false);// ���ò��ɵ������ڵĴ�С
		this.setLocationRelativeTo(null);// ���ô��ڵ���ʾλ��Ϊ��Ļ���м�
		this.setVisible(true);// ���ô��ڿɼ�

		// �����˳�����ť�¼�
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BrowserFrame.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�
			}
		});

		// ���������ļ�����ť�¼�
//		btnDownloadFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new DownLoadFileFrame("�����ļ�",BrowserFrame.this,user);
//			}
//		});

		// �����ļ��б���ť�¼�
//		btnShowFileList.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				new ShowFileListFrame("�ļ��б�",BrowserFrame.this,user);
//			}
//		});

		// �����޸����롱��ť�¼�
		btnModiPsd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ModiPsdFrame("�޸�����", BrowserFrame.this, user);
			}
		});
	}
}
