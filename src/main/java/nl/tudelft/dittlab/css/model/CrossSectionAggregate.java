package nl.tudelft.dittlab.css.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "crosssectionaggregate")
@JsonSerialize(using=nl.tudelft.dittlab.css.serializer.CrossSectionAggregateSerializer.class)
public class CrossSectionAggregate {
	
	@SuppressWarnings("serial")
	@Embeddable
	public static class CrossSectionAggregatePK implements Serializable {
		
		@Column(name = "crosssectionkey")
		private Integer crossSectionKey;

		@Column(name = "starttime")
		private Date time;

		@Column(name = "starttimeutcoffset")
		private Short timeUTCOffset;
		
		public boolean equals(Object o) {
			if (o instanceof CrossSectionAggregatePK) { 
				CrossSectionAggregatePK csapk = (CrossSectionAggregatePK) o;
				return csapk.getCrossSectionKey() == this.getCrossSectionKey() && csapk.getTime() == this.getTime() && csapk.getTimeUTCOffset() == this.getTimeUTCOffset();
			} else {
				return false;
			}
		}
		
		public Integer getCrossSectionKey() {
			return crossSectionKey;
		}

		public Date getTime() {
			return time;
		}

		public Short getTimeUTCOffset() {
			return timeUTCOffset;
		}

		public int hashCode() {
			return this.getCrossSectionKey();
		}

		public void setCrossSectionKey(Integer crossSectionKey) {
			this.crossSectionKey = crossSectionKey;
		}
		
		public void setTime(Date time) {
			this.time = time;
		}
		
		public void setTimeUTCOffset(Short timeUTCOffset) {
			this.timeUTCOffset = timeUTCOffset;
		}

	}
	
	@ManyToOne
	@JoinColumn(name="crosssectionkey", insertable = false, updatable = false)
	private CrossSection crossSection;

	@EmbeddedId
	private CrossSectionAggregatePK csapk;
	
	@Column(name = "avgspeedkmh")
	private Double avgSpeed;
	
	@Column(name = "totalflow")
	private Integer totalFlow;

	public Double getAvgSpeed() {
		return avgSpeed;
	}

	public CrossSectionAggregatePK getCsapk() {
		return csapk;
	}

	public Integer getTotalFlow() {
		return totalFlow;
	}

	public CrossSection getCrossSection() {
		return crossSection;
	}

	public void setCrossSection(CrossSection crossSection) {
		this.crossSection = crossSection;
	}

	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public void setCsapk(CrossSectionAggregatePK csapk) {
		this.csapk = csapk;
	}

	public void setTotalFlow(Integer totalFlow) {
		this.totalFlow = totalFlow;
	}
	
}
