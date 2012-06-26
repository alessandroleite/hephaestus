package com.logus.hephaestus.model;

public class Product implements Model<Long> {

	/**
	 * Serial code version <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6633871101776761535L;

	/**
	 * The project Id
	 */
	private Long id;

	/**
	 * The product name
	 */
	private String name;

	/**
	 * The project description
	 */
	private String description;

	public Product() {
		super();
	}
	public Product(Long id){
		this.id = id;
		
	}
	public Product(Long id, String name, String description) {
		this(id);
		this.name = name;
		this.description = description;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
}