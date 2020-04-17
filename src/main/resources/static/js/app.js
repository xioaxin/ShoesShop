var stompClient = null;

//创建连接
function setConnected(connected) {
    $('#connect').prop("display", connected);
    $('#disConnect').prop("displayed", !connected);
    if (connected) {
        $('#conversation').show();
        $('#chat').show();
    } else {
        $('#conversation').hide();
        $('#chat').hide();
    }
    $('#greeting').html("");
}

function connect() {
    if ($('#name').val() == null) {
        return;
    }
    var socket = new SockJS("/chat");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        stompClient.subscribe("/topic/greetings", function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disConnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
}

function sendName() {
    stompClient.send('/app/hello', {}, JSON.stringify(
        {
            'name': $('#name').val(),
            'content': $('#content').val()
        }));
}

function showGreeting(message) {
    $('#greeting').append('<div>' + message.name + ':' + message.content + '</div>'
    )
}

$(function () {
    $('#connect').click(function () {
        connect();
    });
    $('#disConnect').click(function () {
        disConnect();
    });
    $('#send').click(function () {
        sendName();
    })
})
