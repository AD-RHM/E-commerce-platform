package Repositories;

import Entities.Role;
import Entities.User;
import Services.UserServices;
import com.RAHMANE.E_commerce.platforme.ECommercePlatformApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest(classes = ECommercePlatformApplication.class)
class UserRepoTest {

    @Autowired
    private UserServices userServices;

    @Autowired
    UserRepo userRepo;

    @Test
    public void loginUser (){
        User user = userServices.login("adibrahmane@gmail.com","0000");
        System.out.println(user);
    }

    @Test
    public void registerUser(){
        User user = User.builder()
                .firstName("ADIB")
                .lastName("RAHMANE")
                .email("RAHMANE@gmail.com")
                .password("4444")
                .createdAt(LocalDateTime.now())
                .role(Role.ADMIN)
                .build();
        userServices.signUp(user);
        //List<User> users = userRepo.findAll();
        System.out.println(user);
    }

}