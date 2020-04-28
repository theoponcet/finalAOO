package main;

import java.util.ArrayList;

public class Mailbox {
	
	private String id;
	private ArrayList<Message> queue;
	/**
	 * @param id
	 * @param queue
	 */
	public Mailbox(String id, ArrayList<Message> queue) {
		super();
		this.id = id;
		this.queue = queue;
	}
	
	public void receiveMessage(Message message) {
		this.queue.add(message);
	}
	
	public Message getFirstMessage() {
		Message message = this.queue.get(0);
		this.queue.remove(0);
		return message;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Message> getQueue() {
		return queue;
	}
	public void setQueue(ArrayList<Message> queue) {
		this.queue = queue;
	}
}
