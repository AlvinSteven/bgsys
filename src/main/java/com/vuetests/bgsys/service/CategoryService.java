package com.vuetests.bgsys.service;

import com.vuetests.bgsys.books.Category;
import com.vuetests.bgsys.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list() {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        return categoryDAO.findAll(sort);
        return categoryDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Category get(int id) {
        Category c= categoryDAO.findById(id).orElse(null);
        return c;
    }
}