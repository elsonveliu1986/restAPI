package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;

import repositories.DiscountRuleRepository;
import io.swagger.model.DiscountRule;
import io.swagger.model.DiscountRules;

@Service
public class DiscountRuleServiceImpl implements DiscountRuleService {

	@Autowired
	DiscountRuleRepository discountRuleRepository;
	
	@Override
	public List <DiscountRule> listAllDiscountRules() {
		// TODO Auto-generated method stub
		return discountRuleRepository.findAll();
	}

	@Override
	public DiscountRule getDiscountRuleById(String id) {
		// TODO Auto-generated method stub
		return discountRuleRepository.findOne(id);
	}

	@Override
	public DiscountRule saveDiscountRule(DiscountRule discountRule) {
		// TODO Auto-generated method stub
		return discountRuleRepository.save(discountRule);
		
	}

	@Override
	public void deleteDiscountRule(String id) {
		// TODO Auto-generated method stub
		discountRuleRepository.delete(id);
	}

	@Override
	public Page<DiscountRule> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return  discountRuleRepository.findAll(pageable);
	}

	@Override
	public List<DiscountRule> listAllDiscountRulesByDate(OffsetDateTime startDate, OffsetDateTime endDate) {
		// TODO Auto-generated method stub
		List<DiscountRule> listModified = new ArrayList<DiscountRule>();
		List<DiscountRule> listAll = discountRuleRepository.findAll();
		//System.out.println(startDate);
		//System.out.println(endDate);
		for(DiscountRule dr:listAll){
			//System.out.println("DiscountRule" + dr.toString());
			if(dr.getStartDate().compareTo(endDate)<0 && dr.getEndDate().compareTo(startDate)>0){
				//System.out.println("IsTrue" + (dr.getStartDate().compareTo(endDate)<0 && dr.getEndDate().compareTo(startDate)>0));
				//System.out.println("StartDate" + dr.getStartDate());
				//System.out.println("EndDate" + dr.getEndDate());
				listModified.add(dr);
				}
		}	
		return listModified;
	}

}
