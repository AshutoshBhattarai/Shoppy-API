package com.application.shopapi.User;

import com.application.shopapi.User.RequestHandler.CustomerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserModel, UUID> {

    @Query(value = "Select * from Users WHERE user_id = :id", nativeQuery = true)
    public UserModel findUserById(@Param("id") UUID id);

    @Modifying
    @Transactional
    @Query(value = "Update Users set username = :name where user_id= :id", nativeQuery = true)
    public void updateUserName(@Param("name") String name, @Param("id") UUID id);

    @Query(value = "Select new from users u JOIN customer c ON c.user_id=u.user_id",nativeQuery = true)
    public List<Object[]> findCustomers();
}
