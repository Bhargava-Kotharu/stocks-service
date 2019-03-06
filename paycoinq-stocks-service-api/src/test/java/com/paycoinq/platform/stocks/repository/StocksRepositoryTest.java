package com.paycoinq.platform.stocks.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.paycoinq.platform.stocks.StocksApplication;
import com.paycoinq.platform.stocks.model.repository.StocksRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StocksApplication.class)
public class StocksRepositoryTest {

	@Autowired
	private StocksRepository repository;

	@Test
	public void test() {
		long count = repository.count();
		assertEquals(10, count);
	}
}
