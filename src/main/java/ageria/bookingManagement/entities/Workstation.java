package ageria.bookingManagement.entities;


import ageria.bookingManagement.enums.RoomType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "workstations")
public class Workstation {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column
    private Integer occupants;

    @OneToMany(mappedBy = "workstationId", fetch=FetchType.EAGER)
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    public Workstation(String salaVerde, RoomType roomType, int occupants, Building building) {
        this.description = salaVerde;
        this.roomType = roomType;
        this.occupants = occupants;
        this.building = building;
    }

    public Workstation() {

    }

    @Override
    public String toString() {
        return "Workstation = " +
                "Description: " + description +
                ", Room Type: " + roomType +
                ", Occupants: " + occupants;
    }
}
