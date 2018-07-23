package services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.DiscountRule;
import io.swagger.model.DiscountRules;

public interface DiscountRuleService {
	
	//method getAll() returns list
	List <DiscountRule> listAllDiscountRules();
	
	//finds discount rule with specific ID
	DiscountRule getDiscountRuleById(String id);
	
	//save new discount rule (insert in DB)
	DiscountRule saveDiscountRule(DiscountRule discountRule);
	
	//delete discount rule (delete from DB
    void deleteDiscountRule(String id);
    
    Page<DiscountRule> listAllByPage(Pageable pageable);
    
    //Returns list of Discount Rules where startDate is between the 2 given dates
    List <DiscountRule> listAllDiscountRulesByDate(OffsetDateTime startDate, OffsetDateTime endDate);

}