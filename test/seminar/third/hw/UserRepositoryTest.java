package seminar.third.hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import seminar.third.hw.tdd.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    public void testAddUser() {
        User user = new User("User", "password123", false);
        userRepository.addUser(user);
        assertTrue(userRepository.findByName("User"));
    }

    @Test
    public void testFindByName() {
        User user1 = new User("User", "password123", false);
        User user2 = new User("User2", "password456", true);

        userRepository.addUser(user1);
        userRepository.addUser(user2);

        assertTrue(userRepository.findByName("User"));
        assertTrue(userRepository.findByName("User2"));
        assertFalse(userRepository.findByName("User3"));
    }

    @Test
    public void testLogoutNonAdmins() {
        User adminUser = new User("Admin", "admin123", true);
        User regularUser = new User("User", "password123", false);

        userRepository.addUser(adminUser);
        userRepository.addUser(regularUser);

        adminUser.setAuthenticated(true);
        regularUser.setAuthenticated(true);

        userRepository.logoutNonAdmins();

        assertTrue(adminUser.isAuthenticated());
        assertFalse(regularUser.isAuthenticated());
    }
}
