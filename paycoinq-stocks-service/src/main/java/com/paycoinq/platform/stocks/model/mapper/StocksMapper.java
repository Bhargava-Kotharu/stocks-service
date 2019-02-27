package com.paycoinq.platform.stocks.model.mapper;

import org.springframework.stereotype.Component;

import com.paycoinq.platform.stocks.dto.StockRequest;
import com.paycoinq.platform.stocks.dto.StocksDTO;
import com.paycoinq.platform.stocks.model.entity.StocksEntity;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class StocksMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(StocksEntity.class, StocksDTO.class).mapNulls(true).byDefault().register();
		factory.classMap(StocksEntity.class, StockRequest.class).mapNulls(true).byDefault().register();
	}
}
