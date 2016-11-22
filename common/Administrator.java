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
					+ "1.修改密码\n"
					+ "2.文件列表\n"
					+ "3.下载文件\n"
					+ "4.上传文件\n"
					+ "5.修改其他用户\n"
					+ "6.添加用户\n"
					+ "7.删除用户\n"
					+ "8.列出用户\n"
					+ "9.退出系统\n"
					+ "-------\n");	
			System.out.println("");
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
		System.out.println("上传文件... ...");
		return true;
	}
	
	public boolean changeUser(){
		
		
		System.out.print("用户名: ");
		String name = scanner.next();
		System.out.print("密码: ");
		String password = scanner.next();
		System.out.print("修改身份:　")
		String role = scanner.next();
		if(DataProcessing.update(name, password, role)){
			System.out.println("...修改成功");
		}
		else{
			System.out.println("...修改失败");
			return false;
		}
		return true;
		
	}
	
	public boolean delUser(){
		System.out.print("输入用户名: ");
		String name = scanner.next();
		if(DataProcessing.delete(name)){
			System.out.println("...删除成功");
		}
		else{
			System.out.println("...删除失败");
			return false;
		}
		return true;
	}

	public boolean addUser(){
		System.out.print("输入新用户名: ");
		String name = scanner.next();
		System.out.print("输入新用户密码: ");
		String password = scanner.next();
		System.out.print("输入新用户身份: ");
		String role = scanner.next();
		if(DataProcessing.insert(name, password, role)){
			System.out.println("...添加成功");
		}
		else{
			System.out.println("...添加失败");
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
