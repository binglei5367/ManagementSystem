package common;
import java.sql.SQLException;
import java.io.IOException;

import javax.swing.JFrame;


public abstract class User {
	private String name;
	private String password;
	private String role;
	
<<<<<<< HEAD
	String uploadPath;
	String downloadPath;
	Scanner scanner = new Scanner(System.in);
	
	protected User(String name,String password,String role){
=======
	User(String name,String password,String role){
>>>>>>> parent of 3166661... SQL Simulating
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
	public abstract void showFrame(JFrame parentFrame);
	
	public boolean changeUserInfo(String password) throws SQLException{
		//д�û���Ϣ���洢
		if (DataProcessing.update(name, password, role)){
			this.password=password;
			System.out.println("�޸ĳɹ�");
			return true;
		}else
			return false;
	}
	
	public boolean downloadFile(String filename) throws IOException{
		double ranValue=Math.random();
		if (ranValue>0.5)
			throw new IOException( "Error in accessing file" );
		System.out.println("�����ļ�... ...");
		return true;
	}
	
	public void showFileList() throws SQLException{
		double ranValue=Math.random();
		if (ranValue>0.5)
			throw new SQLException( "Error in accessing file DB" );
		System.out.println("�б�... ...");
	}
	
	public abstract void showMenu();
	
	public void exitSystem(){
		System.out.println("ϵͳ�˳�, ллʹ�� ! ");
		System.exit(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
