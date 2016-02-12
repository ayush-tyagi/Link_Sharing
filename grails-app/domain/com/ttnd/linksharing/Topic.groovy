package com.ttnd.linksharing

import enums.L_Visibility

class Topic {
    String name;
    User createdBy;
    L_Visibility visibility;

    Date lastUpdated;
    Date dateCreated;
    static hasMany = [subscriptions:Subscription,linkResources:LinkResource,documentResource:DocumentResource]
    static constraints = {

        name(blank:false,unique:'createdBy');
        visibility(inlist:L_Visibility.values() as List);


    }
}
