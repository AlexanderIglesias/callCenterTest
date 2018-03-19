package com.almundo.model;

import com.almundo.utilities.EmployedTypeEnum;

public class EmployedDTO {

	private final String name;
	private final EmployedTypeEnum type;
	private final boolean available;

	public static class Builder {
		private EmployedTypeEnum type;
		private String name;
		private boolean available;

		public Builder(String name, EmployedTypeEnum type, boolean available) {
			this.name = name;
			this.type = type;
			this.available = available;
		}

		public EmployedDTO build() {

			return new EmployedDTO(this);

		}

	}

	private EmployedDTO(Builder builder) {
		this.name = builder.name;
		this.type = builder.type;
		this.available = builder.available;

	}

	public String getName() {
		return name;
	}

	public EmployedTypeEnum getType() {
		return type;
	}

	public boolean isAvailable() {
		return available;
	}
	

}
