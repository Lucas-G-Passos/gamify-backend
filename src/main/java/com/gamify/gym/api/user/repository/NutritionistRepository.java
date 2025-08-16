package com.gamify.gym.api.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamify.gym.api.user.model.NutritionistModel;
import com.gamify.gym.api.user.model.User;

public interface NutritionistRepository extends JpaRepository<NutritionistModel, Long> {
    Optional<NutritionistModel> findByCrn(long crn);

    Optional<NutritionistModel> findByCpf(long cpf);

    boolean existsByUser(User user);
}
