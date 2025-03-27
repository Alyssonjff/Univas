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
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _descriptionController = TextEditingController();
  final TextEditingController _authorController = TextEditingController();

  void _saveProjects(List<Map<String, String>> projects) async {
    final String encodedData = jsonEncode(projects);
    await widget.prefs.setString('projects', encodedData);
  }

  List<Map<String, String>> _loadProjects() {
    final String? projectsData = widget.prefs.getString('projects');
    if (projectsData != null) {
      List<dynamic> decodedData = jsonDecode(projectsData);
      return decodedData.map((item) => Map<String, String>.from(item)).toList();
    }
    return [];
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
              'Criar Projetos',
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
        child: SingleChildScrollView(
          child: Form(
            key: _formKey,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                SizedBox(height: 20),
                Text(
                  'Título do Projeto:',
                  style: TextStyle(
                    fontSize: 18,
                    fontFamily: 'Algerian',
                    color: Colors.white,
                  ),
                ),
                SizedBox(height: 10),
                TextFormField(
                  controller: _titleController,
                  decoration: InputDecoration(
                    filled: true,
                    fillColor: Colors.white,
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10.0),
                    ),
                    hintText: 'Digite o título do projeto',
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Por favor, insira um título';
                    }
                    return null;
                  },
                ),
                SizedBox(height: 20),
                Text(
                  'Descrição do Projeto:',
                  style: TextStyle(
                    fontSize: 18,
                    fontFamily: 'Algerian',
                    color: Colors.white,
                  ),
                ),
                SizedBox(height: 10),
                TextFormField(
                  controller: _descriptionController,
                  maxLines: 5,
                  decoration: InputDecoration(
                    filled: true,
                    fillColor: Colors.white,
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10.0),
                    ),
                    hintText: 'Digite a descrição do projeto',
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Por favor, insira uma descrição';
                    }
                    return null;
                  },
                ),
                SizedBox(height: 20),
                Text(
                  'Autor:',
                  style: TextStyle(
                    fontSize: 18,
                    fontFamily: 'Algerian',
                    color: Colors.white,
                  ),
                ),
                SizedBox(height: 10),
                TextFormField(
                  controller: _authorController,
                  decoration: InputDecoration(
                    filled: true,
                    fillColor: Colors.white,
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10.0),
                    ),
                    hintText: 'Digite o nome do autor',
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Por favor, insira o nome do autor';
                    }
                    return null;
                  },
                ),
                SizedBox(height: 40),
                Center(
                  child: ElevatedButton(
                    onPressed: () {
                      if (_formKey.currentState!.validate()) {
                          List<Map<String, String>> projects = _loadProjects();

                        projects.add({
                          'title': _titleController.text,
                          'description': _descriptionController.text,
                          'author': _authorController.text,
                        });

                        _saveProjects(projects);

                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(content: Text('Projeto Criado!')),
                        );

                        _titleController.clear();
                        _descriptionController.clear();
                        _authorController.clear();
                      }
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Color(0xFFD3D3D3),
                      padding: EdgeInsets.symmetric(vertical: 16, horizontal: 40),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10.0),
                      ),
                    ),
                    child: Text(
                      'Criar Projeto',
                      style: TextStyle(
                        fontSize: 18,
                        fontFamily: 'Algerian',
                        color: Colors.white,
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
      bottomNavigationBar: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
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