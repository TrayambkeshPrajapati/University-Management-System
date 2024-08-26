package University_Managment;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FacultyDetails extends JFrame implements ActionListener {

    Choice cempid;
    JTable table;
    JButton search,print,update,add,cancel;

    FacultyDetails(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Search By Emp Id");
        heading.setBounds(20,20,150,20);
        add(heading);

        cempid = new Choice();
        cempid.setBounds(180,20,150,20);
        add(cempid);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        table = new JTable();


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }


        JScrollPane jp =new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        search = new JButton("Search");
        search.setBounds(10,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(420,70,80,20);
        update.addActionListener(this);
        add(update);

        add = new JButton("Add");
        add.setBounds(620,70,80,20);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(800,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String Query = "select * from teacher where empid = '"+cempid.getSelectedItem()+"'";
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
        }else if(ae.getSource() == add){
            setVisible(false);
            new Teacher();
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new FacultyDetails();
    }
}
