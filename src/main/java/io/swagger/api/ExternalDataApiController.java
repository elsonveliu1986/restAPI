package io.swagger.api;

import io.swagger.model.DiscountRule;
import io.swagger.model.Error;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-20T07:41:46.583Z")

@Controller
public class ExternalDataApiController implements ExternalDataApi {

    private static final Logger log = LoggerFactory.getLogger(ExternalDataApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ExternalDataApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> getExternalData(@ApiParam(value = "Number discount rules returned") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "Page number") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        String accept = request.getHeader("Accept");
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://www.mocky.io/v2/5b5489ae2f0000100c0619b4";
        ResponseEntity<String> response= restTemplate.getForEntity(resourceUrl, String.class,HttpStatus.OK);
        //assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        return response;
    }

}
