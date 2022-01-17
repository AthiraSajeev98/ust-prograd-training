package athira.sajeev.BookMyMovie.Service;

import athira.sajeev.BookMyMovie.Entity.Users;
import athira.sajeev.BookMyMovie.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users save(Users users) {
        return userRepository.save(users);
    }

    public Users getUserById(String username) {
        return userRepository.findById(username).get();
    }

    public boolean existById(String username) {
        return userRepository.existsById(username);
    }
}
