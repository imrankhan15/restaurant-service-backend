package com.restaurantbackend.restaurantservices.table;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TableCheckHistoryRepository
        extends JpaRepository<TableCheckHistory, Integer> {
}
