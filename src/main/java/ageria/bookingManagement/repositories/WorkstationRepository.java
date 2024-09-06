package ageria.bookingManagement.repositories;

import ageria.bookingManagement.entities.User;
import ageria.bookingManagement.entities.Workstation;
import ageria.bookingManagement.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkstationRepository extends JpaRepository<Workstation, UUID> {


    List<Workstation> findByRoomType(RoomType roomType);

}
