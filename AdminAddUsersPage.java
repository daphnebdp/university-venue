import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddUsersPage extends JFrame implements ActionListener {
    JLabel labeluser, labelpwd, labelname, labelstatus;
    JFrame AA = new JFrame("Adding Users - University Venue Management System");
    JButton ProceedBtn, ReturnBtn;
    static JTextField uidtf, upwd, uname, ustatus;

    public AdminAddUsersPage() {
        AA.setResizable(false);
        AA.setSize(900, 500);

        AA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AA.setLocationRelativeTo(null);
        AA.setLayout(null);

        labeluser = new JLabel("Username: ");
        labelpwd = new JLabel("Password: ");
        labelname = new JLabel("Full Name: ");
        labelstatus = new JLabel("Status: ");


        uidtf = new JTextField(10);
        upwd = new JTextField(10);
        uname = new JTextField(10);
        ustatus = new JTextField(10);


        ProceedBtn = new JButton("Proceed");
        ReturnBtn = new JButton("Return");

        labeluser.setBounds(100, 50, 100, 25);
        labelpwd.setBounds(100, 80, 100, 25);
        labelname.setBounds(100, 110, 100, 25);
        labelstatus.setBounds(100, 140, 100, 25);


        uidtf.setBounds(200, 50, 400, 25);
        upwd.setBounds(200, 80, 400, 25);
        uname.setBounds(200, 110, 400, 25);
        ustatus.setBounds(200, 140, 400, 25);


        ProceedBtn.setBounds(360, 430, 100, 25);
        ReturnBtn.setBounds(660, 430, 100, 25);


        AA.add(labeluser);
        AA.add(labelpwd);
        AA.add(labelname);
        AA.add(labelstatus);
        AA.add(uidtf);
        AA.add(upwd);
        AA.add(uname);
        AA.add(ustatus);
        AA.add(ProceedBtn);
        AA.add(ReturnBtn);

        ProceedBtn.addActionListener(this);
        ReturnBtn.addActionListener(this);

        AA.setVisible(true);

    }



    public static String getuserid()
    {
        return uidtf.getText();
    }

    public static  String getpwd()
    {
        return upwd.getText();
    }

    public static String getuname()
    {
        return uname.getText();
    }

    public static String getstatus()
    {
        return ustatus.getText();
    }





    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == ProceedBtn){
            int resultBtn = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirm Addition?", "Users Added!", resultBtn);
            if(result == JOptionPane.YES_OPTION){
                String[] MBPArray = new String[4];
                MBPArray[0] = getuserid();
                MBPArray[1] = getpwd();
                MBPArray[2] = getuname();
                MBPArray[3] = getstatus();
                Admin x = new Admin();
                try{
                    x.addUsers(MBPArray[0], MBPArray[1], MBPArray[2], MBPArray[3]);
                    JOptionPane.showMessageDialog(null, "Booking Confirmed");
                    new AdminViewUsersPage().setVisible(true);
                    this.dispose();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error Saving", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else if(result == JOptionPane.NO_OPTION){
                new AdminViewUsersPage().setVisible(true);
                this.dispose();
            }
        }
        else if(e.getSource() == ReturnBtn){
            AA.dispose();
            new AdminViewUsersPage();
        }

    }
}