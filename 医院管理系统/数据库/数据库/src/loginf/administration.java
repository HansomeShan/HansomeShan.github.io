package loginf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import doctor.doctorinf;
import patient.out;
import patient.out3;
import patient.patient;

public class administration implements ActionListener {
    JFrame frame=new JFrame();
    JButton b1=new JButton("管理病人信息");
    JButton b2=new JButton("床位信息");
    JButton b3=new JButton("科室信息");
    JButton b4=new JButton("医生个人信息");
    JButton b5=new JButton("退出登入");
    String x;
    public administration(){};
    public administration(String x) {
        this.x=x;
        //调用登录信息
        frame.setBounds(330,150,600,500);
        b1.setBounds(200, 60, 150, 40);
        b1.setFont(new Font("宋体",0,16));
        b1.addActionListener(this);

        b2.setBounds(200, 120,150, 40);
        b2.setFont(new Font("宋体",0,16));
        b2.addActionListener(this);

        b3.setBounds(200, 180, 150, 40);
        b3.setFont(new Font("宋体",0,16));
        b3.addActionListener(this);

        b4.setBounds(200, 240, 150, 40);
        b4.setFont(new Font("宋体",0,16));
        b4.addActionListener(this);

        b5.setBounds(200,300,150,40);
        b5.setFont(new Font("宋体",0,16));
        b5.addActionListener(this);

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        //frame.add(b5);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        //loginf f=new loginf();
      //   String x=f.tr();

       // administration ad=new administration();
//       doctorinf d=new doctorinf("123");
//
//        patient.out3 ou3=new patient.out3();
//        patient.patient pt=new patient.patient();
//        findinf fi=new findinf();

    }
    public void actionPerformed(ActionEvent e){
        //查询病人信息
        if(e.getSource()==b1){
            patient p=new patient();
        }
        //床位信息
        if(e.getSource()==b2){
            out ou=new out();
        }
        //科室信息
        if(e.getSource()==b3){
            out3 ou=new out3();
        }
        //医生个人信息；
        if(e.getSource()==b4){
            doctorinf d=new doctorinf(x);
        }

    }
}
