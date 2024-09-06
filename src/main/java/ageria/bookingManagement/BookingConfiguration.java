package ageria.bookingManagement;

import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.entities.Workstation;
import ageria.bookingManagement.enums.RoomType;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class BookingConfiguration {


    @Bean
    public Building getBuilding(){
        return new Building("Regione Calabria", "Viale Europa, 35","Catanzaro");
    }

    @Bean
    public Workstation getWorkstationSalaVerdi(){
        return new Workstation("Sala Verdi", RoomType.MEETING, 150, getBuilding());
    }

    public Workstation getWorkstationSalaSordi(){
        return new Workstation("Sala Sordi", RoomType.OPENSPACE, 350, getBuilding());
    }

    public Workstation getWorkstationSalaSantelli(){
        return new Workstation("Sala Santelli", RoomType.PRIVATE, 50, getBuilding());
    }
}
