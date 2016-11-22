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
					+ "1.修改密码\n"
					+ "2.文件列表\n"
					+ "3.下载文件\n"
					+ "4.上传文件\n"
					+ "5.退出系统\n"
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
				System.out.println("输入文件名: ");
				String filename2 = scanner.next();
				if(this.uploadFile(filename2)){
					System.out.println("上传成功");
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
		System.out.println("上传文件... ...");
		return true;
	}

}
