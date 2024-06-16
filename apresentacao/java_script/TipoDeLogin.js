document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('login-form');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const role = document.getElementById('role').value;

        // Armazena o tipo de login no localStorage
        localStorage.setItem('userRole', role);

        // Redireciona para a próxima página
        window.location.href = 'home.html';
    });
});