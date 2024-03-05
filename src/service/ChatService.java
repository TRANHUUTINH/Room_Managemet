package service;

public class ChatService {
    public void sendMessage(String sender, String receiver, String message) {
        System.out.println("From: " + sender);
        System.out.println("To: " + receiver);
        System.out.println("Message: " + message);
    }

    public void sendChatMessage(int customerId, String message) {
        System.out.println("Sending chat message...");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Message: " + message);
        System.out.println("Chat message sent successfully.");
    }
}
