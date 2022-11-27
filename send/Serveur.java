import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serveur = new ServerSocket(0011);   
            Socket client = serveur.accept();
            InputStream in = client.getInputStream();
            DataInputStream din = new DataInputStream(in);
            int dataFile = din.readInt();
            byte[] dataFileByte = new byte[dataFile];
            din.readFully(dataFileByte, 0, dataFile);
            String fileName = new String(dataFileByte);
            File f = new File("./FileSave/"+fileName);
            FileOutputStream fos = new FileOutputStream(f);
            int cont = din.readInt();
            byte[] byteCont = new byte[cont];
            din.readFully(byteCont, 0, cont);
            fos.write(byteCont); 
            serveur.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }
}