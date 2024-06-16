       // Variáveis simuladas para representar as diferentes condições
       var importedCondition_GerarBoletim = 'main_Gerar_boletim';
       var importedCondition_Historico = 'main_Historico';
       var importedCondition_AttDados = 'main_AttDados';
       
       // Função para definir a condição atual
       function setCurrentCondition(condition) {
           window.localStorage.setItem('currentCondition', condition);
       }
       
       // Simulação de definição da condição atual
       document.addEventListener('DOMContentLoaded', () => {
           const searchInput = document.getElementById('search');
           const suggestionsList = document.getElementById('suggestions');
       
           // Dados simulados dos alunos
           let suggestions = [
               { name: 'João Silva', cpf: '123.456.789-00', class: '3A', shift: 'Manhã' },
               { name: 'Maria Oliveira', cpf: '987.654.321-00', class: '8 ano B', shift: 'Tarde' },
               { name: 'Ana Souza', cpf: '111.222.333-44', class: '2B', shift: 'Manhã' }
           ];
       
           searchInput.addEventListener('input', function() {
               const query = this.value.toLowerCase();
               suggestionsList.innerHTML = '';
       
               if (query) {
                   const filteredSuggestions = suggestions.filter(item => item.name.toLowerCase().includes(query));
                   filteredSuggestions.forEach(suggestion => {
                       const li = document.createElement('li');
                       li.innerHTML = `<strong>${suggestion.name}</strong><br>CPF: ${suggestion.cpf}, Turma: ${suggestion.class}, Turno: ${suggestion.shift}`;
                       li.addEventListener('click', function() {
                           searchInput.value = suggestion.name;
                           suggestionsList.innerHTML = '';
                           loadStudentData(suggestion);
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
       
           function loadStudentData(student) {
               // Obter a condição atual do armazenamento local
               var currentCondition = window.localStorage.getItem('currentCondition');
               var selectedClass = window.localStorage.getItem('selectedClass');
               console.log('Student:', student);
               console.log('Current Condition:', currentCondition);
               console.log('Selected Class:', selectedClass);
       
               // Lógica para redirecionamento com base na variável currentCondition
               if (selectedClass === 'main_Gerar_boletim') {
                   console.log('Redirecting to GerarBoletim.html');
                   window.location.href = 'GerarBoletim.html';
               } else if (selectedClass === 'main_Historico') {
                   console.log('Redirecting to HistoricoEcolar.html');
                   window.location.href = 'HistoricoEcolar.html';
               } else if (selectedClass === 'main_AttDados') {
                   console.log('Redirecting to AtualizarDados.html');
                   window.location.href = 'AtualizarDados.html';
               } 
           }
       });
       