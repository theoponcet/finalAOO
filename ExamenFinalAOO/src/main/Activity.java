package main;

public class Activity {
	
	private String id;	
	private Printer printer;
	
	/**
	 * @param id
	 * @param printer
	 */
	public Activity(String id, Printer printer) {
		super();
		this.id = id;
		this.printer = printer;
	}
	
	public boolean doActivity(Message message) {
		switch(message.getType()) {
			case Print:
				return printer.print(message.getMessageObject().getJob());
			case Cancel:
				return printer.cancel();
			case IsAvailable:
				return printer.isAvailable();
			case IsPrinting:
				return printer.isPrinting();
			case PrintingCompleted:
				return printer.printingCompleted();
			case Resume:
				return printer.resume();
			case Start:
				return printer.start();
			case Stop:
				return printer.stop();
			case Suspend:
				return printer.suspend();
			default:
				throw new RuntimeException("Message type not handled");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
}
