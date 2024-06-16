document.addEventListener('DOMContentLoaded', function() {
    const alertasContainer = document.getElementById('alertasContainer');

    // Função para carregar alertas do localStorage
    function carregarAlertas() {
        const alertas = JSON.parse(localStorage.getItem('alertas')) || [];
        mostrarAlertas(alertas);
    }

    // Função para exibir os alertas
    function mostrarAlertas(alertas) {
        alertasContainer.innerHTML = '';
        alertas.forEach(alerta => {
            criarAlerta(alerta);
        });
    }

    // Função para criar um alerta
    function criarAlerta(alerta) {
        const alertaElement = document.createElement('div');
        alertaElement.className = 'alerta';
        alertaElement.innerHTML = `
            <div class="date">${formatarData(alerta.dueDate)}</div>
            <div>
                <h2>${alerta.title}</h2>
                <p>${alerta.description}</p>
            </div>
        `;
        alertasContainer.appendChild(alertaElement);
    }

    // Função para formatar a data
    function formatarData(dateString) {
        const date = new Date(dateString);
        const options = { day: 'numeric',   month: 'long'};
        return date.toLocaleDateString('pt-BR', options);
    }

    // Carregar alertas do localStorage
    carregarAlertas();
});

