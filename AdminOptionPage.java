import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOptionPage extends JFrame implements ActionListener {
    JFrame AOFrame;
    JButton ViewBookingBtn, ViewUsersBtn, ViewVenueBtn, LogoutBtn;

    AdminOptionPage(){
        AOFrame = new JFrame("Admin Option Page");

        AOFrame.setResizable(false);
        AOFrame.setSize(900, 500);
        AOFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AOFrame.setLocationRelativeTo(null);
        AOFrame.setLayout(null);

        ViewBookingBtn = new JButton("View Booking");
        ViewUsersBtn = new JButton("View Users");
        ViewVenueBtn = new JButton("View Venue");
        LogoutBtn = new JButton("Logout");

        ViewBookingBtn.setBounds(370, 100, 200, 55);
        ViewUsersBtn.setBounds(370, 180, 200, 55);
        ViewVenueBtn.setBounds(370, 260, 200, 55);
        LogoutBtn.setBounds(670, 430, 100, 55);

        AOFrame.add(ViewBookingBtn);
        AOFrame.add(ViewUsersBtn);
        AOFrame.add(ViewVenueBtn);
        AOFrame.add(LogoutBtn);


        ViewBookingBtn.addActionListener(this);
        ViewUsersBtn.addActionListener(this);
        ViewVenueBtn.addActionListener(this);
        LogoutBtn.addActionListener(this);

        AOFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ViewBookingBtn){
            AOFrame.dispose();
            new AdminViewBookingPage().setVisible(true);
            this.dispose();
        }
        else if(e.getSource() == ViewUsersBtn){
            AOFrame.dispose();
            new AdminViewUsersPage().setVisible(true);
            this.dispose();
        }
        else if(e.getSource() == ViewVenueBtn){
            AOFrame.dispose();
            new AdminViewVenue().setVisible(true);
        }
        else if(e.getSource() == LogoutBtn){
            AOFrame.dispose();
            new LoginPage();
        }

    }
}
