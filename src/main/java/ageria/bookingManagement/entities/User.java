package ageria.bookingManagement.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String username;

    @Column
    private String fullName;

    @Column
    private String email;

}
