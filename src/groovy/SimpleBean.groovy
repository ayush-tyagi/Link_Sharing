/**
 * Created by ayush on 7/3/16.
 */
class SimpleBean {
    String name
    int age
    SimpleBean(){
    println "Default called"
    }

    SimpleBean(String name,int age){
        println "8-8-8-8-8-88-8-8->>>>>>Constructor called"
        this.name=name
        this.age=age
    }

    String getName() {
        return name
    }

    void setName(String name) {
        println "---------------->>>>>>>>>>>>Setter Name"
        this.name = name
    }

    int getAge() {
        return age
    }

    void setAge(int age) {
        println "============================>>>>>>>Setter Age"
        this.age = age
    }
}

