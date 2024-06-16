document.addEventListener('DOMContentLoaded', function() {
    // Obtém o tipo de login do localStorage
    const role = localStorage.getItem('userRole');

    if (role) {
        // Esconde todos os headers
        document.querySelectorAll('header').forEach(function(header) {
            header.style.display = 'none';
        });

        // Mostra apenas o header correspondente ao tipo de login
        document.getElementById(`${role}-header`).style.display = 'block';
    }
});