import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'dart:convert';

class ProjectsCreatedScreen extends StatelessWidget {
  final SharedPreferences prefs;

  ProjectsCreatedScreen({required this.prefs});

  List<Map<String, String>> _loadProjects() {
    final String? projectsData = prefs.getString('projects');
    if (projectsData != null) {
      List<dynamic> decodedData = jsonDecode(projectsData);
      return decodedData.map((item) => Map<String, String>.from(item)).toList();
    }
    return [];
  }

  @override
  Widget build(BuildContext context) {
    final List<Map<String, String>> projects = _loadProjects();

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
        child: projects.isEmpty
            ? Text(
                'Nenhum projeto criado.',
                style: TextStyle(color: Colors.white, fontSize: 18),
              )
            : ListView.builder(
                itemCount: projects.length,
                itemBuilder: (context, index) {
                  return ListTile(
                    title: Text(
                      projects[index]['title']!,
                      style: TextStyle(color: Colors.white, fontSize: 18),
                    ),
                    subtitle: Text(
                      'Autor: ${projects[index]['author']}',
                      style: TextStyle(color: Colors.white),
                    ),
                  );
                },
              ),
      ),
      floatingActionButton: Stack(
        children: [
          Positioned(
            top: 10,
            left: 10,
            child: IconButton(
              icon: Icon(Icons.arrow_back, size: 30, color: Colors.white),
              onPressed: () {
                Navigator.pop(context);
              },
            ),
          ),
          Positioned(
            bottom: 20,
            right: 20,
            child: IconButton(
              icon: Icon(Icons.home, size: 40, color: Colors.white),
              onPressed: () {
                Navigator.pushNamed(context, '/');
              },
            ),
          ),
        ],
      ),
    );
  }
}