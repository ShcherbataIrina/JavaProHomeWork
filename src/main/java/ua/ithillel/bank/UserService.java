package ua.ithillel.bank;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        userRepository.findAll()
                .forEach(user -> System.out.println("User" + user));

        var newUser = User.builder()
                .uid(UUID.randomUUID().toString())
                .name("Alen")
                .email("altest@gmail.com")
                .role(UserRole.CUSTOMER)
                .build();

//     var persisted = userRepository.save(newUser);
//    System.out.println("User" + persisted);

        var user = userRepository.findById(5L).orElseThrow();
//        user.setRole(UserRole.CUSTOMER);
//        System.out.println("User" + user);
//
//        userRepository.deleteById(8L);
        System.out.println("Count users: " + userRepository.count());
        System.out.println("Find users by email: " + userRepository.findByEmail("altest@gmail.com"));

    }
}
