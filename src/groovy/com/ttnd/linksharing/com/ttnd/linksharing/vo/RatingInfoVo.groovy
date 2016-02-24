package com.ttnd.linksharing.com.ttnd.linksharing.vo

/**
 * Created by ayush on 24/2/16.
 */
class RatingInfoVo {
    Integer totalVotes
    Integer averageScore
    Integer totalScore

    String toString(){
        return "Count: ${this.totalVotes}=======Average Score:${this.averageScore}=====Total Score:${this.totalScore}"
    }
}







