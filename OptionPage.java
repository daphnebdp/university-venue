import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPage extends JFrame implements ActionListener{
    JFrame OFrame;
    JButton MakeBookingBtn, DisplayBookingBtn, CancelBookingBtn, LogoutBtn;

    public OptionPage()
    {
        OFrame = new JFrame("Main Menu - University Venue Management System");

        OFrame.setResizable(false);
        OFrame.setSize(900,500);
        OFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OFrame.setLocationRelativeTo(null);
        OFrame.setLayout(null);

        MakeBookingBtn = new JButton("Make Booking");
        DisplayBookingBtn = new JButton("Display Booking");
        CancelBookingBtn = new JButton("Cancel Booking");
        LogoutBtn = new JButton("Logout");

        MakeBookingBtn.setBounds(370, 100, 200, 55);
        DisplayBookingBtn.setBounds(370, 180, 200, 55);
        CancelBookingBtn.setBounds(370, 260, 200, 55);
        LogoutBtn.setBounds(670, 400, 100, 55);

        OFrame.add(MakeBookingBtn);
        OFrame.add(DisplayBookingBtn);
        OFrame.add(CancelBookingBtn);
        OFrame.add(LogoutBtn);

        MakeBookingBtn.addActionListener(this);
        DisplayBookingBtn.addActionListener(this);
        CancelBookingBtn.addActionListener(this);
        LogoutBtn.addActionListener(this);

        OFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == MakeBookingBtn){
            OFrame.dispose();
            new MakeBookingPage();
        }
        else if(e.getSource() == DisplayBookingBtn){
            OFrame.dispose();
            new DisplayViewPage();
        }
        else if(e.getSource() == CancelBookingBtn){
            OFrame.dispose();
            new CancelBookingPage();
        }
        else if(e.getSource() == LogoutBtn){
            OFrame.dispose();
            new LoginPage();
        }

    }
}