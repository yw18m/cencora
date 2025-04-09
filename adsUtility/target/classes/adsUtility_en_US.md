# adsUtility library

## 'com.cencora.DroolsUtility' type

Display name: `drools utility`

### Constructors

#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|


Invocation syntax:

`a new drools utility`

---

### 'cmmresult' Attribute

Type: 'java.lang.String'

Getter syntax: `the cmmresult of <a drools utility>`

Setter syntax: `set the cmmresult of <a drools utility> to <a string>`

---

### 'information' Attribute

Type: 'java.lang.String'

Getter syntax: `the information of <a drools utility>`

Setter syntax: `set the information of <a drools utility> to <a string>`

---

### 'irtcSearchResult' Attribute

Type: 'java.lang.String'

Getter syntax: `the irtc search result of <a drools utility>`

Setter syntax: `set the irtc search result of <a drools utility> to <a string>`

---

### 'lillySearchResult' Attribute

Type: 'java.lang.String'

Getter syntax: `the lilly search result of <a drools utility>`

Setter syntax: `set the lilly search result of <a drools utility> to <a string>`

---

### 'parsedPayload' Attribute

Type: 'com.jayway.jsonpath.DocumentContext'

Getter syntax: `the parsed payload of <a drools utility>`

Setter syntax: `set the parsed payload of <a drools utility> to <a parsed payload>`

---

### 'payload' Attribute

Type: 'java.lang.String'

Getter syntax: `the payload of <a drools utility>`

Setter syntax: `set the payload of <a drools utility> to <a string>`

---

### 'result' Attribute

Type: 'java.lang.String'

Getter syntax: `the result of <a drools utility>`

Setter syntax: `set the result of <a drools utility> to <a string>`

---

### 'ruleSetParameter' Attribute

Type: 'java.lang.String'

Getter syntax: `the rule set parameter of <a drools utility>`

---

### 'warning' Attribute

Type: 'java.lang.String'

Getter syntax: `the warning of <a drools utility>`

Setter syntax: `set the warning of <a drools utility> to <a string>`

---

### 'DateCompare(String,String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|strDate1|java.lang.String|
|strDate2|java.lang.String|
|dateFormat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'int'



Invocation syntax:

`<a drools utility>.DateCompare(<a string>, <a string>, <a string>)`

---

### 'FindArrayValue(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|strList|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.FindArrayValue(<a string>, <a string>)`

---

### 'FindBooleanValue(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.Boolean'



Invocation syntax:

`<a drools utility>.FindBooleanValue(<a string>)`

---

### 'FindDateValue(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|dateFormat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.util.Date'



Invocation syntax:

`<a drools utility>.FindDateValue(<a string>, <a string>)`

---

### 'FindNodeCount(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'int'



Invocation syntax:

`<a drools utility>.FindNodeCount(<a string>)`

---

### 'FindValue(String,String,boolean)' Method

|Parameter Name|Parameter Type|
|---|---|
|label|java.lang.String|
|searchString|java.lang.String|
|preVal|boolean|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'void'



Invocation syntax:

`<a drools utility>.FindValue(<a string>, <a string>, <a boolean>)`

---

### 'FindValue(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a drools utility>.FindValue(<a string>)`

---

### 'FindValue(String,boolean)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|preVal|boolean|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a drools utility>.FindValue(<a string>, <a boolean>)`

---

### 'FindValueArray(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a drools utility>.FindValueArray(<a string>)`

---

### 'FindValueDouble(String,Double,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|dVal|java.lang.Double|
|opt|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.Boolean'



Invocation syntax:

`<a drools utility>.FindValueDouble(<a string>, <a number>, <a string>)`

---

### 'FindValueInt(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.Integer'



Invocation syntax:

`<a drools utility>.FindValueInt(<a string>)`

---

### 'FindValueLowerCase(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a drools utility>.FindValueLowerCase(<a string>)`

---

### 'FindValueNDCCheck(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a drools utility>.FindValueNDCCheck(<a string>)`

---

### 'FindValueNullInt(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.FindValueNullInt(<a string>)`

---

### 'Parse(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|payload|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'com.cencora.DroolsUtility'



Invocation syntax:

`drools utility.Parse(<a string>)`

---

### 'checkArrayDate(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|dateformat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkArrayDate(<a string>, <a string>)`

---

### 'checkArrayDateFormat(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|dateFormat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkArrayDateFormat(<a string>, <a string>)`

---

### 'checkArrayDateRange(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|dateFormat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkArrayDateRange(<a string>, <a string>)`

---

### 'checkBoolean(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkBoolean(<a string>)`

---

### 'checkDateFormat(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|dateFormat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkDateFormat(<a string>, <a string>)`

---

### 'checkDateValue(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|dateFormat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkDateValue(<a string>, <a string>)`

---

### 'checkDateWithinYear(String,String,Integer)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|parameter|java.lang.String|
|year|java.lang.Integer|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkDateWithinYear(<a string>, <a string>, <a number>)`

---

### 'checkIntLength(String,int,int)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|minLength|int|
|maxLength|int|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkIntLength(<a string>, <a number>, <a number>)`

---

### 'checkLength(String,String,int)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|parameter|java.lang.String|
|length|int|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkLength(<a string>, <a string>, <a number>)`

---

### 'checkLengthRangeArray(String,int,int)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|minLength|int|
|maxLength|int|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkLengthRangeArray(<a string>, <a number>, <a number>)`

---

### 'checkMandatoryFieldNotPresent(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|pathStr|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkMandatoryFieldNotPresent(<a string>)`

---

### 'checkMandatoryFieldNotPresent(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|jsonString|java.lang.String|
|pathStr|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkMandatoryFieldNotPresent(<a string>, <a string>)`

---

### 'checkMaxLength(String,int)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|length|int|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkMaxLength(<a string>, <a number>)`

---

### 'checkMaxLengthInArray(String,int)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|length|int|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkMaxLengthInArray(<a string>, <a number>)`

---

### 'checkPattern(String,String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|parameter|java.lang.String|
|pattern|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkPattern(<a string>, <a string>, <a string>)`

---

### 'checkPatternArray(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|pattern|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkPatternArray(<a string>, <a string>)`

---

### 'checkPatternObject(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|pattern|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkPatternObject(<a string>, <a string>)`

---

### 'checkRevenueDateFormat(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|dateFormat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkRevenueDateFormat(<a string>, <a string>)`

---

### 'checkvalueDoubleArray(String,Double)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|inputValue|java.lang.Double|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkvalueDoubleArray(<a string>, <a number>)`

---

### 'checkvalueStringArray(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|inputValue|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.checkvalueStringArray(<a string>, <a string>)`

---

### 'compareDateValues(String,String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|param1|java.lang.String|
|param2|java.lang.String|
|dateFormat|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.compareDateValues(<a string>, <a string>, <a string>)`

---

### 'convertStringToInt(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|str|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.Integer'



Invocation syntax:

`drools utility.convertStringToInt(<a string>)`

---

### 'eagleCanNDCsCheck(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a drools utility>.eagleCanNDCsCheck(<a string>)`

---

### 'matchRegEx(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|input|java.lang.String|
|regex|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`drools utility.matchRegEx(<a string>, <a string>)`

---

### 'modifyPayloadForGenotropin(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|genotropinNDC|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a drools utility>.modifyPayloadForGenotropin(<a string>)`

---

### 'transformJson(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|arg0|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'void'



Invocation syntax:

`<a drools utility>.transformJson(<a string>)`

---

### 'validateGenotropinNDC(String,String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
|type|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a drools utility>.validateGenotropinNDC(<a string>, <a string>)`

---

### 'validationZipCode(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a drools utility>.validationZipCode(<a string>)`

---

## 'com.cencora.RuleEngineRequest' type

Display name: `rule engine request`

### Constructors

#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|


Invocation syntax:

`a new rule engine request`

---

### 'currentService' Attribute

Type: 'java.lang.String'

Getter syntax: `the current service of <a rule engine request>`

Setter syntax: `set the current service of <a rule engine request> to <a string>`

---

### 'domain' Attribute

Type: 'java.lang.String'

Getter syntax: `the domain of <a rule engine request>`

Setter syntax: `set the domain of <a rule engine request> to <a string>`

---

### 'eventType' Attribute

Type: 'java.lang.String'

Getter syntax: `the event type of <a rule engine request>`

Setter syntax: `set the event type of <a rule engine request> to <a string>`

---

### 'nextService' Attribute

Type: 'java.lang.String'

Getter syntax: `the next service of <a rule engine request>`

Setter syntax: `set the next service of <a rule engine request> to <a string>`

---

### 'parameter' Attribute

Type: 'java.lang.String'

Getter syntax: `the parameter of <a rule engine request>`

Setter syntax: `set the parameter of <a rule engine request> to <a string>`

---

### 'requestPayload' Attribute

Type: 'java.lang.String'

Getter syntax: `the request payload of <a rule engine request>`

Setter syntax: `set the request payload of <a rule engine request> to <a string>`

---

### 'responsePayload' Attribute

Type: 'java.lang.String'

Getter syntax: `the response payload of <a rule engine request>`

Setter syntax: `set the response payload of <a rule engine request> to <a string>`

---

### 'ruleNumber' Attribute

Type: 'java.lang.String'

Getter syntax: `the rule number of <a rule engine request>`

Setter syntax: `set the rule number of <a rule engine request> to <a string>`

---

### 'ruleSetParameters' Attribute

Type: 'java.lang.String'

Getter syntax: `the rule set parameters of <a rule engine request>`

Setter syntax: `set the rule set parameters of <a rule engine request> to <a string>`

---

### 'vendor' Attribute

Type: 'java.lang.String'

Getter syntax: `the vendor of <a rule engine request>`

Setter syntax: `set the vendor of <a rule engine request> to <a string>`

---

### 'FindCount(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'int'



Invocation syntax:

`<a rule engine request>.FindCount(<a string>)`

---

### 'FindJsonPath(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a rule engine request>.FindJsonPath(<a string>)`

---

### 'FindNodeCount(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'int'



Invocation syntax:

`<a rule engine request>.FindNodeCount(<a string>)`

---

### 'FindRequestJsonPath(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'boolean'



Invocation syntax:

`<a rule engine request>.FindRequestJsonPath(<a string>)`

---

### 'FindRequestNodeCount(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'int'



Invocation syntax:

`<a rule engine request>.FindRequestNodeCount(<a string>)`

---

### 'FindValue(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a rule engine request>.FindValue(<a string>)`

---

### 'FindValueRequestPayload(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a rule engine request>.FindValueRequestPayload(<a string>)`

---

### 'FindValueResponsePayload(String)' Method

|Parameter Name|Parameter Type|
|---|---|
|searchString|java.lang.String|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'java.lang.String'



Invocation syntax:

`<a rule engine request>.FindValueResponsePayload(<a string>)`

---

### 'parseIntOrDefault(String,int)' Method

|Parameter Name|Parameter Type|
|---|---|
|input|java.lang.String|
|defaultValue|int|
#### Annotations


|Annotation|Value|
|---|---|
|pureFunction|true|
#### Usage in a decision model


|Case|Usable|
|---|---|
|Can be used in conditions|&check;|
|Can be used in actions|&check;|
Returns: 'int'



Invocation syntax:

`rule engine request.parseIntOrDefault(<a string>, <a number>)`

---

