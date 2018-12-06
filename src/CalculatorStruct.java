import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorStruct extends JFrame implements ActionListener {

	private JPanel panel, panel2;
	private JTextField answerBox;
	private JButton zero, one, two, three, four, five, six, seven, eight, nine, dot, equalTo, add, sub, multiply, div,
			clear, delete;
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	double result;
	String number1 = "";
	int counter = 0;

	public void calc() {
		panel = new JPanel();
		panel2 = new JPanel(new GridLayout(1, 1));
		answerBox = new JTextField(10);
		answerBox = new JTextField(10);
		panel.setLayout(layout);
		zero = new JButton("0");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		dot = new JButton(".");
		add = new JButton("+");
		sub = new JButton("-");
		multiply = new JButton("X");
		div = new JButton("/");
		equalTo = new JButton("=");
		delete = new JButton("d");
		this.getRootPane().setDefaultButton(equalTo);
		clear = new JButton("C");
		panel2.add(answerBox);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(one, gbc);
		one.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(two, gbc);
		two.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(three, gbc);
		three.addActionListener(this);
		gbc.gridx = 3;
		gbc.gridy = 0;
		panel.add(add, gbc);
		add.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(four, gbc);
		four.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(five, gbc);
		five.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 1;
		panel.add(six, gbc);
		six.addActionListener(this);
		gbc.gridx = 3;
		gbc.gridy = 1;
		panel.add(sub, gbc);
		sub.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(seven, gbc);
		seven.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(eight, gbc);
		eight.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(nine, gbc);
		nine.addActionListener(this);
		gbc.gridx = 3;
		gbc.gridy = 2;
		panel.add(div, gbc);
		div.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(dot, gbc);
		dot.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(zero, gbc);
		zero.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 3;
		panel.add(clear, gbc);
		clear.addActionListener(this);
		gbc.gridx = 3;
		gbc.gridy = 3;
		panel.add(multiply, gbc);
		multiply.addActionListener(this);
		gbc.gridwidth = 3;
		gbc.gridx = 3;
		gbc.gridy = 4;
		panel.add(equalTo, gbc);
		equalTo.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(delete, gbc);
		delete.addActionListener(this);
		delete.setActionCommand("delete");
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.getContentPane().add(panel2, BorderLayout.NORTH);
	}

	public CalculatorStruct() {
		calc();
		this.setTitle("Calculator");
		this.setVisible(true);
		this.pack();
		this.setSize(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String input = ae.getActionCommand();
		if (input.charAt(0) == 'C') {
			number1 = "";
			answerBox.setText("");
		} else if (input.charAt(0) == '=') {
			answerBox.setText(working(answerBox.getText()));
		}
		else if(ae.getActionCommand().equals("delete"))
		{
			String inputs = "";
			char arrr[]  =answerBox.getText().toCharArray();
			/*int i=  arrr.length;
			answerBox.remove(i);*/
			answerBox.setText(answerBox.getText().substring(0, answerBox.getText ().length() - 1));
			/*for (int i = 0; i < arrr.length - 1; i++) inputs += arrr[i];
			answerBox.setText(inputs);*/
		}
		else
			answerBox.setText(answerBox.getText().concat(input));
	}

	public String working(String inputs) {
		number1 = "";// stop repeating the same number
		char[] arr = inputs.toCharArray();
		String number2 = "", operator = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
				if (operator.isEmpty()) {
					number1 += arr[i];
				} else
					number2 += arr[i];
			}
			if (arr[i] == '+' || arr[i] == '-' || arr[i] == 'X' || arr[i] == '/') {
				if (counter > 0) {
					if (operator.equals("+")) {
						number1 = String.valueOf(Double.parseDouble(number1) + Double.parseDouble(number2));
						number2 = ""; operator="";//stop making the string of operators
					} else if (operator.equals("-")) {
						number1 = String.valueOf(Double.parseDouble(number1) - Double.parseDouble(number2));
						number2 = "";operator="";
					} else if (operator.equals("X")) {
						number1 = String.valueOf(Double.parseDouble(number1) * Double.parseDouble(number2));
						number2 = ""; operator="";
					} else if (operator.equals("/")) {
						number1 = String.valueOf(Double.parseDouble(number1) / Double.parseDouble(number2));
						number2 = ""; operator="";
					}
				}
				operator += arr[i];
				counter++;
			}
		}
		if (operator.equals("+")) {
			number1 = String.valueOf(Double.parseDouble(number1) + Double.parseDouble(number2));
		} else if (operator.equals("-")) {
			number1 = String.valueOf(Double.parseDouble(number1) - Double.parseDouble(number2));
		} else if (operator.equals("X")) {
			number1 = String.valueOf(Double.parseDouble(number1) * Double.parseDouble(number2));
		} else if (operator.equals("/")) {
			number1 = String.valueOf(Double.parseDouble(number1) / Double.parseDouble(number2));
		}
		return " " + number1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new CalculatorStruct();
	}
}
