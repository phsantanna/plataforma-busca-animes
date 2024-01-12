package com.platform.tracking.anime.repository;

import com.platform.tracking.anime.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositor extends JpaRepository<User, Long> {
}
