// const deleteAlbumButton = document.querySelector(".deleteAlbum");
const albumsUl2 = document.querySelector(".albumsUl");
// const albumId2 = document.getElementById("albumId").innerText
// const artistId2 = document.getElementById("artistId").innerText
albumsUl2.addEventListener("click", deleteAlbum);

function deleteAlbum(event) {
    
    if (event.target.classList.contains("deleteAlbum")) {

    const deleteAlbumButton = event.target;
    const albumContainer = deleteAlbumButton.parentElement;
    const hrefArray = albumContainer.querySelector('a').getAttribute('href').split("/");
    const artistId2 = hrefArray[2];
    const albumId2 = hrefArray[4]; 

    const xhr = new XMLHttpRequest()

    xhr.onreadystatechange = function(response) {

        if(xhr.readyState == 4 && xhr.status == 200) {
            const remainingAlbums = JSON.parse(response.currentTarget.response);
            let html = ''

            remainingAlbums.forEach(function(album) {
                html += `
                    <li>
                    <a href="/artists/${artistId2}/album/${album.id}">Album: ${album.albumName}</a>
                    <button class="deleteAlbum">Remove</button>
                    </li>
                `
            })
            albumsUl2.innerHTML = html
        }
    }
    xhr.open("DELETE", `/api/artists/${artistId2}/albums/${albumId2}`, true)
    xhr.send()
}
}
