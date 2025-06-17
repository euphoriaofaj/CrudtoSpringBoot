package service;

import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRep;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRep userRep;

    public UserServiceImpl(UserRep userRepository) {
        this.userRep = userRep;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRep.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRep.findById(id).orElse(null); // или бросать исключение
    }

    @Override
    public void saveUser(User user) {
        userRep.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRep.save(user); // save работает и для create, и для update
    }

    @Override
    public void deleteUser(Long id) {
        userRep.deleteById(id);
    }
}
