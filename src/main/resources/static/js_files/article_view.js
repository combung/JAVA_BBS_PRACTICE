const boomupButton = document.getElementById("boom-up");
const boomdownButton = document.getElementById("boom-down");
const articleID = document.getElementById("article-id").value;
const request = new XMLHttpRequest();

boomupButton.addEventListener("click", function(){
    boom(boomupButton, articleID);
    });
boomdownButton.addEventListener("click", function(){
    boom(boomdownButton, articleID);
    });

function boom(button, articleID){
    const context = button.id;
    if (context=='boom-up'){
        var url = 'http://localhost:8000/article/'+articleID+'/boomup';
    }else if(context=='boom-down'){
        var url = 'http://localhost:8000/article/'+articleID+'/boomdown';
    }
    
    request.open('POST', url, 'true');
    request.setRequestHeader('Content-type', 'application/json');
    request.send();
    if (context=='boom-up'){
        alert("개추");
    }else if(context=='boom-down'){
        alert("비추");
    }


    window.location.reload();
}
