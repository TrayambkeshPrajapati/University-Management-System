package University_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField U,P;

    Login(){

     getContentPane().setBackground(Color.white);
     setLayout(null);
     JLabel tusername = new JLabel("Username");
     tusername.setBounds(40,20,100,20);
     add(tusername);

     U = new JTextField();
     U.setBounds(150,20,150,20);
     add(U);


        JLabel tpassword = new JLabel("Password");
        tpassword.setBounds(40,70,100,20);
        add(tpassword);

        P = new JPasswordField();
        P.setBounds(150,70,150,20);
        add(P);

    login = new JButton("Login");
    login.setBounds(40,140,120,30);
    login.setBackground(Color.black);
    login.setForeground(Color.white);
    login.addActionListener(this);
    login.setFont(new Font("tp",Font.BOLD,15));
    add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("cp",Font.BOLD,15));
        add(cancel);


        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image I2 = I1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(350,20,200,200);
        add(image);


    setSize(600,300);
    setLocation(500,250);
    setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login){
            String username = U.getText();
            String password = P.getText();

            String query ="select * from Login where username='"+username+"' and password='"+password+"'";
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);

            if(rs.next()){
                setVisible(false);
                new University();
            }else {
                JOptionPane.showMessageDialog(null,"invalid username or password");
                setVisible(false);
            }
            c.s.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        Login L = new Login();
    }
}
