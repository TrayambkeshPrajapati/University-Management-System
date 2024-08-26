package University_Managment;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Result extends JFrame implements ActionListener {

    JTextField search;
    JButton submit,cancel;
    JTable table;

    Result(){
        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,15,400,20);
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);


        search = new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);

        submit = new JButton("Result");
        submit.setBounds(300,90,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tp",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(440,90,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("cp",Font.BOLD,15));
        add(cancel);

        table = new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));

        JScrollPane jcp = new JScrollPane(table);
        jcp.setBounds(0,130,1000,300);
        add(jcp);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            setVisible(false);
            new MarksDisplay(search.getText());
        }else {
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new Result();
    }
}