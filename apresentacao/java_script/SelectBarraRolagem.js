document.addEventListener('DOMContentLoaded', () => {
    const scrollBar = document.querySelector('.barra_de_rolagem');
    if (!scrollBar) {
        console.error("Elemento .barra_de_rolagem não foi encontrado no DOM.");
        return;
    }
    const items = scrollBar.querySelectorAll('a');
    const currentPage = window.location.pathname.split('/').pop();

    const saveSelection = (item) => {
        localStorage.setItem('selectedItem', item.href);
    };

    const loadSelection = () => {
        const selectedItemHref = localStorage.getItem('selectedItem');
        if (selectedItemHref) {
            items.forEach(item => {
                if (item.href === selectedItemHref) {
                    const targetDiv = item.querySelector('div');
                    if (targetDiv) {
                        targetDiv.classList.add('selected');
                        scrollBar.prepend(item);
                    }
                }
            });
        }
    };

    items.forEach(item => {
        item.addEventListener('click', (event) => {
            event.preventDefault();
            items.forEach(i => {
                const targetDiv = i.querySelector('div');
                if (targetDiv) {
                    targetDiv.classList.remove('selected');
                }
            });
            const targetDiv = item.querySelector('div');
            if (targetDiv) {
                targetDiv.classList.add('selected');
                scrollBar.prepend(item);
            }
            scrollBar.scrollTo({ left: 0, behavior: 'smooth' });
            saveSelection(item);

            const selectedClass = targetDiv.classList[0];
            localStorage.setItem('selectedClass', selectedClass);

            setTimeout(() => {
                if (selectedClass === 'main_Gerar_boletim' || selectedClass === 'main_Historico' || selectedClass === 'main_AttDados') {
                    window.location.href = 'PesquisaAluno.html';
                } else {
                    window.location.href = item.href;
                }
            }, 500);
        });
    });

    if (currentPage === 'home.html') {
        localStorage.removeItem('selectedItem');
        localStorage.removeItem('selectedClass');
    } else {
        loadSelection();
    }

    if (currentPage === 'PesquisaAluno.html') {
        const selectedItemHref = localStorage.getItem('selectedItem');
        if (selectedItemHref) {
            items.forEach(item => {
                if (item.href === selectedItemHref) {
                    const targetDiv = item.querySelector('div');
                    if (targetDiv) {
                        targetDiv.classList.add('selected');
                        scrollBar.prepend(item);
                    }
                }
            });
        }
    }
});

