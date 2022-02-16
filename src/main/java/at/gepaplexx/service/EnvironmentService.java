package at.gepaplexx.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;

@ApplicationScoped
public class EnvironmentService {

    public Map<String, String> getEnvironmentVars() throws JsonProcessingException {
        return System.getenv();
    }

}
