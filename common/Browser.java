import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Browser extends User{

	Browser(String name, String password, String role) {
		super(name, password, role);
	}
			
	Scanner scanner = new Scanner(System.in);
	public void showMenu() {
		while(true){
			System.out.print(
					  "--browser--\n"
					+ "1.修改密码\n"
					+ "2.文件列表\n"
					+ "3.下载文件\n"
					+ "4.退出系统\n"
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
					this.changeUserInfo(new_password);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				//文件列表
				try {
					if (this.showFileList()){
						System.out.println("");
					}
					else{
						System.out.println("");
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
				//退出系统
				return;
			default:
				break;
					
			}	
		}
	}
}
