const editAlbumButton1 = document.getElementById("edit-album-button");
const closeModalButton = document.getElementById("modal-submit-album");
const modalContainer = document.getElementById("modal-container-album");
const modalFormSubmit = document.getElementById("modal-submit-album");
const artistId = document.getElementById("artistId").innerText;
const albumId2 = document.getElementById("albumId").innerText;

const albumName = document.getElementById("albumName");
const albumCoverImage = document.getElementById("albumCoverImage");
const albumReleaseDate = document.getElementById("albumReleaseDate");
const albumGenre = document.getElementById("albumGenre");

editAlbumButton1.addEventListener("click", editAlbum);

function editAlbum() {

    modalContainer.classList.toggle("hide");
    const xhr = new XMLHttpRequest();

    xhr.open("GET", `/api/artist/${artistId}/album/${albumId2}`, true);
    xhr.addEventListener("readystatechange", editAlbumBox);
    xhr.send();
}

function editAlbumBox(response) {

    if(this.readyState == 4 && this.status == 200) {
       
        const res = JSON.parse(response.currentTarget.response);
        const editedAlbumName = document.querySelector(`[name="editedAlbumName"]`);
        const editedAlbumCoverImage = document.querySelector(`[name="editedAlbumCoverImage"]`);
        const editedReleaseDate = document.querySelector(`[name="editedReleaseDate"]`);
        const editedGenre = document.querySelector(`[name="editedGenre"]`);
        editedAlbumName.value = res.albumName;
        editedAlbumCoverImage.value = res.albumCoverImage;
        editedReleaseDate.value = res.albumReleaseDate;
        editedGenre.value = res.albumGenre;

    }
}

modalFormSubmit.addEventListener('click', submitAlbumBox);

function submitAlbumBox() {

    const xhr = new XMLHttpRequest();
    const editedAlbumName = document.querySelector(`[name="editedAlbumName"]`);
    const editedAlbumCoverImage = document.querySelector(`[name="editedAlbumCoverImage"]`);
    const editedReleaseDate = document.querySelector(`[name="editedReleaseDate"]`);
    const editedGenre = document.querySelector(`[name="editedGenre"]`);

    function renderAlbum(response) {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(response.currentTarget.response);
            const updatedAlbum = JSON.parse(response.currentTarget.response);
            albumName.innerText = `${updatedAlbum.albumName}`
            albumCoverImage.innerText= `${updatedAlbum.albumCoverImage}`
            albumReleaseDate.innerText= `${updatedAlbum.albumReleaseDate}`
            albumGenre.innerText= `${updatedAlbum.albumGenre}`

        }
    }
    xhr.open("PUT", `/api/artist/${artistId}/album/${albumId2}?albumName=${editedAlbumName.value}&albumCoverImage=${editedAlbumCoverImage.value}&albumReleaseDate=${editedReleaseDate.value}&albumGenre=${editedGenre.value}`, true)
    xhr.addEventListener("readystatechange", renderAlbum)
    xhr.send();

}
