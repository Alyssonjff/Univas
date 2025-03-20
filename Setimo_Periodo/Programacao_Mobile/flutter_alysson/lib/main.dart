import 'package:flutter/material.dart';
import 'screens/home_screen.dart';
import 'screens/create_project_screen.dart';
import 'screens/projects_created_screen.dart';
import 'screens/search_projects_screen.dart';
import 'screens/user_info_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Gestão de Pesquisa Escolar',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      initialRoute: '/',
      routes: {
        '/': (context) => HomeScreen(),
        '/create-project': (context) => CreateProjectScreen(),
        '/projects-created': (context) => ProjectsCreatedScreen(),
        '/search-projects': (context) => SearchProjectsScreen(),
        '/user-info': (context) => UserInfoScreen(),
      },
    );
  }
}
