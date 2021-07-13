package com.izec.repositories;

import com.izec.domeins.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;





public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);

    User findByActivationCode(String code);

    @Query(nativeQuery = true, value = "SELECT MAX(id) FROM usr")
    Long findMaxId();
}
