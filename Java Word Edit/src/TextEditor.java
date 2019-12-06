import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class TextEditor
{

	protected JFrame frmCseTextEditor;
	Format F = new Format();
	Loadfile lf = new Loadfile();
	SaveAs sa = new SaveAs();
	Process proc = new Process();
	String textFile = "";
	static boolean errorLogCheck = true;
	static boolean trackErrorButton = false;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TextEditor window = new TextEditor();
					 Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() 
					 {
						 public void run() {
							 if (errorLogCheck) {
							 Errorlog defaultErrorLog = new Errorlog();
					        }
							 }
					    }));
					window.frmCseTextEditor.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public TextEditor() 
	{
		initialize();
	}
	
	private void initialize() 
	{
		frmCseTextEditor = new JFrame();
		frmCseTextEditor.setTitle("CSE360 Text Editor");
		frmCseTextEditor.setBounds(100, 100, 300, 200);
		frmCseTextEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCseTextEditor.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Load File");
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				textFile = lf.load();
			    
			    // WON'T ACTUALLY LOAD CHECK PREVIOUS CODE TO MAKE IT WORK.
				try( PrintStream out = new PrintStream( new File( "loadFileWorks.txt" ) ) ) {
					
				    out.print(textFile);
				    System.out.print(textFile);
					String loadTxt = "- [Load File] Successfully Loaded the file (.txt)!\n";
			
					Errorlog.Txt(loadTxt);
					Errorlog.outputTxt();
					errorLogCheck = false;
				} catch (FileNotFoundException e1) {
					String loadTxt = "- [Load File] FAILED TO LOAD FILE!\n";
					Errorlog.Txt(loadTxt);
					Errorlog.outputTxt();
					errorLogCheck = false;
				}			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(50, 43, 89, 23);
		frmCseTextEditor.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save As...");
		btnNewButton_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				try( PrintStream out = new PrintStream( new File( sa.save(proc.p(textFile)) ) ) ) {
					
					String loadTxt = "- [Save As...] Successfully saved the formatted text file!\n";
			
					Errorlog.Txt(loadTxt);
					Errorlog.outputTxt();
					errorLogCheck = false;
				} catch (FileNotFoundException e1) {
					String loadTxt = "- [Save As...] FAILED TO SAVE FILE!\n";
					Errorlog.Txt(loadTxt);
					Errorlog.outputTxt();
					errorLogCheck = false;
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(149, 43, 89, 23);
		frmCseTextEditor.getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Error Log");
		btnNewButton_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				String loadTxt = "- [Error Log] Successfully opened Error Log!\n";
				
				Errorlog.Txt(loadTxt);
				Errorlog.outputTxt();
				
				trackErrorButton = true;
				if(trackErrorButton) {
				Errorlog.openErrorLogMessage("random string to run function");
				}
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(50, 95, 89, 23);
		frmCseTextEditor.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Preview");
		btnNewButton_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
					try {
						String loadTxt = "- [Preview] File successfully previewed!\n";
						Errorlog.Txt(loadTxt);
						Errorlog.outputTxt();
						errorLogCheck = false;
					JTextArea ta = new JTextArea(40, 80);
					ta.read(new FileReader("/Users/meeatingchips/eclipse-workspace/CSE360TextEditor/leftj.txt"), null);
					ta.setEditable(false);
					JOptionPane.showMessageDialog(btnNewButton_3, new JScrollPane(ta));
					}
					catch (IOException ioe) {
					ioe.printStackTrace();
					}
					}
					});
				}
			});				
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(149, 95, 89, 23);
		frmCseTextEditor.getContentPane().add(btnNewButton_3);
	}
}