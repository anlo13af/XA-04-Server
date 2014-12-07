package GUI;

import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Console extends JFrame {

	private static PrintStream ps = null;
	private JTextArea textPane = new JTextArea();

	public Console() {
		setSize(400, 400);
		getContentPane().setLayout(null);
		
		JPanel consolePanel = new JPanel();
		consolePanel.setBounds(0, 156, 308, -156);
		getContentPane().add(consolePanel);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		scrollPane.setBounds(0, 0, 384, 362);
		textPane.setBounds(0, 0, 310, 158);
		scrollPane.setViewportView(textPane);
		
		//getContentPane().add(scrollPane);
		

		// this is the trick: overload the println(String)
		// method of the PrintStream
		// and redirect anything sent to this to the text box
		ps = new PrintStream(System.out) {
			public void println(String x) {
				textPane.append(x + "\n");
			}
		};
	}

	public PrintStream getPs() {
		return ps;
	}

}
