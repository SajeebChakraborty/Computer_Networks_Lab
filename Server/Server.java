import java.io.*;
import java.net.*;

public class Server{
	
	public static void main(String[] args) throws Exception{
		
		ServerSocket ss= new ServerSocket(8080);
		System.out.println("Server is running...");
		Socket s=ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1="",str2="";
		
		while(!str1.equalsIgnoreCase("OVER"))
		{
			str1=din.readUTF();
			System.out.println("Client : " + str1);
			if(str1.equalsIgnoreCase("LS"))
			{
				File f1 = new File("../Server");
				File[] files = f1.listFiles();
				
				for(int i=0;i<files.length ; i++)
				{
					
					dout.writeUTF(files[i].getName());
					
				}
				dout.writeUTF("END");
				
			}
			System.out.print("Server : ");
			str2=br.readLine();
			dout.writeUTF(str2);
			
		}
		
		
		
		
	}
}