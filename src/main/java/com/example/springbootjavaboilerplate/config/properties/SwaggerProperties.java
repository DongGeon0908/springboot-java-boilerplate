package com.example.springbootjavaboilerplate.config.properties;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    private static final String SWAGGER_SPLIT_REGEX = ",";
    @NotBlank
    private String projectName;
    @NotBlank
    private String githubUrl;
    private String developerEmail;
    private String apiTitle;
    private String apiDescription;
    @NotBlank
    private String apiVersion;
    @NotBlank
    private String temrsOfServiceUrl;
    private String license;
    private String licenseUrl;
    private String typeJson;
    private String typeXml;
    @NotBlank
    private String apiName;
    @NotBlank
    private String apiKeyName;
    private String apiPassAs;
    @NotBlank
    private String whiteList;

    public String[] getWhiteList() {
        return whiteList.split(SWAGGER_SPLIT_REGEX);
    }

    public Set<String> toProducesAndConsumes() {
        return new HashSet<>(Arrays.asList(typeJson, typeXml));
    }

    public ApiInfo toApiInfo() {
        return new ApiInfo(apiTitle, apiDescription, apiVersion, temrsOfServiceUrl, toContact(),
                license, licenseUrl, new ArrayList<>());
    }

    private Contact toContact() {
        return new Contact(projectName, githubUrl, developerEmail);
    }

    public ApiKey toApiKey() {
        return new ApiKey(apiName, apiKeyName, apiPassAs);
    }
}