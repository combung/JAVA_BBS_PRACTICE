const submitButton = document.getElementById("submit-button");
const request = new XMLHttpRequest();

submitButton.addEventListener("click", function(){
    var id = document.getElementById("article-id").value
    payload={
        "id": id,
        "title": document.getElementById("title").value,
        "auth": document.getElementById("auth").value,
        "content": document.getElementById("content").value
    }
    
    var url="http://localhost:8000/article/"+ id; 
    
    fetch(url,{
        method:'PATCH',
        headers: {
            'Content-Type': 'application/json' 
        },
        body:JSON.stringify(payload)
    })
    .then(response=>response.json())
    .then(data=>{   var articleID = data.id;
                    var newUrl = "http://localhost:8000/articleview/"+ articleID;
                    window.location.replace(newUrl);
                    });
})