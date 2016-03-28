import com.ttnd.linksharing.Constants
import com.ttnd.linksharing.Constants
import com.ttnd.linksharing.Resource
import com.ttnd.linksharing.Subscription
import com.ttnd.linksharing.Topic
import com.ttnd.linksharing.User
import com.ttnd.linksharing.*
import enums.L_Visibility
import enums.Seriousness

//import spock.util.mop.Use

class BootStrap {

    def grailsApplication;

    def init = { servletContext ->

//        createExperiment()
        List<User> users = createUsers()
        List<Topic> topics = createTopics()
        List<Resource> resources = createResources()
        List<Subscription> subscriptions = subscribeTopics()
        List<ReadingItem> readingItems = createReadingItems()
       List<ResourceRating> resourceRatings = createResourceRating()
    }

//    def createExperiment(){
//        Experiment exp=new Experiment(address:"sdvSFW",name:"one",ex_id: 1)
//        if(exp.validate()){
//            exp.save(flush:true)
//            log.info("----------------------------------------->")
//        }else{log.info("===================================>")}
//        Experiment exp1=new Experiment(address:"sdvSFsgsgW",name:"onsdgsgsdgse",ex_id: 1)
//        if(exp1.validate()){
//            exp1.save(flush:true)
//            log.info("-----2---3---3--45-6--8------------------------->")
//        }else{println "+++++++++++++++++++++++++${exp1.errors.allErrors}"}
//
//    }

    List<User> createUsers() {
        List<User> users = []
        if (countRecords() <= 0) {
            User user = new User(isAdmin: true,isActive: true, username:"Krishna" , password: Constants.DEFAULT_PASSWORD, confirmPassword: "abcdef", firstName: "Ram", lastName: "Paramhansa", email_id: "ayush.tyagi@tothenew.com")
//            user.confirmPassword = "abcdef"
            users = checkingAndSavingUser(user)
            User user1 = new User( password: Constants.DEFAULT_PASSWORD, username:"Madhav", confirmPassword: "abcdef", firstName: "Name", lastName: "Radha", email_id: "tyaysu@am.com")
//            user1.confirmPassword = "abcdef"
            users = checkingAndSavingUser(user1)
        }
        users
    }

    List<User> checkingAndSavingUser(User user) {
        List<User> users = User.list()
        if (user.validate()) {
            user.save(failOnError: true, flush: true)
            users.add(user)
            log.info("Successful insertion of :${user}")
        } else {
            log.error("Unsuccessful :${user.errors}")
        }
        users
    }

    int countRecords() {
        int count = User.count()
        log.info "Count : ${count}"
        count
    }

    List<Topic> createTopics() {
        List<Topic> topics = Topic.list()
        User.list().each { it ->
            if (!it.topics) {
                (1..5).each { index ->
                    Topic topic = new Topic(name: "${it}Name${index}", createdBy: it, visibility: L_Visibility.PUBLIC)
                    if (topic.validate()) {
                        topic.save(flush: true)
                        topics.add(topic)
                        log.info("Successful creation of topics--- ${topic}")
                    } else {
                        log.info("Unsuccessful----- ${topic.errors.allErrors}")

                    }
                }
            }
        }
        topics
    }

    List<Resource> createResources() {
        List<Topic> topics = Topic.list()
        List<Resource> resources = []

        topics.each { topic ->
            if (!Resource.countByTopic(topic)) {
                2.times
                        {
                            Resource documentResource = new DocumentResource(contentType:Constants.DOCUMENT_CONTENT_TYPE , description: "${topic.name}Doc${it}", topic: topic, createdBy: topic.createdBy, filePath: "some/file/path")
                            Resource linkResource = new LinkResource(description: "${topic.name}Link${it}", topic: topic, createdBy: topic.createdBy, url: "https://www.google.co.in/")

                            if (documentResource.validate() && linkResource.validate()) {
                                linkResource.save(flush: true)
                                documentResource.save(flush: true)
                                resources.add(documentResource)
                                resources.add(linkResource)
                                topic.addToResources(documentResource)
                                topic.addToResources(linkResource)
                                log.info "${documentResource} and ${linkResource} saved successfully"
                            } else
                                log.error "Error saving ${documentResource.errors.allErrors} and ${linkResource.errors.allErrors}"
                        }

                if (topic.validate()) {
                    topic.save(flush: true)
                    log.info "Topic ${topic} saved successfully"
                } else {
                    log.error "Error saving ${topic.errors.allErrors}"
                }
            }


        }
        resources
    }

    List<Subscription> subscribeTopics() {
        List<User> users = User.list()
        List<Topic> topics = Topic.list()
        List<Subscription> subscriptions = []

        subscriptions += Subscription.findAll("from Subscription")
        users.each { User user ->
            topics.each { Topic topic ->
                if (Subscription.findByUserAndTopic(user, topic) == null) {
                    Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Seriousness.SERIOUS)
                    if (subscription.save(flush: true, failOnError: true)) {
                        log.info "${subscription} saved "
                        subscriptions.add(subscription)
                    } else {
                        log.info "subscription not saved"
                    }
                } else {
                    log.info "User ${user} already subscribed to Topic ${topic}"
                }
            }
        }
        subscriptions
    }

    List<ReadingItem> createReadingItems() {
        List<User> users = User.list()
        List<Topic> topics = Topic.list()
        List<Resource> resources = Resource.list()
        List<ReadingItem> readingItems = []

        users.each { user ->
            topics.each { topic ->
                if (Subscription.findByUserAndTopic(user, topic)) {
                    topic.resources.each { resource ->
                        if (resource.createdBy != user && !users.readingItems.contains(resource)) {
                            ReadingItem readingItem = new ReadingItem(user: user, resource: resource, isRead: false)
                            if (readingItem.validate()) {
                                readingItem.save(flush: true)
                                readingItems.add(readingItem)
                                user.addToReadingItems(readingItem)
                                log.info "${readingItem} saved successfully"
                            } else
                                log.error "Error saving ${readingItem.errors.allErrors}"
                        }
                    }
                }
            }
            user.save()
        }

        return readingItems
    }

    List<ResourceRating> createResourceRating() {
        List<User> users = User.list()
        List<ResourceRating> resourceRatings = []
       println "-------------------------------------------------------------------------------->>>>>>>>>${users}<<<<<<<<<<"
        users.each { user ->

            user.readingItems.each { item ->
                if (!item.isRead) {
                    println "------------->>>>>>>>."
                    ResourceRating resourceRating = new ResourceRating(user: item.user, resource: item.resource, score: 3)
                    if (resourceRating.validate()) {
                        resourceRating.save(flush:true,failOnError: true)
                        resourceRatings.add(resourceRating)
                        log.info("....>>>>>>>>>>>>>>Done Successfully Resource Rating<<<<<<<<<<<<<<<<<....${item}")
                    } else {
                        println "_______+++++++++"
                        log.info("----------Sorry......${resourceRating.errors.allErrors}")

                    }

                }
            }
        }
        resourceRatings
    }

    def destroy = {
    }
}
