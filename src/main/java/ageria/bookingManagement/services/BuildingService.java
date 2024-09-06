package ageria.bookingManagement.services;


import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.repositories.BuildingRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepositoriy buildingRepository;

    public void saveBuilding(Building building) {
        buildingRepository.save(building);
    }



}
