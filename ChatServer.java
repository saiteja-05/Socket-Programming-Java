import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
//import java.util.Calendar;


public class ChatServer {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss= null;
		BufferedReader br = null;
		Socket cs = null;
		
		try
		{
			
		
				//1.ServerSocket instance creation
				
				 ss = new ServerSocket(4000);
				System.out.println("Server is ready ");
				
				//2.chanel creation
				
				while(true)
				{
					 cs = ss.accept();
					
					 br = new BufferedReader(new InputStreamReader(cs.getInputStream())); //for reading
					
					PrintWriter out = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));   //for writing
					
					//String time  = Calendar.getInstance().getTime().toString();
					out.write("Welcome,Ready to Chat  " +"\n");
					out.flush();
					while(true)
					{
						String msg = br.readLine();
						if(msg != null )
						{
							System.out.println("Received : "+msg);
							BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
							 
							out.write(br1.readLine()+"\n");
							
							//out.write(msg.toUpperCase()+" ! \n");
							out.flush();
							//break;
						}
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
		
		finally {
			try {
				br.close();
				cs.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
