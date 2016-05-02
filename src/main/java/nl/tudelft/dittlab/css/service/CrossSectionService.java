package nl.tudelft.dittlab.css.service;

import java.util.List;

import nl.tudelft.dittlab.css.model.CrossSection;

public interface CrossSectionService {
	
	List<CrossSection> findInArea(double xMin, double xMax, double yMin, double yMax);

}
