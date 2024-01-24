package com.in28minutes.myfirstwebapp;

import com.tui.proof.MainApplication;
import com.tui.proof.model.Address;
import com.tui.proof.model.Client;
import com.tui.proof.model.OrderPilote;
import com.tui.proof.model.StatusOrder;
import com.tui.proof.repository.FoodRepository;
import com.tui.proof.service.FoodService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(classes = MainApplication.class)
public class MainApplicationTest {

	@Autowired
	FoodService foodService;

	@Autowired
	FoodRepository repository;

	@Test
	void createOrderTest() {
		OrderPilote pilote = new OrderPilote(1L, new Address(1L, "Street", "2222-222", "Almada", "Portugal"),
				5, 10.5F, new Client(1L,"Luis", "Filho", "910694889"), StatusOrder.Pending);
		foodService.save(pilote);

		assertEquals("test",pilote,repository.findById(1L).get());

	}

	@Test
	void updateOrderTest() {
		OrderPilote pilote = new OrderPilote(1L, new Address(1L, "Street", "2222-222", "Almada", "Portugal"),
				5, 10.5F, new Client(1L,"Luis", "Filho", "910694889"), StatusOrder.Pending);
		foodService.save(pilote);


	}

	@Test
	void searchTest() {
	}

}
