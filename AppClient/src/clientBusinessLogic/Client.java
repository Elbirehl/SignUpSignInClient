package clientBusinessLogic;

import logicalExceptions.MaxThreadsErrorException;
import logicalExceptions.ServerErrorException;
import logicalExceptions.SignInErrorException;
import logicalExceptions.UserExistErrorException;
import logicalExceptions.UserNotActiveException;
import logicalModel.interfaces.Signable;
import logicalModel.message.Message;
import logicalModel.message.MessageType;
import logicalModel.model.User;

/**
 * Implements the  Signable interface to manage user authentication
 * (sign-in and sign-up) via server communication. Processes server responses
 * and handles exceptions for specific error cases.
 *
 * @author Olaia, Meylin, Elbire and Irati
 */
public class Client implements Signable {

    /**
     * Attempts to sign in a user by sending their data to the server. Returns
     * the  User if successful, or throws an exception based on the
     * server's response.
     *
     * @param user the user attempting to sign in
     * @return the signed-in  User object if successful
     * @throws MaxThreadsErrorException if the server has reached its thread
     * limit
     * @throws ServerErrorException if a server error occurs
     * @throws SignInErrorException if sign-in fails
     * @throws UserNotActiveException if the user is inactive
     */
    @Override
    public User signIn(User user) throws MaxThreadsErrorException, ServerErrorException, SignInErrorException, UserNotActiveException {
        Message request = new Message();
        request.setUser(user);
        request.setMessage(MessageType.SIGN_IN_REQUEST);

        Message response = ClientSocket.sendRecieveMessage(request);

        if (response == null) {
            throw new ServerErrorException("No response from server.");
        }

        User resultUser = null;

        if (response.getMessage() == MessageType.OK_RESPONSE) {
            resultUser = response.getUser();
        } else if (response.getMessage() == MessageType.MAX_THREADS_ERROR) {
            throw new MaxThreadsErrorException("Maximum threads reached. Please wait and try again later.");
        } else if (response.getMessage() == MessageType.SERVER_ERROR) {
            throw new ServerErrorException("Internal server error");
        } else if (response.getMessage() == MessageType.SIGN_IN_ERROR) {
            throw new SignInErrorException("Error during sign-in process.");
        } else if (response.getMessage() == MessageType.USER_NOT_ACTIVE) {
            throw new UserNotActiveException("The user is not active");
        }

        return resultUser;
    }

    /**
     * Attempts to sign up a new user by sending their data to the server.
     * Returns the User if successful, or throws an exception if an
     * error occurs.
     *
     * @param user the user attempting to sign up
     * @return the signed-up  User object if successful
     * @throws ServerErrorException if a server error occurs
     * @throws UserExistErrorException if the user already exists
     * @throws MaxThreadsErrorException if the server has reached its thread
     * limit
     */
    @Override
    public User signUp(User user) throws ServerErrorException, UserExistErrorException, MaxThreadsErrorException {
        Message request = new Message();
        request.setUser(user);
        request.setMessage(MessageType.SIGN_UP_REQUEST);

        Message response = ClientSocket.sendRecieveMessage(request);

        if (response == null) {
            throw new ServerErrorException("No response from server.");
        }

        User resultUser = null;

        if (null != response.getMessage()) {
            switch (response.getMessage()) {
                case OK_RESPONSE:
                    resultUser = response.getUser();
                    break;
                case SERVER_ERROR:
                    throw new ServerErrorException("Internal server error");
                case USER_EXISTS_ERROR:
                    throw new UserExistErrorException("The user already exists");
                case MAX_THREADS_ERROR:
                    throw new MaxThreadsErrorException("Maximum threads reached. Please wait and try again later.");
                default:
                    break;
            }
        }

        return resultUser;
    }
}
