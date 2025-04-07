import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'create_project_screen.dart';
import 'projects_created_screen.dart';
import 'search_projects_screen.dart';
import 'user_info_screen.dart';

class HomeScreen extends StatelessWidget {
  final SharedPreferences prefs;

  HomeScreen({required this.prefs});

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
              'Gestão de Pesquisa Escolar',
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
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              ElevatedButton(
                onPressed: () {
                  _navigateWithFade(
                    context,
                    ProjectsCreatedScreen(prefs: prefs),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Color(0xFFD3D3D3),
                  padding: EdgeInsets.symmetric(vertical: 20),
                  minimumSize: Size(double.infinity, 60),
                ),
                child: Text(
                  'Projetos Criados',
                  style: TextStyle(fontSize: 18, fontFamily: 'Algerian'),
                ),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: () {
                  _navigateWithFade(
                    context,
                    SearchProjectsScreen(prefs: prefs),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Color(0xFFD3D3D3),
                  padding: EdgeInsets.symmetric(vertical: 20),
                  minimumSize: Size(double.infinity, 60),
                ),
                child: Text(
                  'Pesquisar Projetos',
                  style: TextStyle(fontSize: 18, fontFamily: 'Algerian'),
                ),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: () {
                  _navigateWithFade(context, CreateProjectScreen(prefs: prefs));
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Color(0xFFD3D3D3),
                  padding: EdgeInsets.symmetric(vertical: 20),
                  minimumSize: Size(double.infinity, 60),
                ),
                child: Text(
                  'Criar Projetos',
                  style: TextStyle(fontSize: 18, fontFamily: 'Algerian'),
                ),
              ),
            ],
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
            IconButton(
              icon: Icon(Icons.person, size: 40, color: Colors.white),
              onPressed: () {
                _navigateWithFade(context, UserInfoScreen());
              },
            ),
          ],
        ),
      ),
    );
  }

  void _navigateWithFade(BuildContext context, Widget destination) {
    Navigator.push(
      context,
      PageRouteBuilder(
        pageBuilder: (context, animation, secondaryAnimation) => destination,
        transitionsBuilder: (context, animation, secondaryAnimation, child) {
          var fadeAnimation = Tween(begin: 0.0, end: 1.0).animate(
            CurvedAnimation(parent: animation, curve: Curves.easeInOut),
          );

          return FadeTransition(opacity: fadeAnimation, child: child);
        },
        transitionDuration: Duration(seconds: 1),
      ),
    );
  }
}
