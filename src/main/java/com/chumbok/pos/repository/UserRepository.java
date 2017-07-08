package com.chumbok.pos;

/**
 * Created by Dell on 30-May-17.
 */

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


}