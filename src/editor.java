// Java Program to create a text editor using java 
import java.awt.*; 
import javax.swing.*; 
import java.io.*;
import java.net.URL;
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*;
import javax.swing.text.Highlighter.HighlightPainter; 
class editor extends JFrame implements ActionListener { 
	// Text component 
	JTextArea t; 

	// Frame 
	JFrame f; 

	// Constructor 
	editor() 
	{ 
		// Create a frame 
		f = new JFrame("editor"); 

		try { 
			// Set metl look and feel 
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 

			// Set theme to ocean 
			MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
		} 
		catch (Exception e) { 
		} 

		// Text component 
		t = new JTextArea(); 

		// Create a menubar 
		JMenuBar mb = new JMenuBar(); 

		// Create a menu for menu 
		JMenu m1 = new JMenu("File"); 

		// Create menu items 
		JMenuItem mi1 = new JMenuItem("New"); 
		JMenuItem mi2 = new JMenuItem("Open"); 
		JMenuItem mi3 = new JMenuItem("Save"); 
		JMenuItem mi9 = new JMenuItem("Print"); 

		// Add action listener 
		mi1.addActionListener(this); 
		mi2.addActionListener(this); 
		mi3.addActionListener(this); 
		mi9.addActionListener(this); 

		m1.add(mi1); 
		m1.add(mi2); 
		m1.add(mi3); 
		m1.add(mi9); 

		// Create a menu for menu 
		JMenu m2 = new JMenu("Edit"); 

		// Create menu items 
		JMenuItem mi4 = new JMenuItem("cut"); 
		JMenuItem mi5 = new JMenuItem("copy"); 
		JMenuItem mi6 = new JMenuItem("paste"); 

		// Add action listener 
		mi4.addActionListener(this); 
		mi5.addActionListener(this); 
		mi6.addActionListener(this); 

		m2.add(mi4); 
		m2.add(mi5); 
		m2.add(mi6); 

		JMenuItem mc = new JMenuItem("close"); 
		JMenuItem m3 = new JMenuItem("Help");
		JMenuItem m4 =new JMenuItem("Search");
		//		m3.setSize(getPreferredSize());
		m3.setPreferredSize(new Dimension(1, m3.getPreferredSize().height));
		mc.addActionListener(this); 
		m3.addActionListener(this);
		m4.addActionListener(this);

		mb.add(m1); 
		mb.add(m2); 
		mb.add(m3);
		mb.add(mc); 
		mb.add(m4);


		f.setJMenuBar(mb); 
		f.add(t); 
		f.setSize(500, 500); 
		f.show(); 
	} 

	// If a button is pressed 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 

		if (s.equals("cut")) { 
			t.cut(); 
		} 
		else if (s.equals("copy")) { 
			t.copy(); 
		} 
		else if (s.equals("paste")) { 
			t.paste(); 
		} 
		else if (s.equals("Save")) { 
			// Create an object of JFileChooser class 
			JFileChooser j = new JFileChooser("f:"); 

			// Invoke the showsSaveDialog function to show the save dialog 
			int r = j.showSaveDialog(null); 

			if (r == JFileChooser.APPROVE_OPTION) { 

				// Set the label to the path of the selected directory 
				File fi = new File(j.getSelectedFile().getAbsolutePath()); 

				try { 
					// Create a file writer 
					FileWriter wr = new FileWriter(fi, false); 

					// Create buffered writer to write 
					BufferedWriter w = new BufferedWriter(wr); 

					// Write 
					w.write(t.getText()); 

					w.flush(); 
					w.close(); 
				} 
				catch (Exception evt) { 
					JOptionPane.showMessageDialog(f, evt.getMessage()); 
				} 
			} 
			// If the user cancelled the operation 
			else
				JOptionPane.showMessageDialog(f, "the user cancelled the operation"); 
		} 
		else if (s.equals("Print")) { 
			try { 
				// print the file 
				t.print(); 
			} 
			catch (Exception evt) { 
				JOptionPane.showMessageDialog(f, evt.getMessage()); 
			} 
		} 
		else if (s.equals("Open")) { 
			// Create an object of JFileChooser class 
			JFileChooser j = new JFileChooser("f:"); 

			// Invoke the showsOpenDialog function to show the save dialog 
			int r = j.showOpenDialog(null); 

			// If the user selects a file 
			if (r == JFileChooser.APPROVE_OPTION) { 
				// Set the label to the path of the selected directory 
				File fi = new File(j.getSelectedFile().getAbsolutePath()); 

				try { 
					// String 
					String s1 = "", sl = ""; 

					// File reader 
					FileReader fr = new FileReader(fi); 

					// Buffered reader 
					BufferedReader br = new BufferedReader(fr); 

					// Initilize sl 
					sl = br.readLine(); 

					// Take the input from the file 
					while ((s1 = br.readLine()) != null) { 
						sl = sl + "\n" + s1; 
					} 

					// Set the text 
					t.setText(sl); 
				} 
				catch (Exception evt) { 
					JOptionPane.showMessageDialog(f, evt.getMessage()); 
				} 
			} 
			// If the user cancelled the operation 
			else
				JOptionPane.showMessageDialog(f, "the user cancelled the operation"); 
		} 
		else if (s.equals("New")) { 
			t.setText(""); 
		} 
		else if (s.equals("close")) { 
			f.setVisible(false); 
		}
		else if(s.equals("Help")) {
			//			JOptionPane.showMessageDialog(f, "You pressed Helped Operation");
			try {
				Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
			} catch (Exception e1) {}
		}
		else if(s.equals("Search")) {
			//			JOptionPane.showMessageDialog(f, "You pressed Helped Operation");
			try {

				JFrame f1=new JFrame("Search Box"); 
				//submit button
				JButton b1=new JButton("Enter");    
				b1.setBounds(100,100,140,40);    
				//enter name label
				JLabel label = new JLabel();		
				label.setText("Enter Search T :");
				label.setBounds(10, 10, 100, 100);
				//empty label which will show event after button clicked
				//	JLabel label1 = new JLabel();
				//	label1.setBounds(10, 110, 200, 100);
				//textfield to enter name
				JTextField textfield= new JTextField();
				textfield.setBounds(110, 50, 130, 30);
				//add to frame

				f1.add(textfield);
				f1.add(label);
				f1.add(b1);    
				f1.setSize(300,300);    
				f1.setLayout(null);    
				f1.setVisible(true);   
			//	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

				//action listener
				b1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String s4,s5;
						s4 = textfield.getText();
						s5 =t.getText();
//						System.out.println(s5);	
//						System.out.println(s4);	
						int doc = s5.length();
						int Stext = s4.length();
						int found = 0;
						char a[] = s4.toCharArray();
						char b[] =s5.toCharArray();						 
						int i =0;
						 while ((i + Stext) <= doc) {
						        int j = 0;
						        while (b[i + j] == a[j]) {
						            j += 1;
						            if (j >= Stext)
						               found++;
						            JOptionPane.showMessageDialog(f,"Pattern Found"); 
						            Highlighter highlighter = t.getHighlighter();
						            HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
						            int p0 = s5.indexOf(s4);
						            int p1 = p0 + s4.length();
						            try {
										highlighter.addHighlight(p0, p1, painter);
									} catch (BadLocationException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						            f1.setVisible(false);   	
						        }
						        i += 1;
						    }
						
					}          
				});



			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	} 

	// Main class 
	public static void main(String args[]) 
	{ 
		editor e = new editor(); 
	} 
} 
