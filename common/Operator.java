<<<<<<< HEAD
package common;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
=======
>>>>>>> parent of 3166661... SQL Simulating
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JFrame;

import GUI.OperatorFrame;

public class Operator extends User
{

	Operator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}
	
	Scanner scanner = new Scanner(System.in);
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
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
					this.changeUserInfo(new_password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				System.out.println(e.getMessage());	
				}
				break;
			case 2:
				//文件列表
				try {
					this.showFileList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				//下载文件
				System.out.print("输入文件名: ");
				String filename = scanner.next();
				try {
					if (this.downloadFile(filename)){
						System.out.println("...下载成功");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
//					e.printStackTrace();
				}
				break;
			case 4:
				//上传文件
				System.out.println("输入文件名: ");
				String filename2 = scanner.next();
				try {
					if(this.uploadFile(filename2)){
						System.out.println("上传成功");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
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
	
	public boolean uploadFile(String filename) throws SQLException{
		System.out.println("上传文件... ...");
		if(Math.random()<0.3){
			throw new SQLException("Not Connected to Database");
		}	
		return true;
	}

	@Override
	public void showFrame(JFrame parentFrame) {
		// TODO Auto-generated method stub
		new OperatorFrame("Operator", parentFrame, this);
	}
}
