package University_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MarksDisplay extends JFrame implements ActionListener{
    String RollNo;
    JButton cancel;
    MarksDisplay(String RollNo){
        this.RollNo = RollNo;

        setSize(550,600);
        setLocation(500,100);

        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel subheading = new JLabel("ITM University Gwalior");
        subheading.setBounds(130,10,500,25);
        subheading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(subheading);

        JLabel heading = new JLabel("Reault Of Examination 2024");
        heading.setBounds(100,50,500,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);


        JLabel lblrollno = new JLabel("Roll No"+RollNo);
        lblrollno.setBounds(60,100,500,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblrollno);

        JLabel lblsemester = new JLabel("");
        lblsemester.setBounds(60,130,500,20);
        lblsemester.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(lblsemester);


        JLabel sub1 = new JLabel();
        sub1.setBounds(60,200,500,25);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(60,230,500,25);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(60,260,500,25);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(60,290,500,25);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(60,320,500,25);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(sub5);

        try {
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from subject where RollNo = '"+RollNo+"'");
        while (rs1.next()){
            sub1.setText(rs1.getString("subject1"));
            sub2.setText(rs1.getString("subject2"));
            sub3.setText(rs1.getString("subject3"));
            sub4.setText(rs1.getString("subject4"));
            sub5.setText(rs1.getString("subject5"));
        }

            ResultSet rs2 = c.s.executeQuery("select * from marks where RollNo = '"+RollNo+"'");
            while (rs2.next()) {
                sub1.setText(sub1.getText()+"-----------"+rs2.getString("marks1"));
                sub2.setText(sub2.getText()+"-----------"+rs2.getString("marks2"));
                sub3.setText(sub3.getText()+"-----------"+rs2.getString("marks3"));
                sub4.setText(sub4.getText()+"-----------"+rs2.getString("marks4"));
                sub5.setText(sub5.getText()+"-----------"+rs2.getString("marks5"));
                lblsemester.setText("Semester " + rs2.getString("semester"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(250,500,120,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("cp",Font.BOLD,15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String args[]){
        new MarksDisplay("");
    }
}
