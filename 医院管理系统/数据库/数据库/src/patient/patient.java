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
public class patient {
    JFrame f=new JFrame("病人信息");
    JLabel l1=new JLabel("姓名");
    JLabel l2=new JLabel("性别");
    JLabel l3=new JLabel("病例号");
    JLabel l4=new JLabel("医师工号");
    JLabel l5=new JLabel("联系电话");
    JLabel l6=new JLabel("病房号");
    JLabel l7=new JLabel("病床号");
    JLabel l8=new JLabel("入院日期");
    JLabel l9=new JLabel("诊断结果");
    JLabel l10=new JLabel("出院日期");
    JButton b1=new JButton("查询");
    JButton b2=new JButton("清空");
    JLabel o=new JLabel("请输入单个独立查询信息");
    JTextArea o1=new JTextArea();
    JTextArea o2=new JTextArea();
    JTextArea o3=new JTextArea();
    JTextArea o4=new JTextArea();
    JTextArea o5=new JTextArea();
    JTextArea o6=new JTextArea();
    JTextArea o7=new JTextArea();
    JTextArea o8=new JTextArea();
    JTextArea o9=new JTextArea();
    JTextArea o10=new JTextArea();
    public patient(){

        o.setBounds(50, 20, 200, 20);
        o.setFont(new Font("宋体",0,16));
        f.add(o);
        f.setBounds(330,150,500,800);
        l1.setBounds(50, 60, 100, 20);
        l1.setFont(new Font("宋体",0,16));
        l2.setBounds(50, 120, 100, 20);
        l2.setFont(new Font("宋体",0,16));
        l3.setBounds(50, 180, 100, 20);
        l3.setFont(new Font("宋体",0,16));
        l4.setBounds(50, 240, 100, 20);
        l4.setFont(new Font("宋体",0,16));
        l5.setBounds(50, 300, 100, 20);
        l5.setFont(new Font("宋体",0,16));
        l6.setBounds(50, 360, 100, 20);
        l6.setFont(new Font("宋体",0,16));
        l7.setBounds(50, 420, 100, 20);
        l7.setFont(new Font("宋体",0,16));
        l8.setBounds(50, 480, 100, 20);
        l8.setFont(new Font("宋体",0,16));
        l9.setBounds(50, 540, 100, 20);
        l9.setFont(new Font("宋体",0,16));
        l10.setBounds(50, 600, 100, 20);
        l10.setFont(new Font("宋体",0,16));
        o1.setBounds(150, 60, 150, 50);
        o2.setBounds(150, 120, 150, 50);
        o3.setBounds(150, 180, 150, 50);
        o4.setBounds(150, 240, 150, 50);
        o5.setBounds(150, 300, 150, 50);
        o6.setBounds(150, 360, 150, 50);
        o7.setBounds(150, 420, 150, 50);
        o8.setBounds(150, 480, 150, 50);
        o9.setBounds(150, 540, 150, 50);
        o10.setBounds(150, 600, 150, 50);
        b1.setBounds(50, 700, 100, 20);
        b2.setBounds(200, 700, 100, 20);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(l8);
        f.add(l9);
        f.add(l10);
        f.add(o1);
        f.add(o2);
        f.add(o3);
        f.add(o4);
        f.add(o5);
        f.add(o6);
        f.add(o7);
        f.add(o8);
        f.add(o9);
        f.add(o10);
        f.add(b1);
        f.add(b2);
        f.setLayout(null);
        f.setVisible(true);
        //  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // 从各个输入窗口获取信息用于查询
                String name1=o1.getText();
                String sex1=o2.getText();
                String pid1=o3.getText();
                String docid1=o4.getText();
                String phone1=o5.getText();
                String rid1=o6.getText();
                String bid1=o7.getText();
                String enter_date1=o8.getText();
                String result1="";
                String out_date1="";
                Connection conn;
                PreparedStatement ps = null;
                ResultSet rs = null;
                //boolean rs;
                conn=linkdatebase.getConnection();
                String sql="select * from patient where name=? or sex=? or pid=? or docid=? or phone=? or rid=? or bid=? or enter_date=? ";
                try {
                    ps=conn.prepareStatement(sql);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try{
                    try {
                        ps.setString(1,name1);
                        ps.setString(2,sex1);
                        ps.setString(3,pid1);
                        ps.setString(4,docid1);
                        ps.setString(5,phone1);
                        ps.setString(6,rid1);
                        ps.setString(7,bid1);
                        ps.setString(8,enter_date1);
                        rs=ps.executeQuery();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    int n=0;
                if(rs.next()!=true){
                    JOptionPane.showMessageDialog(null,"查无此人");
                }
                else{  o1.setText("");
                    name1="";
                    sex1="";
                    pid1="";
                    docid1="";
                    phone1="";
                    rid1="";
                    bid1="";
                    enter_date1="";
                    while(rs.next()==true){
                    name1+=rs.getString("name")+"\n";
                    sex1+=rs.getString("sex")+"\n";
                    pid1+=rs.getString("pid")+"\n";
                    docid1+=rs.getString("docid")+"\n";
                    phone1+=rs.getString("phone")+"\n";
                    rid1+=rs.getString("rid")+"\n";
                    bid1+=rs.getString("bid")+"\n";
                    enter_date1+=rs.getString("enter_date")+"\n";
                    result1+=rs.getString("result");
                    out_date1+=rs.getString("out_date")+"\n";
                    n++;
                    }
                    if(n<=3){
                    o1.setText(name1);
                    o2.setText(sex1);
                    o3.setText(pid1);
                    o4.setText(docid1);
                    o5.setText(phone1);
                    o6.setText(rid1);
                    o7.setText(bid1);
                    o8.setText(enter_date1);
                    o9.setText(result1);
                    o10.setText(out_date1);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"查询数据过多");
                }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // 清空所有输入窗口
                o1.setText("");
                o2.setText("");
                o3.setText("");
                o4.setText("");
                o5.setText("");
                o6.setText("");
                o7.setText("");
                o8.setText("");
                o9.setText("");
                o10.setText("");
            }});
        }

}
