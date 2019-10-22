package de.nordakademie.iaa.repetitorium.dao;

import de.nordakademie.iaa.repetitorium.model.Room;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The room DAO that manages all persistence functionality for a room.
 *
 * @author Stephan Anft
 */
public class RoomDAO {

    private EntityManager entityManager;

    /**
     * Finds a room by given building and room number.
     *
     * @param building   The building.
     * @param roomNumber The room number.
     * @return a room or {@code null}.
     */
    public Room findBy(String building, Integer roomNumber) {
        return entityManager
                .createQuery("select room from Room room where room.building = :building and room.roomNumber = :roomNumber", Room.class)
                .setParameter("building", building)
                .setParameter("roomNumber", roomNumber)
                .getResultStream()
                .findFirst().orElse(null);
    }

    /**
     * Takes the room and stores it in the database.
     *
     * @param room The room to be persisted.
     */
    public void persist(Room room) {
        entityManager.persist(room);
    }

    /**
     * List all rooms currently stored in the database.
     *
     * @return a list of Room entities. If no room was found an empty list is
     * returned.
     */
    public List<Room> findAll() {
        return entityManager.createQuery("select room from Room room", Room.class).getResultList();
    }

    /**
     * Returns the room identified by the given id.
     *
     * @param id The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    public Room findBy(Long id) {
        return entityManager.find(Room.class, id);
    }

    /**
     * Deletes the room.
     *
     * @param room The room to be deleted.
     */
    public void delete(Room room) {
        entityManager.remove(room);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
