package ageria.bookingManagement;

import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.entities.Workstation;
import ageria.bookingManagement.enums.RoomType;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingConfiguration {


    @Bean(name = "getBuilding")
    public Building getBuilding(){
        return new Building("Regione Calabria", "Viale Europa, 35","Catanzaro");
    }

    @Bean
    public Workstation getWorkstationSalaVerdi() {
        Workstation workstation = new Workstation();
        workstation.setDescription("Sala Verdi");
        workstation.setRoomType(RoomType.MEETING);
        workstation.setOccupants(150);


        return workstation;
    }

    @Bean
    public Workstation getWorkstationSalaSordi() {
        Workstation workstation = new Workstation();
        workstation.setDescription("Sala Sordi");
        workstation.setRoomType(RoomType.OPENSPACE);
        workstation.setOccupants(350);


        return workstation;
    }
    @Bean
    public Workstation getWorkstationSalaSantelli() {
        Workstation workstation = new Workstation();
        workstation.setDescription("Sala Santelli");
        workstation.setRoomType(RoomType.PRIVATE);
        workstation.setOccupants(50);


        return workstation;
    }
}
