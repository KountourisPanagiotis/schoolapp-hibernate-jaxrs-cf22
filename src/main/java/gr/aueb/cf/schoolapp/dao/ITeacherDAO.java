package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.Teacher;
import java.util.List;

/**
 * Provides methods for managing teachers in the database.
 *
 * @author Kountouris Panagiotis
 */
public interface ITeacherDAO {

    /**
     * Inserts a new teacher into the database.
     *
     * @param teacher the teacher to insert.
     * @return the newly created teacher.
     */
    Teacher insert(Teacher teacher);

    /**
     * Updates an existing teacher in the database.
     *
     * @param teacher the teacher to update.
     * @return the updated teacher.
     */
    Teacher update(Teacher teacher);

    /**
     * Deletes the teacher with the given ID from the database.
     *
     * @param id the ID of the teacher to delete.
     */
    void delete(Long id);

    /**
     * Returns a list of teachers with the given last name.
     *
     * @param lastname the last name to search for.
     * @return a list of teachers with the given last name.
     */
    List<Teacher> getByLastName(String lastname);

    /**
     * Returns the teacher with the given ID.
     *
     * @param id the ID of the teacher to retrieve.
     * @return the teacher with the given ID.
     */
    Teacher getById(Long id);
}
