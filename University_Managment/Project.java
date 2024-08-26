package University_Managment;

import javax.swing.*;
import java.awt.*;

public class Project extends JFrame implements Runnable {
    Thread t;
    Project() {
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/ITMU.jpg"));
        Image I2 = I1.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        add(image);

        t = new Thread(this);
        t.start();

        setVisible(true);

            setLocation(0,0);
            setSize(1540,850);
            try{
                Thread.sleep(10);
            } catch (Exception e){}
        }
    public  void  run(){
        try {
            Thread.sleep(2000);
            setVisible(false);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        Project P = new Project();
    }
}