function juntarStrings(arrayDeStrings) {
    return arrayDeStrings.join(' ');
  }
  const palavras = ["Diga", "Para", "Todos", "Quem", "Sou!"];
  const frase = juntarStrings(palavras);
  console.log(frase); 
////////////////////////////////////////////  
  function juntarPalavras(arrayDePalavras) {
    return arrayDePalavras.join(', ');
  }
  
frase = juntarPalavras(palavras);
  console.log(frase);   
////////////////////////////////////////////
  function juntarNumeros(arrayDeNumeros) {
    return arrayDeNumeros.join('-');
  }

  const numeros = [1, 2, 3, 4];
  const resultado = juntarNumeros(numeros);
  console.log(resultado); 
////////////////////////////////////////////
function formatarDatas(arrayDeDatas) {
    return arrayDeDatas.map(function(data) {
      const dia = data.getDate().toString().padStart(2, '0');
      const mes = (data.getMonth() + 1).toString().padStart(2, '0');
      const ano = data.getFullYear();
      return `${dia}/${mes}/${ano}`;
    }).join('; '); 
  }
  const datas = [
    new Date('2022-01-01'),
    new Date('2022-02-15'),
    new Date('2022-03-28')
  ];
  const datasFormatadas = formatarDatas(datas);
  console.log(datasFormatadas);
///////////////////////////////////////////
function juntarMatriz(matriz) {
    return matriz.map(function(linha) {
      return linha.join(';');
    }).join(';');
  }
  const matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
  ];
  resultado = juntarMatriz(matriz);
  console.log(resultado); 
/////////////////////////////////////////
function juntarStringsMaiusculas(arrayDeStrings) {
    return arrayDeStrings.map(function(string) {
      return string.toUpperCase();
    }).join(' ');
  }
  
   frase = juntarStringsMaiusculas(palavras);
  console.log(frase); 