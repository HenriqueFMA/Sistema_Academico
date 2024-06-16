const barraDeRolagem = document.querySelector('.barra_de_rolagem');
let isDown = false;
let startX;
let scrollLeft;

barraDeRolagem.addEventListener('mousedown', (e) => {
  isDown = true;
  barraDeRolagem.classList.add('active');
  startX = e.pageX - barraDeRolagem.offsetLeft;
  scrollLeft = barraDeRolagem.scrollLeft;
});

barraDeRolagem.addEventListener('mouseleave', () => {
  isDown = false;
  barraDeRolagem.classList.remove('active');
});

barraDeRolagem.addEventListener('mouseup', () => {
  isDown = false;
  barraDeRolagem.classList.remove('active');
});

barraDeRolagem.addEventListener('mousemove', (e) => {
  if (!isDown) return;
  e.preventDefault();
  const x = e.pageX - barraDeRolagem.offsetLeft;
  const walk = (x - startX) * 1.5; 
  barraDeRolagem.scrollLeft = scrollLeft - walk;
});

