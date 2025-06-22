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

    public UserServiceImpl(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public List<User> getAllUsers() {
        return userRep.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRep.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRep.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRep.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRep.deleteById(id);
    }
}