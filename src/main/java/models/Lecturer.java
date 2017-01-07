package models;

/**
 * Created by patrick_laptop on 22.10.16.
 */
/*
 * Copyright (c) peter.braun@fhws.de
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
/* *****************************************************************************
  This file was generated as part of the GeMARA project by generator class:
  de.fhws.applab.gemara.dalston.generator.models.resources.frontend.JavaModelForSingleClientResourceGenerator
  DON'T EDIT THIS FILE. ALL MODIFICATIONS EXCEPT THOSE MARKED WILL BE OVERWRITTEN.
***************************************************************************** */
// ###(imports) You can edit below this line ###

        import com.owlike.genson.annotation.JsonConverter;
        import com.owlike.genson.annotation.JsonProperty;
        import de.fhws.applab.gemara.models.AbstractModel;
        import de.fhws.applab.gemara.shaklewell.ClientLinkConverter;
        import de.fhws.applab.gemara.shaklewell.Link;

// ###(imports) You can edit above this line ###
public class Lecturer extends AbstractModel
{

    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName( String firstName) {

        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName( String lastName) {

        this.lastName = lastName;
    }

    private String address;

    public String getAddress() {
        return this.address;
    }

    public void setAddress( String address) {

        this.address = address;
    }

    private String roomNumber;

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber( String roomNumber) {

        this.roomNumber = roomNumber;
    }

    private String phone;

    public String getPhone() {
        return this.phone;
    }

    public void setPhone( String phone) {

        this.phone = phone;
    }

    private Link homepage;

    public Link getHomepage() {
        return this.homepage;
    }

    public void setHomepage(Link homepage) {

        this.homepage = homepage;
    }

    public void setHomepage(String homepageUrl) {
        this.homepage = new Link(homepageUrl, "text/html", "homepage");
    }

    private Link profileImageUrl;
    @JsonConverter( ClientLinkConverter.class )
    public Link getProfileImageUrl() {
        return this.profileImageUrl;
    }
    @JsonConverter( ClientLinkConverter.class )
    public void setProfileImageUrl( Link profileImageUrl) {

        this.profileImageUrl = profileImageUrl;
    }

    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle( String title) {

        this.title = title;
    }

    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail( String email) {

        this.email = email;
    }
    private Link selfUri;
    @JsonConverter( ClientLinkConverter.class ) @JsonProperty( "self" ) public Link getSelfUri( ) { return selfUri; }
    @JsonConverter( ClientLinkConverter.class )  @JsonProperty( "self" ) public void setSelfUri( Link link ) { this.selfUri = link; }
}