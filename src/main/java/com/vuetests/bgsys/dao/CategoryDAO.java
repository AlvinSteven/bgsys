package com.vuetests.bgsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuetests.bgsys.books.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}