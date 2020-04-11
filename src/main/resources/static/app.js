var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings/'+$("#channel").val(), function (greeting) {
            showGreeting(JSON.parse(greeting.body).messageContent);

        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName(event) {

    stompClient.send("/app/hello/"+$("#channel").val(), {}, JSON.stringify({'messageContentId': $("#name").val(), 'color': 'rgb(255,0,0)', 'x': 0, 'y': 0, 'drawingButtonPressed': true}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + JSON.stringify(message) + "</td></tr>");
    var canvas = document.getElementById("canv");
    var ctx = canvas.getContext("2d");
    	ctx.fillStyle = message.color; // Red color

        ctx.beginPath();
        ctx.arc(message.x, message.y, 2, 0, Math.PI * 2, true);
        ctx.fill();

}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

function mouseMoved(event){
if(stompClient !== null){
    if(event.buttons>0){
        stompClient.send("/app/hello/"+$("#channel").val(), {}, JSON.stringify({'messageContentId': $("#name").val(), 'color': $("#color").val(), 'x': event.offsetX, 'y': event.offsetY, 'drawingButtonPressed': true}));

    }
}
}