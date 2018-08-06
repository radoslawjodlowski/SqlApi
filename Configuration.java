package pl.raaadziu.nb1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class Configuration {

    private String sqlString;
    
    String getSqlString()
    {
        return sqlString;
    }
    
    private static Logger log = LoggerFactory.getLogger("Configuration");
    
    Configuration()
    {

        sqlString = System.getenv("SQL1");
        if (sqlString == null)
        {
            log.error("Unable to load SQL1 variable");
            throw new NullPointerException();
        }
        log.info("Environment variables loaded ");
    }
}
