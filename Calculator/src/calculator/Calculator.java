package calculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, point;
	private JButton sub, sum, div, mul;
	private JButton equal, neg, ms, mr;
	private JLabel memoryState;
	private JTextField resultField;
	private Integer num1, num2, result, memory;
	private String operation;
	private ActionListener numbersListener, operationListener;
	
	public Calculator() throws HeadlessException {
        super("Calculator");
        setSize(300, 315);
        setLocation(900, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setResizable(false);
 
        initHandlers();
 
        add(initResultPanel());
        add(initNumbersPanel());
        add(initOperationsPanel());
 
 
 
    }

	private JPanel initResultPanel() {
		JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultPanel.setPreferredSize(new Dimension(300, 50));
		memoryState = new JLabel();
		memoryState.setPreferredSize(new Dimension(280, 20));
		resultPanel.add(memoryState);

		resultField = new JTextField();
		resultField.setPreferredSize(new Dimension(280, 25));
		resultPanel.add(resultField);
		return resultPanel;
	}
	
	private JPanel initNumbersPanel() {
        JPanel numbersPanel = new JPanel(new FlowLayout());
        numbersPanel.setPreferredSize(new Dimension(170, 250));
        Dimension buttonSize = new Dimension(50, 50);
 
        b7 = new JButton("7");
        b7.setPreferredSize(buttonSize);
        b7.addActionListener(numbersListener);
        numbersPanel.add(b7);
 
        b8 = new JButton("8");
        b8.setPreferredSize(buttonSize);
        b8.addActionListener(numbersListener);
        numbersPanel.add(b8);
 
        b9 = new JButton("9");
        b9.setPreferredSize(buttonSize);
        b9.addActionListener(numbersListener);
        numbersPanel.add(b9);
 
        b4 = new JButton("4");
        b4.setPreferredSize(buttonSize);
        b4.addActionListener(numbersListener);
        numbersPanel.add(b4);
 
 
        b5 = new JButton("5");
        b5.setPreferredSize(buttonSize);
        b5.addActionListener(numbersListener);
        numbersPanel.add(b5);
 
        b6 = new JButton("6");
        b6.setPreferredSize(buttonSize);
        b6.addActionListener(numbersListener);
        numbersPanel.add(b6);
 
        b1 = new JButton("1");
        b1.setPreferredSize(buttonSize);
        b1.addActionListener(numbersListener);
        numbersPanel.add(b1);
 
        b2 = new JButton("2");
        b2.setPreferredSize(buttonSize);
        b2.addActionListener(numbersListener);
        numbersPanel.add(b2);
 
        b3 = new JButton("3");
        b3.setPreferredSize(buttonSize);
        b3.addActionListener(numbersListener);
        numbersPanel.add(b3);
 
        b0 = new JButton("0");
        b0.setPreferredSize(new Dimension(105, 50));
        b0.addActionListener(numbersListener);
        numbersPanel.add(b0);
 
        point = new JButton(".");
        point.setPreferredSize(buttonSize);
        point.addActionListener(numbersListener);
        numbersPanel.add(point);
        return numbersPanel;
    }
	
	private JPanel initOperationsPanel() {
        JPanel operationsPanel = new JPanel(new FlowLayout());
        operationsPanel.setPreferredSize(new Dimension(110, 250));
        Dimension d = new Dimension(50, 50);
 
        Font font = new Font("arial", Font.BOLD, 10);
 
        ms = new JButton("MS");
        ms.setFont(font);
        ms.setPreferredSize(d);
        ms.addActionListener(operationListener);
        operationsPanel.add(ms);
 
 
        mr = new JButton("MR");
        mr.setFont(font);
        mr.setPreferredSize(d);
        mr.addActionListener(operationListener);
        operationsPanel.add(mr);
 
        div = new JButton("/");
        div.setPreferredSize(d);
        div.addActionListener(operationListener);
        operationsPanel.add(div);
 
        mul = new JButton("*");
        mul.setPreferredSize(d);
        mul.addActionListener(operationListener);
        operationsPanel.add(mul);
 
 
        sum = new JButton("+");
        sum.setPreferredSize(d);
        sum.addActionListener(operationListener);
        operationsPanel.add(sum);
 
 
        sub = new JButton("-");
        sub.setPreferredSize(d);
        sub.addActionListener(operationListener);
        operationsPanel.add(sub);
 
        neg = new JButton("+-");
        neg.setPreferredSize(d);
        neg.addActionListener(operationListener);
        operationsPanel.add(neg);
 
        equal = new JButton("=");
        equal.setPreferredSize(d);
        equal.addActionListener(operationListener);
        operationsPanel.add(equal);
        return operationsPanel;
    }
 
	private void caculat() {
        if (operation.endsWith("+")) {
            result = num1 + num2;
        } else if (operation.endsWith("-")) {
            result = num1 - num2;
        } else if (operation.endsWith("/")) {
            result = num1 / num2;
        } else if (operation.endsWith("*")) {
            result = num1 * num2;
        }
    }
	
	private void initHandlers() {
		numbersListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String command = e.getActionCommand();
				if (command.equals(".")) {
                    resultField.setText(resultField.getText() + command);
                    return;
                }
				if (result != null) {
                    resultField.setText("");
                    result = null;
                }
                resultField.setText(resultField.getText() + command);
 
			}
		};

		
		
	    operationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                
                if (command.equals("MS")) {
                    memory = Integer.parseInt(resultField.getText());
 
                    if (memory == 0) {
                        memoryState.setText("");
                    } else {
                        memoryState.setText("M= " + memory.toString());
                    }
 
                    return;
                }
                
                if (command.equals("MR")) {
                    resultField.setText(memory.toString());
                    return;
                }
                
                if (command.equals("=")) {
                    num2 = Integer.parseInt(resultField.getText());
                    caculat();
                    resultField.setText(result.toString());
                    num1 = num2 = null;
                    operation = null;
                    return;
                }
                
                if (command.equals("+-")) {
                    if (resultField.getText().startsWith("-")) {
                        resultField.setText(resultField.getText().substring(1));
                    } else {
                        resultField.setText("-" + resultField.getText());
                    }
                    return;
                }
 
 
                num1 = Integer.parseInt(resultField.getText());
                resultField.setText("");
                operation = command;
 
 
            }
        };
	} 
	
	public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}