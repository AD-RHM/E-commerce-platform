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
    boolean updateFirstName(@Param("userid") Long id,@Param("first_name") String firstName);

    @Query(
            value = "Update users u set u.last_name = :last_name where u.userid = :userid",
            nativeQuery = true
    )
    boolean updateLastName(@Param("userid") Long id,@Param("last_name") String lastName);

    @Query(
            value = "Update users u set u.password_hash = :password_hash where u.userid = :userid",
            nativeQuery = true
    )
    boolean updatePassword(@Param("userid") Long id,@Param("password_hash") String password_hash);

    @Query(
            value = "Update users u set u.email = :email where u.userid = :userid",
            nativeQuery = true
    )
    boolean updateEmail(@Param("userid") Long id,@Param("email") String firstName);

}