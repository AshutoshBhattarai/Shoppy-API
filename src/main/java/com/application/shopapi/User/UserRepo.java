package com.application.shopapi.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {

    @Query(value = "Select * from Users WHERE user_id = :id",nativeQuery = true)
    public UserModel findUserById(@Param("id") UUID id);
}
