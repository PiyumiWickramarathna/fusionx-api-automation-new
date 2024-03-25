package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/api-config.properties",
        "file:${user.dir}/src/test/resources/api-staging-config.properties",
        "file:${user.dir}/src/test/resources/api-dev-config.properties"
})
public interface ApiConfig extends Config {

  @Key("baseUrl")
  String apiBaseUrl();
  @Key("accountCreation")
  String accountCreation();
  @Key("token.url")
  String tokenUrl();
  @Key("accessToken.path")
  String pathAccessToken();

  @Key("searchCustomer")
  String searchCustomer();
  @Key("getCustomerById")
  String getCustomerById();
  @Key("getProductByAccountType")
  String getProductByAccountType();


}