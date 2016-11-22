import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.InputMismatchException;
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
					  "---admin---\n"
					+ "1.�޸�����\n"
					+ "2.�ļ��б�\n"
					+ "3.�����ļ�\n"
					+ "4.�޸�Ȩ��\n"
					+ "5.����û�\n"
					+ "6.ɾ���û�\n"
					+ "7.�г��û�\n"
					+ "8.ע��ϵͳ\n"
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
				} catch (SQLException e2) {
					// TODO Auto-generated catch block			
					System.out.println(e2.getMessage());
				}
				break;
			case 2:
				//�ļ��б�
				try {
					this.showFileList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
				break;
			case 3:
				//�����ļ�
				System.out.print("�����ļ���: ");
				String filename = scanner.next();
				try {
					if (this.downloadFile(filename)){
						System.out.println("...���سɹ�");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				//�޸�Ȩ��
				if(changeUser()){
					System.out.println("�޸ĳɹ�");
				}
				else{
					System.out.println("�޸�ʧ��");
				}
				break;
			case 5:
				//����û�
				if(addUser()){
					System.out.println("��ӳɹ�");
				}
				else{
					System.out.println("���ʧ��");
				}
				break;
			case 6:
				//ɾ���û�
				if(delUser()){
					System.out.println("ɾ���ɹ�");
				}
				else{
					System.out.println("ɾ��ʧ��");
				}
				break;
			case 7:
				//�û��б�
				if(listUser()){
					System.out.println("��ȡ�ɹ�");
				}
				else{
					System.out.println("��ȡʧ��");
				}
				break;
			case 8:
				//ע��ϵͳ
				return;
			default:
				break;	
			}	
		}	
	}
	
	public boolean changeUser(){
			
		System.out.print("�û���: ");
		String name = scanner.next();
		System.out.print("����: ");
		String password = scanner.next();
		System.out.print("�޸����:��");
		String role = scanner.next();
		
		try {
			if(DataProcessing.update(name, password, role)){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;		
	}
	
	public boolean delUser(){
		System.out.print("�����û���: ");
		String name = scanner.next();
		try {
			if(DataProcessing.delete(name)){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean addUser(){
		System.out.print("�������û���: ");
		String name = scanner.next();
		System.out.print("�������û�����: ");
		String password = scanner.next();
		System.out.print("�������û����: ");
		String role = scanner.next();
		try {
			if(DataProcessing.insert(name, password, role)){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean listUser(){
		Enumeration<User> Allusers = null;
		try {
			Allusers = DataProcessing.getAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
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
