package com.nissan.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiclemodel")
public class VehicleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "model_name")
	private String modelName;

	@Column(name = "launch_year")
	private String launchYear;

	@Column(name = "body_Style")
	private String bodyStyle;

	@Column(name = "trim_Level")
	private String trimLevel;

	@Column(name = "price")
	private int price;

	@Column(name = "type")
	private String type;
	
	public VehicleModel() {

	}

	public VehicleModel(String modelName, String launchYear, String bodyStyle, String trimLevel, int price, String type) {
		super();
		this.modelName = modelName;
		this.launchYear = launchYear;
		this.bodyStyle = bodyStyle;
		this.trimLevel = trimLevel;
		this.price = price;
		this.type = type;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(String launchYear) {
		this.launchYear = launchYear;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public String getTrimLevel() {
		return trimLevel;
	}

	public void setTrimLevel(String trimLevel) {
		this.trimLevel = trimLevel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
