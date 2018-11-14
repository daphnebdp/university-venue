import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddVenuePage extends JFrame implements ActionListener {
    JLabel labelvenueid, labelvenuename, labelvenuecapacity;
    JFrame AAV = new JFrame("Add Venue - University Venue Management System");
    JButton ProceedBtn, ReturnBtn;
    static JTextField vidtf, vntf, vctf;

    public AdminAddVenuePage() {
        AAV.setResizable(false);
        AAV.setSize(900, 500);

        AAV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AAV.setLocationRelativeTo(null);
        AAV.setLayout(null);

        labelvenueid = new JLabel("Venue ID: ");
        labelvenuename = new JLabel("Venue Name: ");
        labelvenuecapacity = new JLabel("Venue Capacity: ");



        vidtf = new JTextField(10);
        vntf = new JTextField(10);
        vctf = new JTextField(10);


        ProceedBtn = new JButton("Proceed");
        ReturnBtn = new JButton("Return");


        labelvenueid.setBounds(100, 80, 100, 25);
        labelvenuename.setBounds(100, 110, 100, 25);
        labelvenuecapacity.setBounds(100, 140, 100, 25);


        vidtf.setBounds(200, 80, 400, 25);
        vntf.setBounds(200, 110, 400, 25);
        vctf.setBounds(200, 140, 400, 25);


        ProceedBtn.setBounds(360, 430, 100, 25);
        ReturnBtn.setBounds(660, 430, 100, 25);



        AAV.add(labelvenueid);
        AAV.add(labelvenuename);
        AAV.add(labelvenuecapacity);
        AAV.add(vidtf);
        AAV.add(vntf);
        AAV.add(vctf);

        AAV.add(ProceedBtn);
        AAV.add(ReturnBtn);

        ProceedBtn.addActionListener(this);
        ReturnBtn.addActionListener(this);

        AAV.setVisible(true);

    }



    public static String getVenueID()
    {
        return vidtf.getText();
    }

    public static  String getVenueName()
    {
        return vntf.getText();
    }

    public static String getVenueCapacity(){
        return vctf.getText();
    }







    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == ProceedBtn){
            int resultBtn = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirm Addition?", "Users Added!", resultBtn);
            if(result == JOptionPane.YES_OPTION){
                String[] MBPArray = new String[3];
                MBPArray[0] = getVenueID();
                MBPArray[1] = getVenueName();
                MBPArray[2] = getVenueCapacity();
                Venue ve = new Venue();
                try{
                    ve.addVenue(MBPArray[0], MBPArray[1], Integer.parseInt(MBPArray[2]));
                    JOptionPane.showMessageDialog(null, "Adding Venue Confirmed");
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
            new AdminViewVenuePage().setVisible(true);
            this.dispose();
        }

    }
}