import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s =null;
		BufferedReader br = null;
		try
		{
			
				//1.creating Socket Connection
				 s = new Socket ("127.0.0.1",4000);
				
				 br = new BufferedReader(new InputStreamReader(s.getInputStream())); //for reading
				
				PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));   //for writing
				
				while(true)
				{
					String msg = br.readLine();
					if(msg != null )
					{
						System.out.println("Message : "+msg);
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						 
						out.write(br1.readLine()+"\n");
						
						
						//out.write("Thanks received  \n");
						out.flush();
						//break;
					}
				}
				
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
				
				
		
		
		
		
		
		

	}

}
