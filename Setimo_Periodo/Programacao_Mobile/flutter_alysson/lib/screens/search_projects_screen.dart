import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'dart:convert';

class SearchProjectsScreen extends StatefulWidget {
  final SharedPreferences prefs;

  SearchProjectsScreen({required this.prefs});

  @override
  _SearchProjectsScreenState createState() => _SearchProjectsScreenState();
}

class _SearchProjectsScreenState extends State<SearchProjectsScreen> {
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _authorController = TextEditingController();

  Map<String, String>? _searchResult;
  String? _errorMessage;

  List<Map<String, String>> _loadProjects() {
    final String? projectsData = widget.prefs.getString('projects');
    if (projectsData != null) {
      List<dynamic> decodedData = jsonDecode(projectsData);
      return decodedData.map((item) => Map<String, String>.from(item)).toList();
    }
    return [];
  }

  void _searchProjects() {
    final String title = _titleController.text.trim();
    final String author = _authorController.text.trim();

    setState(() {
      _searchResult = null;
      _errorMessage = null;

      if (title.isEmpty && author.isEmpty) {
        _errorMessage = 'Digite um título ou autor para pesquisar.';
        return;
      }

      List<Map<String, String>> projects = _loadProjects();

      for (var project in projects) {
        if ((title.isNotEmpty && project['title']!.toLowerCase().contains(title.toLowerCase())) ||
            (author.isNotEmpty && project['author']!.toLowerCase().contains(author.toLowerCase()))) {
          _searchResult = project;
          break;
        }
      }

      if (_searchResult == null) {
        _errorMessage = 'Nenhum projeto encontrado.';
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF40E0D0),
      appBar: AppBar(
        title: Text('Pesquisar Projetos'),
        backgroundColor: Color(0xFF00CED1),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'Pesquisar por Título:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white),
            ),
            SizedBox(height: 10),
            TextField(
              controller: _titleController,
              decoration: InputDecoration(
                hintText: 'Digite o título do projeto',
                border: OutlineInputBorder(),
                fillColor: Colors.white,
                filled: true,
                contentPadding: EdgeInsets.all(16),
              ),
            ),
            SizedBox(height: 20),
            Text(
              'Pesquisar por Autor:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white),
            ),
            SizedBox(height: 10),
            TextField(
              controller: _authorController,
              decoration: InputDecoration(
                hintText: 'Digite o nome do autor',
                border: OutlineInputBorder(),
                fillColor: Colors.white,
                filled: true,
                contentPadding: EdgeInsets.all(16),
              ),
            ),
            SizedBox(height: 40),
            ElevatedButton(
              onPressed: _searchProjects,
              style: ElevatedButton.styleFrom(
                backgroundColor: Color(0xFFD3D3D3),
                padding: EdgeInsets.symmetric(vertical: 16),
                minimumSize: Size(double.infinity, 60),
              ),
              child: Text(
                'Pesquisar',
                style: TextStyle(
                  fontSize: 18,
                  fontFamily: 'Algerian',
                  color: Colors.white,
                ),
              ),
            ),
            SizedBox(height: 20),
            if (_errorMessage != null)
              Text(
                _errorMessage!,
                style: TextStyle(fontSize: 18, color: Colors.red),
              ),
            if (_searchResult != null)
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    'Projeto Encontrado:',
                    style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white),
                  ),
                  SizedBox(height: 10),
                  Text(
                    'Título: ${_searchResult!['title']}',
                    style: TextStyle(fontSize: 16, color: Colors.white),
                  ),
                  Text(
                    'Autor: ${_searchResult!['author']}',
                    style: TextStyle(fontSize: 16, color: Colors.white),
                  ),
                ],
              ),
          ],
        ),
      ),
      bottomNavigationBar: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            IconButton(
              icon: Icon(Icons.menu, size: 40, color: Colors.white),
              onPressed: () {
                print('Menu pressionado');
              },
            ),
            IconButton(
              icon: Icon(Icons.arrow_back, size: 40, color: Colors.white),
              onPressed: () {
                Navigator.pop(context);
              },
            ),
            IconButton(
              icon: Icon(Icons.home, size: 40, color: Colors.white),
              onPressed: () {
                Navigator.pushNamed(context, '/');
              },
            ),
          ],
        ),
      ),
    );
  }
}