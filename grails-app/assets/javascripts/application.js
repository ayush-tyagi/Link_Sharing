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

function showErrorAndSuccess(msg, error) {
    var className = "";
    if (msg != undefined && msg != "") {
        className = "alert-success";
    }
    if (error != undefined && error != "") {
        className = "alert-danger";
    }
    $(".messageAlert").html(error).removeClass("hide").addClass(className);
};

function unsubscribe(topicId) {
    event.preventDefault();
    var myLoader = $(".myLoader");
    myLoader.show();
    $.ajax({
        url: '/subscription/delete',
        data: {topicId: topicId},
        method: 'post',
        success: function (data) {
            $("#subscribedTopics").html(data);
        }
    });

}

function deactivateUser(id) {
    event.preventDefault();
    $.ajax({
        url: '/user/changeToDeactive',
        data: {id: id},
        method: 'post',
        success: function (data) {
            $(".myUser").html(data);
            showErrorAndSuccess(data.message, "");
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
            showErrorAndSuccess(data.message, "");
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
            if (data.error != "") {
                showErrorAndSuccess('', data.error);
            } else {
                $("#subscribedTopics").html(data);
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
function hideEdit() {
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
            $(".createdTopicOfUser").html(data);

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
            //alert(data.message)
            $("#topicContent").html(data)
        }
    })
}


function unhideResourceDescription() {
    $("#changeDescription").removeClass("hide")
//alert("Clicked")
}

function hideEditResource() {
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
            //alert(data.message)
            $("#retainDesc").html(data.resourceDescription);
            hideEditResource();
        },
        error: function (data) {
            alert(data.message)
        }
    })

}

function markAsRead(id) {
    //alert(id)
    var messageAlert = $(".messageAlert");
    $.ajax({
        url: '/readingItem/changeToIsRead',
        data: {id: id},
        method: 'post',
        success: function (data) {
            //alert("Called mark as read")
            $("#markAsRead").html(data)
            //messageAlert
            messageAlert.text("You have successFully changed ")
            messageAlert.addClass("alert-Success").removeClass("hide")
        }
    })
}


function markAsUnread(id) {
    //alert(id)
    $.ajax({
        url: '/readingItem/changeToUnread',
        data: {id: id},
        method: 'post',
        success: function (data) {
            //alert("Called mark as Unread")
            $("#markAsRead").html(data)
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