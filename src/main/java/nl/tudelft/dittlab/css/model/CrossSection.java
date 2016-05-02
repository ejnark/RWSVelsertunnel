package nl.tudelft.dittlab.css.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "crosssection")
public class CrossSection {
	
	@Id
	@Column(name = "key")
	private Integer key;
	
	@Column(name = "locationfordisplay")
	private Point location;
	
	// crossline serialization not yet correctly working, commented out for now
	
//	@Column(name = "crossline")
//	private LineString crossline;
	
	@Column(name = "direction")
	private Short direction;
	
	@OneToMany(mappedBy="crossSection", fetch=FetchType.LAZY)
	private List<CrossSectionAggregate> crossSectionAggregates;

//	public LineString getCrossline() {
//		return crossline;
//	}

	public List<CrossSectionAggregate> getCrossSectionAggregates() {
		return crossSectionAggregates;
	}

	public Short getDirection() {
		return direction;
	}

	public Integer getKey() {
		return key;
	}

	public Point getLocation() {
		return location;
	}

//	public void setCrossline(LineString crossline) {
//		this.crossline = crossline;
//	}

	public void setCrossSectionAggregates(List<CrossSectionAggregate> crossSectionAggregates) {
		this.crossSectionAggregates = crossSectionAggregates;
	}

	public void setDirection(Short direction) {
		this.direction = direction;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

}
