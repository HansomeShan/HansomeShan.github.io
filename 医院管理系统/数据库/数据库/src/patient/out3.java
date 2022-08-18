package patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Linkd.linkdatebase;

public class out3 {
    JFrame f=new JFrame("科室修改表");
    JLabel l1=new JLabel("科室编号");
    JLabel l2=new JLabel("科室名称");
    JLabel l3=new JLabel("科室地址");
    JTextArea t1=new JTextArea();
    JTextArea t2=new JTextArea();
    JTextArea t3=new JTextArea();
    JButton b1=new JButton("查询");
    JButton b2=new JButton("清空");
    JButton b3=new JButton("修改");
    public out3(){
        f.setBounds(330,150,500,300);
        l1.setBounds(50, 60, 150, 20);
        l1.setFont(new Font("宋体",0,16));
        l2.setBounds(50, 120, 150, 20);
        l2.setFont(new Font("宋体",0,16));
        l3.setBounds(50, 180, 150, 20);
        l3.setFont(new Font("宋体",0,16));
        t1.setBounds(160, 60, 150, 40);
        t1.setFont(new Font("宋体",0,16));
        t2.setBounds(160, 120, 150, 40);
        t2.setFont(new Font("宋体",0,16));
        t3.setBounds(160, 180, 150, 40);
        t3.setFont(new Font("宋体",0,16));


        b1.setBounds(320, 60, 150, 40);
        b1.setFont(new Font("宋体",0,16));
        b1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id1=t1.getText();
                String name1=t2.getText();
                String address1=t3.getText();
                Connection con=linkdatebase.getConnection();
                PreparedStatement ps=null;
                ResultSet rs=null;
               try {
                   ps = con.prepareStatement("select * from departmen where name=? or address=? or id=?");
                   ps.setString(1, name1);
                   ps.setString(2, address1);
                   ps.setString(3, id1);
                   rs=ps.executeQuery();

                   f.dispose();
               }catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
                try {
                    if(rs.next()!=true){
                        JOptionPane.showMessageDialog(null,"没有此科室");
                    }
                    else{
                        name1=rs.getString("name");
                        address1=rs.getString("address1");
                        id1= rs.getString("id1");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }});

        b2.setBounds(320, 120, 150, 40);
        b2.setFont(new Font("宋体",0,16));
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                t1.setText("");
                t2.setText("");
                t3.setText("");
            }});

        b3.setBounds(320, 180, 150, 40);
        b3.setFont(new Font("宋体",0,16));
        b3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=t1.getText();
                String name=t2.getText();
                String address=t3.getText();
                Connection con=linkdatebase.getConnection();
                PreparedStatement ps=null;
                try {
                    ps=con.prepareStatement("update department set name=?,address=? where id=?");
                    ps.setString(1,name);
                    ps.setString(2,address);
                    ps.setString(3,id);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"修改成功");
                    f.dispose();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setLayout(null);
        f.setVisible(true);
    }
}
