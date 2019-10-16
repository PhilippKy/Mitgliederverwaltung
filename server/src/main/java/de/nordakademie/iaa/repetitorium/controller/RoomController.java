package de.nordakademie.iaa.repetitorium.controller;

import de.nordakademie.iaa.repetitorium.model.Room;
import de.nordakademie.iaa.repetitorium.service.EntityAlreadyPresentException;
import de.nordakademie.iaa.repetitorium.service.EntityNotFoundException;
import de.nordakademie.iaa.repetitorium.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * REST controller for the room entity.
 *
 * @author Stephan Anft
 */
@RestController
public class RoomController {

    private RoomService roomService;

    /**
     * List all rooms.
     *
     * @return the list of rooms.
     */
    @RequestMapping(path = "/rooms", method = GET)
    public List<Room> listRooms() {
        return roomService.findAll();
    }

    /**
     * Saves the given room (either by creating a new one or updating an existing).
     *
     * @param room The room to save.
     */
    @RequestMapping(path = "/rooms", method = PUT)
    public ResponseEntity saveRoom(@RequestBody Room room) {
        try {
            if (room.getId() == null) {
                roomService.createNew(room);
            }
            else {
                roomService.update(room.getId(), room.getSeats(), room.isProjectorPresent());
            }
            return ResponseEntity.ok().build();
        }
        catch (EntityAlreadyPresentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes the room with given id.
     *
     * @param id The id of the room to be deleted.
     */
    @RequestMapping(path = "/rooms/{id}", method = DELETE)
    public ResponseEntity deleteRoom(@PathVariable Long id) {
        try {
            roomService.delete(id);
            return ResponseEntity.ok(null);
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Inject
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }
}
