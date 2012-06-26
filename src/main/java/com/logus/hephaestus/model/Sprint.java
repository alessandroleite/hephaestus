package com.logus.hephaestus.model;

import org.joda.time.DateTime;

public class Sprint implements Model<Long> {

	/**
	 * Serial code version <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2914585570850954848L;

	/**
	 * The sprint id
	 */
	private Long id;

	/**
	 * The product of sprint
	 */
	private Product product;

	/**
	 * Sprint description
	 */
	private String description;

	/**
	 * The sprint goals
	 */
	private String goals;

	/**
	 * The sprint start date
	 */
	private DateTime startDate;

	/**
	 * The sprint finish date.
	 */
	private DateTime endDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the goals
	 */
	public String getGoals() {
		return goals;
	}

	/**
	 * @param goals the goals to set
	 */
	public void setGoals(String goals) {
		this.goals = goals;
	}

	/**
	 * @return the startDate
	 */
	public DateTime getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public DateTime getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
}