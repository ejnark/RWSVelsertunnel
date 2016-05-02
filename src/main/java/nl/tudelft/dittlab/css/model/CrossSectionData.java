package nl.tudelft.dittlab.css.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=nl.tudelft.dittlab.css.serializer.CrossSectionDataSerializer.class)
public class CrossSectionData {
	
	private Date time;
	private List<SpeedData> speedDataList;
	
	public CrossSectionData() {
		super();
	}
	
	public CrossSectionData(Date time, List<SpeedData> speedData) {
		super();
		this.time = time;
		this.speedDataList = speedData;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<SpeedData> getSpeedDataList() {
		return speedDataList;
	}

	public void setSpeedDataList(List<SpeedData> speedDataList) {
		this.speedDataList = speedDataList;
	}
	
}
