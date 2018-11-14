import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    protected int BookingID;
    protected String BookingDate;
    protected String BookingStartTime;
    protected String BookingEndTime;

    Venue v = new Venue();
    String venueID = v.venueID;

    Users u = new Users();
    String userID = u.userID;
    Date TransactDate;

    public Booking() {

    }

    private static Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new Date(today.getTime());

    }

    private static double getRandom(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }


    public void addBooking(String venueID, String userID, String BookingDate, String BookingStartTime, String BookingEndTime) {
        File m = new File("bookinginfo.txt");
        try {
            if (m.exists()) {
                String info = "\n" + getRandom(1, 5000) + ";" + userID + ";" + venueID + ";" + BookingDate + ";" + BookingStartTime + ";" + BookingEndTime + ";" + getCurrentDate() + "\n";
                FileWriter FileWriter = new FileWriter(m.getAbsoluteFile(), true);
                BufferedWriter BufferedWriter = new BufferedWriter(FileWriter);
                BufferedWriter.append(info);
                BufferedWriter.newLine();
                BufferedWriter.close();
                FileWriter.close();
                System.out.println("Done");

                JOptionPane.showMessageDialog(null, "Booking Made!", "Successful Booking", JOptionPane.INFORMATION_MESSAGE);


            } else
                System.out.println("Failed");

        } catch (Exception e) {
            System.out.println("Whatever");
        }
    }

    public void deleteBooking(int BookingID) throws FileNotFoundException, IOException {

        Scanner in = new Scanner(System.in);
        File inputFile = new File("bookinginfo.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;


        int lineToRemove = BookingID;
        String www = String.valueOf(lineToRemove);


        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.startsWith(www)) continue;
            System.out.println(trimmedLine);
            writer.write((currentLine) + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }

    public String displayBooking(String u) throws IOException {
        //JTextArea textArea = null;
        String text = null;
        String textLine= " ";
        String user,BI,VI,BD,BS,BE,TD;

        try{


            FileReader fr = new FileReader("bookinginfo.txt");
            BufferedReader br = new BufferedReader(fr);
                Scanner sc = new Scanner(fr);
                String delimiter = ";";
                sc.useDelimiter(delimiter);
                sc.nextLine();
                sc.nextLine();
                do {
                    BI = sc.next();
                    VI = sc.next();
                    if (u.equals(user = sc.next())) {
                        BD = sc.next();
                        BS = sc.next();
                        BE = sc.next();
                        TD = sc.next();
                        sc.nextLine();
                        textLine = textLine + BI + " " + VI + " " + user + " " + BD + " " + BS + " " + BE + " " + "\n";
                    }
                else{
                    sc.nextLine();
                }
                }while(sc.hasNextLine() == true);
            sc.close();
            br.close();
            fr.close();

        }catch(IOException ioe){
            ioe.getMessage();
        }
        //textLine = "Ey" + "\n";
        return textLine;

    }

}



