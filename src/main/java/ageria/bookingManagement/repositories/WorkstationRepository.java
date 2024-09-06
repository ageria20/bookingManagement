package ageria.bookingManagement.repositories;

import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.entities.User;
import ageria.bookingManagement.entities.Workstation;
import ageria.bookingManagement.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WorkstationRepository extends JpaRepository<Workstation, UUID> {

    @Query("SELECT w FROM Workstation w WHERE w.roomType = :roomType AND LOWER(w.building.city) LIKE LOWER(:city)")
    List<Workstation> findByRoomTypeAndBuilding(RoomType roomType,String city);

    @Query("SELECT w FROM Workstation w WHERE w.roomType = :roomType AND LOWER(w.building.city) LIKE LOWER(CONCAT('%', :city, '%'))")
    List<Workstation> findPartialByRoomTypeAndBuilding(RoomType roomType,String city);



}
