package com.restaurant.client.menuservice.repository;

import com.restaurant.client.menuservice.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, Long>{
}
