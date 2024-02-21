package com.user.UserAPI.repository;
import com.user.UserAPI.repository.UserRepository;
import com.user.UserAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT e FROM User e WHERE e.name = :name")
    User findbyName(@Param("name") String name);



}
