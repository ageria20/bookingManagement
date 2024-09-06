package ageria.bookingManagement.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "bookings")
public class Booking {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "workstation_id", nullable = false)
    private Workstation workstationId;

    @Column
    private LocalDate bookingDate;

    public Booking() {}

    public Booking(User user, Workstation workstation, LocalDate bookingDate) {
        this.userId = user;
        this.workstationId = workstation;
        this.bookingDate = bookingDate;
    }
}
