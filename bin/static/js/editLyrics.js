const editLyricsButton = document.getElementById("editLyricsButton");
const closeModalButton = document.getElementById("modal-submit");
const modalContainer = document.getElementById("modal-container");
const modalFormSubmit = document.getElementById("modal-submit");
const lyrics = document.getElementById("lyrics");


editLyricsButton.addEventListener("click", editLyrics);

function editLyrics() {

    modalContainer.classList.toggle("hide");
    const xhr = new XMLHttpRequest();
    const songId = editLyricsButton.nextElementSibling.innerHTML.trim();

    xhr.open("GET", `/api/songs/${songId}`, true);
    xhr.addEventListener("readystatechange", editLyricsBox);
    xhr.send();
}

function editLyricsBox(response) {

    if(this.readyState == 4 && this.status == 200) {
       
        const res = JSON.parse(response.currentTarget.response);
        const editedLyrics = document.querySelector(`[name="editedLyrics"]`);
        editedLyrics.value = res.songLyrics;
    }
}

modalFormSubmit.addEventListener('click', submitLyricsBox)

function submitLyricsBox() {
    const xhr = new XMLHttpRequest();
    const editedLyrics = document.querySelector(`[name="editedLyrics"]`);
    const songName = document.getElementById("songName").innerText.trim();
    const songLength = document.getElementById("songLength").innerText.trim();
    const songRating = document.getElementById("songRating").innerText.trim();
    const songVideoUrl = document.getElementById("songVideoUrl").innerText.trim();
    const albumId = document.getElementById("albumId").innerText.trim();
    const songId = editLyricsButton.nextElementSibling.innerHTML.trim();

    function renderLyrics(response) {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const updatedSong = JSON.parse(response.currentTarget.response);
            lyrics.innerHTML = `<p id="songLyrics">Song Lyrics: ${updatedSong.songLyrics}</p>`
        }
    }
    xhr.open("PUT", `/api/songs/${songId}?songLyrics=${editedLyrics.value}&songName=${songName}&songLength=${songLength}&songRating=${songRating}&songVideoUrl=${songVideoUrl}&albumId=${albumId}`, true)
    xhr.addEventListener("readystatechange", renderLyrics)
    xhr.send();

}


