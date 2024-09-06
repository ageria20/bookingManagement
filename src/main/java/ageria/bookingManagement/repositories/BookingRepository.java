package ageria.bookingManagement.repositories;

import ageria.bookingManagement.entities.Booking;
import ageria.bookingManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    List<Booking> findByUserUsername(String username);

    boolean existsByUserUsername(String username);
    boolean existsByUserEmail(String email);
}
