const songButton = document.getElementById("songButton");
const songsUl = document.querySelector(".songsUl");

songButton.addEventListener("click", submitNewSong);

function submitNewSong() {

    const xhr = new XMLHttpRequest();
    const albumId = document.getElementById("albumId").innerText;
    const songNameInput = document.querySelector(`[name="songNameInput"]`);
    const songLengthInput = document.querySelector(`[name="songLengthInput"]`);
    const songRatingInput = document.querySelector(`[name="songRatingInput"]`);
    const songVideoUrlInput = document.querySelector(`[name="songVideoUrlInput"]`);
    const songLyricsInput = document.querySelector(`[name="songLyricsInput"]`);
    

    function renderSongs(response) {
    if (xhr.readyState == 4 && xhr.status == 200) {

        const updateSongs = JSON.parse(response.currentTarget.response);

        let html=''
        updateSongs.forEach(function(song) {

            html += `
            <li>
            <a href="${window.location.pathname}/song/${song.id}">${song.songName}</a>
            <button class="deleteSong">Remove</button>
             </li>
        `

        })
        songsUl.innerHTML = html;

    }

}
    xhr.open('POST', `/api/albums/${albumId}/songs?songNameInput=${songNameInput.value}&songLengthInput=${songLengthInput.value}&songRatingInput=${songRatingInput.value}&songVideoUrlInput=${songVideoUrlInput.value}&songLyricsInput=${encodeURIComponent(songLyricsInput.value)}`, true);
    xhr.addEventListener('readystatechange', renderSongs);
    xhr.send();
}