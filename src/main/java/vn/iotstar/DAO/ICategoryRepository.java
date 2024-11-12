package vn.iotstar.DAO;

import vn.iotstar.Entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findById(int id);
    Category findByCategoryName(String categoryName);

    void insert(Category category);
    void update(Category category);
    void delete(int categoryid);
}
