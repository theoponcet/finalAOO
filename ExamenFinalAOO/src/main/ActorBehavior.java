package main;

import java.util.ArrayList;
import java.util.UUID;

public class ActorBehavior {
	
	private String id;
	private Mailbox mailbox;
	private ArrayList<Activity> logActivities;

	/**
	 * @param id
	 * @param mailbox
	 * @param logActivities
	 */
	public ActorBehavior(String id, Mailbox mailbox, ArrayList<Activity> logActivities) {
		super();
		this.id = id;
		this.mailbox = mailbox;
		this.logActivities = logActivities;
	}
	
	public void executeActivity() {
		Message message = mailbox.getFirstMessage();
		Activity activity = new Activity(UUID.randomUUID().toString(), message.getMessageObject().getPrinter());
		activity.doActivity(message);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Mailbox getMailbox() {
		return mailbox;
	}
	public void setMailbox(Mailbox mailbox) {
		this.mailbox = mailbox;
	}
	public ArrayList<Activity> getLogActivities() {
		return logActivities;
	}
	public void setLogActivities(ArrayList<Activity> logActivities) {
		this.logActivities = logActivities;
	}
}
