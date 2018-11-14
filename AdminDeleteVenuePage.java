import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDeleteVenuePage extends JFrame implements ActionListener {
    JLabel labelvenueid;
    JFrame ADV = new JFrame("Delete Venue - University Venue Management System");
    JButton ProceedBtn, ReturnBtn;
    static JTextField vidtf;

    public AdminDeleteVenuePage() {
        ADV.setResizable(false);
        ADV.setSize(900, 500);

        ADV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ADV.setLocationRelativeTo(null);
        ADV.setLayout(null);

        labelvenueid = new JLabel("Venue ID: ");


        vidtf = new JTextField(10);


        ProceedBtn = new JButton("Proceed");
        ReturnBtn = new JButton("Return");

        labelvenueid.setBounds(100, 50, 100, 25);


        vidtf.setBounds(200, 50, 400, 25);



        ProceedBtn.setBounds(360, 430, 100, 25);
        ReturnBtn.setBounds(660, 430, 100, 25);


        ADV.add(labelvenueid);
        ADV.add(vidtf);
        ADV.add(ProceedBtn);
        ADV.add(ReturnBtn);

        ProceedBtn.addActionListener(this);
        ReturnBtn.addActionListener(this);

        ADV.setVisible(true);

    }



    public static String getvenueid()
    {
        return vidtf.getText();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == ProceedBtn){
            int resultBtn = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirm Deletion?", "Users Deletion", resultBtn);
            if(result == JOptionPane.YES_OPTION){
                String[] MBPArray = new String[1];
                MBPArray[0] = getvenueid();
                Venue v = new Venue();
                try{
                    v.deleteVenue(MBPArray[0]);
                    JOptionPane.showMessageDialog(null, "Users Deleted");
                    new AdminViewUsersPage().setVisible(true);
                    this.dispose();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error Deleting", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else if(result == JOptionPane.NO_OPTION){
                new AdminViewUsersPage().setVisible(true);
                this.dispose();
            }
        }
        else if(e.getSource() == ReturnBtn){
            new AdminViewUsersPage().setVisible(true);
            this.dispose();
        }

    }
}