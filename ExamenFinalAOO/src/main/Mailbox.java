package main;

import java.util.ArrayList;

public class Mailbox {
	
	private String id;
	private ArrayList<Message> highPriorityQueue;
	private ArrayList<Message> lowPriorityQueue;
	private ArrayList<Message> currentQueue;
	/**
	 * @param id
	 * @param queue
	 */
	public Mailbox(String id, ArrayList<Message> highPriorityQueue, ArrayList<Message> lowPriorityQueue, ArrayList<Message> currentQueue) {
		super();
		this.id = id;
		this.highPriorityQueue = highPriorityQueue;
		this.lowPriorityQueue = lowPriorityQueue;
		this.currentQueue = currentQueue;
	}
	
	public void receiveMessage(Message message) {

		switch (message.getPriority()) {
		case HIGH:
			this.highPriorityQueue.add(message);
		case LOW:
			this.lowPriorityQueue.add(message);
		}
	}
	
	public Message getFirstMessage() {
		if (!this.highPriorityQueue.isEmpty()) {
			this.setCurrentQueue(this.highPriorityQueue);
		}
		else {
			this.setCurrentQueue(this.lowPriorityQueue);
		}
		
		Message message = this.currentQueue.get(0);
		this.currentQueue.remove(0);
		return message;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Message> getHighPriorityQueue() {
		return highPriorityQueue;
	}

	public void setHighPriorityQueue(ArrayList<Message> highPriorityQueue) {
		this.highPriorityQueue = highPriorityQueue;
	}

	public ArrayList<Message> getLowPriorityQueue() {
		return lowPriorityQueue;
	}

	public void setLowPriorityQueue(ArrayList<Message> lowPriorityQueue) {
		this.lowPriorityQueue = lowPriorityQueue;
	}

	public ArrayList<Message> getCurrentQueue() {
		return currentQueue;
	}

	public void setCurrentQueue(ArrayList<Message> currentQueue) {
		this.currentQueue = currentQueue;
	}
}
