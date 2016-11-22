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
					+ "1.修改密码\n"
					+ "2.文件列表\n"
					+ "3.下载文件\n"
					+ "4.退出系统\n"
					+ "-------\n");	
			System.out.println("");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch(choice){
			case 1:
				System.out.print("输入新密码: ");
				String new_password = scanner.next();
				this.changeUserInfo(new_password);
				break;
			case 2:
				this.showFileList();
				scanner.next();
				break;
			case 3:
				System.out.print("输入文件名: ");
				String filename = scanner.next();
				if (this.downloadFile(filename)){
					System.out.println("...下载成功");
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
