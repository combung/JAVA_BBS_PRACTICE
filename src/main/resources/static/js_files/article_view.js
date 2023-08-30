function boom(button, articleID){
    const context = button.id;
    if (context=='boom-up'){
        var url = 'http://localhost:8000/article/'+articleID+'/boomup';
    }else if(context=='boom-down'){
        var url = 'http://localhost:8000/article/'+articleID+'/boomdown';
    }
    
    var requstdata = {   
        method:'post',
        headers:{"content":'application/json'},
    }

    fetch(url, requstdata).then(function(response){
        if (response.ok){
            if (context=='boom-up'){
                alert("이 글이 맘에 들어요!!");
            }else if(context=='boom-down'){
                alert("이 글이 별로에요ㅠㅠ");
            }
            window.location.reload();
        }else{
            alert("시스템이 조금 이상해요 ㅠㅠ");
        }

    })
}

function deleteArticle(articleID){
    var url = 'http://localhost:8000/article/'+ articleID;
    console.log(url);
    var indexUrl = 'http://localhost:8000/';

    requestData = {
        method:'delete',
        headers:{"content":'application/json'},
    };
    console.log("im here");
    fetch(url, requestData).then(function(response){
        if(response.ok){
            console.log(response.statusText);
            console.log(response.json());
            window.location.replace(indexUrl);
        }else{
            alert("글을 삭제하지 못했어요ㅠㅠ");
        }
    })
}

const boomupButton = document.getElementById("boom-up");
const boomdownButton = document.getElementById("boom-down");
const deleteButton = document.getElementById("delete-button");
const articleID = document.getElementById("article-id").value;
console.log("updated");
boomupButton.addEventListener("click", function(){
    boom(boomupButton, articleID);
    });

boomdownButton.addEventListener("click", function(){
    boom(boomdownButton, articleID);
    });
 
deleteButton.addEventListener("click", function(){
    deleteArticle(articleID);
})


















