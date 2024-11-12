package vn.iotstar.Services.impl;

import vn.iotstar.DAO.IUserRepository;
import vn.iotstar.DAO.impl.UserRepositoryImpl;
import vn.iotstar.Entity.Users;
import vn.iotstar.Services.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    IUserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users login(String username, String password) {
        return userRepository.login(username, password);
    }

    @Override
    public boolean insert(Users users) {
        if (userRepository.findByUsername(users.getUsername()) == null) {
            userRepository.insert(users);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Users users) {
        if (userRepository.findByUsername(users.getUsername()) != null) {
            userRepository.update(users);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String username) {
        if (userRepository.findByUsername(username) != null) {
            userRepository.delete(username);
            return true;
        }
        return false;
    }
}
