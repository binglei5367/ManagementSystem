package common;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import javax.swing.JFrame;

import GUI.OperatorFrame;

public class Operator extends User
{

	Operator(String name, String password, String role) {
		super(name, password, role);
	}
	
	Scanner scanner = new Scanner(System.in);
	public void showMenu() {
		while(true){
			System.out.print(
					  "--operator--\n"
					+ "1.�޸�����\n"
					+ "2.�ļ��б�\n"
					+ "3.�����ļ�\n"
					+ "4.�ϴ��ļ�\n"
					+ "5.�˳�ϵͳ\n"
					+ "------------\n"
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
					if(this.changeUserInfo(new_password)){
						System.out.print("");
					}
					else{
						System.out.println("");
					}
				} 
				catch (SQLException e) {
					System.out.println(e.getMessage());	
				}
				break;
			case 2:
				//�ļ��б�
				try {
					if(this.showFileList()){
						System.out.println("��ȡ�ļ��б�ɹ�");
					}
					else{
						System.out.println("��ȡ�ļ��б�ʧ��");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				//�����ļ�
				try {
					if (this.downloadFile()){
						System.out.println("���سɹ�");
					}
					else{
						System.out.println("����ʧ��");
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				//�ϴ��ļ�
				try {
					if(this.uploadFile()){
						System.out.println("�ϴ��ɹ�");
					}
					else{
						System.out.println("");
					}
				} catch (SQLException | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				//�˳�ϵͳ
				return;
			default:
				System.out.println("Undefined number");
				break;
			}	
		}
	}
	
	public boolean uploadFile() throws SQLException, IOException{
//		System.out.println("�ϴ��ļ�... ...");
//		if(Math.random()<0.3){
//			throw new SQLException("Not Connected to Database");
//		}	
//		return true;
		
		System.out.println("�����ļ�ID");
		String ID = scanner.next();
		System.out.println("�����ļ�·��");
		String file = scanner.next();
		
		byte[] buffer = new byte[1024];
		File fileRead = new File(file);
		String fileName = fileRead.getName();
		File fileWrite = new File(uploadPath + fileName);
		

		FileInputStream infile = new FileInputStream(fileRead);
		BufferedInputStream in = new BufferedInputStream(infile);
		FileOutputStream outfile = new FileOutputStream(fileWrite);
		BufferedOutputStream out = new BufferedOutputStream(outfile);
		
		while(true){
			int byteRead = in.read(buffer);
			if(byteRead == -1)break;
			out.write(buffer, 0, byteRead);
		}
		in.close();
		out.close();
		

		
		String creator = this.getName();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String description = "Null";
		DataProcessing.insertDoc(ID, creator, timestamp, description, fileName);
		return true;

	}

	@Override
	public void showFrame(JFrame parentFrame) {
		// TODO Auto-generated method stub
		new OperatorFrame("Operator", parentFrame, this);
	}
}
