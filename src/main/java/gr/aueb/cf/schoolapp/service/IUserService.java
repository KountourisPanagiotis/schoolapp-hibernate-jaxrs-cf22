package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dto.UserCredentialsDTO;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.service.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.schoolapp.service.exceptions.EntityNotFoundException;

import java.util.List;

/**
 * Provides methods for managing users.
 *
 * @author Kountouris Panagiotis
 */
public interface IUserService {
    /**
     * Inserts a new user with the given credentials.
     *
     * @param userCredentialsDTO the user credentials.
     * @return the newly created user.
     * @throws EntityAlreadyExistsException if a user with the same username already exists.
     */
    User insertUser(UserCredentialsDTO userCredentialsDTO) throws EntityAlreadyExistsException;

    /**
     * Updates the user with the given credentials.
     *
     * @param userCredentialsDTO the updated user credentials.
     * @return the updated user.
     * @throws EntityNotFoundException if no user with the given ID exists.
     */
    User updateUser(UserCredentialsDTO userCredentialsDTO) throws EntityNotFoundException;

    /**
     * Deletes the user with the given ID.
     *
     * @param id the ID of the user to delete.
     * @throws EntityNotFoundException if no user with the given ID exists.
     */
    void deleteUser(Long id) throws EntityNotFoundException;

    /**
     * Returns a list of users with the given username.
     *
     * @param username the username to search for.
     * @return a list of users with the given username.
     * @throws EntityNotFoundException if no users with the given username exist.
     */
    List<User> getUsersByUsername(String username) throws EntityNotFoundException;

    /**
     * Returns the user with the given ID.
     *
     * @param id the ID of the user to retrieve.
     * @return the user with the given ID.
     * @throws EntityNotFoundException if no user with the given ID exists.
     */
    User getUserById(Long id) throws EntityNotFoundException;
}
