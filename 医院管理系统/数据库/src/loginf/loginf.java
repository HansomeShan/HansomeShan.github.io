package loginf;

import Linkd.linkdatebase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class loginf implements ActionListener {
    JFrame f = new JFrame("医院管理系统登录界面");
    JLabel l1 = new JLabel("用户名");
    JLabel l2 = new JLabel("密码");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton b1 = new JButton("登入");
    JButton b2 = new JButton("注册");
    JButton b3 = new JButton("忘记密码");


   public String tr(){
        return t1.getText();
    }

    //这里要返回判断是否登录成功 可以用一个文件记录登录信息：用时间范围来确保：

    public loginf() {
        f.setBounds(330, 150, 500, 300);

        l1.setBounds(50, 60, 50, 20);
        l1.setFont(new Font("宋体", 0, 16));

        l2.setBounds(50, 120, 50, 20);
        l2.setFont(new Font("宋体", 0, 16));

        t1.setBounds(110, 60, 150, 40);
        t1.setFont(new Font("宋体", 0, 16));

        t2.setBounds(110, 120, 150, 40);
        t2.setFont(new Font("宋体", 0, 16));

        b1.setBounds(270, 120, 150, 40);
        b1.setFont(new Font("宋体", 0, 16));
        b1.addActionListener(this);

        b2.setBounds(100, 170, 100, 40);
        b2.setFont(new Font("宋体", 0, 16));
        b2.addActionListener(this);

        b3.setBounds(210, 170, 100, 40);
        b3.setFont(new Font("宋体", 0, 16));
        b3.addActionListener(this);

        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(t2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setLayout(null);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
       boolean b=false;
       //登录用
        if (e.getSource() == b1) {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            //boolean rs;
            conn = linkdatebase.getConnection();
            String account = t1.getText();
            String passward = t2.getText();
            String sql = "select Dno,Dpassword from Doctor where Dno=? and Dpassword=?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, account);
                ps.setString(2, passward);
                System.out.println(account);
                System.out.println(passward);
                rs = ps.executeQuery();
                if (rs.next() == true) {
//                if(rs){
                    b=true;
                    JOptionPane.showMessageDialog(null, "登录成功", "恭喜", JOptionPane.WARNING_MESSAGE);
                    f.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "登录失败", "登录失败，重新登录", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            finally {
                if(account=="123")
                {
                    shenji ji=new shenji();
                };
                if(b==true) {
                    administration ad = new administration(account);
                }
            }


        }
        //注册
        if (e.getSource() == b2) {
            class indoctrinator implements ActionListener {
                JFrame frame = new JFrame();
                JButton b1 = new JButton("工号");
                // JButton b2=new JButton("密码");//这里可以做个不显示
                JButton b2 = new JButton("姓名");
                JButton b3 = new JButton("性别");
                JButton b4 = new JButton("职称");
                JButton b5 = new JButton("年龄");
                JButton b6 = new JButton("电话");
                JButton b7 = new JButton("科室");
                JButton b9 = new JButton("密码");
                JButton b10=new JButton("再次输入");
                JButton b8 = new JButton("注册");

                JTextField t1 = new JTextField();
                JTextField t2 = new JTextField();
                JTextField t3 = new JTextField();
                JTextField t4 = new JTextField();
                JTextField t5 = new JTextField();
                JTextField t6 = new JTextField();
                JTextField t7 = new JTextField();
                JPasswordField t8 = new JPasswordField();

                public indoctrinator() {
                    //调用登录信息
                    frame.setBounds(330, 150, 800, 800);

                    b1.setBounds(100, 20, 80, 40);
                    b1.setFont(new Font("宋体", 0, 16));
                    b1.addActionListener(this);

                    b2.setBounds(100, 80, 80, 40);
                    b2.setFont(new Font("宋体", 0, 16));
                    b2.addActionListener(this);

                    b3.setBounds(100, 140, 80, 40);
                    b3.setFont(new Font("宋体", 0, 16));
                    b3.addActionListener(this);

                    b4.setBounds(100, 200, 80, 40);
                    b4.setFont(new Font("宋体", 0, 16));
                    b4.addActionListener(this);

                    b5.setBounds(100, 260, 80, 40);
                    b5.setFont(new Font("宋体", 0, 16));
                    b5.addActionListener(this);

                    b6.setBounds(100, 320, 80, 40);
                    b6.setFont(new Font("宋体", 0, 16));
                    b6.addActionListener(this);

                    b7.setBounds(100, 380, 80, 40);
                    b7.setFont(new Font("宋体", 0, 16));
                    b7.addActionListener(this);

                    b9.setBounds(100, 440, 80, 40);
                    b9.setFont(new Font("宋体", 0, 16));
                    b9.addActionListener(this);

                    b10.setBounds(100, 500, 80, 40);
                    b10.setFont(new Font("宋体", 0, 16));
                    b10.addActionListener(this);

                    b8.setBounds(420, 440, 80, 40);
                    b8.setFont(new Font("宋体", 0, 16));
                    b8.addActionListener(this);

                    t1.setBounds(200, 20, 200, 40);
                    t1.setFont(new Font("宋体", 0, 16));
                    t2.setBounds(200, 80, 200, 40);
                    t2.setFont(new Font("宋体", 0, 16));
                    t3.setBounds(200, 140, 200, 40);
                    t3.setFont(new Font("宋体", 0, 16));
                    t4.setBounds(200, 200, 200, 40);
                    t4.setFont(new Font("宋体", 0, 16));
                    t5.setBounds(200, 260, 200, 40);
                    t5.setFont(new Font("宋体", 0, 16));
                    t6.setBounds(200, 320, 200, 40);
                    t6.setFont(new Font("宋体", 0, 16));
                    t7.setBounds(200, 380, 200, 40);
                    t7.setFont(new Font("宋体", 0, 16));

                    t8.setBounds(200, 440, 200, 40);
                    t8.setFont(new Font("宋体", 0, 16));

                    frame.add(b1);
                    frame.add(b2);
                    frame.add(b3);
                    frame.add(b4);
                    frame.add(b5);
                    frame.add(b6);
                    frame.add(b7);
                    frame.add(b8);
                    frame.add(b9);
                    frame.add(t1);
                    frame.add(t1);
                    frame.add(t2);
                    frame.add(t3);
                    frame.add(t4);
                    frame.add(t5);
                    frame.add(t6);
                    frame.add(t7);
                    frame.add(t8);

                    frame.setLayout(null);
                    frame.setVisible(true);
                    //接下来是获取数据库的用户信息；
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == b8){
                    Connection conn;
                    PreparedStatement ps;
                    ResultSet rs;
                    //boolean rs;
                    conn = linkdatebase.getConnection();

//                        Dno CHAR(10) PRIMARY KEY,
//                        Dpassword VARCHAR(15) NOT NULL,
//                        Dname CHAR(20) NOT NULL,
//                        Dsex CHAR(2) NOT NULL,
//                        Dtitle CHAR(10) NOT NULL,
//                        Dage SMALLINT NOT NULL,
//                        Dtel CHAR(11) NOT NULL,
//                        Deptname CHAR(20) NOT NULL,
                    String Dno1 = t1.getText().trim();
                    String Dpassward1 = t8.getText().trim();
                    String Dname1 = t2.getText().trim();
                    String Dsex1 = t3.getText().trim();
                    String Dtitle1 = t4.getText().trim();
                    String Dage1 = t5.getText().trim();
                    String Dtel1 = t6.getText().trim();
                    String Deptname1 = t7.getText().trim();
                        try {
                    String sql = "insert into doctors vaules(?,?,?,?,?,?,?,?,?)";
                    ////dagai
                           // System.out.println("sdafjhksd");
//                        ps = conn.prepareStatement(sql);
//                        ps.setObject(1, Dno1);
//                        ps.setObject(2, Dpassward1);
//                        ps.setObject(3, Dname1);
//                        ps.setObject(4, Dsex1);
//                        ps.setObject(5, Dtitle1);
//                        ps.setObject(6, Dage1);
//                        ps.setObject(7, Dtel1);
//                        ps.setObject(8, Deptname1);
//                        ps.setObject(9,0);


                            ps = conn.prepareStatement(sql);
                            ps.setObject(1, Dno1);
                            ps.setObject(2, Dpassward1);
                            ps.setObject(3, Dname1);
                            ps.setObject(4, Dsex1);
                            ps.setObject(5, Dtitle1);
                            ps.setObject(6, Dage1);
                            ps.setObject(7, Dtel1);
                            ps.setObject(8, Deptname1);
                            ps.setObject(9,0);


                        System.out.println(Dno1);
                        System.out.println(Dpassward1);
                        boolean rest=ps.execute();
                       if (rest!= true) {

                           JOptionPane.showMessageDialog(null, "注册成功", "恭喜", JOptionPane.WARNING_MESSAGE);
                           f.dispose();


                       }
                        System.out.println("dsafk;l");
                        JOptionPane.showMessageDialog(null, "����ɹ���", "ϵͳ��ʾ",JOptionPane.PLAIN_MESSAGE);
                        frame.dispose();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }finally {
                            //linkdatabase.closeAll(rs, ps, con);
                        };
                    }
                };
            };

                indoctrinator indo = new indoctrinator();
            }
            //忘记密码
            if (e.getSource() == b3) {

            }
        }
        ;

    public static void main(String[] args) {
        loginf l=new loginf();
    }
}
