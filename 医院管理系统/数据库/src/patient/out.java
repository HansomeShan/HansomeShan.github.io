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
//该窗体不需要 了
public class out {
    JFrame f=new JFrame("病人信息结果");
    JLabel l1=new JLabel("姓名");
    JLabel l2=new JLabel("性别");
    JLabel l3=new JLabel("病例号");
    JLabel l4=new JLabel("医师工号");
    JTextArea o1=new JTextArea();
    JTextArea o2=new JTextArea();
    JTextArea o3=new JTextArea();
    JTextArea o4=new JTextArea();
    // 生成一个查询按钮
    JButton b1=new JButton("查询");
    public out(){
        f.setBounds(330,150,500,600);
        l1.setBounds(50, 60, 100, 20);
        l1.setFont(new Font("宋体",0,16));
        l2.setBounds(50, 120, 100, 20);
        l2.setFont(new Font("宋体",0,16));
        l3.setBounds(50, 180, 100, 20);
        l3.setFont(new Font("宋体",0,16));
        l4.setBounds(50, 240, 100, 20);
        l4.setFont(new Font("宋体",0,16));
        o1.setBounds(150, 60, 100, 20);
        o1.setFont(new Font("宋体",0,16));
        o2.setBounds(150, 120, 100, 20);
        o2.setFont(new Font("宋体",0,16));
        o3.setBounds(150, 180, 100, 20);
        o3.setFont(new Font("宋体",0,16));
        o4.setBounds(150, 240, 100, 20);
        o4.setFont(new Font("宋体",0,16));
        b1.setBounds(270, 300, 100, 20);
        b1.setFont(new Font("宋体",0,16));
        
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(o1);
        f.add(o2);
        f.add(o3);
        f.add(o4);
        f.add(b1);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = o1.getText();
                String sex = o2.getText();
                String pid = o3.getText();
                String docid = o4.getText();
                System.out.println("sdaslfk;");
                Connection conn;
                PreparedStatement ps;
                ResultSet rs;
                //boolean rs;
                conn = linkdatebase.getConnection();
                String sql = "select * from patient where name=? and sex=? and pid=? and docid=?";
            }
        });
    };
}