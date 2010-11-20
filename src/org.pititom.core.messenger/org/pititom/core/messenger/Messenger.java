package org.pititom.core.messenger;

import java.io.IOException;

import org.pititom.core.Connection;
import org.pititom.core.Identifiable;
import org.pititom.core.event.HandlerRegister;
import org.pititom.core.event.Hook;
import org.pititom.core.event.HookEvent;
import org.pititom.core.event.HookEventGroup;
import org.pititom.core.event.Priority;

/**
 * 
 * @author Thomas Pérennou
 */
public interface Messenger<Message>
		extends
		HandlerRegister<HookEvent<MessengerEvent, Hook>, MessengerEventData<Message>>,
		Connection, Identifiable {

	public static final HookEventGroup<MessengerEvent, Hook> EVENTS = HookEventGroup.get(MessengerEvent.values());
	
	public void transmit(Message message);
	
	public void transmit(Message message, String sender);

	public void transmit(Message message, String sender, Priority priority);

	public void transmit(Message message, String sender, String contact);
	
	public void transmit(Message message, String sender, String contact, String service);

	public void transmit(Message message, String sender, String contact, Priority priority);
	
	public void transmit(Message message, String sender, String contact, String service, Priority priority);
	
	public void addReceiver(Receiver<Message> reciever) throws IOException;
	
	public void addSender(Sender<Message> sender) throws IOException;
	
	public void removeReceiver(final Receiver<Message> receiver) throws IOException;
	
	public void removeSender(final Sender<Message> sender) throws IOException;

	public String[] getReceivers();
	
	public String[] getSenders();
	
}