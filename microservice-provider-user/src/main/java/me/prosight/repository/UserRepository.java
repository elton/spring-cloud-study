package me.prosight.repository;

import me.prosight.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by elton on 2017/2/5.
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}