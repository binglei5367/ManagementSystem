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
					if(this.changeUserInfo(new_password)){
					}
					else{
						System.out.println("�޸�ʧ��");
					}
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 2:
				//�ļ��б�
				try {
					if(this.showFileList()){
						System.out.println("��ȡ�б�ɹ�");
					}
					else{
						System.out.println("��ȡ�б�ʧ��");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
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
				try {
					if(addUser()){
						System.out.println("��ӳɹ�");
					}
					else{
						System.out.println("���ʧ��");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				//ɾ���û�
				try {
					if(delUser()){
						System.out.println("ɾ���ɹ�");
					}
					else{
						System.out.println("ɾ��ʧ��");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				//�û��б�
				try {
					if(listUser()){
						System.out.println("��ȡ�ɹ�");
					}
					else{
						System.out.println("��ȡʧ��");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());;
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
		
		System.out.print("�����û���: ");
		String name = scanner.next();

		if(DataProcessing.deleteUser(name)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean addUser() throws SQLException{
		
		System.out.print("�������û���: ");
		String name = scanner.next();
		System.out.print("�������û�����: ");
		String password = scanner.next();
		System.out.print("�������û����: ");
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
