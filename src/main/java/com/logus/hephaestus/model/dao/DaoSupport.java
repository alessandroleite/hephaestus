package com.logus.hephaestus.model.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.incrementer.PostgreSQLSequenceMaxValueIncrementer;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.logus.hephaestus.model.Model;
import com.logus.hephaestus.model.repository.Repository;

@SuppressWarnings("unchecked")
public abstract class DaoSupport<T extends Model<ID>, ID extends Serializable>
		extends JdbcDaoSupport implements Repository<T, ID> {

	protected PostgreSQLSequenceMaxValueIncrementer sequenceIncrementer;

	public synchronized Long getNextSequenceValue(String sequenceName) {
		if (this.sequenceIncrementer == null)
			this.sequenceIncrementer = new PostgreSQLSequenceMaxValueIncrementer(
					this.getDataSource(), sequenceName);

		return this.sequenceIncrementer.nextLongValue();
	}

	@Override
	public void persist(List<T> entities) {
		for (T t : entities)
			this.persist(t);
	}

	public List<T> find(String sql, Object[] values, RowMapper rowMapper) {
		return this.getJdbcTemplate().query(sql, values, rowMapper);
	}

	public List<T> find(String sql, RowMapper rowMapper) {
		return this.getJdbcTemplate().query(sql, rowMapper);
	}

	public int update(String sql, Object... values) {
		return this.getJdbcTemplate().update(Preconditions.checkNotNull(sql), values);
	}

	public T queryForObject(String sql, Class<T> type, RowMapper mapper, Object... values) {
		List<T> rows = this.getJdbcTemplate().query(sql, values, mapper);
		return rows.isEmpty() ? null : rows.get(0);
	}

	public Object queryForObject(String sql, RowMapper mapper, Object... values) {
		@SuppressWarnings("rawtypes")
		List rows = this.getJdbcTemplate().query(sql, values, mapper);
		return rows.isEmpty() ? null : rows.get(0);
	}

	public Integer queryForInt(String sql, Object[] params) {
		List<Integer> rows = this.getJdbcTemplate().query(sql, params,
				new RowMapper() {
					public Integer mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return Integer.valueOf(rs.getInt(1));
					}
				});
		return rows.isEmpty() ? Integer.valueOf(0) : rows.get(0);
	}

	protected String like(String value) {
		return "%" + Preconditions.checkNotNull(value) + "%";
	}

	protected String whereClause(String sqlBase, Map<String, Object> params) {
		final String and_operator = " and ";
		StringBuilder sb = new StringBuilder(
				Preconditions.checkNotNull(sqlBase)).append(" WHERE 1 = 1 ");

		for (String clause : params.keySet()) {
			sb.append(and_operator).append(clause);
		}

		return sb.toString();
	}

	protected List<T> query(final String query, Map<String, Object> values,
			RowMapper mapper) {
		return query(query, null, values, mapper);
	}

	protected List<T> query(final String query, String order,
			Map<String, Object> values, RowMapper mapper) {
		String sql = this
				.whereClause(query, Preconditions.checkNotNull(values));

		if (!Strings.isNullOrEmpty(order))
			sql += order;

		return this.getJdbcTemplate().query(sql,
				values.values().toArray(new Object[values.values().size()]),
				mapper);
	}

	protected static String bind(String value) {
		String[] columns = Preconditions.checkNotNull(value).replaceAll("\n", "").trim().split(",");
		StringBuilder sb = new StringBuilder(" VALUES (");

		for (int i = 0; i < columns.length; i++) {
			sb.append("?");
			if (!(i + 1 == columns.length))
				sb.append(",");
		}

		return sb.append(")").toString();
	}

	protected static String bindUpdate(String value) {
		StringBuilder sb = new StringBuilder(" SET ");
		String[] columns = Preconditions.checkNotNull(value).split(",");

		for (int i = 1; i < columns.length; i++) {
			sb.append(columns[i]).append(" = ?");
			if (!(i + 1 == columns.length))
				sb.append(" , \n");
		}

		return sb.append(" \n WHERE ").append(columns[0]).append(" = ? ")
				.toString();
	}
}