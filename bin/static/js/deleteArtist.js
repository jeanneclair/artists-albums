const artistsUl2 = document.querySelector(".artistsUl");
// const artistId2 = document.getElementById("artistId").innerText;
// const deleteArtistButton = document.querySelector(".deleteArtist");

artistsUl2.addEventListener("click", deleteArtist);

function deleteArtist(event) {

    if (event.target.classList.contains("deleteArtist")) {

        const deleteArtistButton = event.target;
        const artistContainer = deleteArtistButton.parentElement;
        const hrefArray = artistContainer.querySelector('a').getAttribute('href').split("/");
        const artistId2 = hrefArray[2];
        const xhr = new XMLHttpRequest()

        xhr.onreadystatechange = function(response) {

            if(xhr.readyState == 4 && xhr.status == 200) {

                const remainingArtists = JSON.parse(response.currentTarget.response);
                let html = ''

                remainingArtists.forEach(function(artist) {
                    html += `
                        <li>
                        <a href="/artists/${artist.id}">${artist.artistName}</a>
                        <p>${artist.artistRecordLabel}</p>
                        <button class="deleteArtist">Remove</button>
                        </li>
                    `
                })
                artistsUl2.innerHTML = html
            }
        }
        xhr.open("DELETE", `/api/artists/${artistId2}`, true)
        xhr.send()
}
}
