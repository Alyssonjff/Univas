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

  List<Map<String, String>> _filteredProjects = [];
  List<Map<String, String>> _allProjects = [];

  @override
  void initState() {
    super.initState();
    _loadProjects();

    _titleController.addListener(_filterProjects);
  }

  @override
  void dispose() {
    _titleController.removeListener(_filterProjects);
    super.dispose();
  }

  void _loadProjects() {
    final String? projectsData = widget.prefs.getString('projects');
    if (projectsData != null) {
      try {
        List<dynamic> decodedData = jsonDecode(projectsData);
        setState(() {
          _allProjects =
              decodedData
                  .map((item) => Map<String, String>.from(item))
                  .toList();
          _filteredProjects = List.from(_allProjects);
        });
      } catch (e) {
        print('Erro ao decodificar os dados do projeto: $e');
      }
    }
  }

  void _filterProjects() {
    String titleQuery = _titleController.text.toLowerCase();
    String authorQuery = _authorController.text.toLowerCase();

    setState(() {
      _filteredProjects =
          _allProjects.where((project) {
            bool matchesTitle =
                titleQuery.isEmpty ||
                project['title']!.toLowerCase().contains(titleQuery);
            bool matchesAuthor =
                authorQuery.isEmpty ||
                project['author']!.toLowerCase().contains(authorQuery);
            return matchesTitle && matchesAuthor;
          }).toList();
    });
  }

  void _searchProjects() {
    _filterProjects();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF40E0D0),
      appBar: AppBar(
        title: Center(
          child: Text(
            'Pesquisar Projetos',
            style: TextStyle(color: Colors.white),
          ),
        ),
        backgroundColor: Color(0xFF00CED1),
        automaticallyImplyLeading: false,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'Pesquisar por Título:',
              style: TextStyle(
                fontSize: 18,
                fontWeight: FontWeight.bold,
                color: Colors.white,
              ),
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
              style: TextStyle(
                fontSize: 18,
                fontWeight: FontWeight.bold,
                color: Colors.white,
              ),
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
              onChanged: (value) {
                _filterProjects();
              },
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
            if (_filteredProjects.isEmpty)
              Text(
                'Nenhum projeto encontrado.',
                style: TextStyle(fontSize: 18, color: Colors.red),
              ),
            Expanded(
              child: ListView.builder(
                itemCount: _filteredProjects.length,
                itemBuilder: (context, index) {
                  return Card(
                    color: Color(0xFF00CED1),
                    margin: EdgeInsets.symmetric(vertical: 10),
                    child: ListTile(
                      title: Text(
                        _filteredProjects[index]['title'] ??
                            'Título não disponível',
                        style: TextStyle(color: Colors.white, fontSize: 18),
                      ),
                      subtitle: Text(
                        'Autor: ${_filteredProjects[index]['author'] ?? 'Autor desconhecido'}',
                        style: TextStyle(color: Colors.white),
                      ),
                    ),
                  );
                },
              ),
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
