const songCommentButton = document.getElementById("songCommentButton");
const albumCommentsUl = document.querySelector(".albumCommentsUl");
const albumId = document.querySelector("#albumId").innerHTML;

albumCommentButton.addEventListener("click", submitAlbumComment);

function submitAlbumComment() {
    const xhr = new XMLHttpRequest();

    const albumCommentInput = document.querySelector(`[name="albumCommentInput"]`);

    function renderComments(response) {
    
        if (xhr.readyState == 4 && xhr.status == 200){
        
            const updateComments = JSON.parse(response.currentTarget.response);
          

            let html=''
					updateComments.forEach(function(comment){
						html += `
							<li>
							${comment.text}
							</li>`
                    })
                    albumCommentsUl.innerHTML = html;
        }
    }
    xhr.open('POST', `/api/albums/${albumId}?albumCommentInput=${albumCommentInput.value}`, true);
	xhr.addEventListener('readystatechange', renderComments);
	xhr.send();
}