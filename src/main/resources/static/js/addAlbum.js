const albumButton = document.getElementById("albumButton");
const albumsUl = document.querySelector(".albumsUl");

albumButton.addEventListener("click", submitNewAlbum);

function submitNewAlbum() {

    const xhr = new XMLHttpRequest();
    const albumNameInput = document.querySelector(`[name="albumNameInput"]`);
    const albumReleaseDateInput = document.querySelector(`[name="albumReleaseDateInput"]`);
    const albumGenreInput = document.querySelector(`[name="albumGenreInput"]`);
    const albumImageInput = document.querySelector(`[name="albumImageInput"]`)
    const artistId = document.querySelector(`[name="artistId"]`);


    function renderAlbums(response) {

        if (xhr.readyState == 4 && xhr.status == 200) {

            const updateAlbums = JSON.parse(response.currentTarget.response);

            let html=''
                updateAlbums.forEach(function(album) {
                    html += `
                    <li>
                    <a href="${window.location.pathname}/album/${album.id}">Album: ${album.albumName}</a>
                    <button class="deleteAlbum">Remove</button>
                     </li>
                `

                })
                albumsUl.innerHTML = html;

        }
    }
    xhr.open('POST', `/api/albums?artistId=${artistId.value}&albumNameInput=${albumNameInput.value}&albumReleaseDateInput=${albumReleaseDateInput.value}&albumGenreInput=${albumGenreInput.value}&albumImageInput=${albumImageInput.value}`);
    xhr.addEventListener('readystatechange', renderAlbums);
    xhr.send();
}