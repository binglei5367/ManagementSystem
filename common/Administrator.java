import java.util.Enumeration;
import java.util.Scanner;

public class Administrator extends User{

	Administrator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}
	
	Scanner scanner = new Scanner(System.in);
	
	
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
					+ "5.�޸������û�\n"
					+ "6.����û�\n"
					+ "7.ɾ���û�\n"
					+ "8.�г��û�\n"
					+ "9.�˳�ϵͳ\n"
					+ "-------\n");	
			System.out.println("");
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
				changeUser();
				break;
			case 6:
				addUser();
				break;
			case 7:
				delUser();
				break;
			case 8:
				listUser();
				break;
			case 9:
				System.out.println("");
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
	
	public boolean changeUser(){
		
		
		System.out.print("�û���: ");
		String name = scanner.next();
		System.out.print("����: ");
		String password = scanner.next();
		System.out.print("�޸����:��")
		String role = scanner.next();
		if(DataProcessing.update(name, password, role)){
			System.out.println("...�޸ĳɹ�");
		}
		else{
			System.out.println("...�޸�ʧ��");
			return false;
		}
		return true;
		
	}
	
	public boolean delUser(){
		System.out.print("�����û���: ");
		String name = scanner.next();
		if(DataProcessing.delete(name)){
			System.out.println("...ɾ���ɹ�");
		}
		else{
			System.out.println("...ɾ��ʧ��");
			return false;
		}
		return true;
	}

	public boolean addUser(){
		System.out.print("�������û���: ");
		String name = scanner.next();
		System.out.print("�������û�����: ");
		String password = scanner.next();
		System.out.print("�������û����: ");
		String role = scanner.next();
		if(DataProcessing.insert(name, password, role)){
			System.out.println("...��ӳɹ�");
		}
		else{
			System.out.println("...���ʧ��");
			return false;
		}
		return true;
	}
	
	public boolean listUser(){
		Enumeration<User> Allusers = DataProcessing.getAllUser();
		while(Allusers.hasMoreElements()){
			User user = Allusers.nextElement();
			System.out.println("Username: "+user.getName()+"\t"
					+"Password: "+user.getPassword()+"\t"
					+"Role: "+ user.getRole());
		}
		return true;
	}
}
