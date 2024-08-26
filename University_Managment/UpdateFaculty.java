package University_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateFaculty extends JFrame implements ActionListener {

    JTextField jD,lbaddr,lbpno,lbEmail,jQ;
    JLabel emids;
    JButton submit,cancel;
    Choice  cempids;

    UpdateFaculty(){
        setSize(900, 700);
        setLocation(350,70);

        setLayout(null);
        JLabel heading = new JLabel("Update Faculty Details");
        heading.setBounds(250,10,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,35));
        heading.setForeground(Color.white);
        add(heading);

        JLabel lblrollno = new JLabel("Select Emp Id");
        lblrollno.setBounds(50,100,200,20);
        lblrollno.setFont(new Font("serif",Font.PLAIN,20));
        lblrollno.setForeground(Color.white);
        add(lblrollno);

        cempids = new Choice();
        cempids.setBounds(250,100,200,20);
        add(cempids);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){
                cempids.add(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel name = new JLabel("Teacher Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        name.setForeground(Color.white);
        add(name);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tohoma",Font.PLAIN,18));
        labelname.setForeground(Color.white);
        add(labelname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        fname.setForeground(Color.white);
        add(fname);

        JLabel labelfather = new JLabel();
        labelfather.setBounds(600,150,150,30);
        labelfather.setFont(new Font("Tohoma",Font.PLAIN,18));
        labelfather.setForeground(Color.white);
        add(labelfather);

        JLabel EMpID = new JLabel("Emp iD");
        EMpID.setBounds(50,200,200,30);
        EMpID.setFont(new Font("serif",Font.BOLD,20));
        EMpID.setForeground(Color.white);
        add(EMpID);

        emids = new JLabel();
        emids.setBounds(200,200,200,30);
        emids.setFont(new Font("serif",Font.BOLD,20));
        emids.setForeground(Color.white);
        add(emids);


        JLabel DOB = new JLabel("Enter D.O.B");
        DOB.setBounds(400,200,200,30);
        DOB.setFont(new Font("serif",Font.BOLD,20));
        DOB.setForeground(Color.white);
        add(DOB);

        JLabel lbldc = new JLabel();
        lbldc.setBounds(600,200,150,30);
        lbldc.setFont(new Font("Tohoma",Font.PLAIN,18));
        lbldc.setForeground(Color.white);
        add(lbldc);

        JLabel Address = new JLabel("Address");
        Address.setBounds(50,250,200,30);
        Address.setFont(new Font("serif",Font.BOLD,20));
        Address.setForeground(Color.white);
        add(Address);

        lbaddr = new JTextField();
        lbaddr.setBounds(200,250,150,30);
        add(lbaddr);


        JLabel Pno = new JLabel("Phone No");
        Pno.setBounds(400,250,200,30);
        Pno.setFont(new Font("serif",Font.BOLD,20));
        Pno.setForeground(Color.white);
        add(Pno);

        lbpno = new JTextField();
        lbpno.setBounds(600,250,150,30);
        add(lbpno);


        JLabel Tenth = new JLabel("10th (%)");
        Tenth.setBounds(50,300,200,30);
        Tenth.setFont(new Font("serif",Font.BOLD,20));
        Tenth.setForeground(Color.white);
        add(Tenth);

        JLabel lblTenth = new JLabel();
        lblTenth.setBounds(200,300,150,30);
        lblTenth.setFont(new Font("Tohoma",Font.PLAIN,18));
        lblTenth.setForeground(Color.white);
        add(lblTenth);

        JLabel  Twelth= new JLabel("12th (%)");
        Twelth.setBounds(400,300,200,30);
        Twelth.setFont(new Font("serif",Font.BOLD,20));
        Twelth.setForeground(Color.white);
        add(Twelth);

        JLabel lblTwelth = new JLabel();
        lblTwelth.setBounds(600,300,150,30);
        lblTwelth.setFont(new Font("Tohoma",Font.PLAIN,18));
        lblTwelth.setForeground(Color.white);
        add(lblTwelth);


        JLabel Email = new JLabel("Email ID");
        Email.setBounds(50,350,200,30);
        Email.setFont(new Font("serif",Font.BOLD,20));
        Email.setForeground(Color.white);
        add(Email);

        lbEmail = new JTextField();
        lbEmail.setBounds(200,350,150,30);
        add(lbEmail);


        JLabel Adhar= new JLabel("Aadhar Number");
        Adhar.setBounds(400,350,200,30);
        Adhar.setFont(new Font("serif",Font.BOLD,20));
        Adhar.setForeground(Color.white);
        add(Adhar);

        JLabel lblAdhar = new JLabel();
        lblAdhar.setBounds(600,350,150,30);
        lblAdhar.setFont(new Font("Tohoma",Font.PLAIN,18));
        lblAdhar.setForeground(Color.white);
        add(lblAdhar);

        JLabel Course = new JLabel("Qualification");
        Course.setBounds(50,400,200,30);
        Course.setFont(new Font("serif",Font.BOLD,20));
        Course.setForeground(Color.white);
        add(Course);


        jQ = new JTextField();
        jQ.setBounds(200,400,150,30);
        add(jQ);


        JLabel Branch = new JLabel("Branch");
        Branch.setBounds(400,400,200,30);
        Branch.setFont(new Font("serif",Font.BOLD,20));
        Branch.setForeground(Color.white);
        add(Branch);

        jD = new JTextField();
        jD.setBounds(600,400,150,30);
        add(jD);


        try{
            Conn c = new Conn();
            String Querry = "Select * from teacher where empid ='"+cempids.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(Querry);
            while (rs.next()){
                labelname.setText(rs.getString("name"));
                labelfather.setText(rs.getString("fname"));
                emids.setText(rs.getString("empid"));
                lbldc.setText(rs.getString("dob"));
                lbaddr.setText(rs.getString("address"));
                lbpno.setText(rs.getString("pbo"));
                lblTenth.setText(rs.getString("Tehnth"));
                lblTwelth.setText(rs.getString("Twelth"));
                lbEmail.setText(rs.getString("email"));
                lblAdhar.setText(rs.getString("Aadhr"));
                jQ.setText(rs.getString("Qualification"));
                jD.setText(rs.getString("Department"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cempids.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c = new Conn();
                    String Querry = "Select * from teacher where empid ='"+cempids.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(Querry);
                    while (rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfather.setText(rs.getString("fname"));
                        emids.setText(rs.getString("empid"));
                        lbldc.setText(rs.getString("dob"));
                        lbaddr.setText(rs.getString("address"));
                        lbpno.setText(rs.getString("pbo"));
                        lblTenth.setText(rs.getString("Tehnth"));
                        lblTwelth.setText(rs.getString("Twelth"));
                        lbEmail.setText(rs.getString("email"));
                        lblAdhar.setText(rs.getString("Aadhr"));
                        jQ.setText(rs.getString("Qualification"));
                        jD.setText(rs.getString("Department"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tp",Font.BOLD,15));
        submit.setBackground(Color.BLUE);
        add(submit);

        cancel = new JButton("Close");
        cancel.setBounds(500,500,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("cp",Font.BOLD,15));
        cancel.setBackground(Color.BLUE);
        add(cancel);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/WOW.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(0,0,900,700);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String empid = emids.getText();
            String address = lbaddr.getText();
            String Pno = lbpno.getText();
            String email = lbEmail.getText();
            String Qualification = jQ.getText();
            String Department = jD.getText();
            try {
                String Querry = "update teacher set address = '"+address+"', Pbo = '"+Pno+"', email = '"+email+"',Qualification = '"+Qualification+"',Department ='"+Department+"' where empid='"+empid+"'";
                Conn con = new Conn();
                con.s.executeUpdate(Querry);

                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new UpdateFaculty();
    }
}