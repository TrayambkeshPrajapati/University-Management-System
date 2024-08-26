package University_Managment;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search,print,update,add,cancel;

    StudentLeaveDetails(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Search By Roll No");
        heading.setBounds(20,20,150,20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
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


        table = new JTable();


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }


        JScrollPane jp =new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String Query = "select * from studentleave where RollNo = '"+crollno.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(Query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new StudentLeaveDetails();
    }
}
