package common;
import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		try(Scanner scanner = new Scanner(System.in)){
			while(true){
				System.out.println("---menu---");
				System.out.println("1.登陆");
				System.out.println("2.退出");
				System.out.println("----------");
				int choice;
				while(true){
					try{				
						System.out.print("choose: ");
						choice = scanner.nextInt();		
						break;
						}
					catch(InputMismatchException e){
						System.out.println("Illegal input, please try again");
						scanner.nextLine();
					}
				}
				
				switch(choice){
				case 1:
					System.out.print("用户名: ");
					String name = scanner.next();
					System.out.print("密码: ");
					String password = scanner.next();
					User user = null;
					while(true){
						try{
							user = DataProcessing.searchUser(name, password);
							break;
						}
						catch(SQLException e){
							System.out.println(e.getMessage());
							System.out.println("连接失败, 重试连接...");
						}
					}
					if(user != null){
						System.out.println("...登陆成功");
						user.showMenu();
					}
					else{
						System.out.println("...登陆失败");
					}
					break;
				case 2:
					System.out.println("退出系统...");
					return;
				default:
					break;
				}
			}
		}
	}
}
