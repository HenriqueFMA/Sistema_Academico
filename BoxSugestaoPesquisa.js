document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('search');
    const suggestionsList = document.getElementById('suggestions');

    const suggestions = [
        'João Silva',
        'Maria Oliveira',
        'Pedro Santos',
        'Ana Souza',
        'Lucas Ferreira',
        'Mariana Lima',
        'Rafael Costa',
        'Fernanda Almeida'
    ];

    searchInput.addEventListener('input', function() {
        const query = this.value.toLowerCase();
        suggestionsList.innerHTML = '';

        if (query) {
            const filteredSuggestions = suggestions.filter(item => item.toLowerCase().includes(query));
            filteredSuggestions.forEach(suggestion => {
                const li = document.createElement('li');
                li.textContent = suggestion;
                li.addEventListener('click', function() {
                    searchInput.value = suggestion;
                    suggestionsList.innerHTML = '';
                });
                suggestionsList.appendChild(li);
            });
            suggestionsList.style.display = 'block';
        } else {
            suggestionsList.style.display = 'none';
        }
    });

    document.addEventListener('click', function(event) {
        if (!event.target.closest('.barra_de_pesquisa')) {
            suggestionsList.style.display = 'none';
        }
    });
});
