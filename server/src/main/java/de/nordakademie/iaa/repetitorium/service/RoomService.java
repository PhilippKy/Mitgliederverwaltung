package de.nordakademie.iaa.repetitorium.service;

import de.nordakademie.iaa.repetitorium.model.Room;

import java.util.List;

/**
 * Public interface of the room service.
 *
 * @author Stephan Anft
 */
public interface RoomService {

    /**
     * Takes the new room and stores it in the database.
     *
     * @param room The room to be persisted.
     * @throws EntityAlreadyPresentException if a room with the same building/room number
     *                                       combination is already present in the database.
     */
    void createNew(Room room) throws EntityAlreadyPresentException;

    /**
     * List all rooms currently stored in the database.
     *
     * @return a list of Room entities. If no room was found an empty list is
     * returned.
     */
    List<Room> findAll();

    /**
     * Returns the room identified by the given id.
     *
     * @param id The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    Room findBy(Long id);

    /**
     * Updates a room entity and stores the changes into the database.
     *
     * @param id        The identifier.
     * @param seats     The number of seats.
     * @param projector The projector flag.
     * @throws EntityNotFoundException if no room could be found for the given id.
     */
    void update(Long id, int seats, boolean projector) throws EntityNotFoundException;

    /**
     * Deletes the room with the given id.
     *
     * @param id The identifier.
     * @throws EntityNotFoundException if no room could be fount for the given id.
     */
    void delete(Long id) throws EntityNotFoundException;
}
