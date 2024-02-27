package com.contact.manager.dao;

import com.contact.manager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select e from User e where e.user_email = : user_email")
    public User getUserByEmail(@Param("user_email") String user_email);
}
