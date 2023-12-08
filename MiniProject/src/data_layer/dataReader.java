package data_layer;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Alert.AlertType;
import user_layer.User;

public class dataReader {
	
	private static DataInputStream dis = null;
	private static File file = null;
	
	public static User readData() {
		file = new File("./data/UserData.dat");
		User nuUser = new User();
		
		if(file != null)
		{
			try {
				
				dis = new DataInputStream(new FileInputStream(file));
				
				try
				{
					int count = 0;
					
					while(dis.available() > 0)
					{
						count++;
						String space = "";
						
						//Create a user instance
						
						
						//Read from file
						nuUser.Name = dis.readUTF();
						space = dis.readUTF();
						
						
						nuUser.Surname = dis.readUTF();
						space = dis.readUTF();
						
						nuUser.Email = dis.readUTF();
						space = dis.readUTF();
						
						nuUser.Contacts = (int) dis.readDouble();
						space = dis.readUTF();
						
						nuUser.Password = dis.readInt();
						space = dis.readUTF();
						

						
						//ArrayList<User> userList;
						//add new user to list
						//MainUser uzer = new MainUser(); 
						
						//userList.add(nuUser);
					}
					
				//	return userList;
				}
				catch(IOException iox)
				{
					iox.printStackTrace();
				
					javafx.scene.control.Alert alert = new javafx.scene.control.Alert(AlertType.ERROR);
					alert.setContentText("Unable to retrieve data from the file");
					alert.setTitle("Error reading from file");
					alert.show();
				}
			}
			catch(FileNotFoundException fnf)
			{
				fnf.printStackTrace();
				
				javafx.scene.control.Alert alert = new javafx.scene.control.Alert(AlertType.ERROR);
				alert.setContentText("File Not Found");
				alert.setTitle("Error reading from file");
				alert.show();
			}
			finally
			{
				if(dis != null)
				{
					try
					{
						dis.close();
					}
					catch(IOException iox)
					{
						iox.printStackTrace();
					}
				}
			}
		}
		return nuUser;
	}
}
