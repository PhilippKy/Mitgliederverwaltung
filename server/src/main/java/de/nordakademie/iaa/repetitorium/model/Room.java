package de.nordakademie.iaa.repetitorium.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Entity representing a room.
 *
 * @author Stephan Anft
 */
@Entity
public class Room implements Serializable {

    private Long id;
    private String building;
    private Integer roomNumber;
    private Integer seats;
    private boolean projectorPresent;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    @NaturalId
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Column(name = "ROOM_NUMBER", nullable = false)
    @NaturalId
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(nullable = false)
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Column(name = "PROJECTOR_PRESENT")
    public boolean isProjectorPresent() {
        return projectorPresent;
    }

    public void setProjectorPresent(boolean projectorPresent) {
        this.projectorPresent = projectorPresent;
    }
}
