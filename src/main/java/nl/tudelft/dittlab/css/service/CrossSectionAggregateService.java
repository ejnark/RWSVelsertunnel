package nl.tudelft.dittlab.css.service;

import java.util.Date;
import java.util.List;

import nl.tudelft.dittlab.css.model.CrossSection;
import nl.tudelft.dittlab.css.model.CrossSectionAggregate;

public interface CrossSectionAggregateService {
	
	List<CrossSectionAggregate> findByCrossSectionsAndTimeSortedByTime(List<CrossSection> crossSectionList, Date startTime, Date endTime);

}
