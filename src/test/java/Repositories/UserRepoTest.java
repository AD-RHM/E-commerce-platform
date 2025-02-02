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

//    @Autowired
//    UserRepo userRepo;

//    @Test
//    public void loginUser (){
//        User user = userServices.login("adibrahmane@gmail.com","0000");
//        System.out.println(user);
//    }

//    @Test
//    public void registerUser(){
//        User user = User.builder()
//                .firstName("ADIB")
//                .lastName("RAHMANE")
//                .email("adib@gmail.com")
//                .password("5555")
//                .createdAt(LocalDateTime.now())
//                .role(Role.USER)
//                .build();
//        userServices.signUp(user);
//        //List<User> users = userRepo.findAll();
//        System.out.println(user);
//    }

//    @Test
//    public void editFirstName(){
//        User user = User.builder()
//                .firstName("ADIB")
//                .lastName("RAHMANE")
//                .password("555567")
//                .role(Role.ADMIN)
//                .build();
//        userServices.editProfile(2L,user);
//
//    }
    @Test
    public void showAll(){
        for (User user : userServices.getAllUsers()){
            System.out.println(user.getUserId() + " " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail() + " " +
                    user.getPassword() + " " + user.getRole());

        }
    }


}