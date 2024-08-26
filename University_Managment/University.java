package University_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class University extends JFrame implements ActionListener {
    University() {

        setSize(1540, 850);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/GALAXY.jpg"));
        Image I2 = I1.getImage().getScaledInstance(1540, 790, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        add(image);

        JMenuBar mb = new JMenuBar();
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.red);
        mb.add(newInformation);

        JMenuItem Faculty = new JMenuItem("New Faculty Information");
        Faculty.setBackground(Color.white);
        Faculty.addActionListener(this);
        newInformation.add(Faculty);

        JMenuItem Student = new JMenuItem("New Student Information");
        Student.setBackground(Color.white);
        Student.addActionListener(this);
        newInformation.add(Student);

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.red);
        mb.add(details);

        JMenuItem FacultyDetails = new JMenuItem("Faculty details");
        FacultyDetails.setBackground(Color.white);
        FacultyDetails.addActionListener(this);
        details.add(FacultyDetails);

        JMenuItem StudentDetails = new JMenuItem("Student details");
        StudentDetails.setBackground(Color.white);
        StudentDetails.addActionListener(this);
        details.add(StudentDetails);


        JMenu Leave = new JMenu("Apply Leave");
        Leave.setForeground(Color.red);
        mb.add(Leave);

        JMenuItem FacultyLeave = new JMenuItem("Faculty Leave");
        FacultyLeave.setBackground(Color.white);
        FacultyLeave.addActionListener(this);
        Leave.add(FacultyLeave);

        JMenuItem StudentLeave = new JMenuItem("Student Leave");
        StudentLeave.setBackground(Color.white);
        StudentLeave.addActionListener(this);
        Leave.add(StudentLeave);

        JMenu LeaveDetails = new JMenu("Leave Details");
        LeaveDetails.setForeground(Color.red);
        mb.add(LeaveDetails);

        JMenuItem FacultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        FacultyLeaveDetails.setBackground(Color.white);
        FacultyLeaveDetails.addActionListener(this);
        LeaveDetails.add(FacultyLeaveDetails);

        JMenuItem StudentLeaveDetails = new JMenuItem("Student Leave Details");
        StudentLeaveDetails.setBackground(Color.white);
        StudentLeaveDetails.addActionListener(this);
        LeaveDetails.add(StudentLeaveDetails);


        JMenu Exam = new JMenu("Examination");
        Exam.setForeground(Color.red);
        mb.add(Exam);

        JMenuItem Result = new JMenuItem("Results");
        Result.setBackground(Color.white);
        Result.addActionListener(this);
        Exam.add(Result);

        JMenuItem Maks = new JMenuItem("Enter Marks");
        Maks.setBackground(Color.white);
        Maks.addActionListener(this);
        Exam.add(Maks);
        
        JMenu Update = new JMenu("Update Info");
        Update.setForeground(Color.red);
        mb.add(Update);

        JMenuItem UpdateFaculty = new JMenuItem("Update Faculty Info");
        UpdateFaculty.setBackground(Color.white);
        UpdateFaculty.addActionListener(this);
        Update.add(UpdateFaculty);

        JMenuItem UpdateStudent = new JMenuItem("Update Student Info");
        UpdateStudent .setBackground(Color.white);
        UpdateStudent .addActionListener(this);
        Update.add(UpdateStudent);


        JMenu Fee = new JMenu("Fee");
        Fee.setForeground(Color.red);
        mb.add(Fee);

        JMenuItem FeeStructure = new JMenuItem("Fee Structure");
        FeeStructure.setBackground(Color.white);
        FeeStructure .addActionListener(this);
        Fee.add(FeeStructure);

        JMenuItem FeeForm = new JMenuItem("Fee Form");
        FeeForm.setBackground(Color.white);
        FeeForm .addActionListener(this);
        Fee.add(FeeForm);


        JMenu Exit = new JMenu("Exit");
        Exit.setForeground(Color.red);
        mb.add(Exit);

        JMenuItem Ex = new JMenuItem("Exit");
        Ex.setBackground(Color.white);
        Ex.addActionListener(this);
        Exit.add(Ex);

        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("New Faculty Information")) {
            new Teacher();
        } else if (msg.equals("New Student Information")) {
            new Student();
        } else if (msg.equals("Faculty details")) {
            new FacultyDetails();
        } else if (msg.equals("Student details")) {
            new StudentDetails();
        } else if (msg.equals("Faculty Leave")) {
            new FacultyLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Faculty Leave Details")) {
            new FacultyLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (msg.equals("Enter Marks")) {
            new Maks();
        } else if (msg.equals("Update Faculty Info")) {
            new UpdateFaculty();
        } else if(msg.equals("Update Student Info")){
          new UpdateStudent();
        }else if(msg.equals("Results")){
            new Result();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("Fee Form")) {
            new FeeForm();
        }
    }

        public static void main (String args[]){
            new University();
        }
    }