const songsUl1 = document.querySelector(".songsUl");
// const albumId1 = document.getElementById("albumId").innerText;
// const songId1 = document.getElementById("songId").innerText;
// const deleteSongButton = document.querySelector(".deleteSong");
// deleteSongButton.addEventListener("click", deleteSong);
songsUl.addEventListener("click", deleteSong);

function deleteSong(event) {

    if (event.target.classList.contains("deleteSong")) {
    
        const deleteSongButton = event.target;
        const songContainer = deleteSongButton.parentElement;
        const hrefArray = songContainer.querySelector('a').getAttribute('href').split("/");
        const artistId = hrefArray[2];
        const albumId = hrefArray[4];
        const songId = hrefArray[6];


        const xhr = new XMLHttpRequest()

        xhr.onreadystatechange = function(response) {

            if(xhr.readyState == 4 && xhr.status == 200) {

                const remainingSongs = JSON.parse(response.currentTarget.response);
                let html = ''

                remainingSongs.forEach(function(song) {
                    html += `
                        <li>
                        <a href="/artists/${artistId}/album/${albumId}/song/${song.id}">${song.songName}</a>
                        <button class="deleteSong">Remove</button>
                        </li>
                    `
                })
                songsUl1.innerHTML = html
            }
        }
        xhr.open("DELETE", `/api/albums/${albumId}/songs/${songId}`, true)
        xhr.send()

}
}
