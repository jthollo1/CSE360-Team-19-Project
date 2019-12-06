import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;

import javax.swing.JButton;

public class Preview extends TextEditor
{
	public Preview()
	{
		// constructor
	
	JButton btnNewButton_3 = new JButton("Preview");
	btnNewButton_3.addMouseListener(new MouseAdapter() 
	{
		//@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			String s = "";
			//int i = 0;
			
			//s = F.rightJ(s, 1, 2);
			//s = F.leftJ(s, 2, 1, false, false);
			
			System.out.println(s);
			
		}
	});
	btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnNewButton_3.setBounds(149, 95, 89, 23);
	//frmCseTextEditor.getContentPane().add(btnNewButton_3);
}
}