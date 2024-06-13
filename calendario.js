// Inicializa eventos a partir do localStorage ou com eventos de exemplo
let events = JSON.parse(localStorage.getItem('events')) || [

];

// Função para salvar eventos no localStorage
function saveEvents() {
    localStorage.setItem('events', JSON.stringify(events));
}

// Função para obter o nome do mês
function getMonthName(monthIndex) {
    const monthNames = [
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];
    return monthNames[monthIndex];
}

// Função para atualizar o calendário e a lista de eventos
function updateCalendar() {
    const today = new Date();
    const month = today.getMonth();
    const year = today.getFullYear();
    const firstDayOfMonth = new Date(year, month, 1).getDay();
    const daysInMonth = new Date(year, month + 1, 0).getDate();

    // Atualiza o nome do mês
    const monthName = getMonthName(month);
    document.getElementById('month-name').textContent = monthName.toUpperCase();

    const calendar = document.querySelector('.calendar');
    const eventList = document.getElementById('event-list');

    // Limpa os dias anteriores
    calendar.querySelectorAll('.day').forEach(day => day.remove());

    // Preenche os dias em branco antes do primeiro dia do mês
    for (let i = 0; i < firstDayOfMonth; i++) {
        const emptyDiv = document.createElement('div');
        emptyDiv.className = 'day';
        calendar.appendChild(emptyDiv);
    }

    // Gera os dias do mês
    for (let i = 1; i <= daysInMonth; i++) {
        const dayDiv = document.createElement('div');
        dayDiv.textContent = i < 10 ? `0${i}` : i;
        dayDiv.className = 'day';
        const dateStr = `${year}-${month + 1 < 10 ? '0' : ''}${month + 1}-${i < 10 ? '0' : ''}${i}`;
        const event = events.find(e => e.date === dateStr);
        if (event) {
            dayDiv.classList.add('highlight');
        }
        dayDiv.addEventListener('click', () => {
            // Marca ou desmarca o dia
            if (dayDiv.classList.contains('highlight')) {
                dayDiv.classList.remove('highlight');
                events = events.filter(e => e.date !== dateStr);
            } else {
                dayDiv.classList.add('highlight');
                const eventTitle = prompt("Título do Evento:");
                if (eventTitle) {
                    events.push({ date: dateStr, title: eventTitle });
                }
            }
            saveEvents();
            updateCalendar();
        });
        calendar.appendChild(dayDiv);
    }

    // Limpa a lista de eventos anteriores
    eventList.innerHTML = '';

    // Gera a lista de eventos
    events.filter(e => new Date(e.date).getMonth() === month).forEach(event => {
        const row = document.createElement('tr');
        const dateCell = document.createElement('td');
        dateCell.textContent = new Date(event.date).toLocaleDateString('pt-BR');
        const titleCell = document.createElement('td');
        titleCell.textContent = event.title;
        row.appendChild(dateCell);
        row.appendChild(titleCell);
        eventList.appendChild(row);
    });
}

// Função para adicionar um novo evento
function addEvent() {
    const eventDate = document.getElementById('event-date').value;
    const eventTitle = document.getElementById('event-title').value;
    if (eventDate && eventTitle) {
        events.push({ date: eventDate, title: eventTitle });
        saveEvents();
        updateCalendar();
        document.getElementById('event-date').value = '';
        document.getElementById('event-title').value = '';
    }
}

// Inicializa o calendário ao carregar a página
document.addEventListener('DOMContentLoaded', updateCalendar);
