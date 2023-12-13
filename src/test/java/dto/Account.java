package dto;

import lombok.*;
import tests.BaseTest;
@Data
@AllArgsConstructor
@Builder
public class Account extends BaseTest {
    String accountName;
    String accountNumber;
    String phone;
    String fax;
    String website;
    String accountSite;
    String tickerSymbol;
    String employees;
    String annualRevenue;
    String sicCode;
    String billingCity;
    String billingStateProvince;
    String shippingCity;
    String shippingStateProvince;
    String billingZipPostalCode;
    String billingCountry;
    String shippingZipPostalCode;
    String shippingCountry;
    String slaSerialNumber;
    String numberOfLocations;
    String billingStreet;
    String shippingStreet;
    String description;
    }
