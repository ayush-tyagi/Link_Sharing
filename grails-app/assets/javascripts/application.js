/*
 if (typeof jQuery !== 'undefined') {
 (function ($) {
 $(document).ajaxStart(function () {
 $('#spinner').fadeIn();
 }).ajaxStop(function () {
 $('#spinner').fadeOut();
 });
 })(jQuery);
 }*/


function unsubscribe(topicId) {
    event.preventDefault();
    var myLoader = $(".myLoader");
    myLoader.show();
    $.ajax({
        url: '/subscription/delete',
        data: {topicId: topicId},
        method: 'post',
        success: function (data) {
            console.log(data);
            //$('#ajaxifiedSubscription').replaceWith($('#ajaxifiedSubscription').html(data));
            $("#subscribedTopics").html(data);
            var messageAlert = $(".messageAlert");
            for (item in data) {
                if (item != "error") {
                    messageAlert.text = "You have unsubscribed Successfully";
                    messageAlert.addClass("alert-success")
                } else {
                    messageAlert.text = "Error";
                    messageAlert.addClass("alert-danger")
                }
            }
            myLoader.hide()
            $("#alert").html(messageAlert.text).removeClass("hide")
            //    $("#alert").css({'display':'block'})

        },
        error: function (data) {
            $("#subscribedTopics").html(data.message);
        }
    })

}

function deactivateUser(id) {
    event.preventDefault();
    $.ajax({
        url: '/user/changeToDeactive',
        data: {id: id},
        method: 'post',
        success: function (data) {
            $(".myUser").html(data);
            alert(data.message)
        }
    })
}

function activateUser(id) {
    event.preventDefault();
    $.ajax({
        url: '/user/changeToActive',
        data: {id: id},
        method: 'post',
        success: function (data) {
            alert(data.message)
        }
    })
}


function subscribe(topicId) {
    event.preventDefault();
    $.ajax({
        url: '/subscription/save',
        data: {topicId: topicId},
        method: 'post',
        success: function (data) {
            alert(data.message)
            $("#subscribedTopics").html(data);
            var messageAlert = $(".messageAlert");
            for (item in data) {
                if (item != "error") {
                    messageAlert.text = "You have Subscribed Successfully";
                    messageAlert.addClass("alert-success")
                } else {
                    messageAlert.text = "Error";
                    messageAlert.addClass("alert-danger")
                }
            }
        },
        error: function (data) {
            $("#subscribedTopics").html(data.message);
        }
    })

}


function changeSeriousness(id) {
    var serious = $("#seriousness-" + id + " :selected").attr('value');
    $.ajax({
        url: '/subscription/update',
        data: {id: id, seriousness: serious},
        method: 'post',
        success: function (data) {
            alert(data.message)
        }
    })
}

function changeVisibility(id) {
    var visibile = $("#visibility-" + id + " :selected").attr('value');
    $.ajax({
        url: '/topic/update',
        data: {id: id, visibility: visibile},
        method: 'post',
        success: function (data) {
            alert(data.message)
        }
    })
}

function deleteTopic(id) {
    $.post({
        url: '/topic/delete',
        data: {id: id},
        method: 'post',
        success: function (data) {
            alert(data.message)
        }
    })

}

function changeTopicName() {
    $("#changeTopic").removeClass("hide")

    //alert("Clicked")
}
function  hideEdit(){
$("#changeTopic").addClass("hide")
}

function changeTopicNameByButton(id) {
    var topicName = $("#textTopicName").val();
    //alert(topicName)
    $.ajax({
        url: '/topic/changeTopicName',
        data: {topicName: topicName, id: id},
        method: 'post',
        success: function (data) {
            alert(data.message)


        }
    })
}

function searchTopic() {
    var q = $("#searchTopicId").val();
    //alert("clicked");
    //alert(q);
    $.ajax({
        url: '/topic/searchTopic',
        data: {q: q},
        method: 'post',
        success: function (data) {
            alert(data.message)
            $("#topicContent").html(data)
        }
    })
}


function unhideResourceDescription() {
    $("#changeDescription").removeClass("hide")
//alert("Clicked")
}

function hideEditResource(){
    $("#changeDescription").addClass("hide")
}

function changeResourceDescription(id) {
    var resourceDesc = $("#textDescription").val();
    //alert(resourceDesc)
    $.ajax({
        url: '/resource/changeDescription',
        data: {resourceDesc: resourceDesc, id: id},
        method: 'post',
        success: function (data) {
            alert(data.message)
        },
        error: function (data) {
            alert(data.message)
        }
    })

}
/*
 function success1(data) {
 alert(data.message)
 $("#alert").html(data.message)
 var messageAlert = $(".messageAlert");
 for (item in data) {
 if (item == "message") {
 messageAlert.text = data[item];
 messageAlert.addClass("alert-success")
 } else {
 messageAlert.text = data[item];
 messageAlert.addClass("alert-danger")
 }
 }
 }*/