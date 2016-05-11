import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Controller {
	
	private Model theModel;
	private View theView;
	private double number = 0;
	private String operator = "";
	
	public Controller () {
		
		this.theModel = new Model();
		this.theView = new View();
	
	}
	
	public void run () {
		theView.open(this);
	}
	
	public ActionListener actionListener () {
		return new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				
				JButton button = (JButton) e.getSource();
				String value = button.getText();
				
				//System.out.println("Button \"" + value + "\" pressed");

				if(theModel.findDataType(value) == Model.Data.TYPE_INPUT) {
					
					if(theView.resultLabel.getText() == "0")
						theView.resultLabel.setText(value);
					else
						theView.resultLabel.setText(theView.resultLabel.getText() + value);
					
				} else if (theModel.findDataType(value) == Model.Data.TYPE_OPERATOR) {
					
					operator = value;
					if(theView.resultLabel.getText() != "")
						number = Double.parseDouble(theView.resultLabel.getText());
				    theView.resultLabel.setText("");
				    
				} else if (theModel.findDataType(value) == Model.Data.TYPE_COMMAND) {
					
					switch(value) {
						case "CE":
							number = 0;
							theView.resultLabel.setText("0");
							break;
						case "C":
							theView.resultLabel.setText("0");
							break;
						default:
							theView.resultLabel.setText(String.valueOf(theModel.calculate(number, 
									Double.parseDouble(theView.resultLabel.getText()), operator)));
							
					}
					
				} else {
					
				}
			}
		};
		
	}

}
