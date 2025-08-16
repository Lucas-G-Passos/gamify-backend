package com.gamify.gym.api.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gamify.gym.api.user.model.User;
import com.gamify.gym.api.user.model.UserAuthenticated;
import com.gamify.gym.api.user.repository.NutritionistRepository;
import com.gamify.gym.api.user.repository.PersonalTrainerRepository;
import com.gamify.gym.api.user.repository.PlayerRepository;
import com.gamify.gym.api.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;
    private final NutritionistRepository nutritionistRepository;
    private final PersonalTrainerRepository personalTrainerRepository;

    public UserDetailsServiceImpl(
            UserRepository userRepository,
            PlayerRepository playerRepository,
            NutritionistRepository nutritionistRepository,
            PersonalTrainerRepository personalTrainerRepository) {
        this.userRepository = userRepository;
        this.playerRepository = playerRepository;
        this.nutritionistRepository = nutritionistRepository;
        this.personalTrainerRepository = personalTrainerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        String userType;
        if (playerRepository.existsByUser(user)) {
            userType = "player";
        } else if (nutritionistRepository.existsByUser(user)) {
            userType = "nutritionist";
        } else if (personalTrainerRepository.existsByUser(user)) {
            userType = "personal";
        } else {
            throw new UsernameNotFoundException("User type not recognized");
        }

        return new UserAuthenticated(user, userType);
    }
}
