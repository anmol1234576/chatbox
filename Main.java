import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        JFrame frame =new JFrame("Anmol Chat");
        JLabel namelb,messagelb;
        JTextField nametf, messagetf;
        JButton sendbutton;
        namelb= new JLabel("Name");
        messagelb= new JLabel("Message");


        nametf= new JTextField();
        messagetf = new JTextField();
sendbutton = new JButton("Send");
        namelb.setBounds(20,20,150,30);
        nametf.setBounds(180,20,200,30);

        messagelb.setBounds(20,60,150,30);
        messagetf.setBounds(180,60,200,30);

        sendbutton.setBounds(100,120,150,30);


        frame.add(namelb);
        frame.add(messagelb);
frame.add(nametf);
frame.add(messagetf);
frame.add(sendbutton);





        frame.setLayout(null);
        frame.setResizable(false);
frame.setSize(450,200);
frame.setVisible(true);

sendbutton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(nametf.getText().toString().isEmpty()|| messagetf.getText().toString().isEmpty()){
            JOptionPane.showMessageDialog(null,"PLEASE ENTER NAME AND MESSAGE");

        }
        else {
            String url = "jdbc:mysql://localhost:3306/anmoldb";
            String username = "root";
            String password = "";


            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("Data Base is Connected");
                String insertQuery= "insert into chat" +" values (null,?, ?)";

                PreparedStatement ps =connection.prepareStatement(insertQuery);
                ps.setString(1,nametf.getText().toString());
                ps.setString(2,messagetf.getText().toString());
                ps.execute();
            } catch (SQLException ex) {
                throw new RuntimeException(ex + "DB is not Connected");
            }
        }
    }
});
    }
}