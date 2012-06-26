package com.logus.hephaestus.model;

import java.io.Serializable;

public interface Model<ID extends Serializable> extends Serializable {
	
	ID getId();
}
