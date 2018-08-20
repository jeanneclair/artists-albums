const artistButton = document.getElementById("artistButton");
const artistsUl = document.querySelector(".artistsUl");

artistButton.addEventListener("click", submitNewArtist);

function submitNewArtist() {

    const xhr = new XMLHttpRequest();
    const artistNameInput = document.querySelector(`[name="artistNameInput"]`);
    const artistRecordLabelInput = document.querySelector(`[name="artistRecordLabelInput"]`);

    function renderArtists(response) {

        if (xhr.readyState == 4 && xhr.status == 200) {

            const updateArtists = JSON.parse(response.currentTarget.response);

            let html=''
                updateArtists.forEach(function(artist) {

                    html += `
                    <li>
                    <a href="/artists/${artist.id}">${artist.artistName}</a>
                    <p>${artist.artistRecordLabel}</p> 
                    <button class="deleteArtist">Remove</button>  
                    </li>
                `

                })
                artistsUl.innerHTML = html;

        }
    }
    xhr.open('POST', `/api/artists?artistNameInput=${artistNameInput.value}&artistRecordLabelInput=${artistRecordLabelInput.value}`, true);
    xhr.addEventListener('readystatechange', renderArtists);
    xhr.send();
}