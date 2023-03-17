package com.application.shopapi.User;

import com.application.shopapi.User.RequestHandler.UserRequest;
import com.application.shopapi.User.RequestHandler.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByUsername(String username);

    @Query(value = "Select * from users WHERE user_id = :id", nativeQuery = true)
    public UserModel findUserById(@Param("id") UUID id);

    @Modifying
    @Transactional
    @Query(value = "Update users set username = :name where user_id= :id", nativeQuery = true)
    public void updateUserName(@Param("name") String name, @Param("id") UUID id);
    @Query("SELECT NEW com.application.shopapi.User.RequestHandler.UserResponse"
           + "(u.id,u.username,u.password,u.email,u.role,c.firstname,c.lastname,c.middlename,c.address,c.dob,c.createdAt,c.updatedAt)"
           +" from UserModel u INNER JOIN CustomerModel c ON c.user=u.id")
    public List<UserResponse> findCustomers();
}
