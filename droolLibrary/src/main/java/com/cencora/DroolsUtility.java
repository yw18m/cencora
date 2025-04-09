package com.cencora;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
//import com.bazaarvoice.jolt.Chainr;
//import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.json.*;
import org.apache.commons.lang3.time.DateUtils;
import java.time.ZoneId;
import java.time.LocalDate;
import com.ibm.rules.engine.annotations.PureFunction;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DroolsUtility {

	String payload;
	String ruleSetParameter;
	HashMap<String, String> responseMap = new HashMap<String, String>();
	String returnJson;
	String result = "";
	String cmmresult = "";
	String lillySearchResult = "";
	String irtcSearchResult = "";
	String warning = "";
	String information = "";
	String value = "";
	Boolean valueB = false;
	Date date = null;
	String dateException = "";

	@JsonIgnore
	ObjectMapper objectMapper = new ObjectMapper();

	List<Boolean> isAbsentLst = new ArrayList<>();
	List<String> paths;
	Double code = 0.00d;

	@JsonIgnore
	DocumentContext parsedPayload;

	Double valueDouble;
	Integer valueInt;

	@PureFunction
	public DroolsUtility() {
	}

	@PureFunction
	public static Integer convertStringToInt(String str) {
		if (str == null) {
			System.out.println("Input string is null.");
			return null;
		}

		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input: " + str + " is not a valid integer.");
			return null;
		}
	}

	@PureFunction
	public static boolean matchRegEx(String input, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	@PureFunction
	public static DroolsUtility Parse(String payload) {
		DroolsUtility du = new DroolsUtility();
		du.setPayload(payload);
		du.transformJson(payload);
		return du;
	}

	@PureFunction
	public DocumentContext getParsedPayload() {
		return parsedPayload;
	}

	public void setParsedPayload(DocumentContext parsedPayload) {
		this.parsedPayload = parsedPayload;
	}

	@PureFunction
	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@PureFunction
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@PureFunction
	public String getCmmresult() {
		return cmmresult;
	}

	public void setCmmresult(String cmmresult) {
		this.cmmresult = cmmresult;
	}

	@PureFunction
	public String getLillySearchResult() {
		return lillySearchResult;
	}

	@PureFunction
	public String getIrtcSearchResult() {
		return irtcSearchResult;
	}

	public void setLillySearchResult(String lillySearchResult) {
		this.lillySearchResult = lillySearchResult;
	}

	public void setIrtcSearchResult(String irtcSearchResult) {
		this.irtcSearchResult = irtcSearchResult;
	}

	@PureFunction
	public String getRuleSetParameter() {
		return ruleSetParameter;
	}

	@PureFunction
	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	@PureFunction
	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@PureFunction
	public void transformJson(String arg0) {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);
		setParsedPayload(JsonPath.using(config).parse(arg0));
	}

	@PureFunction
	public void FindValue(String label, String searchString, boolean preVal) throws JsonProcessingException {
		if (preVal) {
			value = (((ArrayList<Object>) (parsedPayload.read("$." + searchString)))
					.toArray()[0]) != null
							? ((ArrayList<Object>) (parsedPayload.read("$." + searchString)))
									.toArray()[0].toString()
							: null;
		} else
			value = parsedPayload.read("$." + searchString) != null
					? (parsedPayload.read("$." + searchString)).toString()
					: null;
		responseMap.put(label, value);

		try {
			returnJson = objectMapper.writeValueAsString(responseMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@PureFunction
	public int FindNodeCount(String searchString) throws JsonProcessingException {
		net.minidev.json.JSONArray jsonArray = (parsedPayload.read("$." + searchString));
		return jsonArray.size();
	}

	@PureFunction
	public String FindValue(String searchString) throws JsonProcessingException {
		value = parsedPayload.read("$." + searchString);
		return value;
	}

	@PureFunction
	public Boolean FindValueDouble(String searchString, Double dVal, String opt) throws JsonProcessingException {
		Boolean result = false;
		try {
			net.minidev.json.JSONArray jsonArray = parsedPayload.read("$." + searchString);
			code = Double.parseDouble(jsonArray.get(0).toString());
			if (opt.equals("min")) {
				if (code < dVal) {
					result = true;
				} else
					result = false;
			} else if (opt.equals("max")) {
				if (code > dVal) {
					result = true;
				} else
					result = false;
			}
		} catch (Exception e) {
			System.out.println(" FindValueArray Excpetion");
		}
		return result;
	}

	@PureFunction
	public String FindValueArray(String searchString) throws JsonProcessingException {
		try {
			net.minidev.json.JSONArray jsonArray = parsedPayload.read("$." + searchString);
			value = jsonArray.get(0).toString();
		} catch (Exception e) {
			System.out.println(" FindValueArray Excpetion");
		}
		return value;
	}

	@PureFunction
	public String FindValueNDCCheck(String searchString) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);
		boolean check = true;

		List<String> opdivo = new ArrayList<String>();
		opdivo.add("00003375614");
		opdivo.add("00003377211");
		opdivo.add("00003377412");
		opdivo.add("00003373413");

		List<String> yervoy = new ArrayList<String>();
		yervoy.add("00003232711");
		yervoy.add("00003232822");

		try {
			net.minidev.json.JSONArray jsonArray = JsonPath.using(config).parse(payload).read("$." + searchString);
			String ndc1 = (String) jsonArray.get(0);
			String ndc2 = (String) jsonArray.get(1);

			if (opdivo.contains(ndc1) && yervoy.contains(ndc2)) {
				check = false;
			} else if (yervoy.contains(ndc1) && opdivo.contains(ndc2)) {
				check = false;
			}

			if (check) {
				return " (" + ndc1 + ") and (" + ndc2 + ") ";

			}
		} catch (Exception e) {

		}

		return "empty";
	}

	/**
	 * Eagle CAN MedicationRequest NDCs code check
	 */
	@PureFunction
	public String eagleCanNDCsCheck(String searchString) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		List<String> ndcList = new ArrayList<String>();

		String arr[] = { "42367052025", "42367052125", "42367053133" };
		String result = "valid";

		for (String item : arr) {
			ndcList.add(item);
		}

		try {
			net.minidev.json.JSONArray jsonArray = JsonPath.using(config).parse(payload).read("$." + searchString);

			if (jsonArray.size() == 0) {
				result = "Exception";
			} else {
				for (int ndcIndex = 0; ndcIndex < jsonArray.size(); ndcIndex++) {
					if (!ndcList.contains(jsonArray.get(ndcIndex))) {
						result = "Exception";
					}
				}

			}

		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * PfizerOncologyTogther MedicationRequest NDCs code check
	 */
	/**
	 * public String pfizerOncologyTogetheNDCsCheck(String searchString) throws
	 * JsonProcessingException {
	 * Configuration config =
	 * Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
	 * Option.SUPPRESS_EXCEPTIONS);
	 * 
	 * List<String> ndcList = new ArrayList<String>();
	 * String arr [] = {"00009766304", "00008010001", "00069013501",
	 * "00069019301","00069013601", "70255002501", "70255002503", "70255002504",
	 * "70255002502", "00009752903", "00009752904", "00009752905", "00009752905",
	 * "00069029860", "00009509101", "00009509301", "00013013202", "00069018721",
	 * "00069018821", "00069018921", "00069068803", "00069048603", "00069028403",
	 * "00069018721", "00013257691", "00013258691", "00013259691", "00069014501",
	 * "00069015111", "00069022701", "00069023101", "70255001002", "00008451001",
	 * "00069029110", "00069029101", "00069029310", "00069029210", "00069029201",
	 * "00069029410", "00069032401", "00069130801", "00069130810", "00069130501",
	 * "00069130510", "00069130601", "00069130610", "00069130701", "00069130710",
	 * "00069130901", "00069130910", "00069130904", "00069023801", "00069024901",
	 * "00069055038", "00069077038", "00069083038", "00069098038", "00069119530",
	 * "00069029630", "00008117901",
	 * "00008117901", "00069030501", "00069030801", "00069019730", "00069119830",
	 * "00069229930", "00069814020", "00069814120", "00013871762", "00013872789"};
	 * String result = "valid";
	 * 
	 * for(String item : arr) {
	 * ndcList.add(item);
	 * }
	 * 
	 * try {
	 * net.minidev.json.JSONArray jsonArray =
	 * JsonPath.using(config).parse(payload).read("$." + searchString);
	 * 
	 * if(jsonArray.size() == 0) {
	 * result = "Exception";
	 * }else {
	 * 
	 * for(int ndcIndex =0; ndcIndex < jsonArray.size(); ndcIndex++) {
	 * 
	 * if(!ndcList.contains(jsonArray.get(ndcIndex))) {
	 * result = "Exception";
	 * }
	 * }
	 * 
	 * }
	 * 
	 * }catch(Exception e) {
	 * // System.out.println("Exception Occurred");
	 * }
	 * 
	 * return result;
	 * }
	 */

	@PureFunction
	public String validateGenotropinNDC(String searchString, String type) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		String requestType = "";

		switch (type) {
			case "ndc":
				requestType = "NotGenoptropinNDC";
				break;
			case "display":
				requestType = "NotGenoptropinDisplay";
				break;
			case "text":
				requestType = "NotGenoptropinText";
				break;
			case "referenceNdc":
				requestType = "NotGenoptropinReferenceNDC";
				break;
			case "referenceDisplay":
				requestType = "NotGenoptropinReferenceDisplay";
				break;
			case "referenceText":
				requestType = "NotGenoptropinReferenceText";
				break;
			default:
				requestType = "Exception";
				break;
		}

		List<String> ndcList = new ArrayList<String>();
		String ndc1 = "";
		String ndc2 = "";
		String arr[] = { "00013262681", "00013264681", "00013264902", "00013265002", "00013265102", "00013265202",
				"00013265302", "00013265402", "00013265502", "00013265602", "00013265702", "00013265802", "08290328203",
				"08290320119", "00013476192", "00013264703", "08290320109", "08290320122", "0013262681", "0013264681",
				"0013264902", "0013265002", "0013265102", "0013265202", "0013265302", "0013265402", "0013265502",
				"0013265602", "0013265702", "0013265802", "8290328203", "8290320119", "0013476192", "0013264703",
				"8290320109", "8290320122" };

		for (String item : arr) {
			ndcList.add(item);
		}

		try {
			net.minidev.json.JSONArray jsonArray = JsonPath.using(config).parse(payload).read("$." + searchString);

			if (jsonArray.size() == 0) {
				return "Exception";
			} else if (jsonArray.size() == 1) {
				ndc1 = jsonArray.get(0).toString();

				if (ndcList.contains(ndc1)) {
					return ndc1;
				} else {
					return requestType;
				}

			} else if (jsonArray.size() > 1) {

				ndc1 = jsonArray.get(0).toString();
				ndc2 = jsonArray.get(1).toString();

				if (ndcList.contains(ndc1)) {
					return ndc1;
				} else if (ndcList.contains(ndc2)) {
					return ndc2;
				} else {
					return requestType;
				}
			}

		} catch (Exception e) {

		}

		return "Exception";
	}

	@PureFunction
	public String modifyPayloadForGenotropin(String genotropinNDC)
			throws JsonMappingException, JsonProcessingException {

		String updatedJson = "";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(payload);
		ObjectNode node = (ObjectNode) json;
		ObjectWriter ow = new ObjectMapper().writer();

		if ("Exception".equals(genotropinNDC)) {

		} else if ("NotGenoptropinNDC".equals(genotropinNDC)) {
			node.put("BrandEnrollmentAPIKey", "");
			updatedJson = ow.writeValueAsString(json);
			setInformation(updatedJson);

		} else if ("NotGenoptropinDisplay".equals(genotropinNDC)) {
			node.put("BrandEnrollmentAPIKey", "");
			updatedJson = ow.writeValueAsString(json);
			setInformation(updatedJson);

		} else if ("NotGenoptropinText".equals(genotropinNDC)) {
			node.put("BrandEnrollmentAPIKey", "");
			updatedJson = ow.writeValueAsString(json);
			setInformation(updatedJson);

		} else if ("NotGenoptropinReferenceNDC".equals(genotropinNDC)) {
			node.put("BrandEnrollmentAPIKey", "");
			updatedJson = ow.writeValueAsString(json);
			setInformation(updatedJson);

		} else if ("NotGenoptropinReferenceDisplay".equals(genotropinNDC)) {
			node.put("BrandEnrollmentAPIKey", "");
			updatedJson = ow.writeValueAsString(json);
			setInformation(updatedJson);

		} else if ("NotGenoptropinReferenceText".equals(genotropinNDC)) {
			node.put("BrandEnrollmentAPIKey", "");
			updatedJson = ow.writeValueAsString(json);
			setInformation(updatedJson);

		} else {
			node.put("BrandEnrollmentAPIKey", genotropinNDC);
			updatedJson = ow.writeValueAsString(json);
			setInformation(updatedJson);
		}
		return updatedJson;
	}

	@PureFunction
	public String FindValueLowerCase(String searchString) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		value = JsonPath.using(config).parse(payload).read("$." + searchString);
		return value.toLowerCase();
	}

	@PureFunction
	public Boolean FindBooleanValue(String searchString) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		valueB = JsonPath.using(config).parse(payload).read("$." + searchString);
		return valueB;
	}

	@PureFunction
	public String FindValue(String searchString, boolean preVal) throws JsonProcessingException {

		if (preVal) {
			value = (((ArrayList<Object>) (parsedPayload.read("$." + searchString)))
					.toArray()[0]) != null
							? ((ArrayList<Object>) (parsedPayload.read("$." + searchString)))
									.toArray()[0].toString()
							: null;
		} else
			value = parsedPayload.read("$." + searchString) != null
					? (parsedPayload.read("$." + searchString)).toString()
					: null;
		return value;
	}

	@PureFunction
	public Date FindDateValue(String searchString, String dateFormat) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		value = JsonPath.using(config).parse(payload).read("$." + searchString);
		try {
			date = DateUtils.parseDate(value, dateFormat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dateException = "Invalid or Unsupported date format";
		}
		return date;

	}

	@PureFunction
	public boolean validationZipCode(String searchString) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));

		boolean check = false;
		try {

			if (arrayvalue.get(0).toString().matches("[0-9]{5}")
					|| arrayvalue.get(0).toString().matches("[0-9]{5}-[0-9]{4}")) {
				check = true;
			}
		} catch (Exception e) {

		}
		if (check) {
			return check;
		}
		return check;
	}

	@PureFunction
	public boolean checkArrayDateFormat(String searchString, String dateFormat) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		boolean checkformat = false;

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));
		for (int i = 0; i < arrayvalue.size(); i++) {
			try {

				if ((arrayvalue.get(i).toString())
						.matches("([0-9]{4})-(0[1-9]|1[0-2]|[1-9])-(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])")) // for
																											// yyyy/MM/dd
																											// format
					checkformat = true;

			} catch (Exception e) {
				// ex.printStackTrace();
			}

		}
		return checkformat;
	}

	@PureFunction
	public boolean checkDateValue(String searchString, String dateFormat) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		value = JsonPath.using(config).parse(payload).read("$." + searchString);
		try {
			date = DateUtils.parseDate(value, dateFormat);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	@PureFunction
	public boolean checkArrayDate(String searchString, String dateformat) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));

		for (int i = 0; i < arrayvalue.size(); i++) {
			try {
				date = DateUtils.parseDate(arrayvalue.get(i).toString(), dateformat);
			} catch (ParseException e) {
				dateException = "Invalid or Unsupported date format";
				return false;
			}
		}
		return true;
	}

	@PureFunction
	public boolean FindArrayValue(String searchString, String strList) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));
		strList = strList + ","; // add comma to list and compare array item and list item to avoid partial matc
		for (int i = 0; i < arrayvalue.size(); i++) {
			if (!strList.toLowerCase().contains(arrayvalue.get(i).toString().toLowerCase() + ",")) {
				return false;
			} else {
			}
		}
		return true;
	}

	@PureFunction
	public boolean checkMandatoryFieldNotPresent(String pathStr) {
		paths = new ArrayList<>();
		return checkMandatoryFieldNotPresent(payload, pathStr);
	}

	// New Endpoint for calling Jolt pass in parameters for your spec and input
	// json. Please pull input and spec from your drl file when you write the rule
	// for this function instead of specifying file path
	// public String transformJSON(String transformSPEC) {
	// List chainrSpecJSON = JsonUtils.classpathToList(transformSPEC);
	// Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
	// Object payloadobj = JsonUtils.jsonToObject(payload);
	// Object transformedOutput = chainr.transform(payloadobj);
	// // Object transformedOutput =
	// chainr.transform(JsonUtils.jsonToObject(payload));
	// return JsonUtils.toJsonString(transformedOutput);
	// }

	@PureFunction
	public boolean checkMandatoryFieldNotPresent(String jsonString, String pathStr) {
		JSONPointer.Builder builder = new JSONPointer.Builder();
		if (pathStr.contains("[]")) {
			calculatePath(jsonString, pathStr);
			for (String path : paths) {
				if (checkMandatoryFieldNotPresent(jsonString, path)) {
					return true;
				}
			}
		} else {
			List<String> tokens = Arrays.asList(pathStr.split("\\."));
			for (String token : tokens) {
				builder = builder.append(token);
			}
			JSONPointer jsonPointer = builder.build();
			JSONObject jsonObject = new JSONObject(jsonString);
			Object retVal = jsonObject.optQuery(jsonPointer);
			return Objects.isNull(retVal) || (retVal != null && retVal.toString().isEmpty())
					|| "null".equals(retVal.toString());
		}

		return false;
	}

	private void calculatePath(String jsonString, String pathStr) {
		JSONPointer.Builder builder = new JSONPointer.Builder();
		List<String> tokens = Arrays.asList(pathStr.split("\\."));
		StringBuilder path = new StringBuilder();
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).equals("[]")) {
				JSONPointer jsonPointer = builder.build();
				JSONObject jsonObject = new JSONObject(jsonString);
				JSONArray jsonArray = (JSONArray) jsonObject.optQuery(jsonPointer);
				calculatePath(jsonString, i, jsonArray, tokens, path);
			} else {
				builder.append(tokens.get(i));
			}
		}
	}

	private void calculatePath(String jsonString, Integer tokenIndex, JSONArray jsonArray, List<String> tokens,
			StringBuilder path) {

		if (!Objects.isNull(jsonArray) && !jsonArray.isEmpty()) {
			for (int j = 0; j < jsonArray.length(); j++) {
				path = new StringBuilder();
				for (int k = 0; k < tokens.size(); k++) {
					if (k == tokenIndex) {
						tokens.set(k, String.valueOf(j));
					}
					if (k == 0) {
						path.append(tokens.get(k));
					} else {
						path.append(".").append(tokens.get(k));
					}
				}
				String actPath = path.toString();
				if (actPath.contains("[]")) {
					calculatePath(jsonString, actPath);
				} else {
					paths.add(actPath);
				}
			}
		}
	}

	@PureFunction
	public boolean checkDateFormat(String searchString, String dateFormat) throws JsonProcessingException {

		boolean checkformat = false;
		String val = (parsedPayload.read("$." + searchString));
		try {
			if ((val.toString()).matches("(0[1-9]|1[0-2]|[1-9])/(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])/([0-9]{4})")) // for
																													// MM/DD/YYYY
																													// format
				checkformat = true;

		} catch (Exception e) {
			// ex.printStackTrace();

		}
		return checkformat;
	}

	@PureFunction
	public boolean checkRevenueDateFormat(String searchString, String dateFormat) throws JsonProcessingException {

		boolean checkformat = false;

		net.minidev.json.JSONArray arrayvalue = (parsedPayload.read("$." + searchString));
		for (int i = 0; i < arrayvalue.size(); i++) {
			try {

				if ((arrayvalue.get(i).toString())
						.matches("(0[1-9]|1[0-2]|[1-9])/(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])/([0-9]{4})")) // for
																											// MM/DD/YYYY
																											// format
					checkformat = true;

			} catch (Exception e) {
				// ex.printStackTrace();
			}

		}
		return checkformat;
	}

	@PureFunction
	public boolean checkLength(String searchString, String parameter, int length) throws JsonProcessingException {
		net.minidev.json.JSONArray arrayvalue = (parsedPayload.read("$." + searchString));
		for (int i = 0; i < arrayvalue.size(); i++) {
			if (parsedPayload.read("$." + searchString + "[" + i + "]" + parameter) == null) {
			} else if (parsedPayload.read("$." + searchString + "[" + i + "]" + parameter).toString().length() < length)
				return true;
		}
		return false;
	}

	@PureFunction
	public boolean checkMaxLength(String searchString, int length) throws JsonProcessingException {
		if (parsedPayload.read("$." + searchString) == null) {
		} else if (parsedPayload.read("$." + searchString).toString().length() > length)
			return true;
		return false;
	}

	@PureFunction
	public boolean checkPattern(String searchString, String parameter, String pattern) throws JsonProcessingException {
		net.minidev.json.JSONArray arrayvalue = (parsedPayload.read("$." + searchString));
		for (int i = 0; i < arrayvalue.size(); i++) {
			if (!parsedPayload.read("$." + searchString + "[" + i + "]" + parameter).toString().matches(pattern))
				return true;
		}
		return false;
	}

	@PureFunction
	public boolean checkBoolean(String searchString) throws JsonProcessingException {
		if (parsedPayload.read("$." + searchString) == null)
			return true;
		else if (parsedPayload.read("$." + searchString).getClass().getSimpleName().toString().contains("Boolean"))
			return false;
		else
			return true;
	}

	@PureFunction
	public boolean checkDateWithinYear(String searchString, String parameter, Integer year)
			throws JsonProcessingException {
		LocalDate requiredDate = LocalDate.now().plusYears(year);
		ZoneId zoneId = ZoneId.of("US/Eastern");
		Date expirationDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			expirationDate = sdf.parse(searchString);
		} catch (Exception ex) {
			System.out.println("Date format is wrong.");
		}
		if (parameter.equals("after")) {
			if (expirationDate.after(Date.from(requiredDate.atStartOfDay(zoneId).toInstant()))) {
				return true;
			} else
				return false;
		} else if (parameter.equals("before")) {
			if (expirationDate.before(Date.from(requiredDate.atStartOfDay(zoneId).toInstant()))) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	@PureFunction
	public Integer FindValueInt(String searchString) throws JsonProcessingException {
		valueInt = parsedPayload.read("$." + searchString);
		return valueInt;
	}

	@PureFunction
	public boolean FindValueNullInt(String searchString) throws JsonProcessingException {
		if (parsedPayload.read("$." + searchString) == null)
			return true;
		else
			return false;
	}

	@PureFunction
	public boolean checkIntLength(String searchString, int minLength, int maxLength) throws JsonProcessingException {
		System.out.println(parsedPayload.read("$." + searchString) == null);
		if (parsedPayload.read("$." + searchString) == null) {
			return false;
		} else if (((parsedPayload.read("$." + searchString)).toString().length() >= minLength)
				&& ((parsedPayload.read("$." + searchString)).toString().length() <= maxLength))
			return false;
		return true;
	}

	@PureFunction
	public boolean checkArrayDateRange(String searchString, String dateFormat) throws JsonProcessingException {
		Boolean check = false;
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date expirationDate = null;
		Date inputDate = null;
		LocalDate maxDate = LocalDate.now().plusDays(180);
		LocalDate minDate = LocalDate.now().plusDays(-2);
		ZoneId zoneId = ZoneId.of("US/Eastern");
		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));
		System.out.println(arrayvalue);
		for (int i = 0; i < arrayvalue.size(); i++) {
			try {
				expirationDate = sdf.parse(arrayvalue.get(i).toString());
				inputDate = inputFormat.parse(inputFormat.format(expirationDate));

				if ((inputDate.after(Date.from(maxDate.atStartOfDay(zoneId).toInstant())))
						|| (inputDate.before(Date.from(minDate.atStartOfDay(zoneId).toInstant())))) {
					check = true;

				}

			} catch (ParseException e) {
				dateException = "Invalid or Unsupported date format";
				System.out.println("Invalid or Unsupported date format");
				check = false;

			}
		}
		return check;
	}

	@PureFunction
	public boolean compareDateValues(String param1, String param2, String dateFormat) throws JsonProcessingException {
		Boolean check = false;
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date readyDate = null;
		Date dueDate = null;
		net.minidev.json.JSONArray arrayvalue1 = (JsonPath.using(config).parse(payload).read("$." + param1));
		net.minidev.json.JSONArray arrayvalue2 = (JsonPath.using(config).parse(payload).read("$." + param2));

		for (int i = 0; i < arrayvalue1.size(); i++) {
			try {
				readyDate = sdf.parse(arrayvalue1.get(i).toString());
				dueDate = sdf.parse(arrayvalue2.get(i).toString());
				if (dueDate.before(readyDate)) {
					check = true;
				}

			} catch (ParseException e) {
				dateException = "Invalid or Unsupported date format";
				System.out.println("Invalid or Unsupported date format");
				check = false;

			}
		}
		return check;
	}

	@PureFunction
	public boolean checkMaxLengthInArray(String searchString, int length) throws JsonProcessingException {

		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));
		System.out.println(arrayvalue);
		for (int i = 0; i < arrayvalue.size(); i++) {
			try {
				if (arrayvalue.get(i).toString() != null && arrayvalue.get(i).toString().length() > length) {

					System.out.println("Invalid value");
					System.out.println(arrayvalue.get(i).toString());
					return true;
				}
			} catch (NullPointerException e) {

				return false;
			}
		}
		return false;
	}

	@PureFunction
	public boolean checkLengthRangeArray(String searchString, int minLength, int maxLength)
			throws JsonProcessingException {

		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));
		System.out.println(arrayvalue);
		for (int i = 0; i < arrayvalue.size(); i++) {
			try {
				if (arrayvalue.get(i).toString() != null && arrayvalue.get(i).toString().length() > maxLength
						|| arrayvalue.get(i).toString().length() < minLength) {

					System.out.println("Invalid value");
					return true;
				}
			} catch (NullPointerException e) {

				return false;
			}
		}
		return false;
	}

	@PureFunction
	public boolean checkPatternArray(String searchString, String pattern) throws JsonProcessingException {

		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));
		System.out.println(arrayvalue);
		for (int i = 0; i < arrayvalue.size(); i++) {
			try {
				if ((arrayvalue.get(i).toString() != null) && (!arrayvalue.get(i).toString().matches(pattern))) {

					System.out.println("Invalid value");

					return true;
				}
			} catch (NullPointerException e) {

				return false;

			}

		}

		return false;
	}

	@PureFunction
	public boolean checkPatternObject(String searchString, String pattern) throws JsonProcessingException {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);
		value = parsedPayload.read("$." + searchString);
		boolean check = false;
		System.out.println(value);
		try {
			if ((value.toString() != null) && (!value.toString().matches(pattern))) {

				System.out.println("Null value");
			} else if (!value.toString().matches(pattern)) {
				System.out.println("Invalid value");
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;

		}
		return check;
	}

	@PureFunction
	public boolean checkvalueStringArray(String searchString, String inputValue) throws JsonProcessingException {

		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));
		System.out.println(arrayvalue);
		for (int i = 0; i < arrayvalue.size(); i++) {
			try {
				if (arrayvalue.get(i).toString().equalsIgnoreCase(inputValue)) {
					System.out.println("Invalid value");
					return true;
				}
			} catch (NullPointerException e) {

				return true;
			}
		}
		return false;
	}

	@PureFunction
	public boolean checkvalueDoubleArray(String searchString, Double inputValue) throws JsonProcessingException {

		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL,
				Option.SUPPRESS_EXCEPTIONS);

		net.minidev.json.JSONArray arrayvalue = (JsonPath.using(config).parse(payload).read("$." + searchString));

		for (int i = 0; i < arrayvalue.size(); i++) {
			try {

				if (Double.valueOf(arrayvalue.get(i).toString()).equals(inputValue)) {
					System.out.println("Invalid value");

					return true;
				}
			} catch (NullPointerException e) {

				return true;
			}
		}
		return false;
	}

	@PureFunction
	public int DateCompare(String strDate1, String strDate2, String dateFormat) throws JsonProcessingException {
		SimpleDateFormat dtformat = new SimpleDateFormat(dateFormat);
		Date date1 = null, date2 = null;
		try {
			date1 = dtformat.parse(strDate1);
			date2 = dtformat.parse(strDate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dateException = "Invalid or Unsupported date format";
		}
		return (date1.compareTo(date2));

	}

}
