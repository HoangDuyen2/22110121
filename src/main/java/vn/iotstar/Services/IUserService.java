package vn.iotstar.Services;

import vn.iotstar.Entity.Users;

import java.util.List;

public interface IUserService {
    List<Users> findAll();
    Users findByUsername(String username);
    Users login(String username, String password);

    boolean insert(Users users);
    boolean update(Users users);
    boolean delete(String username);
}
