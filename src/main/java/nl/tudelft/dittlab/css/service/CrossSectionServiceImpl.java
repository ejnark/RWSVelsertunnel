package nl.tudelft.dittlab.css.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.tudelft.dittlab.css.model.CrossSection;
import nl.tudelft.dittlab.css.repository.CrossSectionRepository;

@Service("crossSectionService")
public class CrossSectionServiceImpl implements CrossSectionService {
	
	@Autowired
	CrossSectionRepository crossSectionRepository;
	
	public List<CrossSection> findInArea(double xMin, double xMax, double yMin, double yMax) {
		return crossSectionRepository.findCrossSectionsInArea(xMin, xMax, yMin, yMax);
	}

}
