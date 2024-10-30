package clientBusinessLogic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicalModel.message.Message;

/**
 * The {@code ClientSocket} class manages socket connections to the server, 
 * enabling sending and receiving of {@code Message} objects.
 * 
 * Configured with IP and port settings from {@code config.config}, this class
 * uses TCP to send a {@code Message} request and receive a server response.
 * 
 * Errors in connection or I/O are logged, and resources are safely closed in 
 * a {@code finally} block.
 * 
 * @author 
 * Irati and Olaia
 * 
 * @see Message
 */
public class ClientSocket {

    /** Logger for debug and error information. */
    private static final Logger logger = Logger.getLogger(ClientSocket.class.getName());

    /**
     * Sends a {@code Message} to the server and waits for a response.
     * 
     * This method connects to the server using IP and port settings from 
     * {@code config.config}. It then sends the message and returns the 
     * response received.
     * 
     * @param request the {@code Message} to send to the server.
     * @return the server’s response as a {@code Message}, or {@code null} on error.
     */
    public static Message sendRecieveMessage(Message request) {
        Socket socket = null;
        ObjectInputStream read = null;
        ObjectOutputStream write = null;
        Message response = null;

        try {
            ResourceBundle configFile = ResourceBundle.getBundle("config.config");
            String ip = configFile.getString("IP");
            int port = Integer.parseInt(configFile.getString("PORT"));

            // Establish socket connection with configured IP and port
            socket = new Socket(ip, port);

            // Initialize input/output streams
            write = new ObjectOutputStream(socket.getOutputStream());
            read = new ObjectInputStream(socket.getInputStream());

            // Send request message to server
            write.writeObject(request);

            // Receive server response
            response = (Message) read.readObject();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "I/O Error: {0}", e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Class not found", ex);
        } finally {
            // Safely close socket and streams
            try {
                if (socket != null) socket.close();
                if (read != null) read.close();
                if (write != null) write.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error closing resources: {0}", e.getMessage());
                e.printStackTrace();
            }
            logger.info("Client connection closed");
        }
        return response;
    }
}
