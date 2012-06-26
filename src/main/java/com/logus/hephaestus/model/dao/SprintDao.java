package com.logus.hephaestus.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.google.common.base.Preconditions;
import com.logus.hephaestus.model.Product;
import com.logus.hephaestus.model.Sprint;

public class SprintDao extends DaoSupport<Sprint, Long> {

	private static final String SEQUENCE_NAME = "sq_sprint";
	private static final String SQL_SELECT_ALL = "select id_sprint, cd_product, ds_description, ds_goals, dt_start, dt_finish from tb_sprint s \n"
			+ " join tb_product p on p.id_product = s.cd_product ";

	@Override
	public Sprint persist(Sprint entity) {
		if (Preconditions.checkNotNull(entity).getId() == null) {
			entity.setId(this.getNextSequenceValue(SEQUENCE_NAME));
			this.update(
					"INSERT INTO tb_sprint (id_sprint, cd_product, ds_description, ds_goals, dt_start, dt_finish) VALUES (?,?,?,?,?,?) ",
					entity.getId(), entity.getProduct().getId(), entity
							.getDescription(), entity.getGoals(), new Date(
							entity.getStartDate().getMillis()), new Date(entity
							.getEndDate().getMillis()));
		} else {
			this.update(
					"update tb_sprint set cd_product = ?, ds_description = ?, ds_goals = ?, dt_start = ?, dt_finish = ? where id_sprint = ?",
					entity.getProduct().getId(), entity.getDescription(),
					entity.getGoals(), new Date(entity.getStartDate()
							.getMillis()), new Date(entity.getEndDate()
							.getMillis()), entity.getId());
		}

		return entity;
	}

	@Override
	public Boolean remove(Sprint entity) {
		return this.update("delete from tb_sprint where sprint_id = ?",
				entity.getId()) > 0;
	}

	@Override
	public Sprint findById(Long id) {
		return (Sprint) this.queryForObject(SQL_SELECT_ALL
				+ " where id_sprint = ?", new SprintRowMapper(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sprint> findAll() {
		return this.getJdbcTemplate().query(
				SQL_SELECT_ALL + " order by dt_finish", new SprintRowMapper());
	}

	private static class SprintRowMapper implements RowMapper<Sprint> {
		@Override
		public Sprint mapRow(ResultSet rs, int rowNum) throws SQLException {
			Sprint sprint = new Sprint(rs.getLong(1));
			
			sprint.setProduct(new Product(rs.getLong(2)));
			sprint.setDescription(rs.getString(3));
			sprint.setGoals(rs.getString(4));
			sprint.setStartDate(new DateTime(rs.getDate(5)));
			sprint.setEndDate(new DateTime(rs.getDate(6)));

			return sprint;
		}
	}
}