package findinf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class findinf {
    JFrame frame=new JFrame("床位信息");
    JLabel label1=new JLabel("病床号");
    JLabel label2=new JLabel("病房号");
    JLabel label3=new JLabel("目前状态");
    JLabel label4=new JLabel("科室");
    JLabel label5=new JLabel("收费标准");
    JButton button1=new JButton("查询");
    JButton button2=new JButton("修改");

    JTextField text1=new JTextField();
    JTextField text2=new JTextField();
    JTextField text3=new JTextField();
    JTextField text4=new JTextField();
    JTextField text5=new JTextField();
    public findinf(){
        frame.setBounds(300,200,500,500);
        label1.setBounds(50,50,100,30);
        label2.setBounds(50,100,100,30);
        label3.setBounds(50,150,100,30);
        label4.setBounds(50,200,100,30);
        label5.setBounds(50,250,100,30);
        text1.setBounds(150,50,100,30);
        text2.setBounds(150,100,100,30);
        text3.setBounds(150,150,100,30);
        text4.setBounds(150,200,100,30);
        text5.setBounds(150,250,100,30);
        button1.setBounds(50,300,100,30);
        button2.setBounds(150,300,100,30);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(text4);
        frame.add(text5);
        frame.add(button1);
        frame.add(button2);
        frame.setLayout(null);
        frame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=text1.getText();
                String room=text2.getText();
                String state=text3.getText();
                String dep=text4.getText();
                String fee=text5.getText();
                if(id.equals("")||room.equals("")||state.equals("")||dep.equals("")||fee.equals("")){
                    JOptionPane.showMessageDialog(null,"请输入完整信息");
                }
                else{
                    JOptionPane.showMessageDialog(null,"查询成功");
                }
            }
    });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=text1.getText();
                String room=text2.getText();
                String state=text3.getText();
                String dep=text4.getText();
                String fee=text5.getText();
                if(id.equals("")||room.equals("")||state.equals("")||dep.equals("")||fee.equals("")){
                    JOptionPane.showMessageDialog(null,"请输入完整信息");
                }
                else{
                    JOptionPane.showMessageDialog(null,"修改成功");
                }
            }
        });
}
    public static void main(String[] args) {
        new findinf();
    }
}
