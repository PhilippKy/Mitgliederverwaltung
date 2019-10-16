package de.nordakademie.iaa.repetitorium.service;

import de.nordakademie.iaa.repetitorium.dao.RoomDAO;
import de.nordakademie.iaa.repetitorium.model.Room;

import javax.inject.Inject;
import java.util.List;

/**
 * Room service implementation.
 *
 * @author Stephan Anft
 */
public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;

    @Override
    public void createNew(Room room) throws EntityAlreadyPresentException {
        if (roomDAO.findBy(room.getBuilding(), room.getRoomNumber()) != null) {
            // Existing room found in database
            throw new EntityAlreadyPresentException();
        }
        roomDAO.persist(room);
    }

    @Override
    public List<Room> findAll() {
        return roomDAO.findAll();
    }

    @Override
    public Room findBy(Long id) {
        return roomDAO.findBy(id);
    }

    @Override
    public void update(Long id, int seats, boolean projector) throws EntityNotFoundException {
        Room room = findBy(id);
        if (room == null) {
            throw new EntityNotFoundException();
        }
        room.setSeats(seats);
        room.setProjectorPresent(projector);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Room room = findBy(id);
        if (room == null) {
            throw new EntityNotFoundException();
        }
        roomDAO.delete(room);
    }

    @Inject
    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }
}
