const alunos = [
    { nome: "Aluno 1", notas: [[10, 9, 8], [7, 6, 5], [9, 8, 7], [6, 5, 4]] },
    { nome: "Aluno 2", notas: [[8, 7, 6], [9, 8, 7], [7, 6, 5], [10, 9, 8]] }
    // Adicione mais alunos e notas conforme necessário
];

const tbody = document.querySelector("#notasTable tbody");

alunos.forEach(aluno => {
    const row = document.createElement("tr");

    const nomeCell = document.createElement("td");
    nomeCell.textContent = aluno.nome;
    row.appendChild(nomeCell);

    aluno.notas.forEach(bimestre => {
        bimestre.forEach(nota => {
            const notaCell = document.createElement("td");
            const input = document.createElement("input");
            input.type = "text";
            input.value = nota;
            notaCell.appendChild(input);
            row.appendChild(notaCell);
        });
    });

    tbody.appendChild(row);
});

document.getElementById("salvarNotas").addEventListener("click", () => {
    const updatedAlunos = [];
    const rows = tbody.querySelectorAll("tr");

    rows.forEach(row => {
        const cells = row.querySelectorAll("td");
        const nome = cells[0].textContent;
        const notas = [];
        
        for (let i = 1; i < cells.length; i++) {
            const inputs = cells[i].querySelectorAll("input");
            inputs.forEach(input => {
                if (notas[Math.floor((i - 1) / 3)]) {
                    notas[Math.floor((i - 1) / 3)].push(parseFloat(input.value));
                } else {
                    notas[Math.floor((i - 1) / 3)] = [parseFloat(input.value)];
                }
            });
        }

        updatedAlunos.push({ nome, notas });
    });

    console.log("Notas atualizadas:", updatedAlunos);
    alert("Notas salvas com sucesso!");
});
