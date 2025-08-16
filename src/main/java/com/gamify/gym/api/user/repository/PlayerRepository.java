package com.gamify.gym.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamify.gym.api.user.model.PlayerModel;
import com.gamify.gym.api.user.model.User;

public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
    boolean existsByUser(User user);
}
