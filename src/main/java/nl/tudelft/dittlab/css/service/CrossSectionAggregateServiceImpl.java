package nl.tudelft.dittlab.css.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.tudelft.dittlab.css.model.CrossSection;
import nl.tudelft.dittlab.css.model.CrossSectionAggregate;
import nl.tudelft.dittlab.css.repository.CrossSectionAggregateRepository;

@Service("crossSectionAggregateService")
public class CrossSectionAggregateServiceImpl implements CrossSectionAggregateService {
	
	@Autowired
	CrossSectionAggregateRepository crossSectionAggregateRepository;
	
	@Autowired
	CrossSectionService crossSectionService;

	@Override
	public List<CrossSectionAggregate> findByCrossSectionsAndTimeSortedByTime(List<CrossSection> crossSectionList, Date startTime, Date endTime) {
		
		return crossSectionAggregateRepository.findByCrossSectionInAndCsapkTimeBetweenOrderByCsapkTimeAsc(crossSectionList, startTime, endTime);
		
	}

}
