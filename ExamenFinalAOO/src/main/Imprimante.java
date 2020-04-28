package main;

public class Imprimante implements SansFilToPrinter{
	
	private Printer printer;
	
	
	public Imprimante (Printer printer) {
		this.printer=printer;
	}
	
	public boolean demarrer() {
		return printer.start();
	}
	public boolean arreter() {
		return printer.start();
	}
	public boolean imprimer(Document d) {
		Job aJob=new Job(d);
		return printer.print(aJob);
	}
	public boolean impressionTerminee() {
		return printer.printingCompleted();
	}

}
