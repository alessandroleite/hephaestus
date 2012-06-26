package com.logus.hephaestus.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.google.common.base.Preconditions;
import com.logus.hephaestus.model.Product;

public class ProductDao extends DaoSupport<Product, Long> {

	private static final String SEQUENCE_NAME = null;

	@Override
	public Product persist(Product product) {
		if (Preconditions.checkNotNull(product.getId()) == null) {
			product.setId(this.getNextSequenceValue(SEQUENCE_NAME));
			this.update(
					"INSERT INTO tb_product (id_product, no_product, ds_product",
					product.getId(), product.getName(),
					product.getDescription());
		} else {
			this.update(
					"UPDATE tb_product set no_product = ?, ds_product = ? where id_product = ?",
					product.getName(), product.getDescription(),
					product.getId());
		}
		return product;
	}

	@Override
	public Boolean remove(Product entity) {
		return this.update("delete from tb_product where id_product = ?",
				Preconditions.checkNotNull(entity.getId())) > 0;
	}

	@Override
	public Product findById(Long id) {
		return (Product) this
				.queryForObject(
						"SELECT id_product, no_product, ds_product from tb_product where id_product = ? ",
						new ProductRowMapper(), id);
	}

	@Override
	public List<Product> findAll() {
		return null;
	}

	private static class ProductRowMapper implements RowMapper {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Product(rs.getLong(1), rs.getString(2), rs.getString(3));
		}
	}
}