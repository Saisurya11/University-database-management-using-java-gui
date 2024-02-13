import java.io.*;
import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class adminpass
{
JTextField userid;
void ad1()
{
JFrame fram1=new JFrame("ADMIN");

//
Font originalFont = new Font("Arial", Font.PLAIN, 30);
Font newFont = originalFont.deriveFont(30f);

JLabel Adminpage=new JLabel("Adminpage");
Adminpage.setBounds(130,0,190,50);
Adminpage.setFont(newFont);
fram1.add(Adminpage);
//

fram1.getContentPane().setBackground(Color.CYAN);
JLabel la1=new JLabel("Enter user id");
JLabel la2=new JLabel("Enter password");
la1.setBounds(50,50,170,30);
la2.setBounds(50,100,170,30);
fram1.add(la1);
fram1.add(la2);


userid=new JTextField();
JTextField pass=new JTextField();
userid.setBounds(220,50,170,30);
pass.setBounds(220,100,170,30);
fram1.add(userid);
fram1.add(pass);

JButton con =new JButton("CONFIRM");
con.setBounds(120,150,90,50);
fram1.add(con);

con.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
if(userid.getText().equals("User") && pass.getText().equals("pass"))
{
admin ob=new admin();
ob.admin1();
}  else{
JOptionPane.showMessageDialog(null, "Invalid Admin ID or password");
}
}
});


JButton exit2=new JButton("EXIT");
exit2.setBounds(220,150,90,50);
fram1.add(exit2);
exit2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
fram1.dispose();
}


});

fram1.setSize(500, 600); 
fram1.setLayout(null);
fram1.setVisible(true); 
}

}

//

class admin
{
void admin1()
{


JFrame f1=new JFrame();
JButton bu1=new JButton("create student id");
f1.getContentPane().setBackground(Color.CYAN);
bu1.setBounds(50,50,170,50);
f1.add(bu1); 

bu1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
studentidcreation obj=new studentidcreation();
 }  
 });

JButton bu2=new JButton(" Add Announcements");
bu2.setBounds(50,120,270,50);
f1.add(bu2); 

JTextField tf=new JTextField("Enter Announcements");
tf.setBounds(400,100,500,300);
f1.add(tf);

bu2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
String lin=tf.getText();

Announcements obj=new Announcements(lin);
}
});



JButton bu3=new JButton("enter CGPA");
bu3.setBounds(50,190,170,50);
f1.add(bu3);
bu3.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{

CGPA ob=new CGPA();

}});



JButton bu4=new JButton("EXIT");
bu4.setBounds(50,260,170,50);
f1.add(bu4);

bu4.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
f1.dispose();
}
});


f1.setSize(1000, 700); 
f1.setLayout(null);
f1.setVisible(true); 
}
}

//

class CGPA
{
CGPA()
{
JFrame framecgpa=new JFrame("CGPA");
framecgpa.getContentPane().setBackground(Color.CYAN);

JTextField usr=new JTextField("enter user name");
usr.setBounds(100,100,200,40);
framecgpa.add(usr);

JTextField cgpaval=new JTextField("enter cgpa");
cgpaval.setBounds(400,100,200,40);
framecgpa.add(cgpaval);

JButton save=new JButton("SAVE");
save.setBounds(300,200,200,40);
framecgpa.add(save);

save.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
try{
FileReader stud_f=new FileReader("Student_details.txt");
BufferedReader br = new BufferedReader(stud_f);
String line;
int flag=0;

String cgpa1=cgpaval.getText();
while ((line = br.readLine()) != null) {
String[] parts = line.split("\\|");
String id = parts[3].trim();
if(usr.getText().equals(id))
{
try
{
BufferedWriter CGPA1=new BufferedWriter(new FileWriter("CGPA.txt",true));
CGPA1.write(id+"|"+cgpa1+"\n");
JOptionPane.showMessageDialog(null, "succesfully created");
flag=1;
CGPA1.close();
}
catch(IOException ex1)
{
}
}
if (flag==0)
{
JOptionPane.showMessageDialog(null, "no id  found");
}
}
br.close();
}
catch (IOException ex) 
{
System.out.println("file not found of CGPA");
//ex.printStackTrace();
}
}});

JButton exit2=new JButton("EXIT");
exit2.setBounds(900,600,100,30);
framecgpa.add(exit2);

exit2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
framecgpa.dispose();
}
});
framecgpa.setSize(1000, 700); 
framecgpa.setLayout(null);
framecgpa.setVisible(true); 
}
}
//
class Announcements
{

Announcements(String LINE)
{
try
{
FileWriter OBJ=new FileWriter("Announcements.txt");
BufferedWriter Announce=new BufferedWriter(OBJ);
Announce.write(LINE+"\n");
Announce.close();
}
catch(IOException e1)
{
System.out.println("file creation failed of Announcements");
}
}
}

class studentidcreation
{
studentidcreation()
{
JFrame f2=new JFrame();
f2.getContentPane().setBackground(Color.CYAN);

JLabel l2 = new JLabel("NAME");
l2.setBounds(50, 50, 170, 30);
f2.add(l2);

JTextField name=new JTextField();
name.setBounds(220,50,170,30);
f2.add(name);

JLabel l5 = new JLabel("Father Name");
l5.setBounds(50, 100, 170, 30);
f2.add(l5);

JTextField f_name=new JTextField();
f_name.setBounds(220,100,170,30);
f2.add(f_name);

JLabel l4 = new JLabel("Password");
l4.setBounds(50, 150, 170, 30);
f2.add(l4);

JTextField pass=new JTextField();
pass.setBounds(220,150,170,30);
f2.add(pass);

JLabel l3 = new JLabel("PHONE NUMBER");
l3.setBounds(50, 200, 170, 30);
f2.add(l3);

JTextField number=new JTextField();
number.setBounds(220,200,170,30);
f2.add(number);


JLabel l6 =new JLabel("user name");
l6.setBounds(50,250,170,30);
f2.add(l6);

JTextField username=new JTextField();
username.setBounds(220,250,170,30);
f2.add(username);



JButton save=new JButton("SAVE");
save.setBounds(120,300,100,30);
f2.add(save);
save.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
save_student object = new save_student(name, f_name, pass, number, username);
f2.dispose();
}
});


JButton exit2=new JButton("EXIT");
exit2.setBounds(260,300,100,30);
f2.add(exit2);

exit2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
f2.dispose();
}
});

f2.setSize(500, 600); 
f2.setLayout(null);
f2.setVisible(true); 
}
}

//

class save_student extends studentidcreation
{
save_student(JTextField name, JTextField f_name, JTextField pass, JTextField number, JTextField username)
{
super();
String phone=number.getText();
String s_name=name.getText();
String father_name=f_name.getText();
String passwo=pass.getText();
String userna=username.getText();
try{
FileWriter stud_file=new FileWriter("Student_details.txt",true);
BufferedWriter stud=new BufferedWriter(stud_file);
stud.write(s_name+"|"+father_name+"|"+phone+"|"+userna+"|"+passwo+"\n");
JOptionPane.showMessageDialog(null, "Succesfully created");
stud.close();
}
catch(IOException e)
{
System.out.println("file not foundof save_student");
}
}
}

//

class Student extends studentpass
{
JLabel la;
Student(String ide)
{
JFrame fr1=new JFrame("Student Page");
fr1.getContentPane().setBackground(Color.CYAN);
la=new JLabel();
la.setBounds(500,1,150,200);
fr1.add(la);

JLabel wel=new JLabel("welcome to the student block");
wel.setBounds(30,0,280,30);
fr1.add(wel);

JButton Studentinfo=new JButton("StudentInfo");
Studentinfo.setBounds(50,50,150,30);
fr1.add(Studentinfo);
Studentinfo.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
try{
FileReader stud_f=new FileReader("Student_details.txt");
BufferedReader br = new BufferedReader(stud_f);
String line;
while ((line = br.readLine()) != null) {
String[] parts = line.split("\\|");
String name=parts[0].trim();
String f_name=parts[1].trim();
String num=parts[2].trim();
String id = parts[3].trim();
String password = parts[4].trim();
if(ide.equals(id))
{
la.setText("<html>----INFO----<br/>name="+name+",<br/>father name="+f_name+",<br/>number="+num+", <br/>id="+id+"<br/>,pass="+password+"</html>");
}
}
br.close();
}
catch (IOException ex) 
{
System.out.println("file not found of student");
//ex.printStackTrace();
}

}
});

JButton marks=new JButton("CGPA");
marks.setBounds(50,150,100,30);
fr1.add(marks);
marks.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
String line;
//cgpa file
try
{
BufferedReader CGPA1=new BufferedReader(new FileReader("CGPA.txt"));
while ((line = CGPA1.readLine()) != null) {
String[] parts = line.split("\\|");
String id1=parts[0].trim();
String gpa = parts[1].trim();
if(ide.equals(id1)){
la.setText("<html>CGPA :- <br/>"+gpa+"<html>");
CGPA1.close();
}}}
catch(IOException eo2)
{

}


}
});

JButton fee=new JButton("Announcements");
fee.setBounds(50,250,100,30);
fr1.add(fee);
fee.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
try{
FileReader OBJ=new FileReader("Announcements.txt");
BufferedReader Announce=new BufferedReader(OBJ);
String line=Announce.readLine();
la.setText("<html>Announcements:-<br/><html>"+line);

Announce.close();
}
catch(IOException e1)
{
System.out.println("announcements of student");
}
}
});

JButton exit2=new JButton("EXIT");
exit2.setBounds(900,600,90,50);
fr1.add(exit2);
exit2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
fr1.dispose();
}


});


fr1.setSize(1000, 700); 
fr1.setLayout(null);
fr1.setVisible(true); 

}
}

//

class studentpass
{
void studp()
{
JFrame fram1=new JFrame("Student");

Font originalFont = new Font("Arial", Font.PLAIN, 30);
Font newFont = originalFont.deriveFont(30f);

JLabel Adminpage=new JLabel("Student Page");
Adminpage.setBounds(130,0,190,50);
Adminpage.setFont(newFont);
fram1.add(Adminpage);

fram1.getContentPane().setBackground(Color.CYAN);
JLabel la1=new JLabel("Enter Student id");
JLabel la2=new JLabel("Enter Student password");
la1.setBounds(50,50,170,30);
la2.setBounds(50,100,170,30);
fram1.add(la1);
fram1.add(la2);


JTextField userid=new JTextField();
JTextField pass=new JTextField();
userid.setBounds(220,50,170,30);
pass.setBounds(220,100,170,30);
fram1.add(userid);
fram1.add(pass);

JButton con =new JButton("CONFIRM");
con.setBounds(120,150,90,50);
fram1.add(con);

con.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
try{
FileReader stud_f=new FileReader("Student_details.txt");
BufferedReader br = new BufferedReader(stud_f);
String line;
while ((line = br.readLine()) != null) {
String[] parts = line.split("\\|");
String id = parts[3].trim();
String password = parts[4].trim();
if (userid.getText().equals(id) && pass.getText().equals(password)) {
br.close();
Student OBJ=new Student(id);
}
else
{
JOptionPane.showMessageDialog(null, "Invalid student ID or password");
br.close();
}
}

}
catch (IOException eo1) 
{
}

}
});


JButton exit2=new JButton("EXIT");
exit2.setBounds(220,150,90,50);
fram1.add(exit2);
exit2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
fram1.dispose();
}


});

fram1.setSize(500, 600); 
fram1.setLayout(null);
fram1.setVisible(true); 
}
}



class man {
public static void main(String[] args)
{
JFrame frame= new JFrame("UNIVERISTY DATABASE");
frame.getContentPane().setBackground(Color.ORANGE);
JButton button = new JButton("Student"); 
JButton button1 = new JButton("Admin"); 
JButton ex1=new JButton("exit");

button.setBounds(150, 200, 220,50);
button1.setBounds(150, 100, 220,50);
ex1.setBounds(150,300,220,50);

button1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
adminpass oj1=new adminpass();
oj1.ad1();
}
});

button.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
studentpass o=new studentpass();
o.studp();
}
});

ex1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
frame.dispose();
}
});

frame.add(button);
frame.add(button1);
frame.add(ex1);


frame.setSize(500, 600); 
frame.setLayout(null);
frame.setVisible(true); 
}
}