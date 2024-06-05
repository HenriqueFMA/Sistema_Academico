document.addEventListener('DOMContentLoaded', function () {
    // Dados de exemplo
    const dadosDoAluno = {
        nome: 'João Silva',
        cpf: '123.456.789-00',
        dataNascimento: '2010-01-01',
        rg: 'MG-12.345.678',
        serie: '5ª série',
        turno: 'Manhã',
        nis: '1234567890',
        foto: '' // Adicione a URL da foto se houver
    };

    const dadosDosPais = {
        mae: {
            nome: 'Maria Silva',
            cpf: '987.654.321-00',
            rg: 'MG-98.765.432',
            dataNascimento: '1980-05-05'
        },
        pai: {
            nome: 'José Silva',
            cpf: '654.321.987-00',
            rg: 'MG-65.432.198',
            dataNascimento: '1978-10-10'
        },
        nisResponsavel: '0987654321'
    };

    const endereco = {
        rua: 'Rua das Flores',
        bairro: 'Centro',
        complemento: 'Apto 101'
    };

    // Preenche os dados do aluno
    document.getElementById('nome-aluno').value = dadosDoAluno.nome;
    document.getElementById('cpf-aluno').value = dadosDoAluno.cpf;
    document.getElementById('data-nascimento-aluno').value = dadosDoAluno.dataNascimento;
    document.getElementById('rg-aluno').value = dadosDoAluno.rg;
    document.getElementById('serie').value = dadosDoAluno.serie;
    document.getElementById('turno').value = dadosDoAluno.turno;
    document.getElementById('nis-aluno').value = dadosDoAluno.nis;

    // Preenche os dados da mãe
    document.getElementById('nome-mae').value = dadosDosPais.mae.nome;
    document.getElementById('cpf-mae').value = dadosDosPais.mae.cpf;
    document.getElementById('rg-mae').value = dadosDosPais.mae.rg;
    document.getElementById('data-nascimento-mae').value = dadosDosPais.mae.dataNascimento;

    // Preenche os dados do pai
    document.getElementById('nome-pai').value = dadosDosPais.pai.nome;
    document.getElementById('cpf-pai').value = dadosDosPais.pai.cpf;
    document.getElementById('rg-pai').value = dadosDosPais.pai.rg;
    document.getElementById('data-nascimento-pai').value = dadosDosPais.pai.dataNascimento;

    //nis responsavel
    document.getElementById('niss-responsavel').value = dadosDosPais.nisResponsavel;


    // Preenche o endereço
    document.getElementById('rua').value = endereco.rua;
    document.getElementById('bairro').value = endereco.bairro;
    document.getElementById('complemento').value = endereco.complemento;
});