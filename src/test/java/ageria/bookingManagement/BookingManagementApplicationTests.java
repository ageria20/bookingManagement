package ageria.bookingManagement;

import ageria.bookingManagement.entities.Booking;
import ageria.bookingManagement.entities.Building;
import ageria.bookingManagement.entities.User;
import ageria.bookingManagement.entities.Workstation;
import ageria.bookingManagement.services.BookingService;
import ageria.bookingManagement.services.BuildingService;
import ageria.bookingManagement.services.UserService;
import ageria.bookingManagement.services.WorkstationsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookingManagementApplicationTests {

	@Autowired
	private WorkstationsService workstationsService;

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private UserService userService;





	@Test
	void chckBookingOnDb() {

		Building getBuildingFormDb = buildingService.findById(UUID.fromString("101fc2fc-7ea8-4714-9484-7a1253c089ad"));
		Workstation workstationFromDB = workstationsService.findWorkstationById(UUID.fromString("81d3c2ab-5226-490d-8542-973c2facefcb"));
		User user1FromDB = userService.findUserById(UUID.fromString("1e63e86c-b65e-4f75-908d-1079c3abc901"));

		assertNotNull(workstationFromDB, "expected workstation not null");
		assertNotNull(getBuildingFormDb,"expected building not null" );
		assertNotNull(user1FromDB, "expected user not null");


	}

	@ParameterizedTest
	@CsvSource({"A", "M"})
	void checkUserNAme(String letterName){
		List<User> users = userService.findByNameStartingWithIgnoreCase(letterName);
		assertAll(
				() -> assertNotNull(users, "expected users not null"),
                () -> users.forEach(user -> assertNotNull(user.getUsername(), "expected username not null"))
		);
	}





}
