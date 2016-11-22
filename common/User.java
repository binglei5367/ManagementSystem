package common;
import java.sql.SQLException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import javax.swing.JFrame;


public abstract class User {
	private String name;
	private String password;
	private String role;
	
	String uploadPath;
	String downloadPath;
	Scanner scanner = new Scanner(System.in);
	
	protected User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;		
		
		uploadPath = "C:\\Workspace\\Upload\\";				//上传文件路径
		downloadPath = "C:\\Workspace\\Download\\";			//下载文件路径
		
	}
	
	public abstract void showFrame(JFrame parentFrame);
	
	public boolean changeUserInfo(String password) throws SQLException{
		//写用户信息到存储
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			return true;
		}else
			return false;
	}
	
	public boolean downloadFile() throws IOException{
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new IOException( "Error in accessing file" );
//		System.out.println("下载文件... ...");
//		return true;
//	
		System.out.println("输入文件ID");
		String ID = scanner.next();
		String filename;
		try {
			filename = DataProcessing.searchDoc(ID).getFilename();
		} catch (SQLException e) {
			System.out.println("未找到文件");
			return false;
		} catch (NullPointerException e){
			System.out.println("未找到文件");
			return false;
		}
		byte[] buffer = new byte[1024];
		File fileRead = new File(uploadPath + filename);
		File fileWrite = new File(downloadPath + filename);

		try{
			FileInputStream infile = new FileInputStream(fileRead);
			BufferedInputStream in = new BufferedInputStream(infile);
			FileOutputStream outfile = new FileOutputStream(fileWrite);
			BufferedOutputStream out = new BufferedOutputStream(outfile);
			
			while(true){
				int byteRead = in.read(buffer);
				if(byteRead == -1)break;
				out.write(buffer, 0, byteRead);
			}
			in.close();
			out.close();
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean showFileList() throws SQLException{
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in accessing file DB" );
//		System.out.println("列表... ...");
		
		Enumeration<Doc> Filelist = null;
		try{
			Filelist = DataProcessing.getAllDocs();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(Filelist != null){
			while(Filelist.hasMoreElements()){
				Doc doc = Filelist.nextElement();
				System.out.println(
						  "FileID:   " + doc.getID() + "\n"
						+ "Creator:  " + doc.getCreator() + "\n"
						+ "Time:     " + doc.getTimestamp() + "\n"
						+ "FileName: " + doc.getFilename() + "\n");
			}
			return true;
		}
		return false;
	}
	
	public abstract void showMenu();
	
	public void exitSystem(){
		System.out.println("系统退出, 谢谢使用 ! ");
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
