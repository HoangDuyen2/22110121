package vn.iotstar.DAO;

import vn.iotstar.Entity.Users;

import java.util.List;

public interface IUserRepository {
    List<Users> findAll();
    Users findByUsername(String username);
    Users login(String username, String password);

    void insert(Users users);
    void update(Users users);
    void delete(String username);
}
