document.addEventListener('DOMContentLoaded', function() {
    const quantidadeAulasForm = document.getElementById('quantidadeAulasForm');
    const salvarFrequenciaButton = document.getElementById('salvarFrequencia');
    const tbody = document.querySelector('#frequenciaTable tbody');

   
    fetch('sua_api_url') // Substitua 'sua_api_url' pela URL da sua API
        .then(response => response.json())
        .then(data => {
            data.forEach(record => {
                const row = document.createElement('tr');
                const alunoCell = document.createElement('td');
                alunoCell.textContent = record.nome;
                const dataCell = document.createElement('td');
                dataCell.textContent = record.data;
                const frequenciaCell = document.createElement('td');

                const select = document.createElement('select');
                select.innerHTML = `
                    <option value="P">Presente</option>
                    <option value="F">Falta</option>
                    <option value="FJ">Falta Justificada</option>
                `;
                select.value = record.presenca;

                frequenciaCell.appendChild(select);
                row.appendChild(alunoCell);
                row.appendChild(dataCell);
                row.appendChild(frequenciaCell);
                tbody.appendChild(row);
            });
        })
        .catch(error => console.error('Erro ao carregar dados:', error));

    quantidadeAulasForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const quantidadeAulas = document.getElementById('quantidadeAulas').value;
        console.log('Quantidade de Aulas:', quantidadeAulas);
        // Aqui você pode fazer algo com a quantidade de aulas, como enviar para o backend
    });

    salvarFrequenciaButton.addEventListener('click', function() {
        const rows = tbody.querySelectorAll('tr');
        const frequenciaData = [];

        rows.forEach(row => {
            const aluno = row.cells[0].textContent;
            const data = row.cells[1].textContent;
            const frequencia = row.cells[2].querySelector('select').value;

            frequenciaData.push({ aluno, data, frequencia });
        });

        console.log('Frequência dos Alunos:', frequenciaData);
        // Aqui você pode enviar os dados de frequência para o backend
    });
});
