package Repositories;

import Entities.Role;
import Entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = com.RAHMANE.E_commerce.platforme.ECommercePlatformeApplication.class)
class UserRepoTest {

    private UserRepo userRepo;

    @Test
    public void saveUser (){

        User user = new  User(
                "Adib",
                "RAHMANE",
                "adib@gmail.com",
                "0000",
                Role.USER
        );
        userRepo.save(user);

        User retrievedUser = userRepo.findById(user.getUserId()).orElse(null);
        assertNotNull(retrievedUser);
        assertEquals("Adib", retrievedUser.getFirstName());
        assertEquals("RAHMANE", retrievedUser.getLastName());
        assertEquals("adib@gmail.com", retrievedUser.getEmail());
        assertEquals("0000", retrievedUser.getPassword());
        assertEquals(Role.USER, retrievedUser.getRole());
    }

}