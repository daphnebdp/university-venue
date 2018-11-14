import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Venue {
    protected String venueID;
    protected String venueName;
    protected int venueCapacity;

    public Venue(){
        venueID = "";
        venueName = "";
        venueCapacity = 0;
    }

    public void Venue(String venueid, String venuename, int venuecapacity){
        venueID = venueid;
        venueName = venuename;
        venueCapacity = venuecapacity;


    }

    public void addVenue(String venueID, String venueName, int venueCapacity){
        File m = new File("venueinfo.txt");
        try {
            if (m.exists()) {
                String info = "\n" + venueID + ";" + venueName + ";" + venueCapacity + "\n";
                FileWriter FileWriter = new FileWriter(m.getAbsoluteFile(), true);
                BufferedWriter BufferedWriter = new BufferedWriter(FileWriter);
                BufferedWriter.append(info);
                BufferedWriter.newLine();
                BufferedWriter.close();
                System.out.println("Done");
                JOptionPane.showMessageDialog(null, "Venue Added!", "Successful Addition", JOptionPane.INFORMATION_MESSAGE);


            } else
                System.out.println("Failed");

        } catch (Exception e) {
            System.out.println("Whatever");
        }
    }



    public void deleteVenue(String venueID) throws IOException {
        Scanner in = new Scanner(System.in);
        File le = new File("venueinfo.txt");
        File tempFile = new File("temp2.txt");

        BufferedReader reader = new BufferedReader(new FileReader(le));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;


        String lineToRemove;
        lineToRemove = venueID;


        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.startsWith(lineToRemove)) continue;
            System.out.println(trimmedLine);
            writer.write((currentLine) + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        Files.move(tempFile.toPath(), le.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }
}
