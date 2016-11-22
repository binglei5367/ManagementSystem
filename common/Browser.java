package common;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JFrame;

import GUI.BrowserFrame;

public class Browser extends User{

	Browser(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}
			
	Scanner scanner = new Scanner(System.in);
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		while(true){
			System.out.print(
					  "--browser--\n"
					+ "1.�޸�����\n"
					+ "2.�ļ��б�\n"
					+ "3.�����ļ�\n"
					+ "4.�˳�ϵͳ\n"
					+ "-----------\n"
					+ "choose: ");	
			int choice;
			while(true){
				try{
					choice = scanner.nextInt();
					break;
				}
				catch(InputMismatchException e){
					System.out.println("Illegal Input, please try again");
					scanner.nextLine();
					System.out.print("choose again: ");
				}
			}
			switch(choice){
			case 1:
				//�޸�����
				System.out.print("����������: ");
				String new_password = scanner.next();
				try {
					this.changeUserInfo(new_password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				//�ļ��б�
				try {
					this.showFileList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				//�����ļ�
				System.out.print("�����ļ���: ");
				String filename = scanner.next();
				try {
					if (this.downloadFile(filename)){
						System.out.println("���سɹ�");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("����ʧ��");
					scanner.nextLine();
				}
				break;
			case 4:
				//�˳�ϵͳ
				return;
			default:
				break;
					
			}	
		}
	}
	@Override
	public void showFrame(JFrame parentFrame) {
		// TODO Auto-generated method stub
		new BrowserFrame("Browser", parentFrame, this);
	}
}
