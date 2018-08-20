const songCommentButton = document.getElementById("songCommentButton");
const songCommentsUl = document.querySelector(".songCommentsUl");
const songId = document.querySelector("#songId").innerHTML;

songCommentButton.addEventListener("click", submitSongComment);

function submitSongComment() {

    const xhr = new XMLHttpRequest();

    const songCommentInput = document.querySelector(`[name="songCommentInput"]`);

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
                    songCommentsUl.innerHTML = html;
        }
    }
    xhr.open('POST', `/api/songs/${songId}?songCommentInput=${songCommentInput.value}`, true);
	xhr.addEventListener('readystatechange', renderComments)
	xhr.send();
}