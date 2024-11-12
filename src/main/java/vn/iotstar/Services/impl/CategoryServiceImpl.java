package vn.iotstar.Services.impl;

import vn.iotstar.DAO.ICategoryRepository;
import vn.iotstar.DAO.impl.CategoryRepositoryImpl;
import vn.iotstar.Entity.Category;
import vn.iotstar.Services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    ICategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public boolean insert(Category category) {
        if(categoryRepository.findByCategoryName(category.getCategoryname()) == null) {
            categoryRepository.insert(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        if(categoryRepository.findByCategoryName(category.getCategoryname()) != null) {
            categoryRepository.update(category);
        }
        return false;
    }

    @Override
    public boolean delete(int categoryid) {
        if(categoryRepository.findById(categoryid) != null) {
            categoryRepository.delete(categoryid);
            return true;
        }
        return false;
    }
}
