package de.akza.jk.services;

import de.akza.jk.Dtos.GetUserDto;
import de.akza.jk.exceptions.UserNotFoundException;
import de.akza.jk.mappers.UserMapper;
import de.akza.jk.models.User;
import de.akza.jk.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<GetUserDto> getAllUsers() {
        return this.userMapper.toDtos(this.userRepository.findAll());
    }

    public GetUserDto getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("Der Benutzer mit der ID " + id + " konnte nicht gefunden werden!");
        }
        return this.userMapper.toDto(user.get());

    }

    public GetUserDto getUserByUsername(String username) {
        Optional<User> user = this.userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UserNotFoundException("Der Benutzer mit dem Namen " + username + " konnte nicht gefunden werden!");
        }
        return this.userMapper.toDto(user.get());
    }
}
