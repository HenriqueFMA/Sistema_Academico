document.addEventListener('DOMContentLoaded', function() {
    const alertaForm = document.getElementById('alertaForm');

    // Verificação de elemento existente
    if (!alertaForm) {
        return;
    }

    // Evento de submissão do formulário
    alertaForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const titulo = document.getElementById('titulo').value;
        const descricao = document.getElementById('descricao').value;
        const vencimento = document.getElementById('vencimento').value;

        const novoAlerta = {
            title: titulo,
            description: descricao,
            dueDate: vencimento
        };

        const alertas = JSON.parse(localStorage.getItem('alertas')) || [];
        alertas.push(novoAlerta);
        localStorage.setItem('alertas', JSON.stringify(alertas));

        // Limpar o formulário após adicionar o alerta
        alertaForm.reset();

        // Redirecionar para a página local "home.html" após adicionar o alerta
        window.location.href = "Confirmacao_Aviso.html"; // Substitua pelo caminho relativo da sua página local
    });
});