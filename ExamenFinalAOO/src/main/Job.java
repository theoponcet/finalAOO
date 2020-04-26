package main;

public class Job {
	
	

	static public int WAITING = 0;
	static public int PRINTING = 1;
	static public int COMPLETED = 2;
	static public int CANCELLED = 3;

	private Printer printer;
	private Document document;
	private int state;

	public Job(Document aDocument) { setDocument(aDocument); }
	
	public int getState() { return this.state; }
	
	public void setState(int state) { this.state = state; }
	
	public Printer getPrinter() { return this.printer; }
	
	public void setPrinter(Printer aPrinter) { printer = aPrinter; }
	
	public Document getDocument() { return document; }
	
	public void setDocument(Document document) { this.document = document; }
} // fin de la classe Job
