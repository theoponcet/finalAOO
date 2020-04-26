package main;

class True implements On {
	
	@Override
	public boolean start(Printer myPrinter) {
		System.err.println("Erreur");
		return false;
	}
}





