package com.logus.hephaestus.model;

import java.util.LinkedList;
import java.util.List;

public class BackLogItem implements Model<Long>, Comparable<BackLogItem> {

	/**
	 * Serial code version <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -5523194044361490723L;

	private Long id;

	private String description;

	private Sprint sprint;

	private List<Task> tasks = new LinkedList<Task>();

	private Integer order;

	/**
	 * Add a not <code>null</code> {@link Task} to this {@link BackLogItem}.
	 * 
	 * @param taskToAdd
	 *            Task to be add. Could not be <code>null</code>
	 * @return <code>true</code> if the given {@link Task} was added or
	 *         <code>false</code> otherwise.
	 */
	public boolean addTask(Task taskToAdd) {
		if (taskToAdd != null) {
			return this.tasks.add(taskToAdd);
		}
		return false;
	}

	/**
	 * Remove a given task.
	 * 
	 * @param taskToRemove
	 *            Task to be remove
	 * @return <code>true</code> if the given task was removed of
	 *         <code>false</code> otherwise.
	 */
	public boolean removeTask(Task taskToRemove) {
		return this.tasks.remove(taskToRemove);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(BackLogItem other) {
		if (this.order < other.order)
			return -1;
		else if (this.order > other.order) {
			return 1;
		}
		return 0;
	}

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
	 * @return the sprint
	 */
	public Sprint getSprint() {
		return sprint;
	}

	/**
	 * @param sprint
	 *            the sprint to set
	 */
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	/**
	 * @return the tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks
	 *            the tasks to set
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
}