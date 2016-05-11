public class Model {

	public double calculate (double operandX, double operandY, String operator) {
		System.out.println(operandX + "\t" + operandY + "\t" + operator);
		switch (operator) {
			case "+":
				return operandX + operandY;
			case "-":
				return operandX - operandY;
			case "*":
				return operandX * operandY;
			case "/":
				if (operandY == 0) {
					return 0;
				}
				
				return operandX / operandY;
		}
		
		return 0;
		
	}
	
	public int findDataType(String value) {
		
		switch (value) {
			case "+":
			case "-":
			case "*":
			case "/":
				return Data.TYPE_OPERATOR;

			case "CE":
			case "C":
			case "=":
				return Data.TYPE_COMMAND;

			default:
				return Data.TYPE_INPUT;
		}

	}
	
	public static class Data {
		
		public static final int TYPE_OPERATOR = 1;
		public static final int TYPE_COMMAND = 2;
		public static final int TYPE_INPUT = 3;
	}
	
}
