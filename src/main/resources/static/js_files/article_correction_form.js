const submitButton = document.getElementById("submit-button");

submitButton.addEventListener("click", function(){
    var id = document.getElementById("article-id").value
    payload={
        "title": document.getElementById("title").value,
        "auth": document.getElementById("auth").value,
        "content": document.getElementById("content").value
    }
    
    console.log(payload);
    var url="http://localhost:8000/article/"+ id; 
    var requestData = {
        method:'PATCH',
        headers: {'Content-Type': 'application/json'},
        body:JSON.stringify(payload)
    };

    fetch(url,requestData)
        .then(response=>response.json())
        .then(data=>{   var articleID = data.id;
                        var newUrl = "http://localhost:8000/articleview/"+ articleID;
                        window.location.replace(newUrl);
                        });
   
})