document.getElementById('file-upload').addEventListener('change', function(event) {
    const uploadedFiles = document.getElementById('uploaded-files');
    const files = event.target.files;

    for (let i = 0; i < files.length; i++) {
        const fileItem = document.createElement('div');
        fileItem.className = 'file-item';
        fileItem.innerHTML = `<a href="#" onclick="openFile(event, '${URL.createObjectURL(files[i])}')" target="_blank">${files[i].name} (${Math.round(files[i].size / 1024)}K)</a>`;
        uploadedFiles.appendChild(fileItem);
    }
});

document.getElementById('add-link').addEventListener('click', function() {
    const linkInput = document.getElementById('link-upload');
    const uploadedFiles = document.getElementById('uploaded-files');

    if (linkInput.value) {
        const linkItem = document.createElement('div');
        linkItem.className = 'link-item';
        linkItem.innerHTML = `<a href="${linkInput.value}" target="_blank">${linkInput.value}</a>`;
        uploadedFiles.appendChild(linkItem);
        linkInput.value = '';
    }
});

document.getElementById('finish').addEventListener('click', function() {
    
    // Aqui você pode adicionar a lógica para manipular os dados finalizados, como enviar o formulário 
    window.location.href = 'Confirmacao_Ocorrencia.html';
});

function openFile(event, fileUrl) {
    event.preventDefault();
    window.open(fileUrl, '_blank');
}