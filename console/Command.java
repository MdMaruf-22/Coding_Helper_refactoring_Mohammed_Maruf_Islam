import console.CommandHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CommandHandler handler = new CommandHandler();
        try {
            handler.start();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}