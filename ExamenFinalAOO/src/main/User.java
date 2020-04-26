package main;

public class User {
	
	
	private int quota = 0;

	
	public int getQuota() { return quota; }

	public void increaseQuota(int nbPages) { quota = quota + nbPages; }

	public void decreaseQuota(int nbPages) { quota = quota - nbPages; }
} // fin de la classe User
