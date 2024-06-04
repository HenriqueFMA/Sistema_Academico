document.getElementById('photo-placeholder').addEventListener('click', function() {
    document.getElementById('foto_do_aluno').click();
});

document.getElementById('foto_do_aluno').addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('preview-img').src = e.target.result;
            document.getElementById('preview-img').style.display = 'block';
            document.getElementById('placeholder-text').style.display = 'none';
        }
        reader.readAsDataURL(file);
    }
});
