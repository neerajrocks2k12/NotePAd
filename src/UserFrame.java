/**import java.awt.*;
import javax.swing.*;

class UserFrame extends JFrame
{
	JPanel panel;
	JTextArea mypane;
	JTabbedPane tabbedPane;
	JScrollPane scroll;
	
	UserFrame()
	{
		scroll=new JScrollPane();
		panel=new JPanel();
		mypane=new JTextArea(0,0);
		//mypane.setSize(setPreferredSize());
		mypane.setLineWrap(true);
		mypane.setWrapStyleWord(true);
		scroll.add(mypane);
		
		tabbedPane=new JTabbedPane();
		//panel.setLayout(new BorderLayout());
		panel.add(scroll,BorderLayout.CENTER);

		tabbedPane.add("new file",scroll);
		add(tabbedPane);
	}
	
	public static void main(String[] args)
	{
		UserFrame fr=new UserFrame();
		fr.setSize(300,300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);
		fr.setVisible(true);
	}
}
/***/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class UserFrame extends JFrame implements ActionListener{
public static String name = "charles";
public static int number = 1;
public static JMenuItem print;
public static JMenuItem print2;
public static JMenuItem copy;
public static JMenuItem paste;
public static JMenuItem cut;
Clipboard clip = getToolkit().getSystemClipboard();
public static JButton jb11;
public static JButton jb12;

public static ImageIcon icon1;
public static ImageIcon icon2;
public static ImageIcon icon3;
public static ImageIcon icon4;
public static ImageIcon icon5;
public static ImageIcon icon6;
public static ImageIcon icon7;
public static JCheckBox tbox;
public static JRadioButton rbut; public static JComboBox combo;
public static JList list;

public static Pan2 pans;
public static JTabbedPane tab;

UserFrame(){
setTitle("UsersFrame");
setSize(600,550); }


public static void main(String[] args){
File dir = new File("C:");
String[] FoldersAndFiles = dir.list();

UserFrame f = new UserFrame();
JMenuBar bar = new JMenuBar();
bar.setToolTipText("this is the manu bar please use this carefully");
JToolBar tb = new JToolBar();
tb.setToolTipText("This is a tool bar");
tb.setLayout(new FlowLayout());
icon1 = new ImageIcon("src\\Paint-icon.png");
icon2 = new ImageIcon("src\\stop-icon.png");
icon3 = new ImageIcon("src\\shield-icon.png");
icon4 = new ImageIcon("src\\repair-icon.png");
icon5 = new ImageIcon("src\\sunset-icon.png");
icon6 = new ImageIcon("src\\strawberry-icon.png");
icon7 = new ImageIcon("src\\girl-icon.png");

tbox = new JCheckBox("What");
rbut = new JRadioButton("Why"); 
combo = new JComboBox();
combo.addItem("Plain");
combo.addItem("Fancy");
combo.addItem("Official");
combo.addActionListener(f);

jb11 = new JButton(icon1);
jb11.addActionListener(f);
jb11.setToolTipText("this button has a tool tip, please read!");
jb12 = new JButton(icon2);
jb12.addActionListener(f);
JButton jb13 = new JButton(icon3);
JButton jb14 = new JButton(icon4);
JButton jb15 = new JButton(icon5);
JButton jb16 = new JButton(icon6);
JButton jb17 = new JButton(icon7);
JMenu fileMenu = new JMenu("File");
JMenu editMenu = new JMenu("Edit");
print = new JMenuItem("print name");
print2 = new JMenuItem("print nothen");
copy = new JMenuItem("Copy");
paste = new JMenuItem("Paste");
cut = new JMenuItem("Cut");
print.addActionListener(f);
print2.addActionListener(f);
copy.addActionListener(f);
paste.addActionListener(f);
cut.addActionListener(f);
fileMenu.add(print);
fileMenu.add(print2);
editMenu.add(copy);
editMenu.add(paste);
editMenu.add(cut);
bar.add(fileMenu);
bar.add(editMenu);
f.setJMenuBar(bar); tb.add(jb11);
tb.add(jb12);
tb.add(jb13);
tb.add(jb14);
tb.add(jb15);
tb.add(jb16);
tb.add(jb17);
//tb.add(tbox);
tb.add(rbut);
tb.add(combo);

JPanel pan = new JPanel();
pans = new Pan2();
tab = new JTabbedPane();

tab.add("File "+number,pans.Pan2());
pan.setLayout(new BorderLayout());
pan.add(tb,BorderLayout.NORTH);
pan.add(tab,BorderLayout.CENTER);

JScrollPane scroll = new JScrollPane(pan);
f.add(scroll);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
}


@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

Object c = (Object) e.getSource();

if(c==combo){
JComboBox cb = (JComboBox) e.getSource();
String passed = (String) cb.getSelectedItem();
System.out.println(passed);
}
if(c==jb11){
System.out.println("Charles");
}
if(c==jb12){
number++;
tab.add("File"+number,pans.Pan2());
}
if(c==print){
System.out.println("The menu item");
}
if(c==print2){
System.out.println("The menu 222item");
}
if(c==copy){

}
if(c==paste){ try{ }
catch(Exception ex){ } }
if(c==cut){

}
}


}
class Pan2{
JPanel pan2;
JTextArea area;
JTextArea lineNumbers;
public JPanel Pan2(){
area = new JTextArea();
lineNumbers = new JTextArea(20,1);
lineNumbers.setBackground(Color.YELLOW);
pan2 = new JPanel();
pan2.setLayout(new BorderLayout());
pan2.add(area,BorderLayout.CENTER);
pan2.add(lineNumbers,BorderLayout.WEST);
return pan2;
}
}