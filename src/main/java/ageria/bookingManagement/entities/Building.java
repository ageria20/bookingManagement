package ageria.bookingManagement.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    private List<Workstation> workstations;
}
