import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Admin extends Users{
    protected String adminID;
    protected String adminPass;

    public void addUsers(String userID, String password, String username, String userStatus) {
        File m = new File("userinfo.txt");
        try {
            if (m.exists()) {
                String info = "\n" + userID + ";" + password + ";" + username + ";" + userStatus + "\n";
                FileWriter FileWriter = new FileWriter(m.getAbsoluteFile(), true);
                BufferedWriter BufferedWriter = new BufferedWriter(FileWriter);
                BufferedWriter.append(info);
                BufferedWriter.newLine();
                BufferedWriter.close();
                System.out.println("Done");
                JOptionPane.showMessageDialog(null, "Users successfully added!", "Successful Addition", JOptionPane.INFORMATION_MESSAGE);


            } else
                System.out.println("Failed");

        } catch (Exception e) {
            System.out.println("Whatever");
        }

    }

    public void deleteUsers(String userID) throws IOException {
        Scanner in = new Scanner(System.in);
        File fi = new File("userinfo.txt");
        File tempFile = new File("temp1.txt");

        BufferedReader reader = new BufferedReader(new FileReader(fi));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;


       String lineToRemove;
       lineToRemove = userID;


        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.startsWith(lineToRemove)) continue;
            System.out.println(trimmedLine);
            writer.write((currentLine) + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        Files.move(tempFile.toPath(), fi.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }
    }

