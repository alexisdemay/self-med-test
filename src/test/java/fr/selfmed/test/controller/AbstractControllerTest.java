package fr.selfmed.test.controller;

public abstract class AbstractControllerTest {

    protected String getXmlExpectedFormat() {
        return "<root>\n"
                + "  <transaction id=\"127\" date=\"2019-07-26\">\n"
                + "    <label>Achat De Titres</label>\n"
                + "    <amount>-800,10</amount>\n"
                + "    <status>ASSIGNED</status>\n"
                + "  </transaction>\n"
                + "  <transaction id=\"124\" date=\"2019-02-01\">\n"
                + "    <label>CHQ 564789-l</label>\n"
                + "    <amount>42,22</amount>\n"
                + "    <status>ASSIGNED</status>\n"
                + "  </transaction>\n"
                + "  <transaction id=\"956\" date=\"2019-04-25\">\n"
                + "    <label>NETFLIX ORIGINAL</label>\n"
                + "    <amount>-14,00</amount>\n"
                + "    <status>NOTASSIGNED</status>\n"
                + "  </transaction>\n"
                + "</root>";
    }

    protected String getJsonExpectedFormat() {
        return "{\n"
                + "  \"transactions\" : [\n"
                + "     {\n"
                + "      \"id\" : 127,\n"
                + "      \"date\" : \"26/07/2019\",\n"
                + "      \"label\" : \"Achat De Titres\",\n"
                + "      \"amout\" : -800.1,\n"
                + "      \"status\" : \"ASSIGNED\"\n"
                + "    }, {\n"
                + "      \"id\" : 124,\n"
                + "      \"date\" : \"01/02/2019\",\n"
                + "      \"label\" : \"CHQ 564789-l\",\n"
                + "      \"amout\" : 42.22,\n"
                + "      \"status\" : \"ASSIGNED\"\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\" : 956,\n"
                + "      \"date\" : \"25/04/2019\",\n"
                + "      \"label\" : \"NETFLIX ORIGINAL\",\n"
                + "      \"amout\" : -14.0,\n"
                + "      \"status\" : \"NOTASSIGNED\"\n"
                + "    }\n"
                + "  ]\n"
                + "}";
    }

    protected String getExpectedSelfMedOutput() {
        return "transaction:\n"
                + "\tid: 127\n"
                + "\tdate: 2019-07-26\n"
                + "\tlabel: Achat De Titres\n"
                + "\tamout: -80010\n"
                + "\tstatus: 0\n"
                + "transaction:\n"
                + "\tid: 124\n"
                + "\tdate: 2019-02-01\n"
                + "\tlabel: CHQ 564789-l\n"
                + "\tamout: 4222\n"
                + "\tstatus: 0\n"
                + "transaction:\n"
                + "\tid: 956\n"
                + "\tdate: 2019-04-25\n"
                + "\tlabel: NETFLIX ORIGINAL\n"
                + "\tamout: -1400\n"
                + "\tstatus: 1\n";
    }

    protected String getExpectedJsonOutput() {
        return "{\n"
                + "  \"transactions\" : [ {\n"
                + "    \"id\" : 127,\n"
                + "    \"date\" : \"26/07/2019\",\n"
                + "    \"label\" : \"Achat De Titres\",\n"
                + "    \"amout\" : -800.1,\n"
                + "    \"status\" : \"ASSIGNED\"\n"
                + "  }, {\n"
                + "    \"id\" : 124,\n"
                + "    \"date\" : \"01/02/2019\",\n"
                + "    \"label\" : \"CHQ 564789-l\",\n"
                + "    \"amout\" : 42.22,\n"
                + "    \"status\" : \"ASSIGNED\"\n"
                + "  }, {\n"
                + "    \"id\" : 956,\n"
                + "    \"date\" : \"25/04/2019\",\n"
                + "    \"label\" : \"NETFLIX ORIGINAL\",\n"
                + "    \"amout\" : -14.0,\n"
                + "    \"status\" : \"NOTASSIGNED\"\n"
                + "  } ]\n"
                + "}";
    }

}
