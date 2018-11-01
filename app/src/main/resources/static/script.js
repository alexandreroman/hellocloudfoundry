function doGreeting() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var json = JSON.parse(this.responseText);
            var bannerMessage = document.getElementById("message");
            bannerMessage.textContent = json.message;
        }
    };

    var nameInput = document.getElementById("name");
    xhttp.open("GET", apiEndpoint + "/greeting?name=" + nameInput.value, true);
    xhttp.send();
}

window.onload = function () {
    document.getElementById("name").onkeypress = function (e) {
        if (!e) e = window.event;
        var keyCode = e.keyCode || e.which;
        if (keyCode == '13') {
            e.preventDefault();
            doGreeting();
        }
    };
    document.getElementById("send").onclick = doGreeting;
};
