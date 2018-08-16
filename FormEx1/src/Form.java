import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Form extends JFrame {
	
	private JTextField textField;
	private JButton button;
	
	public Form() {
		super("JFrame Demo");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocation(200,200);
		//
		//setVisible(true);
		
		textField= new JTextField(20);
		add(textField);
		
		button=new JButton("Click");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("Hola");
				
			}
		});
		add(button);
	}
}
