import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	private Controller theController;
	public JLabel resultLabel = new JLabel("0");
	
	public View () {
		
	}
	
	public void open (Controller theController) {
		this.theController = theController;
		init();
		setVisible(true);
	}
	
	private void init () {
		
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel calculatorPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		calculatorPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		resultLabel.setPreferredSize(new Dimension(0, 50));
		resultLabel.setFont(new Font("Courier New", Font.PLAIN, 24));
		
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3,3,3,3);
		calculatorPanel.add(resultLabel, gbc);
		
		gbc.gridwidth = 1;
		
		String commandsList[] = {"←", "±", "√", "%", "1/x", "CE", "C", "="};
		for(String commandName : commandsList) {
			JButton command = new JButton(commandName);
			command.setFocusable(false);
			command.addActionListener(theController.actionListener());
			switch(commandName) {
				case "←":
				case "±":
				case "√":
				case "%":
				case "1/x":
					gbc.gridy = 1;
					break;
				case "CE":
					gbc.gridy = 2;
					gbc.gridx = 4;
					break;
				case "C":
					gbc.gridy = 3;
					gbc.gridx = 4;
					break;
				case "=":
					gbc.gridy = 4;
					gbc.gridx = 4;
					gbc.gridheight = 2;
					break;
			}
			calculatorPanel.add(command, gbc);
			gbc.gridx++;
		}
		gbc.gridheight = 1;
		gbc.gridx = 0;
		
		JButton[] Btns = new JButton[10];
		for(int i=0; i<10; i++) {
			Btns[i] = new JButton(String.valueOf(i));
			Btns[i].setFocusable(false);
			Btns[i].addActionListener(theController.actionListener());
			if(i==0) { 
				gbc.gridy = 5;
				gbc.gridwidth = 2;
			}	
			if(i>=1 && i<=3) {
				gbc.gridy = 4;
				if(i==1) gbc.gridx = 0;
				if(i==2) gbc.gridx = 1;
				if(i==3) gbc.gridx = 2;
			}
			if(i>=4 && i<=6) {
				gbc.gridy = 3;
				if(i==4) gbc.gridx = 0;
				if(i==5) gbc.gridx = 1;
				if(i==6) gbc.gridx = 2;
			}
			if(i>=7 && i<=9) {
				gbc.gridy = 2;
				if(i==7) gbc.gridx = 0;
				if(i==8) gbc.gridx = 1;
				if(i==9) gbc.gridx = 2;
			}
			
			calculatorPanel.add(Btns[i], gbc);
			gbc.gridwidth = 1;
		}
		
		gbc.gridx = 3;
		gbc.gridy = 5;
		String operatorsList[] = {"+", "-", "*", "/"};
		for(String operatorName : operatorsList) {
			JButton operator = new JButton(operatorName);
			operator.setFocusable(false);
			operator.addActionListener(theController.actionListener());
			calculatorPanel.add(operator, gbc);
			gbc.gridy--;
		}
		
		gbc.gridx = 2;
		gbc.gridy = 5;
		JButton period = new JButton(".");
		period.setFocusable(false);
		period.addActionListener(theController.actionListener());
		calculatorPanel.add(period, gbc);
		
		this.add(calculatorPanel);
		this.pack();
	}

}