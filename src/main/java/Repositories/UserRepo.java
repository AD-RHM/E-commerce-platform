package Repositories;

import Entities.User;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    //JPQL QUERY
    //@Query("Update User u SET u.firstName = ?2 where u.userId = ?1")

    //Native query Param
    @Modifying
    @Transactional
    @Query(
            value = "Update users set first_name = :first_name where userid = :userid",
            nativeQuery = true
    )
    void updateFirstName(@Param("userid") Long id,@Param("first_name") String firstName);

    @Modifying
    @Transactional
    @Query(
            value = "Update users set last_name = :last_name where userid = :userid",
            nativeQuery = true
    )
    void updateLastName(@Param("userid") Long id,@Param("last_name") String lastName);

    @Modifying
    @Transactional
    @Query(
            value = "Update users set password_hash = :password_hash where userid = :userid",
            nativeQuery = true
    )
    void updatePassword(@Param("userid") Long id,@Param("password_hash") String password_hash);

    @Modifying
    @Transactional
    @Query(
            value = "Update users set email = :email where userid = :userid",
            nativeQuery = true
    )
    void updateEmail(@Param("userid") Long id,@Param("email") String firstName);

}