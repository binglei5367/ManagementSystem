import java.util.Scanner;

public class Operator extends User
{

	Operator(String name, String password, String role) {
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
					+ "4.�ϴ��ļ�\n"
					+ "5.�˳�ϵͳ\n"
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
				System.out.println("�����ļ���: ");
				String filename2 = scanner.next();
				if(this.uploadFile(filename2)){
					System.out.println("�ϴ��ɹ�");
				}
				break;
			case 5:
				return;
			default:
				break;
					
			}	
		}
		
	}
	
	public boolean uploadFile(String filename){
		System.out.println("�ϴ��ļ�... ...");
		return true;
	}

}
