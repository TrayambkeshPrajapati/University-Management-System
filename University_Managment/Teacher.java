package University_Managment;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Teacher extends JFrame implements ActionListener {

    JTextField empid,frame,fframe,lbaddr,lbpno,lbTenth,lbTwelth,lbEmail,lbAdhar;
    JDateChooser dc;
    JComboBox cbQualification,cbDepartment;
    JButton submit,cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L + 1000L));


    Teacher(){
        setSize(900, 700);
        setLocation(350,70);

        setLayout(null);
        JLabel heading = new JLabel("New Faculty Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Faculty Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        frame = new JTextField();
        frame.setBounds(200,150,150,30);
        add(frame);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        fframe = new JTextField();
        fframe.setBounds(600,150,150,30);
        add(fframe);

        JLabel EMPIDS = new JLabel("Faculty Id");
        EMPIDS.setBounds(50,200,200,30);
        EMPIDS.setFont(new Font("serif",Font.BOLD,20));
        add(EMPIDS);

        empid = new JTextField();
        empid.setBounds(200,200,150,30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);


        JLabel DOB = new JLabel("Enter D.O.B");
        DOB.setBounds(400,200,200,30);
        DOB.setFont(new Font("serif",Font.BOLD,20));
        add(DOB);

        dc = new JDateChooser();
        dc.setBounds(600,200,150,30);
        add(dc);

        JLabel Address = new JLabel("Address");
        Address.setBounds(50,250,200,30);
        Address.setFont(new Font("serif",Font.BOLD,20));
        add(Address);

        lbaddr = new JTextField();
        lbaddr.setBounds(200,250,150,30);
        add(lbaddr);


        JLabel Pno = new JLabel("Phone No");
        Pno.setBounds(400,250,200,30);
        Pno.setFont(new Font("serif",Font.BOLD,20));
        add(Pno);

        lbpno = new JTextField();
        lbpno.setBounds(600,250,150,30);
        add(lbpno);


        JLabel Tenth = new JLabel("10th (%)");
        Tenth.setBounds(50,300,200,30);
        Tenth.setFont(new Font("serif",Font.BOLD,20));
        add(Tenth);

        lbTenth = new JTextField();
        lbTenth.setBounds(200,300,150,30);
        add(lbTenth);

        JLabel  Twelth= new JLabel("12th (%)");
        Twelth.setBounds(400,300,200,30);
        Twelth.setFont(new Font("serif",Font.BOLD,20));
        add(Twelth);

        lbTwelth = new JTextField();
        lbTwelth.setBounds(600,300,150,30);
        add(lbTwelth);


        JLabel Email = new JLabel("Email ID");
        Email.setBounds(50,350,200,30);
        Email.setFont(new Font("serif",Font.BOLD,20));
        add(Email);

        lbEmail = new JTextField();
        lbEmail.setBounds(200,350,150,30);
        add(lbEmail);


        JLabel Adhar= new JLabel("Aadhaar Number");
        Adhar.setBounds(400,350,200,30);
        Adhar.setFont(new Font("serif",Font.BOLD,20));
        add(Adhar);

        lbAdhar = new JTextField();
        lbAdhar.setBounds(600,350,150,30);
        add(lbAdhar);

        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);


        String sQualification[] = {"B.Ed","M.Ed","PRT", "TGT", "PGT","MBA","M.Tech","PHD","CTET"};
        cbQualification = new JComboBox(sQualification);
        cbQualification.setBounds(200,400,150,30);
        cbQualification.setBackground(Color.white);
        add(cbQualification);


        JLabel  Department= new JLabel("Department");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);


        String sDepartment[] = {"Computer Science Engineering.","Mechanical Engineering.","Civil Engineering.","Electronics & Communication Engineering.","Electrical Engineering"};

        cbDepartment = new JComboBox(sDepartment);
        cbDepartment.setBounds(600,400,150,30);
        cbDepartment.setBackground(Color.white);
        add(cbDepartment);



        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tp",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Close");
        cancel.setBounds(500,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("cp",Font.BOLD,15));
        add(cancel);


        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/Back.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(0,0,900,700);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = frame.getText();
            String fname = fframe.getText();
            String EMPIDS = empid.getText();
            String dob = ((JTextField) dc.getDateEditor().getUiComponent()).getText();
            String address = lbaddr.getText();
            String Pno = lbpno.getText();
            String Tenth = lbTenth.getText();
            String Twelth = lbTwelth.getText();
            String email = lbEmail.getText();
            String Aadhar = lbAdhar.getText();
            String Qualification = (String) cbQualification.getSelectedItem();
            String Deapartment = (String) cbDepartment.getSelectedItem();

            try {
                String Querry = "insert into teacher values('"+name+"','"+fname+"','"+EMPIDS+"','"+dob+"','"+address+"','"+Pno+"','"+Tenth+"','"+Twelth+"','"+email+"','"+Aadhar+"','"+Qualification+"','"+Deapartment+"')";
                Conn con = new Conn();
                con.s.executeUpdate(Querry);

                JOptionPane.showMessageDialog(null,"Faculty Details Inserted Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new Teacher();
    }
}
