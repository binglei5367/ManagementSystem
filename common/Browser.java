import java.util.Scanner;

public class Browser extends User{

	Browser(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		while(true){
			System.out.print(
					  "-------\n"
					+ "1.�޸�����\n"
					+ "2.�ļ��б�\n"
					+ "3.�����ļ�\n"
					+ "4.�˳�ϵͳ\n"
					+ "-------\n");	
			System.out.println("");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch(choice){
			case 1:
				System.out.print("����������: ");
				String new_password = scanner.next();
				this.changeUserInfo(new_password);
				break;
			case 2:
				this.showFileList();
				scanner.next();
				break;
			case 3:
				System.out.print("�����ļ���: ");
				String filename = scanner.next();
				if (this.downloadFile(filename)){
					System.out.println("...���سɹ�");
				}
				break;
			case 4:
				return;
			default:
				break;
					
			}	
		}
		
	}

}
