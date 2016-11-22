package common;
import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		try(Scanner scanner = new Scanner(System.in)){
			while(true){
				System.out.println("---menu---");
				System.out.println("1.��½");
				System.out.println("2.�˳�");
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
					System.out.print("�û���: ");
					String name = scanner.next();
					System.out.print("����: ");
					String password = scanner.next();
					User user = null;
					while(true){
						try{
							user = DataProcessing.searchUser(name, password);
							break;
						}
						catch(SQLException e){
							System.out.println(e.getMessage());
							System.out.println("����ʧ��, ��������...");
						}
					}
					if(user != null){
						System.out.println("...��½�ɹ�");
						user.showMenu();
					}
					else{
						System.out.println("...��½ʧ��");
					}
					break;
				case 2:
					System.out.println("�˳�ϵͳ...");
					return;
				default:
					break;
				}
			}
		}
	}
}
