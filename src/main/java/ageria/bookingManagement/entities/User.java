package ageria.bookingManagement.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Data
@Table(name = "users")
public class User {

    @Setter(AccessLevel.NONE)
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

    public User(String ageria, String andreaGeria, String mail) {
        this.username = ageria;
        this.fullName = andreaGeria;
        this.email = mail;
    }

    public User() {
    }
}
