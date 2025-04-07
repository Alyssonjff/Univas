import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'dart:convert';

class ProjectsCreatedScreen extends StatefulWidget {
  final SharedPreferences prefs;

  ProjectsCreatedScreen({required this.prefs});

  @override
  _ProjectsCreatedScreenState createState() => _ProjectsCreatedScreenState();
}

class _ProjectsCreatedScreenState extends State<ProjectsCreatedScreen> {
  List<Map<String, String>> _projects = [];

  @override
  void initState() {
    super.initState();
    _loadProjects();
  }

  void _loadProjects() {
    final String? projectsData = widget.prefs.getString('projects');
    if (projectsData != null) {
      try {
        List<dynamic> decodedData = jsonDecode(projectsData);
        setState(() {
          _projects =
              decodedData
                  .map((item) => Map<String, String>.from(item))
                  .toList();
        });
      } catch (e) {
        print('Erro ao decodificar os dados do projeto: $e');
      }
    }
  }

  void _removeProject(BuildContext context, int index) {
    List<Map<String, String>> projects = _projects;
    final String projectTitle =
        projects[index]['title'] ?? 'Título desconhecido';

    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Confirmar Exclusão'),
          content: Text(
            'Tem certeza que deseja remover o projeto "$projectTitle"?',
          ),
          actions: <Widget>[
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('Cancelar'),
            ),
            TextButton(
              onPressed: () {
                setState(() {
                  projects.removeAt(index);
                  widget.prefs.setString('projects', jsonEncode(projects));
                });
                Navigator.of(context).pop();
              },
              child: Text('Remover'),
            ),
          ],
        );
      },
    );
  }

  void _editProject(BuildContext context, int index) {
    List<Map<String, String>> projects = _projects;
    final project = projects[index];
    final TextEditingController _messageController = TextEditingController(
      text: project['message'],
    );

    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Editar Mensagem'),
          content: TextField(
            controller: _messageController,
            maxLines: 5,
            decoration: InputDecoration(
              hintText: 'Digite a nova mensagem...',
              border: OutlineInputBorder(),
            ),
          ),
          actions: <Widget>[
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('Cancelar'),
            ),
            TextButton(
              onPressed: () {
                setState(() {
                  project['message'] = _messageController.text.trim();
                  widget.prefs.setString('projects', jsonEncode(projects));
                });
                Navigator.of(context).pop();
              },
              child: Text('Salvar'),
            ),
          ],
        );
      },
    );
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
              'Projetos Criados',
              style: TextStyle(
                color: Colors.white,
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
        ),
      ),
      body: Center(
        child:
            _projects.isEmpty
                ? Text(
                  'Nenhum projeto criado.',
                  style: TextStyle(color: Colors.white, fontSize: 18),
                )
                : ListView.builder(
                  itemCount: _projects.length,
                  itemBuilder: (context, index) {
                    return Card(
                      color: Color(0xFF00CED1),
                      margin: EdgeInsets.symmetric(vertical: 10),
                      child: ListTile(
                        title: Text(
                          _projects[index]['title'] ?? 'Título não disponível',
                          style: TextStyle(color: Colors.white, fontSize: 18),
                        ),
                        subtitle: Text(
                          'Autor: ${_projects[index]['author'] ?? 'Autor desconhecido'}',
                          style: TextStyle(color: Colors.white),
                        ),
                        trailing: Row(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            IconButton(
                              icon: Icon(Icons.delete, color: Colors.white),
                              onPressed: () {
                                _removeProject(context, index);
                              },
                            ),
                            IconButton(
                              icon: Icon(Icons.edit, color: Colors.white),
                              onPressed: () {
                                _editProject(context, index);
                              },
                            ),
                          ],
                        ),
                        onTap: () {
                          showDialog(
                            context: context,
                            builder: (context) {
                              return AlertDialog(
                                title: Text(
                                  _projects[index]['title'] ?? 'Sem título',
                                ),
                                content: Text(
                                  _projects[index]['message'] ?? 'Sem mensagem',
                                ),
                                actions: <Widget>[
                                  TextButton(
                                    child: Text('Fechar'),
                                    onPressed: () {
                                      Navigator.of(context).pop();
                                    },
                                  ),
                                ],
                              );
                            },
                          );
                        },
                      ),
                    );
                  },
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
