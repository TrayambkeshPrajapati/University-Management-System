package University_Managment;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {
    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;

    StudentLeave(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);

        getContentPane().setBackground(Color.YELLOW);

        JLabel heading = new JLabel("Apply Leave For Students");
        heading.setBounds(120,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lblrollno = new JLabel("Search By Roll No");
        lblrollno.setBounds(170,100,150,20);
        lblrollno.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(145,130,200,20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()){
                crollno.add(rs.getString("RollNo"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(220,180,200,20);
        lblDate.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblDate);

        dcdate = new JDateChooser();
        dcdate.setBounds(145,210,200,25);
        add(dcdate);


        JLabel time = new JLabel("Time Duration");
        time.setBounds(190,260,200,20);
        time.setFont(new Font("Tahoma",Font.BOLD,15));
        add(time);

        ctime = new Choice();
        ctime.setBounds(145,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(120,350,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tp",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Close");
        cancel.setBounds(270,350,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("cp",Font.BOLD,15));
        add(cancel);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String RollNo = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String Querry = "insert into studentleave values('"+RollNo+"','"+date+"','"+duration+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(Querry);
                JOptionPane.showMessageDialog(null,"Leave COnformed");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new StudentLeave();
    }
}
