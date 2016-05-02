package nl.tudelft.dittlab.css.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;

@JsonSerialize(using=nl.tudelft.dittlab.css.serializer.SpeedDataSerializer.class)
public class SpeedData {
	
	private Integer key;
	private Point location;
	private Double avgSpeed;
	
	public SpeedData() {
		super();
	}
	
	public SpeedData(Integer key, Point location, Double avgSpeed) {
		super();
		this.key = key;
		this.location = location;
		this.avgSpeed = avgSpeed;
	}
	
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public Double getAvgSpeed() {
		return avgSpeed;
	}
	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}
	
	

}
