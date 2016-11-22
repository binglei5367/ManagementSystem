import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrator extends User{

	Administrator(String name, String password, String role) {
		super(name, password, role);
	}
	
	Scanner scanner = new Scanner(System.in);
	
	
	public void showMenu() {
		while(true){
			System.out.print(
					  "---admin---\n"
					+ "1.修改密码\n"
					+ "2.文件列表\n"
					+ "3.下载文件\n"
					+ "4.修改权限\n"
					+ "5.添加用户\n"
					+ "6.删除用户\n"
					+ "7.列出用户\n"
					+ "8.注销系统\n"
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
				//修改密码
				System.out.print("输入新密码: ");
				String new_password = scanner.next();
				try {
					if(this.changeUserInfo(new_password)){
					}
					else{
						System.out.println("修改失败");
					}
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 2:
				//文件列表
				try {
					if(this.showFileList()){
						System.out.println("获取列表成功");
					}
					else{
						System.out.println("获取列表失败");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
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
				//修改权限
				if(changeUser()){
					System.out.println("修改成功");
				}
				else{
					System.out.println("修改失败");
				}
				break;
			case 5:
				//添加用户
				try {
					if(addUser()){
						System.out.println("添加成功");
					}
					else{
						System.out.println("添加失败");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				//删除用户
				try {
					if(delUser()){
						System.out.println("删除成功");
					}
					else{
						System.out.println("删除失败");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				//用户列表
				try {
					if(listUser()){
						System.out.println("获取成功");
					}
					else{
						System.out.println("获取失败");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());;
				}
				break;
			case 8:
				//注销系统
				return;
			default:
				break;	
			}	
		}	
	}
	
	public boolean changeUser(){
		
		System.out.print("用户名: ");
		String name = scanner.next();
		System.out.print("密码: ");
		String password = scanner.next();
		System.out.print("修改身份:　");
		String role = scanner.next();
		
		try {
			if(DataProcessing.updateUser(name, password, role)){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;		
	}
	
	public boolean delUser() throws SQLException{
		
		System.out.print("输入用户名: ");
		String name = scanner.next();

		if(DataProcessing.deleteUser(name)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean addUser() throws SQLException{
		
		System.out.print("输入新用户名: ");
		String name = scanner.next();
		System.out.print("输入新用户密码: ");
		String password = scanner.next();
		System.out.print("输入新用户身份: ");
		String role = scanner.next();
		
		if(DataProcessing.insertUser(name, password, role)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean listUser() throws SQLException{
		
		Enumeration<User> Allusers = null;
		Allusers = DataProcessing.getAllUser();
		if(Allusers != null){
			while(Allusers.hasMoreElements()){
				User user = Allusers.nextElement();
				System.out.println("Username: "+user.getName()+"\t"
						+"Password: "+user.getPassword()+"\t"
						+"Role: "+ user.getRole());
			}
			return true;
		}
		return false;
	}
}
