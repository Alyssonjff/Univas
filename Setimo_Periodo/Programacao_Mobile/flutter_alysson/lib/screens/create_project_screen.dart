import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'dart:convert';

class CreateProjectScreen extends StatefulWidget {
  final SharedPreferences prefs;

  CreateProjectScreen({required this.prefs});

  @override
  _CreateProjectScreenState createState() => _CreateProjectScreenState();
}

class _CreateProjectScreenState extends State<CreateProjectScreen> {
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _authorController = TextEditingController();
  final TextEditingController _messageController = TextEditingController();

  List<Map<String, String>> _loadProjects() {
    final String? projectsData = widget.prefs.getString('projects');
    if (projectsData != null) {
      try {
        List<dynamic> decodedData = jsonDecode(projectsData);
        return decodedData
            .map((item) => Map<String, String>.from(item))
            .toList();
      } catch (e) {
        print('Erro ao decodificar os dados do projeto: $e');
      }
    }
    return [];
  }

  void _saveProject() {
    final String title = _titleController.text.trim();
    final String author = _authorController.text.trim();
    final String message = _messageController.text.trim();

    if (title.isNotEmpty && author.isNotEmpty && message.isNotEmpty) {
      List<Map<String, String>> existingProjects = _loadProjects();
      existingProjects.add({
        'title': title,
        'author': author,
        'message': message,
      });

      List<Map<String, dynamic>> projectsToSave =
          existingProjects
              .map(
                (project) => {
                  'title': project['title'],
                  'author': project['author'],
                  'message': project['message'],
                },
              )
              .toList();

      widget.prefs.setString('projects', jsonEncode(projectsToSave));

      Navigator.pop(context);
    } else {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Por favor, preencha todos os campos.')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF40E0D0),
      appBar: PreferredSize(
        preferredSize: Size.fromHeight(80.0),
        child: Container(
          color: Color(0xFF00CED1),
          child: Center(
            child: Text(
              'Criar Projeto',
              style: TextStyle(
                color: Colors.white,
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: _titleController,
              decoration: InputDecoration(
                labelText: 'Título do Projeto',
                fillColor: Colors.white,
                filled: true,
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 20),
            TextField(
              controller: _authorController,
              decoration: InputDecoration(
                labelText: 'Autor do Projeto',
                fillColor: Colors.white,
                filled: true,
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 20),
            TextField(
              controller: _messageController,
              decoration: InputDecoration(
                labelText: 'Mensagem',
                fillColor: Colors.white,
                filled: true,
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 40),
            ElevatedButton(
              onPressed: _saveProject,
              style: ElevatedButton.styleFrom(
                backgroundColor: Color(0xFFD3D3D3),
                padding: EdgeInsets.symmetric(vertical: 16),
                minimumSize: Size(double.infinity, 60),
              ),
              child: Text(
                'Salvar Projeto',
                style: TextStyle(fontSize: 18, fontFamily: 'Algerian'),
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
