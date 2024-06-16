document.addEventListener('DOMContentLoaded', () => {
    const scrollBar = document.querySelector('.barra_de_rolagem' );
    
    const items = scrollBar.querySelectorAll('a');

    const currentPage = window.location.pathname.split('/').pop();

    // Função para salvar o item selecionado no localStorage
    const saveSelection = (item) => {
        localStorage.setItem('selectedItem', item.href);
    };

    // Função para carregar o item selecionado do localStorage
    const loadSelection = () => {
        const selectedItemHref = localStorage.getItem('selectedItem');
        if (selectedItemHref) {
            items.forEach(item => {
                if (item.href === selectedItemHref) {
                    item.querySelector('.main_matricula, .main_Gerar_boletim, .main_Evento, .main_Historico, .main_ocorrencia, .main_avisos, .main_AttDados, .main_AddProfessor, .main_desempenho').classList.add('selected');
                    // Mover o item selecionado para a primeira posição
                    const scrollBar = document.querySelector('.barra_de_rolagem');
                    scrollBar.prepend(item);
                }
            });
        }
    };

    // Adiciona evento de clique a cada item para salvar a seleção, mudar a cor e redirecionar
    items.forEach(item => {
        item.addEventListener('click', (event) => {
            event.preventDefault();
            // Remove a classe 'selected' de todos os elementos .main_*
            items.forEach(i => i.querySelector('.main_matricula, .main_Gerar_boletim, .main_Evento, .main_Historico, .main_ocorrencia, .main_avisos, .main_AttDados, .main_AddProfessor, .main_desempenho').classList.remove('selected'));

            // Adiciona a classe 'selected' ao elemento .main_* do item clicado
            item.querySelector('.main_matricula, .main_Gerar_boletim, .main_Evento, .main_Historico, .main_ocorrencia, .main_avisos, .main_AttDados, .main_AddProfessor, .main_desempenho').classList.add('selected');

            // Mover o item selecionado para a primeira posição
            const scrollBar = document.querySelector('.barra_de_rolagem');
            scrollBar.prepend(item);

            // Rolagem suave até o início
            scrollBar.scrollTo({ left: 0, behavior: 'smooth' });

            // Salva a seleção
            saveSelection(item);

            // Redirecionar para a página após um pequeno delay para permitir a rolagem suave
            setTimeout(() => {
                window.location.href = item.href;
            }, 500);
        });
    });

    // Verifica se a página atual é home.html e limpa a seleção se for o caso
    if (currentPage === 'home.html') {
        localStorage.removeItem('selectedItem');
    } else {
        // Carrega a seleção ao iniciar
        loadSelection();
    }
});

