package com.bee.simplejdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bee.simplejdbc.controller.Bee;

@Repository
public class UserRepository {

	/*
	 * autowiring jdbc using configured setting in application.properties
	 * 
	 */
	@Autowired
	JdbcTemplate jdbcTemplate;

	//Get all
	public List<Bee> getAllBeeTags() {

		List<Bee> bees = jdbcTemplate.query("SELECT * FROM dev_db.beehive", new BeeMapper());  
		return bees;
	}
	
	// Get by id
	public Bee getBeeTag(String id) {
		return jdbcTemplate.queryForObject("SELECT * FROM dev_db.beehive where id = "+ id +";", new BeeMapper());
	}

	// Post
	public int addNewBee(Bee bee) {

      return jdbcTemplate.update("INSERT INTO dev_db.beehive (id, speed, latitude, longitude, altitude, fuel, damage, nectar, honey) VALUES(?,?,?,?,?,?,?,?,?)", bee.id, bee.speed, bee.latitude, bee.longitude, bee.altitude, bee.fuel, bee.damage, bee.nectar, bee.honey);
	}

	// Put
	public int updateBee(Bee bee) {
	      return jdbcTemplate.update("UPDATE dev_db.beehive SET id ='"+ bee.id+ "', speed ='"+ bee.speed+ "', latitude ='" + bee.latitude + "', longitude ='"+ bee.longitude + "', altitude ='"+ bee.altitude+ "', fuel ='"+ bee.fuel+ "', damage ='"+ bee.damage+ "', nectar ='"+ bee.nectar+ "', honey ='"+ bee.honey + "' WHERE id ='" + bee.id+"';");
	}
	
	//Delete by id
	public int removeBee(String id) {
		return jdbcTemplate.update("DELETE FROM dev_db.beehive WHERE id = '" + id +"';");
	}

	
	// Remap the output from MySQL into Object format
	private static class BeeMapper implements RowMapper<Bee>{
		
		@Override
		public Bee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Bee bee =  new Bee();
			bee.id = resultSet.getString("id");
			bee.speed = resultSet.getInt("speed");
			bee.latitude = resultSet.getInt("latitude");
			bee.longitude = resultSet.getInt("longitude");
			bee.altitude = resultSet.getInt("altitude");
			bee.fuel = resultSet.getInt("fuel");
			bee.damage = resultSet.getInt("damage");
			bee.nectar = resultSet.getInt("nectar");
			bee.honey = resultSet.getInt("honey");
			return bee;
		}
	}





}
