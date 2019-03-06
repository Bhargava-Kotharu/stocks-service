package com.paycoinq.platform.stocks.model.mapper;

import java.text.ParseException;

import org.springframework.stereotype.Component;

import com.paycoinq.platform.stocks.dto.StockRequest;
import com.paycoinq.platform.stocks.dto.StocksDTO;
import com.paycoinq.platform.stocks.model.entity.StocksEntity;
import com.paycoinq.platform.stocks.utils.DateUtils;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Mapper component to convert StocksDTO, StockRequest to StocksEntity and vice
 * versa
 * 
 * @author bkotharu
 *
 */
@Component
public class StocksMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {

		factory.classMap(StocksEntity.class, StocksDTO.class).mapNulls(true)
				.customize(new CustomMapper<StocksEntity, StocksDTO>() {
					@Override
					public void mapAtoB(StocksEntity entity, StocksDTO dto, MappingContext context) {
						try {
							dto.setCreatedDate(DateUtils.getDateInReadableFormat(entity.getCreatedDate()));
							dto.setLastUpdated(DateUtils.getDateInReadableFormat(entity.getLastUpdated()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).byDefault().register();
		factory.classMap(StocksEntity.class, StockRequest.class).mapNulls(true).byDefault().register();
	}
}
