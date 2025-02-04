package fr.afpa.pompey.cda.appweb;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix="fr.afpa.pompey.cda.appweb")
public class CustomProperties {


    private String apiUrl;

}
