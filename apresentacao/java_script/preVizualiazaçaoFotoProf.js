// Função que verifica se está na tela de ADDprofessor e exibe a imagem do professor
function showProfessorImageIfOnAddProfessorScreen() {
    if (document.querySelector('.formulario')) {
        const professorImage = 'url_da_imagem_do_professor'; // Substitua pela URL da imagem do professor
        document.getElementById('preview-img').src = professorImage;
        document.getElementById('preview-img').style.display = 'block';
        document.getElementById('placeholder-text').style.display = 'none';
    }
}

// Adicionar event listener ao placeholder da foto
document.getElementById('photo-placeholder').addEventListener('click', function() {
    document.getElementById('foto_do_professor').click();
});

// Adicionar event listener para a mudança de arquivo no input de foto
document.getElementById('foto_do_professor').addEventListener('change', function(event) {
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

// Chamar a função para mostrar a imagem do professor, se aplicável
showProfessorImageIfOnAddProfessorScreen();
