package main;

public class Actor {
	
	private String id;
	private Mailbox mailbox;
	private ActorBehavior behavior;
	
	/**
	 * @param id
	 * @param mailbox
	 * @param behavior
	 */
	public Actor(String id, Mailbox mailbox, ActorBehavior behavior) {
		super();
		this.id = id;
		this.mailbox = mailbox;
		this.behavior = behavior;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Mailbox getMailbox() {
		return this.mailbox;
	}
	public void setMailbox(Mailbox mailbox) {
		this.mailbox = mailbox;
	}
	public ActorBehavior getBehavior() {
		return behavior;
	}
	public void setBehavior(ActorBehavior behavior) {
		this.behavior = behavior;
	}
}
