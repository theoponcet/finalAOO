package main;

public class MessageObject {
	
	private Printer printer;
	private Job job;
	private User user;
	
	/**
	 * @param printerName
	 * @param job
	 * @param user
	 */
	public MessageObject(Printer printer, Job job, User user) {
		super();
		this.printer = printer;
		this.job = job;
		this.user = user;
	}
	
	public Printer getPrinter() {
		return printer;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
