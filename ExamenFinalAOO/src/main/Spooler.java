package main;

import java.util.Collections;
import java.util.Vector;

public class Spooler {

	static private Spooler instance;

	
	synchronized static public Spooler getInstance() {
		if (instance == null) { 
			instance = new Spooler();
		}
		return instance;
	}

	public Spooler() {}

	protected Vector<Printer> printers = new Vector<Printer>();

	public void join(Printer aPrinter) {
		printers.add(aPrinter);
		aPrinter.setSpooler(this);
		aPrinter.start();
	}

	public void quit(Printer aPrinter) {
		printers.remove(aPrinter);
		aPrinter.setSpooler(null);
		aPrinter.stop();
	}

	public Job print(Document aDocument, User aUser) {
		Job aJob = new Job(aDocument);
		aJob.setState(Job.WAITING);
		authorizedToPrint(aUser, aJob);
		return aJob;
	}

	private void authorizedToPrint(User aUser, Job aJob) {
		if (aUser.getQuota() > aJob.getDocument().getTotalPages()) {
			findBestPrinter(aUser, aJob);
		}
	}

	protected void findBestPrinter(User aUser, Job aJob) {
		for (Printer aPrinter : printers) {
			if (aPrinter.isAvailable()) {
				schedule(aUser, aJob, aPrinter );
				return;
			}
		}
	}
		
	
	
	protected void schedule(User aUser, Job aJob, Printer aPrinter) {
		aPrinter.print(aJob);
// attendre que la tâche soit terminée
		if (aJob.getState() == Job.COMPLETED) {
			bill(aJob, aUser);
		}
	}

	private void bill(Job aJob, User aUser) {
		aUser.decreaseQuota(aJob.getDocument().getTotalPages());
	}
} // fin de la classe Spooler
