package com.jfrog.rest.apis.testcases;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.jfrog.base.Base;
import com.jfrog.pojo.GETArtifactsAPIPojo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GETandSearchTestCases extends Base {
    
    String COMMON_PATH = "/artifactory/api";
        
    @Test
    public void getAllartifacts() {
        final String artifact_path= COMMON_PATH+"/storage/sbt-release";
                    
        REQUEST.get(artifact_path)
               .then().statusCode(200)
               .assertThat().body(matchesJsonSchemaInClasspath("GET-JsonSchemaFile.json"));
        
        GETArtifactsAPIPojo getArtifactsList = REQUEST.get(artifact_path).as(GETArtifactsAPIPojo.class);
        Assert.assertEquals(getArtifactsList.getChildren()[0].getUri(), "/play_2.12-0.0.1-SNAPSHOT.jar");
        Assert.assertEquals(getArtifactsList.getChildren()[1].getUri(), "/myJFrog.txt");
    }


    @Test
    public void searchArtifact() {
        final String artifact_searchPath = COMMON_PATH+"/search/artifact";
        final String paramName = "name";
        final String paramValue = "play_2.12-0.0.1-SNAPSHOT.jar";

        REQUEST.queryParam(paramName, paramValue)
               .when()
               .get(artifact_searchPath)
               .then().statusCode(200)
               .assertThat().body(matchesJsonSchemaInClasspath("GET-SearchResultSchema.json"));                
    }
}