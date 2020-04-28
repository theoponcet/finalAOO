package main;

public class Message {
	private String id;
	private MessageType type;
	private MessageObject messageObject;
	
	public Message(String id, MessageType type, MessageObject messageObject) {
		super();
		this.id = id;
		this.type = type;
		this.messageObject = messageObject;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public MessageObject getMessageObject() {
		return messageObject;
	}
	public void setMessageObject(MessageObject messageObject) {
		this.messageObject = messageObject;
	}
}

