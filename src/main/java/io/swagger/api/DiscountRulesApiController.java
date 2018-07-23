package io.swagger.api;

import io.swagger.model.Discount;
import io.swagger.model.DiscountRule;
import io.swagger.model.DiscountRules;
import io.swagger.model.Error;

import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import services.DiscountRuleService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-20T07:41:46.583Z")

@RestController
public class DiscountRulesApiController implements DiscountRulesApi {

    private static final Logger log = LoggerFactory.getLogger(DiscountRulesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private DiscountRuleService discountRuleService;

    @org.springframework.beans.factory.annotation.Autowired
    public DiscountRulesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> addDiscountRule(@ApiParam(value = "DiscountRule object that needs to be added to DB" ,required=true )  @Valid @RequestBody DiscountRule body) {
        String accept = request.getHeader("Accept");
        ResponseEntity<?> response = new ResponseEntity<>(discountRuleService.saveDiscountRule(body), HttpStatus.OK);
        return response;
    }

    public ResponseEntity<?> deleteDiscountRule(@ApiParam(value = "The discount rule ID",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        ResponseEntity<DiscountRule> response = new ResponseEntity<>(HttpStatus.OK);
        discountRuleService.deleteDiscountRule(id);
        return response;
    }

    public ResponseEntity<?> findDiscountRules(@ApiParam(value = "Start date of the discountRule") @Valid @RequestParam(value = "startDate", required = false) String startDate,@ApiParam(value = "End date of the discountRule") @Valid @RequestParam(value = "endDate", required = false) String endDate,@ApiParam(value = "Number discount rules returned") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "Page number") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        String accept = request.getHeader("Accept");
        //if (accept != null && accept.contains("application/json")) {
            try {
            	if(pageSize!=null && pageNumber!=null && startDate==null && endDate==null){
            			Pageable pageable = new PageRequest(pageNumber, pageSize);
            			Page<DiscountRule> discountRules = discountRuleService.listAllByPage(pageable);
            			ResponseEntity<Page<DiscountRule>> response = new ResponseEntity<Page<DiscountRule>>(discountRules, HttpStatus.OK);
                		return response;
            		}
            	if(startDate!=null && endDate!=null && pageSize!=null && pageNumber!=null){
            		Pageable pageable = new PageRequest(pageNumber, pageSize);
            		List<DiscountRule> discountRuleList = discountRuleService.listAllDiscountRulesByDate(convert(startDate), convert(endDate));
            		PagedListHolder<DiscountRule> page = new PagedListHolder<DiscountRule>(discountRuleList);
            		
            		page.setPageSize(pageSize); // number of items per page
            		page.setPage(pageNumber);      // set to actual page

            		Page<DiscountRule> discountRulesPageable = new PageImpl<DiscountRule> (page.getPageList(),pageable,discountRuleList.size());
        			ResponseEntity<Page<DiscountRule>> response = new ResponseEntity<Page<DiscountRule>>(discountRulesPageable, HttpStatus.OK);
            		return response;
            		
            	}
            	if(startDate!=null && endDate!=null && pageSize==null && pageNumber==null){
            		List<DiscountRule> list = discountRuleService.listAllDiscountRulesByDate(convert(startDate), convert(endDate));
            		if(startDate.compareTo(endDate)<0 && list.size()>0){
            			ResponseEntity<List <DiscountRule>> response = new ResponseEntity<List <DiscountRule>>(list, HttpStatus.OK);
            			return response;
            		}
            		else 
            			return new ResponseEntity<List <DiscountRule>>(HttpStatus.BAD_REQUEST);
            	}
            	ResponseEntity<List <DiscountRule>> response = new ResponseEntity<List <DiscountRule>>(discountRuleService.listAllDiscountRules(), HttpStatus.OK);
                return response;
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List <DiscountRule>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    	//}
    }

    public ResponseEntity<DiscountRule> findRuleDiscountById(@ApiParam(value = "The discount rule ID",required=true) @PathVariable("id") String id) {
        //String accept = request.getHeader("Accept");
        //if (accept != null && accept.contains("application/json")) {
            try {
            	ResponseEntity<DiscountRule> response = new ResponseEntity<>(discountRuleService.getDiscountRuleById(id), HttpStatus.OK);
                return response;
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DiscountRule>(HttpStatus.INTERNAL_SERVER_ERROR);
           // }
        }
        //return new ResponseEntity<DiscountRule>(HttpStatus.NOT_IMPLEMENTED);
        
    }

    public ResponseEntity<DiscountRule> updateDiscountRule(@ApiParam(value = "The discount rule ID",required=true) @PathVariable("id") String id,@ApiParam(value = "Discount Rule object that needs to be added to DB" ,required=true )  @Valid @RequestBody DiscountRule body) {
        String accept = request.getHeader("Accept");
        //DiscountRule discountRule = discountRuleService.getDiscountRuleById(id);
        discountRuleService.saveDiscountRule(body);
        ResponseEntity<DiscountRule> response = new ResponseEntity<>(discountRuleService.getDiscountRuleById(id), HttpStatus.OK);
        return response;
    }
    
    public static OffsetDateTime convert(String dateString){
    	
		return OffsetDateTime.parse(dateString);
    	
    }

}
