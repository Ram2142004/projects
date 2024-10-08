package DB;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class OnlineGame {

    public static void main(String[] args) {
        try {
            // Create a server socket to listen for incoming connections
            ServerSocket serverSocket = new ServerSocket(65091);
            System.out.println("Waiting for a player to connect...");

            // Accept an incoming connection and create a socket for communicating with the client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Player connected from: " + clientSocket.getInetAddress().getHostAddress());

            // Create input and output streams for communicating with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Determine who will be the guesser and who will be the chooser
            String role;
            if (Math.random() < 0.5) {
                role = "guesser";
                out.println("You are the guesser");
            } else {
                role = "chooser";
                out.println("You are the chooser");
            }

            // If this player is the chooser, ask them to think of a number
            if (role.equals("chooser")) {
                out.println("Think of a number between 1 and 100 and type it in the console.");
            }

            // If this player is the guesser, ask them to make a guess
            if (role.equals("guesser")) {
                out.println("Enter a guess in the console:");
            }

            // Create a Scanner for reading input from the console
            Scanner console = new Scanner(System.in);

            // Play the game until someone wins
            while (true) {
                if (role.equals("chooser")) {
                    // Read the number that the chooser thought of
                    int number = console.nextInt();

                    // Send the number to the guesser
                    out.println(number);

                    // Wait for the guesser's guess
                    int guess = Integer.parseInt(in.readLine());

                    // Check if the guess is correct
                    if (guess == number) {
                        out.println("You won!");
                        break;
                    } else {
                        out.println("Incorrect. Try again.");
                    }
                } else {
                    // Wait for the chooser to send the number
                    int number = Integer.parseInt(in.readLine());

                    // Read the guesser's guess
                    int guess = console.nextInt();

                    // Send the guess to the chooser
                    out.println(guess);

                    // Check if the guess is correct
                    if (guess == number) {
                        out.println("You won!");
                        break;
                    } else {
                        out.println("Incorrect. Try again.");}}
                
            }
            
        } catch(Exception e) {e.printStackTrace();}
        }}

            // Close the socket and exit the program
        

