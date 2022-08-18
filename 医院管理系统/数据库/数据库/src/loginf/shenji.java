package loginf;

import Linkd.linkdatebase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class shenji {
    JFrame frame=new JFrame("审核信息");
    JLabel b1=new JLabel("工号");

    JLabel b2=new JLabel("姓名");
    JLabel b3=new JLabel("性别");
    JLabel b4=new JLabel("职称");
    JLabel b5=new JLabel("年龄");
    JLabel b6=new JLabel("电话");
    JLabel b7=new JLabel("科室");

    JLabel b8=new JLabel("密码");//这里可以做个不显示

    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JTextField t5=new JTextField();
    JTextField t6=new JTextField();
    JTextField t7=new JTextField();
    JPasswordField t8=new JPasswordField();

    JButton jb1=new JButton("否决");
    JButton jb2=new JButton("同意");
    public shenji(){
        frame.setBounds(330,150,600,800);

        b1.setBounds(100, 20, 80, 40);
        b1.setFont(new Font("宋体",0,16));


        b2.setBounds(100, 80,80, 40);
        b2.setFont(new Font("宋体",0,16));


        b3.setBounds(100, 140, 80, 40);
        b3.setFont(new Font("宋体",0,16));


        b4.setBounds(100, 200, 80, 40);
        b4.setFont(new Font("宋体",0,16));


        b5.setBounds(100, 260, 80, 40);
        b5.setFont(new Font("宋体",0,16));


        b6.setBounds(100, 320, 80, 40);
        b6.setFont(new Font("宋体",0,16));


        b7.setBounds(100, 380, 80, 40);
        b7.setFont(new Font("宋体",0,16));


        b8.setBounds(100, 440, 80, 40);
        b8.setFont(new Font("宋体",0,16));


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
        t8.setBounds(200,440,200,40);
        t8.setFont(new Font("宋体",0,16));

        jb1.setBounds(100, 500, 80, 40);
        jb1.setFont(new Font("宋体",0,16));
        jb2.setBounds(200,500, 80, 40);
        jb2.setFont(new Font("宋体",0,16));

        jb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs;
                try {
                    ps = conn.prepareStatement("delete from doctors where Dno=?");
                    ps.setObject(1,t1.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    rs = ps.executeQuery();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }});
        jb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs;
                try {
                    ps = conn.prepareStatement("insert into doctoc values(?,?,?,?,?,?,?,?)");
                    ps.setObject(1,t1.getText());
                    ps.setObject(2,t8.getText());
                    ps.setObject(3,t2.getText());
                    ps.setObject(4,t3.getText());
                    ps.setObject(5,t4.getText());
                    ps.setObject(6,t5.getText());
                    ps.setObject(7,t6.getText());
                    ps.setObject(8,t7.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"有信息重复无法通过");
                }finally {
                    try {
                        ps = conn.prepareStatement("delete from doctors where Dno=?");
                        ps.setObject(1,t1.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                try {
                    rs = ps.executeQuery();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }});

        b8.setBounds(100, 440, 80, 40);
        b8.setFont(new Font("宋体",0,16));

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
        frame.add(t8);
        frame.add(jb1);
        frame.add(jb2);


        frame.setLayout(null);
        frame.setVisible(true);
        //接下来是获取数据库的用户信息；

        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        //boolean rs;
        conn = linkdatebase.getConnection();
        String Dno1 = "";
        String Dname1 = "";
        String Dsex1 = "";
        String Dtitle1 = "";
        String Dage1 = "";
        String Dtel1 = "";
        String Deptname1 ="";
        String Paswwd1="";
        String sql = "SELECT Dno,Dname,Dsex,Dtitle,Dage,Dtel,Deptname from Doctors ";
        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()==true){
                 Dno1 = rs.getString(1);
                Dname1= rs.getString(2);
                Dsex1 = rs.getString(3);
                Dtitle1 = rs.getString(4);
                Dage1 = rs.getString(5);
                Dtel1 = rs.getString(6);
                Deptname1 = rs.getString(7);
                System.out.println(Dno1);
                t1.setText(Dno1);
                t2.setText(Dname1);
                t3.setText(Dsex1);
                t4.setText(Dtitle1);
                t5.setText(Dage1);
                t6.setText(Dtel1);
                t7.setText(Deptname1);

            }
    } catch (SQLException e) {
            e.printStackTrace();
        }finally {
          System.out.println("sad;lkf");
        }

    }

    }
