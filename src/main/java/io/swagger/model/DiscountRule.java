package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Discounts;

import org.threeten.bp.OffsetDateTime;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DiscountRule
 */
@Document(collection="discountRule")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-20T07:41:46.583Z")
@EntityScan
public class DiscountRule   {
	
  @JsonProperty("id")
  @Id
  private String id = null;

  @JsonProperty("ruleId")
  private String ruleId = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("ruleName")
  private String ruleName = null;

  @JsonProperty("startDate")
  private OffsetDateTime startDate = null;

  @JsonProperty("endDate")
  private OffsetDateTime endDate = null;

  @JsonProperty("Discounts")
  private Discounts discounts = null;

  public DiscountRule id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DiscountRule ruleId(String ruleId) {
    this.ruleId = ruleId;
    return this;
  }

  /**
   * Get ruleId
   * @return ruleId
  **/
  @ApiModelProperty(value = "")


  public String getRuleId() {
    return ruleId;
  }

  public void setRuleId(String ruleId) {
    this.ruleId = ruleId;
  }

  public DiscountRule userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public DiscountRule ruleName(String ruleName) {
    this.ruleName = ruleName;
    return this;
  }

  /**
   * Get ruleName
   * @return ruleName
  **/
  @ApiModelProperty(value = "")


  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  public DiscountRule startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public DiscountRule endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public DiscountRule discounts(Discounts discounts) {
    this.discounts = discounts;
    return this;
  }

  /**
   * Get discounts
   * @return discounts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Discounts getDiscounts() {
    return discounts;
  }

  public void setDiscounts(Discounts discounts) {
    this.discounts = discounts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiscountRule discountRule = (DiscountRule) o;
    return Objects.equals(this.id, discountRule.id) &&
        Objects.equals(this.ruleId, discountRule.ruleId) &&
        Objects.equals(this.userId, discountRule.userId) &&
        Objects.equals(this.ruleName, discountRule.ruleName) &&
        Objects.equals(this.startDate, discountRule.startDate) &&
        Objects.equals(this.endDate, discountRule.endDate) &&
        Objects.equals(this.discounts, discountRule.discounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ruleId, userId, ruleName, startDate, endDate, discounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscountRule {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ruleId: ").append(toIndentedString(ruleId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    ruleName: ").append(toIndentedString(ruleName)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

