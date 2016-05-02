package nl.tudelft.dittlab.css.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Point;

import nl.tudelft.dittlab.css.model.CrossSection;
import nl.tudelft.dittlab.css.model.CrossSectionAggregate;
import nl.tudelft.dittlab.css.model.CrossSectionData;
import nl.tudelft.dittlab.css.model.SpeedData;
import nl.tudelft.dittlab.css.model.TimeArea;

@Service("crossSectionDataService")
public class CrossSectionDataServiceImpl implements CrossSectionDataService {

	@Autowired
	CrossSectionService crossSectionService;
	
	@Autowired
	CrossSectionAggregateService crossSectionAggregateService;
	
	@Override
	public List<CrossSectionData> getCrossSectionDataForTimeArea(TimeArea timeArea) {
		
		List<CrossSection> crossSectionList = crossSectionService.findInArea(timeArea.getxMin(), timeArea.getxMax(), timeArea.getyMin(), timeArea.getyMax());
		List<CrossSectionAggregate> crossSectionAggregateList = crossSectionAggregateService.findByCrossSectionsAndTimeSortedByTime(crossSectionList, timeArea.getStartTime(), timeArea.getEndTime());

		return createAndPopulateCrossSectionDataList(crossSectionAggregateList);
		
	}
	
	@Override
	public List<CrossSectionData> createAndPopulateCrossSectionDataList(List<CrossSectionAggregate> timeSortedCrossSectionAggregateList) {
		
		List<CrossSectionData> crossSectionDataList = new ArrayList<>();
		Date currentTimePosition = timeSortedCrossSectionAggregateList.get(0).getCsapk().getTime();
		int index = 0;
		
		outerloop:
		while (index < timeSortedCrossSectionAggregateList.size()) {
			
			List<SpeedData> speedDataList = new ArrayList<>();
			CrossSectionData crossSectionData = new CrossSectionData(timeSortedCrossSectionAggregateList.get(index).getCsapk().getTime(), speedDataList);
			
				while (timeSortedCrossSectionAggregateList.get(index).getCsapk().getTime().getTime() == currentTimePosition.getTime()) {
					
					CrossSectionAggregate crossSectionAggregate = timeSortedCrossSectionAggregateList.get(index);
					Integer key = crossSectionAggregate.getCrossSection().getKey();
					Point location = crossSectionAggregate.getCrossSection().getLocation();
					Double avgSpeed = crossSectionAggregate.getAvgSpeed();
					
					SpeedData speedData = new SpeedData(key, location, avgSpeed);				
					speedDataList.add(speedData);
	
					index++;
					
					if (index >= timeSortedCrossSectionAggregateList.size()) {
						break outerloop;
					}
						
				}
				
				currentTimePosition = timeSortedCrossSectionAggregateList.get(index).getCsapk().getTime();
				crossSectionDataList.add(crossSectionData);
			
		}
		
		return crossSectionDataList;
		
	}

}
