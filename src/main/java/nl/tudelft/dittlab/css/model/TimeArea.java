package nl.tudelft.dittlab.css.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TimeArea {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss", timezone="CET")
	private Date startTime;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss", timezone="CET")
	private Date endTime;
	
	private Double xMin;
	private Double xMax;
	private Double yMin;
	private Double yMax;
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date starttime) {
		this.startTime = starttime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endtime) {
		this.endTime = endtime;
	}
	public Double getxMin() {
		return xMin;
	}
	public void setxMin(Double xMin) {
		this.xMin = xMin;
	}
	public Double getxMax() {
		return xMax;
	}
	public void setxMax(Double xMax) {
		this.xMax = xMax;
	}
	public Double getyMin() {
		return yMin;
	}
	public void setyMin(Double yMin) {
		this.yMin = yMin;
	}
	public Double getyMax() {
		return yMax;
	}
	public void setyMax(Double yMax) {
		this.yMax = yMax;
	}
	
}
