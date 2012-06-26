package com.logus.hephaestus.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> extends org.springframework.jdbc.core.RowMapper {

	T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
