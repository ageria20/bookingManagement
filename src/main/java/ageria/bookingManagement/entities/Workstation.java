package ageria.bookingManagement.entities;


import ageria.bookingManagement.enums.RoomType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "workstations")
public class Workstation {


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

    @OneToMany(mappedBy = "workstationId")
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
}
