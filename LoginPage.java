
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {
    JFrame LFrame;
    JLabel LoginLabel, UserIDLabel, PasswordLabel;
    static JTextField UserIDTextField, PasswordTextField;
    JButton LoginBtn, AdminLoginBtn;


    public LoginPage()
    {
        LFrame = new JFrame("University Venue Management System");

        LFrame.setResizable(false);
        LFrame.setSize(900, 500);
        LFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LFrame.setLocationRelativeTo(null);
        LFrame.setLayout(null);

        LoginLabel = new JLabel("Login");
        UserIDLabel = new JLabel("User ID");
        PasswordLabel = new JLabel("Password");

        UserIDTextField = new JTextField(10);
        PasswordTextField = new JTextField(10);

        LoginBtn = new JButton("Login");
        AdminLoginBtn = new JButton("Admin Login");

        LoginLabel.setBounds(150, 10, 100, 25);
        UserIDLabel.setBounds(100, 20, 100, 25);
        PasswordLabel.setBounds(100, 50, 100, 25);

        UserIDTextField.setBounds(200, 20, 100, 25);
        PasswordTextField.setBounds(200, 50, 100, 25);

        LoginBtn.setBounds(360, 430, 100, 25);
        AdminLoginBtn.setBounds(560, 430, 200, 25);



        LFrame.add(LoginLabel);
        LFrame.add(UserIDLabel);
        LFrame.add(PasswordLabel);
        LFrame.add(UserIDTextField);
        LFrame.add(PasswordTextField);
        LFrame.add(LoginBtn);
        LFrame.add(AdminLoginBtn);


        LoginBtn.addActionListener(this);
        AdminLoginBtn.addActionListener(this);

        LFrame.setVisible(true);


    }

    public static String getUserID()
    {
        return UserIDTextField.getText();
    }

    public static String getPassword()
    {
        return PasswordTextField.getText();
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == LoginBtn){
            String[] LogArray = new String[2];
            LogArray[0] = getUserID();
            LogArray[1] = getPassword();

            try{
               Users u = new Users();
               boolean found = u.CheckLogin(LogArray[0], LogArray[1]);
                if(found == true){
                    JOptionPane.showMessageDialog(null, "Login Success", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    LFrame.dispose();
                    new OptionPage();

                }
                else
                    JOptionPane.showMessageDialog(null, "Invalid Username/Password", "Login Failed",JOptionPane.ERROR_MESSAGE);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error", "Login Failure", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == AdminLoginBtn){
            if(getUserID().equals("admin") && getPassword().equals("admin")){
                LFrame.dispose();
                new AdminOptionPage();
            }
            else
                JOptionPane.showMessageDialog(null, "Invalid Username/Password", "Login Failed",JOptionPane.ERROR_MESSAGE);
        }


    }
}
