package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dto.TeacherDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.schoolapp.service.exceptions.EntityNotFoundException;
import java.util.List;

/**
 * Provides methods for managing teachers.
 *
 * @author Kountouris Panagiotis
 */
public interface ITeacherService {

    /**
     * Inserts a new teacher with the given information.
     *
     * @param teacherDTO the teacher's information.
     * @return the newly created teacher.
     * @throws EntityAlreadyExistsException if a teacher with the same ID already exists.
     */
    Teacher insertTeacher(TeacherDTO teacherDTO) throws EntityAlreadyExistsException;

    /**
     * Updates the teacher with the given information.
     *
     * @param teacherDTO the updated teacher information.
     * @return the updated teacher.
     * @throws EntityNotFoundException if no teacher with the given ID exists.
     */
    Teacher updateTeacher(TeacherDTO teacherDTO) throws EntityNotFoundException;

    /**
     * Deletes the teacher with the given ID.
     *
     * @param id the ID of the teacher to delete.
     * @throws EntityNotFoundException if no teacher with the given ID exists.
     */
    void deleteTeacher(Long id) throws EntityNotFoundException;

    /**
     * Returns a list of teachers with the given last name.
     *
     * @param lastname the last name to search for.
     * @return a list of teachers with the given last name.
     * @throws EntityNotFoundException if no teachers with the given last name exist.
     */
    List<Teacher> getTeachersByLastname(String lastname) throws EntityNotFoundException;

    /**
     * Returns the teacher with the given ID.
     *
     * @param id the ID of the teacher to retrieve.
     * @return the teacher with the given ID.
     * @throws EntityNotFoundException if no teacher with the given ID exists.
     */
    Teacher getTeacherById(Long id) throws EntityNotFoundException;
}
