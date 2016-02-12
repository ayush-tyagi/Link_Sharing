package com.ttnd.linksharing

class User {

    String email_id;
    String firstName;
    String lastName;
    String userName;
    String password;
    Boolean isActive;
    Boolean isAdmin;
    byte[] photo;
    static transients = ['name']
    Date lastUpdated;
    Date dateCreated;
    static hasMany = [topics:Topic,subscriptions:Subscription,linkResources:LinkResource,documentResource:DocumentResource,ratingItem:ResourceRating]
    static mapping = {

    photo(sqlType:'longblob')
    }


    static constraints = {
        email_id(unique:true,blank:false,email:true);
        password(blank:false,minSize:5);
        firstName(blank:false);
        lastName(blank:false);
        isActive(nullable:true);
        isAdmin(nullable:true);
        photo(nullable:true);
    }

    String getName()
    {
     [this.firstName,this.lastName].join(' ')

    }
}
