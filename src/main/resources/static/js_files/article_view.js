function boom(button, articleID){
    const context = button.id;
    if (context=='boom-up'){
        var url = 'http://localhost:8000/article/'+articleID+'/boomup';
    }else if(context=='boom-down'){
        var url = 'http://localhost:8000/article/'+articleID+'/boomdown';
    }
    
    request.open('POST', url, true);
    request.setRequestHeader('Content-type', 'application/json');
    request.send();
    if (context=='boom-up'){
        alert("개추");
    }else if(context=='boom-down'){
        alert("비추");
    }
    window.location.reload();
}

function deleteRequest(articleID){
    var url = 'http://localhost:8000/article/'+ articleID;
    console.log(url);
    var newUrl = 'http://localhost:8000/';
    request.open('DELETE', url, true);
    request.send();
    window.location.replace(newUrl);
}



const boomupButton = document.getElementById("boom-up");
const boomdownButton = document.getElementById("boom-down");
const deleteButton = document.getElementById("delete-button");
const articleID = document.getElementById("article-id").value;
const request = new XMLHttpRequest();

boomupButton.addEventListener("click", function(){
    boom(boomupButton, articleID);
    });

boomdownButton.addEventListener("click", function(){
    boom(boomdownButton, articleID);
    });

deleteButton.addEventListener("click", function(){
    deleteRequest(articleID);
})


















