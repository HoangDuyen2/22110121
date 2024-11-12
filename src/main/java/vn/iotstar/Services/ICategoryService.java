package vn.iotstar.Services;

import vn.iotstar.Entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category findByCategoryName(String categoryName);

    boolean insert(Category category);
    boolean update(Category category);
    boolean delete(int categoryid);
}
