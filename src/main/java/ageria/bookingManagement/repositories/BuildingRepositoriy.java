package ageria.bookingManagement.repositories;

import ageria.bookingManagement.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingRepositoriy extends JpaRepository<Building, UUID> {


}
