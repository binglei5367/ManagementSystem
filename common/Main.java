import java.util.*;
import java.util.jar.Attributes.Name;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test_creatUsers();
		
		while(true){
			System.out.println("---menu---");
			System.out.println("1.��½");
			System.out.println("2.�˳�");
			System.out.println("----------");
			Scanner scanner = new Scanner(System.in);
			int choice;
			String name, password;
			choice = scanner.nextInt();
			
			switch(choice){
			case 1:
				System.out.print("�û���: ");
				name = scanner.next();
				System.out.println("����: ");
				password = scanner.next();
				User user = DataProcessing.search(name, password);
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
	
	/*
	public static boolean test_creatUsers(){
		Administrator admin_a = new Administrator("admin_a", "666", "Administrator");
		Operator oper_b = new Operator("oper_b", "666", "Operator");
		Browser brow_c = new Browser("brow", "666", "Browser");
		return true;
	}
	*/

}
