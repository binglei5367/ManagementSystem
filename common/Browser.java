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
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				//�ļ��б�
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
				//�˳�ϵͳ
				return;
			default:
				break;
					
			}	
		}
	}
}
