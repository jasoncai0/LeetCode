package ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


/**
 * Created by zhensheng on 2016/5/4.
 */



public class TimerPrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println(now);
        Toolkit.getDefaultToolkit().beep();
    }
    public static void main(String[]args){
        ActionListener al = new TimerPrinter();
        Timer t=  new Timer(10000,al);
        t.start();

        JOptionPane.showMessageDialog(null,"QUIT?");
        System.exit(0);
    }

}
