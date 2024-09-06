package ageria.bookingManagement.services;

import ageria.bookingManagement.entities.Booking;
import ageria.bookingManagement.entities.User;
import ageria.bookingManagement.exceptions.NotFoundExceptionId;
import ageria.bookingManagement.exceptions.ValidationException;
import ageria.bookingManagement.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void saveBooking(Booking booking){
        if(bookingRepository.existsByUserIdAndBookingDate(booking.getUserId(), booking.getBookingDate()) ){
            throw new ValidationException("The booking with date already exists - save failed");
        } else if (bookingRepository.existsByBookingDateAndWorkstationId(booking.getBookingDate(), booking.getWorkstationId())) {
            throw new ValidationException("The booking with the workstation and date selected is already occupied - save failed");
        } else {
            bookingRepository.save(booking);
            System.out.println("Booking saved successfully");
        }
    }

    public Booking findById(UUID id){
        return bookingRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));
    }

    public void deleteById(UUID id){
        bookingRepository.deleteById(id);
        System.out.println("Booking deleted successfully");
    }

    public void findByIdAndUpdateBookingDate(UUID id, LocalDate bookingDate){
        Booking found = this.findById(id);
        found.setBookingDate( bookingDate );
        bookingRepository.save(found);
    }



//    public void checkDate(User user, LocalDate bookingDate){
//        if(bookingRepository.existsByBookinDate(bookingDate)){
//
//        }
//    }
}
