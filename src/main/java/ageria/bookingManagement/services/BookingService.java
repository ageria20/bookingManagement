package ageria.bookingManagement.services;

import ageria.bookingManagement.entities.Booking;
import ageria.bookingManagement.entities.User;
import ageria.bookingManagement.exceptions.NotFoundExceptionId;
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
        bookingRepository.save(booking);
        System.out.println("Booking saved successfully");
    }

    public Booking findById(UUID id){
        return bookingRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));
    }

//    public void checkDate(User user, LocalDate bookingDate){
//        if(bookingRepository.existsByBookinDate(bookingDate)){
//
//        }
//    }
}
