package nl.tudelft.dittlab.css.service;

import java.util.List;

import nl.tudelft.dittlab.css.model.CrossSectionAggregate;
import nl.tudelft.dittlab.css.model.CrossSectionData;
import nl.tudelft.dittlab.css.model.TimeArea;

public interface CrossSectionDataService {
	
	List<CrossSectionData> getCrossSectionDataForTimeArea(TimeArea timeArea);
	
	List<CrossSectionData> createAndPopulateCrossSectionDataList(List<CrossSectionAggregate> timeSortedCrossSectionAggregateList);

}
