package test.parkinglot.domain;

public enum Color {
	WHITE("White"),
	BLACK("Black"),
	BLUE("Blue"),
	GREEN("Green"),
	RED("Red"),
	YELLOW("Yellow"),
	SILVER("Silver"),
	OTHERS("Others");
	
	private String stringVal;
	
	Color(String stringVal) {
		this.stringVal = stringVal;
	}

	public String getStringVal() {
		return stringVal;
	}

	public void setStringVal(String stringVal) {
		this.stringVal = stringVal;
	}
	
	public static Color getColor(String stringVal) {
		switch (stringVal) {
		case "White":
			return Color.WHITE;
		case "Black":
			return Color.BLACK;
		case "Blue":
			return Color.BLUE;
		case "Green":
			return Color.GREEN;
		case "Red":
			return Color.RED;
		case "Yellow":
			return Color.YELLOW;
		case "Silver":
			return Color.SILVER;
		default:
			return Color.OTHERS;
		}
	}
}
