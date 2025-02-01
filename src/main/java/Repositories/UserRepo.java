package Repositories;

import Entities.User;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    //JPQL QUERY
    //@Query("Update User u SET u.firstName = ?2 where u.userId = ?1")

    //Native query Param
    @Query(
            value = "Update users u set u.first_name = :first_name where u.userid = :userid",
            nativeQuery = true
    )
    boolean updateFirstName(@Param("first_name") Long id,@Param("userid") String firstName);
}