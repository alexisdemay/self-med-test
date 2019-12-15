# Technical Test for Self-Med

## Getting Started

Self-med test for Spring and Java programming.

### Prerequisites

The lombok plugin is required: <https://projectlombok.org/setup/>

### Usage

* Start the Spring Boot server
* Once is started, you can access by the following url: http://localhost:8000/self-med/api/v1/output?inputFormat=**<INPUT_FORMAT>**&outputFormat=**<OUTPUT_FORMAT>**
    * **<INPUT_FORMAT>**=xml|json
    * **<OUTPUT_FORMAT>**=xml|json|self_med

### Examples

To get the XML input from a fake external service into SELF-MED format:
<http://localhost:8000/self-med/api/v1/output?inputFormat=xml&outputFormat=self_med>
```
transaction:
	id: 127
	date: 2019-07-26
	label: Achat De Titres
	amout: -80010
	status: 0
transaction:
	id: 124
	date: 2019-02-01
	label: CHQ 564789-l
	amout: 4222
	status: 0
transaction:
	id: 956
	date: 2019-04-25
	label: NETFLIX ORIGINAL
	amout: -1400
	status: 1
```

To get the XML input from a fake external service into JSON format:
<http://localhost:8000/self-med/api/v1/output?inputFormat=xml&outputFormat=json>
```json
{
  "transactions" : [ {
    "id" : 127,
    "date" : "26/07/2019",
    "label" : "Achat De Titres",
    "amout" : -800.1,
    "status" : "ASSIGNED"
  }, {
    "id" : 124,
    "date" : "01/02/2019",
    "label" : "CHQ 564789-l",
    "amout" : 42.22,
    "status" : "ASSIGNED"
  }, {
    "id" : 956,
    "date" : "25/04/2019",
    "label" : "NETFLIX ORIGINAL",
    "amout" : -14.0,
    "status" : "NOTASSIGNED"
  } ]
}
```

To get the JSON input from a fake external service into XML format:
<http://localhost:8000/self-med/api/v1/output?inputFormat=json&outputFormat=xml>
```xml
<root>
    <transaction id="127" date="2019-07-26">
        <label>Achat De Titres</label>
        <amount>-800,10</amount>
        <status>ASSIGNED</status>
    </transaction>
    <transaction id="124" date="2019-02-01">
        <label>CHQ 564789-l</label>
        <amount>42,22</amount>
        <status>ASSIGNED</status>
    </transaction>
    <transaction id="956" date="2019-04-25">
        <label>NETFLIX ORIGINAL</label>
        <amount>-14,00</amount>
        <status>NOTASSIGNED</status>
    </transaction>
</root>
```