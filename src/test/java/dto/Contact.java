package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tests.BaseTest;
@Data
@AllArgsConstructor
@Builder
public class Contact extends BaseTest {
    String phone;
    String homePhone;
    String firstName;
    String lastName;
    String mobile;
    String title;
    String otherPhone;
    String department;
    String fax;
    String email;
    String assistant;
    String asstPhone;
    String momsEmail;
    String mailingCity;
    String mailingStateProvince;
    String otherCity;
    String otherStateProvince;
    String mailingZipPostalCode;
    String mailingCountry;
    String otherZipPostalCode;
    String otherCountry;
    String languages;
    String mailingStreet;
    String otherStreet;
    String description;
}
