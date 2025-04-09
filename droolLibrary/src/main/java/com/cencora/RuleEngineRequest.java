package com.cencora;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashMap;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.apache.commons.lang3.StringUtils;
import com.ibm.rules.engine.annotations.PureFunction;

/**
 * Rule Engine Request class is used
 * for setting request payload and
 * response value.
 */

public class RuleEngineRequest {

    private String ruleSetParameters;
    private String domain;
    private String responsePayload;
    private String requestPayload;
    private String vendor;
    private String currentService;
    String value = "";
    String payload;
    boolean delta = false;
    private String nextService;
    private String eventType;
    private String parameter;
    private int matchCount;
    private int arrayDepth;
    private String ruleNumber;

    @PureFunction
    public String FindValueResponsePayload(String searchString) throws JsonProcessingException {
        Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
                Option.SUPPRESS_EXCEPTIONS);
        String responsePayloadData = getResponsePayload();
        value = JsonPath.using(config).parse(responsePayloadData).read("$." + searchString);
        return value;
    }

    @PureFunction
    public boolean FindRequestJsonPath(String searchString) throws JsonProcessingException {
        Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
                Option.SUPPRESS_EXCEPTIONS);
        String requestPayloadData = getRequestPayload();
        try {
            net.minidev.json.JSONArray jsonArray = JsonPath.using(config).parse(requestPayloadData)
                    .read("$." + searchString);
            delta = jsonArray.isEmpty();
        } catch (Exception e) {
        }
        return delta;
    }

    @PureFunction
    public String FindJsonPath(String searchString) throws JsonProcessingException {
        Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
                Option.SUPPRESS_EXCEPTIONS);
        String responsePayloadData = getResponsePayload();
        try {
            net.minidev.json.JSONArray jsonArray = JsonPath.using(config).parse(responsePayloadData)
                    .read("$." + searchString);
            value = jsonArray.get(0).toString();
        } catch (Exception e) {
        }
        return value;
    }

    @PureFunction
    public String FindValue(String searchString) throws JsonProcessingException {
        Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
                Option.SUPPRESS_EXCEPTIONS);
        value = JsonPath.using(config).parse(payload).read("$." + searchString);
        return value;
    }

    @PureFunction
    public String FindValueRequestPayload(String searchString) throws JsonProcessingException {
        Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
                Option.SUPPRESS_EXCEPTIONS);
        String requestPayloadData = getRequestPayload();
        value = JsonPath.using(config).parse(requestPayloadData).read("$." + searchString);
        return value;
    }

    @PureFunction
    public int FindNodeCount(String searchString) throws JsonProcessingException {
        Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
                Option.SUPPRESS_EXCEPTIONS);
        net.minidev.json.JSONArray jsonArray = (JsonPath.using(config).parse(responsePayload)
                .read("$." + searchString));
        return jsonArray.size();
    }

    @PureFunction
    public int FindCount(String searchString) throws JsonProcessingException {
        Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
                Option.SUPPRESS_EXCEPTIONS);
        String requestPayloadData = getRequestPayload();
        try {
            matchCount = StringUtils.countMatches(requestPayloadData, searchString);
        } catch (Exception e) {
        }
        return matchCount;
    }

    @PureFunction
    public int FindRequestNodeCount(String searchString) throws JsonProcessingException {
        Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
                Option.SUPPRESS_EXCEPTIONS);
        String requestPayloadData = getRequestPayload();
        try {
            net.minidev.json.JSONArray jsonArray = (JsonPath.using(config).parse(requestPayloadData)
                    .read("$." + searchString));
            arrayDepth = jsonArray.size();
        } catch (Exception e) {
        }
        return arrayDepth;
    }

    @PureFunction
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @PureFunction
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @PureFunction
    public String getCurrentService() {
        return currentService;
    }

    public void setCurrentService(String currentService) {
        this.currentService = currentService;
    }

    @PureFunction
    public String getRuleSetParameters() {
        return ruleSetParameters;
    }

    public void setRuleSetParameters(String ruleSetParameters) {
        this.ruleSetParameters = ruleSetParameters;
    }

    @PureFunction
    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @PureFunction
    public String getEventType() {
        return eventType;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @PureFunction
    public String getParameter() {
        return parameter;
    }

    @PureFunction
    public String getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(String responsePayload) {
        this.responsePayload = responsePayload;
    }

    @PureFunction
    public String getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(String requestPayload) {
        this.requestPayload = requestPayload;
    }

    @PureFunction
    public String getRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(String ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    @PureFunction
    public static int parseIntOrDefault(String input, int defaultValue) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
