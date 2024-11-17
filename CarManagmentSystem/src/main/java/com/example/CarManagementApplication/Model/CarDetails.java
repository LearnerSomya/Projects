//Model is a package where ewe make our tables. in mongoDb we have data as Key:Value pairs
package com.example.CarManagementApplication.Model;

import java.io.*;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collation = "CarDetails")
//This "CarDetails" will be the name of our Table/Collection in or database
public class CarDetails {
    @Id
    private String Title;
    private String Description;
    private List<Strings> Tags;
    private List<Strings> Images;
    private List<Strings> Company;

    public CarDetails(String title, String description, List<Strings> tags, List<Strings> images, List<Strings> company) {
        this.Title = title;
        this.Description = description;
        this.Tags = tags;
        this.Images = images;
        this.Company = company;
    }

}
