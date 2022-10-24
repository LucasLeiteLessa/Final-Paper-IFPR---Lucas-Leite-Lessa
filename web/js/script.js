    var option = {
    animation: true,
    delay: 10000//10sec
};

function Toasty() {
    var toastHTMLElement = document.getElementById('EpicToast');

    var toastElement = new bootstrap.Toast(toastHTMLElement, option);

    toastElement.show();
    
    return false;
}
