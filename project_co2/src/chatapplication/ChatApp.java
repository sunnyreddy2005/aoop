package chatapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ChatApp {

    
    class Message {
        private String content;
        private User sender;

        public Message(String content, User sender) {
            this.content = content;
            this.sender = sender;
        }

        public String getContent() {
            return content;
        }

        public User getSender() {
            return sender;
        }
    }

    
    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    
    class ChatRoom {
        private String name;
        private List<Message> messages = new ArrayList<>();
        private List<User> users = new ArrayList<>();

        public ChatRoom(String name) {
            this.name = name;
        }

        public void addUser(User user) {
            users.add(user);
            System.out.println(user.getName() + " has joined the chat room.");
        }

        public void sendMessage(String content, User sender) {
            Message message = new Message(content, sender);
            messages.add(message);
            
            users.forEach(u -> {
                if (!u.equals(sender)) {
                    System.out.println(u.getName() + " received message: " + message.getContent() + " from " + sender.getName());
                }
            });
        }

        public void displayMessages() {
            System.out.println("Messages in " + name + ":");
            messages.forEach(m -> System.out.println(m.getSender().getName() + ": " + m.getContent()));
        }
    }

   
    public static void main(String[] args) {
        ChatApp app = new ChatApp();
        ChatRoom room = app.new ChatRoom("General");

        
        Consumer<String> notification = (message) -> System.out.println("Notification: " + message);

       
        User user1 = new User("sunny");
        User user2 = new User("rithik");

        
        room.addUser(user1);
        room.addUser(user2);

       
        room.sendMessage("Hello, everyone!", user1);
        room.sendMessage("Hi sunny!", user2);

       
        room.displayMessages();
        notification.accept("New message sent!");
    }
}
