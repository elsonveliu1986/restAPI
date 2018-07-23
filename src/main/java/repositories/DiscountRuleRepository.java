package repositories;

import java.util.List;

import io.swagger.model.DiscountRule;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.threeten.bp.OffsetDateTime;

@Repository
public interface DiscountRuleRepository extends MongoRepository<DiscountRule, String> {
	
	//public DiscountRule findByid(String id);
	public List<DiscountRule> findByStartDateBetween(OffsetDateTime startDate, OffsetDateTime endDate);

}
