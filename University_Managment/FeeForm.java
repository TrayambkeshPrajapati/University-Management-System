package University_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class FeeForm extends JFrame implements ActionListener {
    Choice crollnos;
    JComboBox cbcourse,cbranch,cesemister;
    JLabel total,lbltotal;
    JButton submit,PayFee,cancel;
    FeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image I2 = I1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel lblrollno = new JLabel("Select Roll No");
        lblrollno.setBounds(40,60,150,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblrollno);

        crollnos = new Choice();
        crollnos.setBounds(200,60,150,20);
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

        JLabel name = new JLabel("Student Name");
        name.setBounds(40,100,150,20);
        name.setFont(new Font("serif",Font.BOLD,16));
        add(name);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(40,140,150,20);
        fname.setFont(new Font("serif",Font.BOLD,16));
        add(fname);

        JLabel labelfather = new JLabel();
        labelfather.setBounds(200,140,150,20);
        labelfather.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelfather);


        try{
            Conn c = new Conn();
            String Querry = "Select * from student where RollNo ='"+crollnos.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(Querry);
            while (rs.next()){
                labelname.setText(rs.getString("name"));
                labelfather.setText(rs.getString("fname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        crollnos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c = new Conn();
                    String Querry = "Select * from student where RollNo ='"+crollnos.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(Querry);
                    while (rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfather.setText(rs.getString("fname"));
                    };
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        JLabel Course = new JLabel("Course");
        Course.setBounds(40,180,150,20);
        Course.setFont(new Font("serif",Font.PLAIN,16));
        add(Course);


        String scourse[] = {"B.Tech","BCA","BBA","MCA","MBA","B.Com","Bsc","Msc","M.Tech"};
        cbcourse = new JComboBox(scourse);
        cbcourse.setBounds(200,180,150,16);
        cbcourse.setBackground(Color.white);
        add(cbcourse);


        JLabel Branch = new JLabel("Branch");
        Branch.setBounds(40,220,150,16);
        Branch.setFont(new Font("serif",Font.PLAIN,16));
        add(Branch);


        String sbranch[] = {"Normal","Computer Science Engineering.","Mechanical Engineering.","Civil Engineering.","Electronics & Communication Engineering.","Electrical Engineering"};

        cbranch = new JComboBox(sbranch);
        cbranch.setBounds(200,220,150,16);
        cbranch.setBackground(Color.white);
        add(cbranch);

        JLabel csemister = new JLabel("Select Semester");
        csemister.setBounds(40,260,150,20);
        csemister.setFont(new Font("serif",Font.PLAIN,20));
        add(csemister);

        String semester[] ={"semester1","semester2","Semester3","Semester4","semester5","semester6","semester7","semester8"};
        cesemister = new JComboBox(semester);
        cesemister.setBounds(200,260,150,20);
        add(cesemister);

        total = new JLabel("Total Fee");
        total.setBounds(40,300,150,20);
        total.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(total);

        lbltotal = new JLabel();
        lbltotal.setBounds(200,300,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);

        submit = new JButton("Update");
        submit.setBounds(30,380,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tp",Font.BOLD,15));
        add(submit);

        PayFee = new JButton("Pay Fee");
        PayFee.setBounds(150,380,100,25);
        PayFee.setBackground(Color.black);
        PayFee.setForeground(Color.white);
        PayFee.addActionListener(this);
        PayFee.setFont(new Font("cp",Font.BOLD,15));
        add(PayFee);

        cancel = new JButton("Back");
        cancel.setBounds(270,380,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("cp",Font.BOLD,15));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cesemister.getSelectedItem();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from fee where course = '"+course+"'");
                while (rs.next()){
                total.setText(rs.getString(semester));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == PayFee) {
            String RollNo = crollnos.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cesemister.getSelectedItem();
            String branch = (String) cbranch.getSelectedItem();
            String total = lbltotal.getText();
            try{
                Conn c = new Conn();

                String Query = "insert into feedetails values('"+RollNo+"','"+course+"','"+semester+"','"+branch+"','"+total+"')";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null,"College Fee SUbmitted SuccessFully");
            }catch (Exception e){
                e.printStackTrace();
            }


        }else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new FeeForm();
    }
}
