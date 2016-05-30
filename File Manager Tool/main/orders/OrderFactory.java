package oop.ex6.filescript.orders;

public class OrderFactory {

	/** The regex sign */
	private final static String REGEX = "#";
	/** The reverse command */
	private final static String REVERSE_COMMAND = "REVERSE";
	/** The order name location */
	private final static int ORDER_NAME = 0;
	/** The default order */
	public final static Order DEFAULT_ORDER = new Abs();
	/**
	 * This method creating the order according to the command.
	 * @param orderText - The command from the command file.
	 * @return The order that created.
	 * @throws OrderException - If the order command has an error.
	 */
	public static Order createOrders(String orderText) throws OrderException {
		Order order;
		if (orderText == null) {
			return DEFAULT_ORDER;
		} else {
			String[] orderStringArray = orderText.split(REGEX);
			switch (orderStringArray[ORDER_NAME]) {
				case "abs": 
					order = new Abs();
					break;
				case "type":
					order = new Type();
					break;
				case "size":
					order = new Size();
					break;
				default :
					throw new BadOrderNameException();
			}
			if(orderText.endsWith(REVERSE_COMMAND)){
				order = new Reverse(order);
			}
			return order;
		}
	}
}
