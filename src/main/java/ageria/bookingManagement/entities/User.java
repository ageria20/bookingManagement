package ageria.bookingManagement.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String username;

    @Column
    private String fullName;

    @Column
    private String email;

    @OneToMany(mappedBy = "userId")
    private List<Booking> bookings;

}
