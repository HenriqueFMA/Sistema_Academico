document.getElementById('file-upload').addEventListener('change', handleFileSelect, false);
document.getElementById('add-link').addEventListener('click', handleLinkAdd, false);

function handleFileSelect(event) {
    const files = event.target.files;
    const output = document.getElementById('uploaded-files');
    
    for (let i = 0, f; f = files[i]; i++) {
        const fileReader = new FileReader();

        fileReader.onload = (function(theFile) {
            return function(e) {
                const fileDiv = document.createElement('div');
                fileDiv.className = 'uploaded-file';

                if (theFile.type.startsWith('image/')) {
                    const img = document.createElement('img');
                    img.src = e.target.result;
                    fileDiv.appendChild(img);
                } else {
                    const link = document.createElement('a');
                    link.href = e.target.result;
                    link.target = '_blank';
                    link.textContent = theFile.name;
                    fileDiv.appendChild(link);
                }

                const removeBtn = document.createElement('span');
                removeBtn.textContent = 'Remove';
                removeBtn.onclick = function() {
                    fileDiv.remove();
                };
                fileDiv.appendChild(removeBtn);

                output.appendChild(fileDiv);
            };
        })(f);

        fileReader.readAsDataURL(f);
    }
}

function handleLinkAdd() {
    const linkInput = document.getElementById('link-upload');
    const linkValue = linkInput.value;
    const output = document.getElementById('uploaded-files');

    if (linkValue) {
        const linkDiv = document.createElement('div');
        linkDiv.className = 'uploaded-file';

        const link = document.createElement('a');
        link.href = linkValue;
        link.target = '_blank';
        link.textContent = linkValue;

        const removeBtn = document.createElement('span');
        removeBtn.textContent = 'Remove';
        removeBtn.onclick = function() {
            linkDiv.remove();
        };

        linkDiv.appendChild(link);
        linkDiv.appendChild(removeBtn);
        output.appendChild(linkDiv);

        linkInput.value = ''; // Clear the input field
    }
}
