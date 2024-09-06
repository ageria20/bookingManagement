package ageria.bookingManagement.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "buildings")
public class Building {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    private List<Workstation> workstations;

    public Building(String name, String address, String catanzaro) {
        this.name = name;
        this.address = address;
        this.city = catanzaro;
    }

    public Building() {}
}
