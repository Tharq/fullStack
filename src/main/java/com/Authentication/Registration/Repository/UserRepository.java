package com.Authentication.Registration.Repository;

import com.Authentication.Registration.Modal.MyUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<MyUser,String> {

    Optional<MyUser> findByName(String username);

}
