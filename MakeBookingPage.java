import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeBookingPage extends JFrame implements ActionListener {
    JLabel labeluser, labeldate, labelstart, labelend, labelvenueid;
    JFrame MBP = new JFrame("Make Booking - University Venue Management System");
    JButton ProceedBtn, ReturnBtn;
    static JTextField usertf, datetf, starttf, endtf, vidtf;

    public MakeBookingPage() {
        MBP.setResizable(false);
        MBP.setSize(900, 500);

        MBP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MBP.setLocationRelativeTo(null);
        MBP.setLayout(null);

        //labeluser = new JLabel("Username: ");
        labelvenueid = new JLabel("Venue ID: ");
        labeldate = new JLabel("Date(dd-mm-yy): ");
        labelstart = new JLabel("Start Time(hh:mm): ");
        labelend = new JLabel("End Time(hh:mm): ");


        usertf = new JTextField(10);
        vidtf = new JTextField(10);
        datetf = new JTextField(10);
        starttf = new JTextField(10);
        endtf = new JTextField(10);


        ProceedBtn = new JButton("Proceed");
        ReturnBtn = new JButton("Return");

        //labeluser.setBounds(100, 50, 100, 25);
        labelvenueid.setBounds(100, 80, 100, 25);
        labeldate.setBounds(100, 110, 100, 25);
        labelstart.setBounds(100, 140, 100, 25);
        labelend.setBounds(100, 170, 100, 25);


        //usertf.setBounds(200, 50, 400, 25);
        vidtf.setBounds(200, 80, 400, 25);
        datetf.setBounds(200, 110, 400, 25);
        starttf.setBounds(200, 140, 400, 25);
        endtf.setBounds(200, 170, 400, 25);


        ProceedBtn.setBounds(360, 430, 100, 25);
        ReturnBtn.setBounds(660, 430, 100, 25);


        //MBP.add(labeluser);
        MBP.add(labelvenueid);
        MBP.add(labeldate);
        MBP.add(labelstart);
        MBP.add(labelend);
        //MBP.add(usertf);
        MBP.add(vidtf);
        MBP.add(datetf);
        MBP.add(starttf);
        MBP.add(endtf);
        MBP.add(ProceedBtn);
        MBP.add(ReturnBtn);

        ProceedBtn.addActionListener(this);
        ReturnBtn.addActionListener(this);

        MBP.setVisible(true);

    }



    public static String getVenueID()
    {
        return vidtf.getText();
    }

    public static  String getBookDate()
    {
        return datetf.getText();
    }

    public static String getBookST()
    {
        return starttf.getText();
    }

    public static String getBookET()
    {
        return endtf.getText();
    }





    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == ProceedBtn){
            int resultBtn = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirm Booking?", "Booking Cancelled", resultBtn);
            if(result == JOptionPane.YES_OPTION){
                Booking b = new Booking();
                String[] MBPArray = new String[5];
                MBPArray[0] = LoginPage.getUserID();
                MBPArray[1] = getVenueID();
                MBPArray[2] = getBookDate();
                MBPArray[3] = getBookST();
                MBPArray[4] = getBookET();
                try{
                    b.addBooking(MBPArray[0], MBPArray[1], MBPArray[2], MBPArray[3], MBPArray[4]);
                    JOptionPane.showMessageDialog(null, "Booking Confirmed");
                    MBP.dispose();
                    new OptionPage();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error Saving", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else if(result == JOptionPane.NO_OPTION){
                MBP.dispose();
                new MakeBookingPage();
            }
        }
        else if(e.getSource() == ReturnBtn){
            MBP.dispose();
            new OptionPage();
        }

    }
}