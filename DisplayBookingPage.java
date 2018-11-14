import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DisplayBookingPage extends JFrame implements ActionListener {
    JLabel labeluser;
    JFrame DBP = new JFrame("Display Booking - University Venue Management System");
    JButton ProceedBtn, ReturnBtn;
    static JTextField usertf;

    public DisplayBookingPage() {
        DBP.setResizable(false);
        DBP.setSize(900, 500);

        DBP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DBP.setLocationRelativeTo(null);
        DBP.setLayout(null);

        labeluser = new JLabel("Username: ");

        usertf = new JTextField(10);


        ProceedBtn = new JButton("Proceed");
        ReturnBtn = new JButton("Return");

        labeluser.setBounds(100, 50, 100, 25);

        usertf.setBounds(200, 50, 400, 25);


        ProceedBtn.setBounds(360, 430, 100, 25);
        ReturnBtn.setBounds(660, 430, 100, 25);


        DBP.add(labeluser);
        DBP.add(usertf);
        DBP.add(ProceedBtn);
        DBP.add(ReturnBtn);

        ProceedBtn.addActionListener(this);
        ReturnBtn.addActionListener(this);

        DBP.setVisible(true);

    }



    public static String getUID()
    {
        return usertf.getText();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == ProceedBtn){
            Booking b = new Booking();
            try {
                b.displayBooking(getUID());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            this.dispose();
        }
        else if(e.getSource() == ReturnBtn){
            DBP.dispose();
            new OptionPage();
        }

    }
}