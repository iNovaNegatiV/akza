package de.akza.jk.config;

import de.akza.jk.models.Role;
import de.akza.jk.models.User;
import de.akza.jk.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SetupDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${setup.data.username}")
    private String setupUsername;
    @Value("${setup.data.password}")
    private String setupPassword;
    @Value("${setup.data.firstname}")
    private String setupFirstname;
    @Value("${setup.data.lastname}")
    private String setupLastname;

    public SetupDataLoader(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername(setupUsername).isPresent()) {
            System.out.println("User with name " + setupUsername + " already exists. Not creating new Admin");
            return;
        }

        var user =
                User.builder()
                        .firstname(setupFirstname)
                        .lastname(setupLastname)
                        .username(setupUsername)
                        .password(passwordEncoder.encode(setupPassword))
                        .role(Role.ADMIN)
                        .build();
        userRepository.save(user);
    }
}
