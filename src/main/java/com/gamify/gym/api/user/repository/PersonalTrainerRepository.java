package com.gamify.gym.api.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamify.gym.api.user.model.PersonalTrainerModel;
import com.gamify.gym.api.user.model.User;

public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainerModel, Long> {
    Optional<PersonalTrainerModel> findByCref(String cref);

    Optional<PersonalTrainerModel> findByCpf(String cpf);

    boolean existsByUser(User user);
}
