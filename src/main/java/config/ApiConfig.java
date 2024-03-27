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

  @Key("local_baseUrl")
  String apiBaseUrl();

  @Key("qa_baseUrl")
  String qaBaseUrl();

  @Key("uat_baseUrl")
  String uatBaseUrl();

  @Key("accountCreation")
  String accountCreation();
  @Key("token.url")
  String tokenUrl();
  @Key("accessToken.path")
  String pathAccessToken();

  @Key("searchCustomer.path")
  String searchCustomer();
  @Key("getCustomerById.path")
  String getCustomerById();
  @Key("getProductByAccountType.path")
  String getProductByAccountType();

  @Key("getSubProductByProductId.path")
  String getSubProductByProductId();

  @Key("getAccountSchemeTypes.path")
  String getAccountScheme();

  @Key("getPeriodByStatus.path")
  String getPeriodByStatus();

  @Key("getSearchSupplies.path")
  String getSearchSupplies();

  @Key("getCalculatedChargeDetails.path")
  String getCalculatedChargeDetails();


}