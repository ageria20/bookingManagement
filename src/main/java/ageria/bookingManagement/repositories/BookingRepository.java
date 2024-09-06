package ageria.bookingManagement.repositories;

import ageria.bookingManagement.entities.Booking;
import ageria.bookingManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    Booking findByBookingDate(LocalDate bookingDate);

//    @Query("SELECT b.users.id, b.bookingData FROM Booking b JOIN b.users WHERE b.users.id = b.user_id AND b.booking = :bookingDate")
//    boolean existsByBookinDate(LocalDate bookingDate);



}
