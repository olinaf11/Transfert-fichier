import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFileChooser;

/**
 * Client
 */
public class Client {
    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        File file = jfc.getSelectedFile();
        // System.out.println((int)file.length());
        try {
            Socket client = new Socket("localhost", 0011);
            OutputStream out = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            FileInputStream fis = new FileInputStream(file);
            byte[] cont = new byte[(int)file.length()];
            int t = fis.read(cont);
        // send file name
            dos.writeInt(file.getName().getBytes().length);
            dos.write(file.getName().getBytes());
        // send data file
            dos.writeInt(t);
            dos.write(cont);
        // out.flush();
            client.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
}