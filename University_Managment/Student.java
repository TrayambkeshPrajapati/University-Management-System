package University_Managment;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student extends JFrame implements ActionListener {

    JTextField rollnos,frame,fframe,lbaddr,lbpno,lbTenth,lbTwelth,lbEmail,lbAdhar;
    JDateChooser dc;
    JComboBox cbcourse,cbranch;
    JButton submit,cancel;

    Student(){
        setSize(900, 700);

        setLocation(350,70);
        setLayout(null);
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Student Name");
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


        JLabel RollNo = new JLabel("Roll Number");
        RollNo.setBounds(50,200,200,30);
        RollNo.setFont(new Font("serif",Font.BOLD,20));
        add(RollNo);

        rollnos = new JTextField();
        rollnos.setBounds(200,200,150,30);
        rollnos.setFont(new Font("serif",Font.BOLD,20));
        add(rollnos);


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


        JLabel Adhar= new JLabel("Aadhar Number");
        Adhar.setBounds(400,350,200,30);
        Adhar.setFont(new Font("serif",Font.BOLD,20));
        add(Adhar);

        lbAdhar = new JTextField();
        lbAdhar.setBounds(600,350,150,30);
        add(lbAdhar);

        JLabel Course = new JLabel("Course");
        Course.setBounds(50,400,200,30);
        Course.setFont(new Font("serif",Font.BOLD,20));
        add(Course);


        String scourse[] = {"B.Tech","BCA","BBA","MCA","MBA","B.Com","Bsc","Msc","M.Tech"};
        cbcourse = new JComboBox(scourse);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);


        JLabel Branch = new JLabel("Branch");
        Branch.setBounds(400,400,200,30);
        Branch.setFont(new Font("serif",Font.BOLD,20));
        add(Branch);


        String sbranch[] = {"Normal","Computer Science Engineering.","Mechanical Engineering.","Civil Engineering.","Electronics & Communication Engineering.","Electrical Engineering"};
        cbranch = new JComboBox(sbranch);
        cbranch.setBounds(600,400,150,30);
        cbranch.setBackground(Color.white);
        add(cbranch);



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
            String RollNo = rollnos.getText();
            String dob = ((JTextField) dc.getDateEditor().getUiComponent()).getText();
            String address = lbaddr.getText();
            String Pno = lbpno.getText();
            String Tenth = lbTenth.getText();
            String Twelth = lbTwelth.getText();
            String email = lbEmail.getText();
            String Aadhar = lbAdhar.getText();
            String Course = (String) cbcourse.getSelectedItem();
            String Branch = (String) cbranch.getSelectedItem();

            try {
                String Querry = "insert into student values('"+name+"','"+fname+"','"+RollNo+"','"+dob+"','"+address+"','"+Pno+"','"+Tenth+"','"+Twelth+"','"+email+"','"+Aadhar+"','"+Course+"','"+Branch+"')";
                Conn con = new Conn();
                con.s.executeUpdate(Querry);

                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new Student();
    }
}
