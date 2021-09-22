function bigger() {
    document.getElementById("textInput").style.fontSize = "24pt";
};

function moo(){
    str1=document.getElementById("textInput").value.toUpperCase();
    str1=str1.split(".").join("Moo.")
    document.getElementById("textInput").value=str1;
}

(function(window, document, undefined){
window.onload = init;
  function init(){
    document.getElementById("fancyShmancy").addEventListener("change", radioUpdate);
    document.getElementById("boringBetty").addEventListener("change", radioUpdate);
  }
})(window, document, undefined);

function radioUpdate() {
    radioVal = document.querySelector('input[name="stylerRadio"]:checked').value;
    if (radioVal == "fancy") {
        document.getElementById("textInput").style.fontWeight = "bold";
        document.getElementById("textInput").style.color = "blue";
        document.getElementById("textInput").style.textDecoration = "underline";
    }
    else {
        document.getElementById("textInput").style.fontWeight = "normal";
        document.getElementById("textInput").style.color = "black";
    }
};
