package at.gepaplexx.service;

import at.gepaplexx.domain.Configuration;
import io.smallrye.config.PropertiesConfigSource;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ConfigurationService {

    public List<Configuration> getConfiguration() {
        var configuration = new ArrayList<Configuration>();
        ConfigProvider.getConfig().getConfigSources().forEach(source -> {
            if(source instanceof PropertiesConfigSource pcsource) {
                configuration.add(new Configuration(pcsource.getName(), pcsource.getProperties()));
            }
        });

        return configuration;
    }

}
