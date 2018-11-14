import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminDeleteUsersPage extends JFrame implements ActionListener {
    JLabel labeluser;
    JFrame AD = new JFrame("Make Booking - University Venue Management System");
    JButton ProceedBtn, ReturnBtn;
    static JTextField uidtf;

    public AdminDeleteUsersPage() {
        AD.setResizable(false);
        AD.setSize(900, 500);

        AD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AD.setLocationRelativeTo(null);
        AD.setLayout(null);

        labeluser = new JLabel("Username: ");


        uidtf = new JTextField(10);


        ProceedBtn = new JButton("Proceed");
        ReturnBtn = new JButton("Return");

        labeluser.setBounds(100, 50, 100, 25);


        uidtf.setBounds(200, 50, 400, 25);



        ProceedBtn.setBounds(360, 430, 100, 25);
        ReturnBtn.setBounds(660, 430, 100, 25);


        AD.add(labeluser);
        AD.add(uidtf);
        AD.add(ProceedBtn);
        AD.add(ReturnBtn);

        ProceedBtn.addActionListener(this);
        ReturnBtn.addActionListener(this);

        AD.setVisible(true);

    }



    public static String getuserid()
    {
        return uidtf.getText();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == ProceedBtn){
            try{
                Admin a = new Admin();
                a.deleteUsers(getuserid());
                JOptionPane.showMessageDialog(null, "Users Deleted");
                AD.dispose();
                new AdminOptionPage();
            }catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        else if(e.getSource() == ReturnBtn){
            new AdminViewUsersPage().setVisible(true);
            this.dispose();
        }

    }
}