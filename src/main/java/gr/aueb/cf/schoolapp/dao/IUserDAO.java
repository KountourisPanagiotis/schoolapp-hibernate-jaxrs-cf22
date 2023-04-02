package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.User;

import java.util.List;

/**
 * Provides methods for managing users in the data store.
 *
 * @author Kountouris Panagiotis
 */
public interface IUserDAO {

    /**
     * Inserts a new user into the database.
     *
     * @param user the user to insert.
     * @return the newly created user.
     */
    User insert(User user);

    /**
     * Updates an existing user in the database.
     *
     * @param user the user to update.
     * @return the updated user.
     */
    User update(User user);

    /**
     * Deletes the user with the given ID from the database.
     *
     * @param id the ID of the user to delete.
     */
    void delete(Long id);

    /**
     * Returns a list of users with the given username.
     *
     * @param username the username to search for.
     * @return a list of users with the given username.
     */
    List<User> getByUsername(String username);

    /**
     * Returns the user with the given ID.
     *
     * @param id the ID of the user to retrieve.
     * @return the user with the given ID.
     */
    User getById(Long id);
}
