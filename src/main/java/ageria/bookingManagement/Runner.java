package ageria.bookingManagement;

import ageria.bookingManagement.entities.Booking;
import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.entities.User;
import ageria.bookingManagement.entities.Workstation;
import ageria.bookingManagement.enums.RoomType;
import ageria.bookingManagement.services.BookingService;
import ageria.bookingManagement.services.BuildingService;
import ageria.bookingManagement.services.UserService;
import ageria.bookingManagement.services.WorkstationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private WorkstationsService workstationsService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
//        User user1 = new User("ageria", "Andrea Geria", "ageria@gmail.com");
//        User user2 = new User("mgeria", "Mirko Geria", "mgeria@gmail.com");
//        User user3 = new User("mabozzi", "Mirko Abozzi", "mabozzi@gmail.com");
//        User user4 = new User("cicciodb", "Francesco De Benedetto", "cicciodb@gmail.com");
        User user1FromDB = userService.findUserById(UUID.fromString("1e63e86c-b65e-4f75-908d-1079c3abc901"));
        User user2FromDB = userService.findUserById(UUID.fromString("69582222-68e4-441a-b0ca-ffc98c5c1b4c"));
        User user3FromDB = userService.findUserById(UUID.fromString("8b15ef1a-e8a5-4b40-a8d8-105ad4e77e56"));
        User user4FromDB = userService.findUserById(UUID.fromString("9353304e-29f3-4d33-8864-9b4379e44b52"));


        Workstation workstationVerdiFromDB = workstationsService.findWorkstationById(UUID.fromString("456579b8-f556-4e10-b8ae-19a746cf95f2"));
        Workstation workstationSordiFromDB = workstationsService.findWorkstationById(UUID.fromString("81d3c2ab-5226-490d-8542-973c2facefcb"));
        Workstation workstationSantelliFromDB = workstationsService.findWorkstationById(UUID.fromString("d77ac390-f471-4e67-ac7a-0908f49b7afd"));


        // Utenti creati e salvati
        //        userService.saveUser(user1);
//        userService.saveUser(user2);
//        userService.saveUser(user3);
//        userService.saveUser(user4);

        Building newBuilding = (Building) ctx.getBean("getBuilding");
//        System.out.println(newBuilding);
        // buildingService.saveBuilding(newBuilding);
        Building buildingFromDB = buildingService.findById(UUID.fromString("101fc2fc-7ea8-4714-9484-7a1253c089ad"));


//        Workstation workstationVerdi = (Workstation) ctx.getBean("getWorkstationSalaVerdi");
//        workstationVerdi.setBuilding(buildingFromDB);
//
//        Workstation workstationSordi = (Workstation) ctx.getBean("getWorkstationSalaSordi");
//        workstationSordi.setBuilding(buildingFromDB);
//        Workstation workstationSantelli = (Workstation) ctx.getBean("getWorkstationSalaSantelli");
//        workstationSantelli.setBuilding(buildingFromDB);
//        workstationsService.saveWorkstations(workstationVerdi);
//        workstationsService.saveWorkstations(workstationSordi);
//        workstationsService.saveWorkstations(workstationSantelli);

        Booking booking1user1 = new Booking(user1FromDB, workstationVerdiFromDB, LocalDate.of(2024, 9, 6));
        Booking booking2user1 = new Booking(user1FromDB, workstationSordiFromDB, LocalDate.of(2024, 10, 16));
        Booking booking3user1 = new Booking(user1FromDB, workstationSantelliFromDB, LocalDate.of(2024, 11, 28));
        Booking booking1user2 = new Booking(user2FromDB, workstationSantelliFromDB, LocalDate.of(2024, 12, 28));
        Booking booking2user2 = new Booking(user2FromDB, workstationSantelliFromDB, LocalDate.of(2024, 12, 25));
        bookingService.saveBooking(booking2user2);
//        bookingService.saveBooking(booking1user1);
//        bookingService.saveBooking(booking2user1);
//        bookingService.saveBooking(booking3user1);

        workstationsService.findByRoomType(RoomType.PRIVATE).forEach(System.out::println);








    }
}
