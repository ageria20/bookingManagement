package ageria.bookingManagement.repositories;

import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingRepositories extends JpaRepository<Building, UUID> {


}
