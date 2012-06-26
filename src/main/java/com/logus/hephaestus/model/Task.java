package com.logus.hephaestus.model;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;

public class Task implements Model<Long> {

	/**
	 * Serial code version <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 7227678034242289912L;

	private Long id;

	private BackLogItem item;

	private DateTime createdTime;

	private TaskStatus status;

	private User owner;

	private List<Impediment> impediments = new LinkedList<Impediment>();

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
	 * @return the item
	 */
	public BackLogItem getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(BackLogItem item) {
		this.item = item;
	}

	/**
	 * @return the createdTime
	 */
	public DateTime getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime
	 *            the createdTime to set
	 */
	public void setCreatedTime(DateTime createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the status
	 */
	public TaskStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @return the impediments
	 */
	public List<Impediment> getImpediments() {
		return impediments;
	}

	/**
	 * @param impediments
	 *            the impediments to set
	 */
	public void setImpediments(List<Impediment> impediments) {
		this.impediments = impediments;
	}
}