import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CancelBookingPage extends JFrame implements ActionListener {

    JLabel BookingID;

    static JTextField BDTextField;


    JButton CancelBtn, ReturnBtn;

    JTable Table = new JTable();
    DefaultTableModel model;

    JFrame DFrame = new JFrame("Cancel Booking");


    public CancelBookingPage()
    {

        DFrame.setResizable(false);
        DFrame.setSize(900,500);

        DFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFrame.setLocationRelativeTo(null);
        DFrame.setLayout(null);

        model = new DefaultTableModel();
        Table.setModel(model);

        Table.setBackground(Color.LIGHT_GRAY);
        Table.setForeground(Color.black);
        Font font = new Font("",1,22);
        Table.setFont(font);
        Table.setRowHeight(30);

        BookingID = new JLabel("Booking ID: ");


        BDTextField = new JTextField(10);



        CancelBtn = new JButton("Cancel Booking");
        ReturnBtn = new JButton("Return Booking");

        BookingID.setBounds(20, 220, 100, 25);


        BDTextField.setBounds(160, 220, 100, 25);


        CancelBtn.setBounds(310, 265, 100, 25);
        ReturnBtn.setBounds(310, 310, 100, 25);

        DFrame.setLayout(null);

        DFrame.add(BookingID);

        DFrame.add(BDTextField);


        DFrame.add(CancelBtn);
        DFrame.add(ReturnBtn);


        CancelBtn.addActionListener(this);
        ReturnBtn.addActionListener(this);

        DFrame.setVisible(true);

    }

    public static String getBookID()
    {
        return BDTextField.getText();
    }





    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == CancelBtn){
            try{

                Booking l = new Booking();
                    l.deleteBooking(Integer.parseInt(getBookID()), LoginPage.getUserID());
                    JOptionPane.showMessageDialog(null, "Booking Cancelled");
                    DFrame.dispose();
                    new OptionPage();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else if(e.getSource() == ReturnBtn){
            DFrame.dispose();
            new OptionPage();
        }
    }
}