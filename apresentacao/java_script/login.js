document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('login-form');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const role = document.getElementById('role').value;

        
        window.location.href = 'home.html';
    });
});