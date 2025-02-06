package com.restaurant.client.menuservice.repository;

import com.restaurant.client.menuservice.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, Long>{
    Optional<MenuModel> findMenuModelByMenuId(Long menuId);
}
