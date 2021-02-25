package com.tts.ecommerce.Repository;

import com.tts.ecommerce.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
