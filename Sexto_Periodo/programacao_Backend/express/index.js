const express = require("express")

const app = express()

//rota raiz
app.get('/', (req,res) =>{
    const html = `
    `
    res.send("<title>Primeira Pagina</title> <h1> Primeira pagina </h1>")
})

//segunda rota
app.get('/sobre', (req,res) =>{
    const html = `
    <title>Segunda pagina </title>
    <h1>Texto Grande <p> dentro do P </p> </h1>
    `
    res.send(html)
})

app.get('/calculo', (req,res) =>{
    const html = `
    <form method='get' action="/enviar-formulario">
        <label>Ano de nascimento:</label><br>
        <input type="number" name="ano"><br><br>
        
        <button type="submit">Enviar</button>
    </form>
    `
    res.send(html)
})

app.get('/enviar-formulario', (req,res) =>{
    const ano = req.query.ano
    const data = new Date().getFullYear()
    const nascimento = data - ano
    const html = `
        idade: ${nascimento}
    `
    res.send(html)
})

//rotas dinamicas
app.get('/idade/:id_date', (req,res) =>{
    const data = new Date().getFullYear()
    const id = req.params.id_date
    const nascimento = data - id
    res.send(`Idade Final ${nascimento}`)
})
app.listen(3000, () => {
    console.log("Servidor está escutando....")
})