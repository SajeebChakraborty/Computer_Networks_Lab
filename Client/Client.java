import java.io.*;
import java.net.*;

public class Client{
	
	public static void main(String[] args) throws Exception
	{
		Socket s=new Socket("localhost",8080);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1="",str2="";
		
		while(!str1.equalsIgnoreCase("OVER"))
		{
			System.out.print("Client : ");
			str1=br.readLine();
			dout.writeUTF(str1);
			
			if(str1.equalsIgnoreCase("LS"))
			{
				String st;
				System.out.println("\tList:");
				while(true)
				{
					
					st=din.readUTF();
					if(st.equals("END"))
					{
						
						break;
						
					}
					else{
						
						System.out.println(st);
						
					}
					
					
				}
				
				
			}
			str2=din.readUTF();
			System.out.println("Server : " + str2);
			
			
		}
		
		s.close();
		dout.flush();
		dout.close();
		
		
		
		
		
		
	}
}