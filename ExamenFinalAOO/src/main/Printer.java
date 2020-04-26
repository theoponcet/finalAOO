package main;

public class Printer implements On{
	
	
	public boolean on = true;
	private Job currentJob = null;
	private String name;
	//public Printer p = new Printer();
	
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public void setCurrentJob(Job ajob) {this.currentJob = ajob ;}

	@Override
	public boolean start(Printer myPrinter){
		return myPrinter.on;				
	}
	
	
	public boolean stop() {
		if (on) { on = false;
			return false;
		}
		System.err.println("Erreur");
		return false;
	}
	
	public boolean suspend() {
		if(isPrinting()) {
			currentJob.setState(Job.WAITING);
			return true;
		}
		System.err.println("Erreur");
		return false;
	}
	
	public boolean resume() {
		if(currentJob.getState()==Job.WAITING) {
			currentJob.setState(Job.PRINTING);
			return true;
		}
		System.err.println("Erreur");
		return false;
	}
	
	public boolean cancel() {
		if(currentJob.getState()==Job.WAITING) {
			currentJob.setState(Job.CANCELLED);
			currentJob=null;
			return true;
		}
		System.err.println("Erreur");
		return false;
		
	}
	
	public boolean print(Job aJob) {
// l’imprimante doit être allumée
// et ne doit pas être en train d’imprimer un document
		if (isAvailable()){
			currentJob = aJob;
			aJob.setPrinter(this);
			aJob.setState(Job.PRINTING);
			return true;
		}
		System.err.println("Erreur");
		return false;
	}
	
	
	public boolean printingCompleted() {
// l’imprimante doit être allumée
// et en train d’imprimer un document
		if (isPrinting()){
			currentJob.setPrinter(null);
			currentJob.setState(Job.COMPLETED);
			currentJob = null;
			return true;
		}
		System.err.println("Erreur");
		return false;
	}

	
	public boolean isAvailable() {
		return on && currentJob == null;
	}

	
	public boolean isPrinting() {
		return on && currentJob != null;
	}
//	@Override
//	public boolean start(Printer myPrinter) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	//public boolean start(Printer myPrinter) {
		// TODO Auto-generated method stub
		//return false;
	//}
} // fin de la classe Printer
