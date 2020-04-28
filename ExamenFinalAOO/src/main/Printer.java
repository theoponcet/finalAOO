package main;

public class Printer {
	
	
	public boolean on = false;
	private Job currentJob = null;
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public void setCurrentJob(Job ajob) {
		Log jobLog = new Log(ajob);
		this.currentJob = ajob ;
		this.currentJob.addObserver(jobLog);
	}

	public void setSpooler(Spooler spooler) {
	}
	
	public boolean start(){
		if (!on) { on = true;
			 return true;
		}
		System.err.println("Erreur");
		return false;
	}
	
	
	public boolean stop() {
		if (on) { on = false;
			return true;
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
			this.setCurrentJob(aJob);;
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
