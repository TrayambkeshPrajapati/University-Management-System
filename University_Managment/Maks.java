package University_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Maks extends JFrame implements ActionListener {
Choice crollnos;
JComboBox cesemister;
JButton cancel,submit;
JTextField tf1,tf2,tf3,tf4,tf5,mk1,mk2,mk3,mk4,mk5;
    Maks(){
        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image I2 = I1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(500,40,400,300);
        add(image);

        JLabel heading = new JLabel("Enter Maks Of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,20));
        add(heading);

        JLabel lblrollno = new JLabel("Select Roll No");
        lblrollno.setBounds(50,70,150,20);
        lblrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollno);

        crollnos = new Choice();
        crollnos.setBounds(200,70,150,20);
        add(crollnos);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()){
                crollnos.add(rs.getString("RollNo"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel csemister = new JLabel("Select Semester");
        csemister.setBounds(50,110,150,20);
        csemister.setFont(new Font("serif",Font.PLAIN,20));
        add(csemister);

        String semester[] ={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        cesemister = new JComboBox(semester);
        cesemister.setBounds(200,110,150,20);
        add(cesemister);

        cesemister.setBackground(Color.white);
        setVisible(true);

        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100,150,200,40);
        add(lblentersubject);

        JLabel lblmaks = new JLabel("Enter Marks");
        lblmaks.setBounds(320,150,200,40);
        add(lblmaks);

        tf1 = new JTextField();
        tf1.setBounds(50,200,200,20);
        add(tf1);

        tf2 = new JTextField();
        tf2.setBounds(50,230,200,20);
        add(tf2);

        tf3 = new JTextField();
        tf3.setBounds(50,260,200,20);
        add(tf3);

        tf4 = new JTextField();
        tf4.setBounds(50,290,200,20);
        add(tf4);

        tf5 = new JTextField();
        tf5.setBounds(50,320,200,20);
        add(tf5);

        mk1 = new JTextField();
        mk1.setBounds(250,200,200,20);
        add(mk1);

        mk2 = new JTextField();
        mk2.setBounds(250,230,200,20);
        add(mk2);

        mk3 = new JTextField();
        mk3.setBounds(250,260,200,20);
        add(mk3);

        mk4 = new JTextField();
        mk4.setBounds(250,290,200,20);
        add(mk4);

        mk5 = new JTextField();
        mk5.setBounds(250,320,200,20);
        add(mk5);

        submit = new JButton("Update");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tp",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Close");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("cp",Font.BOLD,15));
        add(cancel);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            try{
                Conn c = new Conn();
                String Query1 = "insert into subject values('"+crollnos.getSelectedItem()+"','"+cesemister.getSelectedItem()+"', '"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"')";
                String Query2 = "insert into marks values('"+crollnos.getSelectedItem()+"','"+cesemister.getSelectedItem()+"', '"+mk1.getText()+"','"+mk2.getText()+"','"+mk3.getText()+"','"+mk4.getText()+"','"+mk5.getText()+"')";
                c.s.executeUpdate(Query1);
                c.s.executeUpdate(Query2);

                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new Maks();
    }
}
