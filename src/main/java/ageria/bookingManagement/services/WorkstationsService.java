package ageria.bookingManagement.services;


import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.entities.Workstation;
import ageria.bookingManagement.enums.RoomType;
import ageria.bookingManagement.exceptions.NotFoundExceptionId;
import ageria.bookingManagement.repositories.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkstationsService {

    // TODO: Implement WorkstationsService methods here
    @Autowired
    private WorkstationRepository workstationRepository;

    public void saveWorkstations(Workstation workstation){
        workstationRepository.save(workstation);
        System.out.println("Workstations saved successfully");
    }

    public Workstation findWorkstationById(UUID id){
        return workstationRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));

    }

    public void deleteById(UUID id){
        if(!workstationRepository.existsById(id)){
            throw new NotFoundExceptionId(id);

        }else {
        workstationRepository.deleteById(id);
        System.out.println("Workstations deleted successfully");
        }
    }

    public void findWorkstationByIdAndUpdate(UUID id, String description){
        Workstation found = this.findWorkstationById(id);
        found.setDescription(description);
        workstationRepository.save(found);
        System.out.println("Workstation con id: " + id + " e descrizione: " + description +  " e' stato aggiornato");
    }

    public List<Workstation> findByRoomType(RoomType roomType, String city){
        return workstationRepository.findByRoomTypeAndBuilding(roomType, city);
    }


}
