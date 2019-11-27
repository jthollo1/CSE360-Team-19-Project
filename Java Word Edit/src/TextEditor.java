import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextEditor 
{

	private JFrame frmCseTextEditor;
	private Loadfile lf;
	private SaveAs sa;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TextEditor window = new TextEditor();
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
				lf = new Loadfile();
				lf.load();
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
				// handle mouse click
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
				// handle mouse click
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(50, 95, 89, 23);
		frmCseTextEditor.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Preview");
		btnNewButton_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				// handle mouse click
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(149, 95, 89, 23);
		frmCseTextEditor.getContentPane().add(btnNewButton_3);
	}
}
