package com.ciandt.challenge.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ciandt.challenge.vo.DeliveryRoute;

@Repository
public class RoutesJdbcRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public DeliveryRoute findById(long id) {
		return jdbcTemplate.queryForObject("select * from cliente where id=?", new Object[] { id },
				new BeanPropertyRowMapper<DeliveryRoute>(DeliveryRoute.class));
	}
	
	class DeliveryRouteRowMapper implements RowMapper<DeliveryRoute> {
		@Override
		public DeliveryRoute mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeliveryRoute route = new DeliveryRoute();
			route.setId(rs.getLong("id"));
			route.setOrigem(rs.getString("origem"));
			route.setDestino(rs.getString("destino"));
			route.setDistancia(rs.getBigDecimal("distancia"));
			
			return route;
		}
	}

	public List<DeliveryRoute> findAll() {
		return jdbcTemplate.query("select * from route", new DeliveryRouteRowMapper());
	}
	
	public int deleteById(long id) {
		return jdbcTemplate.update("delete from route where id=?", new Object[] { id });
	}

	public int insert(DeliveryRoute deliveryRoute) {
		return jdbcTemplate.update("insert into route (origem, destino, distancia) " + "values(?,  ?, ?)",
				new Object[] { deliveryRoute.getOrigem(), deliveryRoute.getDestino(), deliveryRoute.getDistancia()});
	}
	
	public int update(DeliveryRoute deliveryRoute) {
		return jdbcTemplate.update("update route " +" set origem = ?, destino = ?, distancia = ? "  + " where id = ?",
				new Object[] { deliveryRoute.getOrigem(), deliveryRoute.getDestino(), deliveryRoute.getDistancia(), deliveryRoute.getId() });
	}

	public List<DeliveryRoute> findByOrigem(String origem) {
		return jdbcTemplate.query("select * from route where origem = ?",new Object[] { origem }, new DeliveryRouteRowMapper());
	}
	
	public List<DeliveryRoute> findByDestino(String destino) {
		return jdbcTemplate.query("select * from route where destino = ?",new Object[] { destino }, new DeliveryRouteRowMapper());
	}
	
}
