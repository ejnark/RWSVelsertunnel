package nl.tudelft.dittlab.css.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.tudelft.dittlab.css.model.CrossSectionData;
import nl.tudelft.dittlab.css.model.TimeArea;
import nl.tudelft.dittlab.css.service.CrossSectionDataService;

@Controller("crossSectionDataController")
public class CrossSectionDataController {
	
	@Autowired
	CrossSectionDataService crossSectionDataService;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public @ResponseBody List<CrossSectionData> getData(@RequestBody TimeArea timeArea) {
		
		return crossSectionDataService.getCrossSectionDataForTimeArea(timeArea);
		
	}

}
