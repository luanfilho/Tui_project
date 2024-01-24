package com.tui.proof.repository;

import com.tui.proof.model.OrderPilote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository <OrderPilote, Long>{

    @Query("FROM OrderPilote g where g.client.firstName like %:keyword% or g.client.lastName like %:keyword%" +
            " or g.client.telephone like %:keyword%")
    List<OrderPilote> findByKeyword(@Param("keyword") String keyword);

}
