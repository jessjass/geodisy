package Dataverse.DataverseJSONFieldClasses;

import org.json.JSONArray;
import org.json.JSONObject;

public class Producer extends JSONField{
    private String producerName, producerAffiliation, producerAbbreviation, producerURL, producerLogoURL;

    public Producer() {
        this.producerName = "";
        this.producerAffiliation = "";
        this.producerAbbreviation = "";
        this.producerURL = "";
        this.producerLogoURL = "";
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerAffiliation() {
        return producerAffiliation;
    }

    public void setProducerAffiliation(String producerAffiliation) {
        this.producerAffiliation = producerAffiliation;
    }

    public String getProducerAbbreviation() {
        return producerAbbreviation;
    }

    public void setProducerAbbreviation(String producerAbbreviation) {
        this.producerAbbreviation = producerAbbreviation;
    }

    public String getProducerURL() {
        return producerURL;
    }

    public void setProducerURL(String producerURL) {
        this.producerURL = producerURL;
    }

    public String getProducerLogoURL() {
        return producerLogoURL;
    }

    public void setProducerLogoURL(String producerLogoURL) {
        this.producerLogoURL = producerLogoURL;
    }

    @Override
    public void setField(JSONObject field) {
        String title = field.getString("typeName");
        String value = field.getString("value");
        switch (title) {
            case("producerName"):
                this.producerName = value;
                break;
            case("producerAffiliation"):
                this.producerAffiliation = value;
                break;
            case("producerAbbreviation"):
                this.producerAbbreviation = value;
                break;
            case("producerURL"):
                this.producerURL = value;
                break;
            case("producerLogoURL"):
                this.producerLogoURL = value;
                break;
            default:
                System.out.println("Something went wrong with Producer parsing");
        }
    }
}
