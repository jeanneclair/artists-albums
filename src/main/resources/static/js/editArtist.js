const editArtistButton = document.getElementById("edit-artist-button");
const closeModalButton = document.getElementById("modal-submit-artist");
const modalContainer = document.getElementById("modal-container-artist");
const modalFormSubmit = document.getElementById("modal-submit-artist");
const artistId = document.getElementById("artistId").innerText;
const artistName = document.getElementById("artistName");
const artistRecordLabel = document.getElementById("artistRecordLabel");

editArtistButton.addEventListener("click", editArtist);

function editArtist() {

    modalContainer.classList.toggle("hide");
    const xhr = new XMLHttpRequest();

    xhr.open("GET", `/api/artist/${artistId}`, true);
    xhr.addEventListener("readystatechange", editArtistBox);
    xhr.send();
}

function editArtistBox(response) {

    if(this.readyState == 4 && this.status == 200) {
       
        const res = JSON.parse(response.currentTarget.response);
        const editedArtistName = document.querySelector(`[name="editedArtistName"]`);
        const editedArtistRecordLabel = document.querySelector(`[name="editedRecordLabel"]`);
        editedArtistName.value = res.artistName;
        editedArtistRecordLabel.value = res.artistRecordLabel;
    }
}

modalFormSubmit.addEventListener('click', submitArtistBox);

function submitArtistBox() {

    const xhr = new XMLHttpRequest();
    const editedArtistName = document.querySelector(`[name="editedArtistName"]`);
    const editedArtistRecordLabel = document.querySelector(`[name="editedRecordLabel"]`);

    function renderArtist(response) {

        if (xhr.readyState == 4 && xhr.status == 200) {
            const updatedArtist = JSON.parse(response.currentTarget.response);            
            artistName.innerText = `${updatedArtist.artistName}`
            artistRecordLabel.innerText = `${updatedArtist.artistRecordLabel}`
        }
    }
    xhr.open("PUT", `/api/artist/${artistId}?artistName=${editedArtistName.value}&artistRecordLabel=${editedArtistRecordLabel.value}`, true)
    xhr.addEventListener("readystatechange", renderArtist)
    xhr.send();
    
}