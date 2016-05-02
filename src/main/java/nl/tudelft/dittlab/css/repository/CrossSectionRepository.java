package nl.tudelft.dittlab.css.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nl.tudelft.dittlab.css.model.CrossSection;

@Repository("crossSectionRepository")
public interface CrossSectionRepository extends JpaRepository<CrossSection, Integer> {
	
	@Query(value = "SELECT c FROM CrossSection c WHERE ((st_x(c.location) BETWEEN :xMin AND :xMax) AND (st_y(c.location) BETWEEN :yMin AND :yMax))")
	List<CrossSection> findCrossSectionsInArea(@Param("xMin") double xMin, @Param("xMax") double xMax, @Param("yMin") double yMin, @Param("yMax") double yMax);

}
