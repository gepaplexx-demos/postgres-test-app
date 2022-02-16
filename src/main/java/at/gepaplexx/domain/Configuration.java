package at.gepaplexx.domain;

import lombok.ToString;

import java.util.Map;

@ToString
public class Configuration {

    String name;
    Map<String, String> properties;

    public Configuration(String name, Map<String, String> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
