package nl.tudelft.dittlab.css.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.tudelft.dittlab.css.model.CrossSection;
import nl.tudelft.dittlab.css.model.CrossSectionAggregate;
import nl.tudelft.dittlab.css.model.CrossSectionAggregate.CrossSectionAggregatePK;

public interface CrossSectionAggregateRepository extends JpaRepository<CrossSectionAggregate, CrossSectionAggregatePK> {
	
	List<CrossSectionAggregate> findByCrossSectionInAndCsapkTimeBetweenOrderByCsapkTimeAsc(List<CrossSection> crossSectionList, Date startDate, Date endDate);

}
