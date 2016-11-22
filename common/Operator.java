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
					+ "1.修改密码\n"
					+ "2.文件列表\n"
					+ "3.下载文件\n"
					+ "4.上传文件\n"
					+ "5.退出系统\n"
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
				//修改密码
				System.out.print("输入新密码: ");
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
				//文件列表
				try {
					if(this.showFileList()){
						System.out.println("获取文件列表成功");
					}
					else{
						System.out.println("获取文件列表失败");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				//下载文件
				try {
					if (this.downloadFile()){
						System.out.println("下载成功");
					}
					else{
						System.out.println("下载失败");
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				//上传文件
				try {
					if(this.uploadFile()){
						System.out.println("上传成功");
					}
					else{
						System.out.println("");
					}
				} catch (SQLException | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				//退出系统
				return;
			default:
				System.out.println("Undefined number");
				break;
			}	
		}
	}
	
	public boolean uploadFile() throws SQLException, IOException{
//		System.out.println("上传文件... ...");
//		if(Math.random()<0.3){
//			throw new SQLException("Not Connected to Database");
//		}	
//		return true;
		
		System.out.println("输入文件ID");
		String ID = scanner.next();
		System.out.println("输入文件路径");
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
