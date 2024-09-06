package ageria.bookingManagement.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "buildings")
public class Building {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    private List<Workstation> workstations;

    public Building(String regioneCalabria, String name, String catanzaro) {
        this.name = name;
        this.address = regioneCalabria;
        this.city = catanzaro;
    }
}
