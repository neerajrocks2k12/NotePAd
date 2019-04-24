import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.Scanner;

@SuppressWarnings("serial")
public class notePadmain extends JFrame implements ActionListener
{
	private JTextArea txtarea;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem open, save, exit;
	
	notePadmain()
	{
		setSize(500,300);
		setLocation(300,200);
		setLayout(new BorderLayout());
		
		txtarea=new JTextArea();
		txtarea.setSize(0, 0);
		txtarea.setWrapStyleWord(true);
		txtarea.setLineWrap(true);
		
		menuBar=new JMenuBar();
		file=new JMenu("File");
		open=new JMenuItem("Open");
		save=new JMenuItem("Save");
		exit=new JMenuItem("Exit");
		
		file.add(open);
		file.add(save);
		file.add(exit);
		
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		menuBar.add(file);
		setJMenuBar(menuBar);
		add(txtarea);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exit)
			dispose();
		if(e.getSource()==open)
		{
			JFileChooser choser=new JFileChooser();
			int rzlt=choser.showOpenDialog(open);
			if(rzlt==JFileChooser.APPROVE_OPTION)
			{
				txtarea.setText("");
				try
				{
					Scanner scan=new Scanner(new FileReader(choser.getSelectedFile().getPath()));
					while(scan.hasNext())
						txtarea.append(scan.nextLine()+"\n");
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==save)
		{
			JFileChooser saver=new JFileChooser();
			int rzlt=saver.showOpenDialog(save);
			if(rzlt==JFileChooser.APPROVE_OPTION)
			{
				try
				{
					BufferedWriter out=new BufferedWriter(new FileWriter(saver.getSelectedFile().getPath()));
					out.write(txtarea.getText());
					out.close();
				}
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		notePadmain fr=new notePadmain();
		try {
            // Set System L&F
        /*UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());*/
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
		ImageIcon ico=new ImageIcon("src/res/notepad.png");
		fr.setIconImage(ico.getImage());
		fr.setTitle("TextEditor");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}