package clientBusinessLogic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.logging.Level;
import logicalModel.message.Message;
import java.util.logging.Logger;


/**
 *
 * @author 2dam
 * Tiene el codigo de los sockets
 * Clase para establecer una conexión con el servidor y enviar un objeto User.
 */
public class ClientSocket {

    private static Logger logger = Logger.getLogger(ClientSocket.class.getName());
    public static Message sendRecieveMessage(Message request) {
        Socket socket = null;
        ObjectInputStream read = null;
        ObjectOutputStream write = null;
        Message response = null;

        try {
            ResourceBundle configFile = ResourceBundle.getBundle("config.config");
            String ip = configFile.getString("IP");
            int port = Integer.parseInt(configFile.getString("PORT"));

            socket = new Socket(ip, port);

            write = new ObjectOutputStream(socket.getOutputStream());
            read = new ObjectInputStream(socket.getInputStream());

            // Enviar el objeto User al servidor
            write.writeObject(request);

            // Recibir respuesta del servidor
            response = (Message) read.readObject();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error: {0}", e.getMessage());
             e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Error: Class not found", ex);
        }  finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (read != null) {
                    read.close();
                }
                if (write != null) {
                    write.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("Fin cliente");
        }
        return response;

    }
}
