package com.logus.hephaestus.model;

import org.joda.time.DateTime;

public class Impediment implements Model<Long> {

	/**
	 * Serial code version <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -4899377086696895635L;

	/**
	 * The impediment id
	 */
	private Long id;

	/**
	 * The impediment description
	 */
	private String description;

	/**
	 * The {@link Task} of this {@link Impediment}
	 */
	private Task task;

	/**
	 * The date of reported
	 */
	private DateTime createdDate;

	/**
	 * The date of solution.
	 */
	private DateTime resolvedDate;

	/**
	 * The report of this {@link Impediment}
	 */
	private User reportedBy;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the task
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * @param task
	 *            the task to set
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 * @return the createdDate
	 */
	public DateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the resolvedDate
	 */
	public DateTime getResolvedDate() {
		return resolvedDate;
	}

	/**
	 * @param resolvedDate
	 *            the resolvedDate to set
	 */
	public void setResolvedDate(DateTime resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	/**
	 * @return the reportedBy
	 */
	public User getReportedBy() {
		return reportedBy;
	}

	/**
	 * @param reportedBy
	 *            the reportedBy to set
	 */
	public void setReportedBy(User reportedBy) {
		this.reportedBy = reportedBy;
	}
}