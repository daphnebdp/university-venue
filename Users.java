import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Users {
    protected String username;
    protected String password;
    protected String userID;
    public String userStatus;

    public Users() {
        username = "";
        password = "";
    }

    public void Users(String userid, String uname, String pwd) {
        userID = userid;
        username = uname;
        password = pwd;
    }

    public boolean CheckLogin(String userid, String userpd) {
        String line = null;
        boolean retV = false;
        try {
            FileReader FileReader = new FileReader("userinfo.txt");

            BufferedReader BufferedReader = new BufferedReader(FileReader);

            //ArrayList<String>uinfo = new ArrayList();
            while ((line = BufferedReader.readLine()) != null) {
                String[] token = line.split(";");
                retV = true;
                return retV;
            }

            BufferedReader.close();
        } catch (FileNotFoundException FNE) {
            JOptionPane.showMessageDialog(null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
        } catch (IOException IOE) {
            IOE.printStackTrace();
        }
        return retV;
    }


}
