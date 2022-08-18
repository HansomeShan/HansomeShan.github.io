package doctor;

import Linkd.linkdatebase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class doctorinf implements ActionListener {
    JFrame frame=new JFrame("医生信息 l1.setBounds(50, 60, 100, 20);\n" +
            "        l1.setFont(new Font(\"宋体\",0,16));");
    JButton b1=new JButton("工号");
    // JButton b2=new JButton("密码");//这里可以做个不显示
    JButton b2=new JButton("姓名");
    JButton b3=new JButton("性别");
    JButton b4=new JButton("职称");
    JButton b5=new JButton("年龄");
    JButton b6=new JButton("电话");
    JButton b7=new JButton("科室");
    JButton b8=new JButton("修改");

    JLabel t1=new JLabel();
    JLabel t2=new JLabel();
    JLabel t3=new JLabel();
    JLabel t4=new JLabel();
    JLabel t5=new JLabel();
    JTextField t6=new JTextField();
    JLabel t7=new JLabel();

    String x;
    public doctorinf(){};
    public doctorinf(String x) {
        this.x=x;
        //调用登录信息
        frame.setBounds(330,150,600,700);

        b1.setBounds(100, 20, 80, 40);
        b1.setFont(new Font("宋体",0,16));
        b1.addActionListener(this);

        b2.setBounds(100, 80,80, 40);
        b2.setFont(new Font("宋体",0,16));
        b2.addActionListener(this);

        b3.setBounds(100, 140, 80, 40);
        b3.setFont(new Font("宋体",0,16));
        b3.addActionListener(this);

        b4.setBounds(100, 200, 80, 40);
        b4.setFont(new Font("宋体",0,16));
        b4.addActionListener(this);

        b5.setBounds(100, 260, 80, 40);
        b5.setFont(new Font("宋体",0,16));
        b5.addActionListener(this);

        b6.setBounds(100, 320, 80, 40);
        b6.setFont(new Font("宋体",0,16));
        b6.addActionListener(this);

        b7.setBounds(100, 380, 80, 40);
        b7.setFont(new Font("宋体",0,16));
        b7.addActionListener(this);

        b8.setBounds(420, 440, 80, 40);
        b8.setFont(new Font("宋体",0,16));
        b8.addActionListener(this);

        t1.setBounds(200,20,200,40);
        t1.setFont(new Font("宋体",0,16));
        t2.setBounds(200,80,200,40);
        t2.setFont(new Font("宋体",0,16));
        t3.setBounds(200,140,200,40);
        t3.setFont(new Font("宋体",0,16));
        t4.setBounds(200,200,200,40);
        t4.setFont(new Font("宋体",0,16));
        t5.setBounds(200,260,200,40);
        t5.setFont(new Font("宋体",0,16));
        t6.setBounds(200,320,200,40);
        t6.setFont(new Font("宋体",0,16));
        t7.setBounds(200,380,200,40);
        t7.setFont(new Font("宋体",0,16));




        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(t1);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        frame.add(t6);
        frame.add(t7);

        frame.setLayout(null);
        frame.setVisible(true);
        //接下来是获取数据库的用户信息；

        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        //boolean rs;
        conn = linkdatebase.getConnection();

        String sql = "SELECT Dno,Dname,Dsex,Dtitle,Dage,Dtel,Deptname from Doctor where Dno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,x);
            rs = ps.executeQuery();

            while(rs.next()==true){
                String Dno = rs.getString(1);
                String Dname = rs.getString(2);
                String Dsex = rs.getString(3);
                String Dtitle = rs.getString(4);
                String Dage = rs.getString(5);
                String Dtel = rs.getString(6);
                String Deptname = rs.getString(7);
                System.out.println(Dno);
                t1.setText(Dno);
                t2.setText(Dname);
                t3.setText(Dsex);
                t4.setText(Dtitle);
                t5.setText(Dage);
                t6.setText(Dtel);
                t7.setText(Deptname);

                //dm.addRow(new Object[]{Dno,Dname,Dsex,Dtitle,Dage,Dtel,Deptname});

            }
//            if (rs.next() == true) {
////                if(rs){
//
//                JOptionPane.showMessageDialog(null, "登录成功", "恭喜", JOptionPane.WARNING_MESSAGE);
//                frame.dispose();
//
//            } else {
//                JOptionPane.showMessageDialog(null, "登录失败", "登录失败，重新登录", JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        //boolean rs;
        conn = linkdatebase.getConnection();

        String sql = "Update Doctor set Dtel=?    where Dno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,t6.getText());
            ps.setObject(2,x);
             ps.executeUpdate();
            ps = conn.prepareStatement(sql);
            sql="select * from Doctor where Dno=?";
            ps.setObject(1,x);
            rs=ps.executeQuery();
            while(rs.next()==true){
                String Dno = rs.getString(1);
                String Dname = rs.getString(2);
                String Dsex = rs.getString(3);
                String Dtitle = rs.getString(4);
                String Dage = rs.getString(5);
                String Dtel = rs.getString(6);
                String Deptname = rs.getString(7);
                System.out.println(Dno);
                t1.setText(Dno);
                t2.setText(Dname);
                t3.setText(Dsex);
                t4.setText(Dtitle);
                t5.setText(Dage);
                t6.setText(Dtel);
                t7.setText(Deptname);

                //dm.addRow(new Object[]{Dno,Dname,Dsex,Dtitle,Dage,Dtel,Deptname});

            }
//            if (rs.next() == true) {
////                if(rs){
//
//                JOptionPane.showMessageDialog(null, "登录成功", "恭喜", JOptionPane.WARNING_MESSAGE);
//                frame.dispose();
//
//            } else {
//                JOptionPane.showMessageDialog(null, "登录失败", "登录失败，重新登录", JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
