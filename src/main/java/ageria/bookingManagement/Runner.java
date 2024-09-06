package ageria.bookingManagement;

import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.entities.User;
import ageria.bookingManagement.entities.Workstation;
import ageria.bookingManagement.services.BuildingService;
import ageria.bookingManagement.services.UserService;
import ageria.bookingManagement.services.WorkstationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

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
    ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("ageria", "Andrea Geria", "ageria@gmail.com");
        User user2 = new User("mgeria", "Mirko Geria", "mgeria@gmail.com");
        User user3 = new User("mabozzi", "Mirko Abozzi", "mabozzi@gmail.com");
        User user4 = new User("cicciodb", "Francesco De Benedetto", "cicciodb@gmail.com");

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





    }
}
