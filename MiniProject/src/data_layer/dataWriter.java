package data_layer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class dataWriter {

	private static File nuFile = new File(".//data/UserData.dat");
	private static DataOutputStream dos = null;
	private static DataInputStream dis = null;
	
	public static boolean AddNewRecord(String Name, String Surname, String Email, double Contacts, int Password)
	{
		boolean result = false;
		//ArrayList<Graph.Vertex<MainUser>> list = new ArrayList<>();
		
		
		try
		{
			dos = new DataOutputStream(new FileOutputStream(nuFile, true));
			
			try
			{
				dos.writeUTF(Name); //Name of the customer
				dos.writeUTF(" "); //space
				dos.writeUTF(Surname);
				dos.writeUTF(" ");
				dos.writeUTF(Email);
				dos.writeUTF(" ");
				dos.writeDouble(Contacts);;
				dos.writeUTF(" ");
				dos.writeInt(Password);
				dos.writeUTF(" ");
				dos.writeUTF("\n"); //new line
				
				result = true;
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(dos != null)
			{
				try
				{
					dos.close();
				}
				catch(IOException iox)
				{
					iox.printStackTrace();
				}
			}
		}	
		return result;
	}
	
	
}
