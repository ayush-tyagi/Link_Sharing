package com.ttnd.linksharing

class Experiment {
    int ex_id
    String name
    String address
    static constraints = {
        ex_id unique: true
    }
}
