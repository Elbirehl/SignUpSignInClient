package clientBusinessLogic;

import logicalModel.interfaces.Signable;

/**
 * Factory class to create instances of Signable.
 *
 * This class provides a static method to obtain a new instance of a
 * Signable object, currently implemented by the Client class.
 *
 *
 * Usage: Call ClientFactory.getSignable() to receive a  Signable
 * instance.
 *
 * @see logicalModel.interfaces.Signable
 * @see Client
 *
 * @version 1.0
 * @since 2024
 *
 * @author Elbire and Irati
 */
public class ClientFactory {

    /**
     * Creates and returns an instance of  Signable, implemented by
     * Client.
     *
     * @return a new Signable instance
     */
    public static Signable getSignable() {
        return new Client();
    }
}
