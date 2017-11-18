package test.parkinglot.domain;

public enum Color {
	WHITE(1,"White"),
	BLACK(2,"Black"),
	BLUE(3,"Blue"),
	GREEN(4,"Green"),
	RED(5,"Red"),
	YELLOW(6,"Yellow"),
	SILVER(7,"Silver"),
	OTHERS(0,"Others");
	
	private int intVal;
	private String stringVal;
	
	Color(int intVal, String stringVal) {
		this.intVal = intVal;
		this.stringVal = stringVal;
	}

	public int getIntVal() {
		return intVal;
	}

	public void setIntVal(int intVal) {
		this.intVal = intVal;
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
