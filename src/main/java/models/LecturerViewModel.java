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
  de.fhws.applab.gemara.dalston.generator.models.views.frontend.ResourceViewGenerator
  DON'T EDIT THIS FILE. ALL MODIFICATIONS EXCEPT THOSE MARKED WILL BE OVERWRITTEN.
***************************************************************************** */
// ###(imports) You can edit below this line ###

import com.owlike.genson.annotation.JsonConverter;
import com.owlike.genson.annotation.JsonProperty;
import de.fhws.applab.gemara.models.ViewModel;
import de.fhws.applab.gemara.shaklewell.ClientLinkConverter;
import de.fhws.applab.gemara.shaklewell.Link;

// ###(imports) You can edit above this line ###
public class LecturerViewModel extends ViewModel< Lecturer >
{
    public LecturerViewModel( )
    {
        theModel = new Lecturer( );
    }

    public LecturerViewModel( Lecturer theModel )
    {
        super( theModel );
    }

    public String getFirstName( )
    {
        return theModel.getFirstName( );
    }

    public void setFirstName( String firstName )
    {
        theModel.setFirstName( firstName );
    }

    public String getLastName( )
    {
        return theModel.getLastName( );
    }

    public void setLastName( String lastName )
    {
        theModel.setLastName( lastName );
    }

    public String getAddress( )
    {
        return theModel.getAddress( );
    }

    public void setAddress( String address )
    {
        theModel.setAddress( address );
    }

    public String getRoomNumber( )
    {
        return theModel.getRoomNumber( );
    }

    public void setRoomNumber( String roomNumber )
    {
        theModel.setRoomNumber( roomNumber );
    }

    public String getPhone( )
    {
        return theModel.getPhone( );
    }

    public void setPhone( String phone )
    {
        theModel.setPhone( phone );
    }

    public Link getHomepage()
    {
        return theModel.getHomepage();
    }

    public void setHomepage(String homepageUrl)
    {
        theModel.setHomepage(homepageUrl);
    }

    public void setHomepage(Link homepage) {
        theModel.setHomepage(homepage);
    }

    @JsonConverter( ClientLinkConverter.class )
    public Link getProfileImageUrl( )
    {
        return theModel.getProfileImageUrl( );
    }

    @JsonConverter( ClientLinkConverter.class )
    public void setProfileImageUrl( Link profileImageUrl )
    {
        theModel.setProfileImageUrl( profileImageUrl );
    }

    public String getTitle( )
    {
        return theModel.getTitle( );
    }

    public void setTitle( String title )
    {
        theModel.setTitle( title );
    }

    public String getEmail( )
    {
        return theModel.getEmail( );
    }

    public void setEmail( String email )
    {
        theModel.setEmail( email );
    }

    @Override
    public String toString( )
    {
        return "LecturerViewModel{" +
                "firstName='" + this.getFirstName( ) + '\'' +
                ", lastName='" + this.getLastName( ) + '\'' +
                ", title='" + this.getTitle( ) + '\'' +
                ", urlWelearn='" + this.getHomepage() + '\'' +
                ", email='" + this.getEmail( ) + '\'' +
                ", phone='" + this.getPhone( ) + '\'' +
                ", urlProfileImage='" + this.getProfileImageUrl( ) + '\'' +
                ", address='" + this.getAddress( ) + '\'' +
                ", roomNumber='" + this.getRoomNumber( ) + '\'' +
                '}';
    }

    @JsonConverter( ClientLinkConverter.class )
    @JsonProperty( "self" )
    public Link getSelfUri( )
    {
        return theModel.getSelfUri( );
    }

    @JsonConverter( ClientLinkConverter.class )
    @JsonProperty( "self" )
    public void setSelfUri( Link link )
    {
        theModel.setSelfUri( link );
    }
}