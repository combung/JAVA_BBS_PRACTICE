const submitButton = document.getElementById("submit-button");

submitButton.addEventListener("click", function(){
    payload={
        "title": document.getElementById("title").value,
        "auth": document.getElementById("auth").value,
        "content": document.getElementById("content").value
    }
    
    var url="http://localhost:8000/article/create"
    
    fetch(url,
        {
            method:'POST',
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