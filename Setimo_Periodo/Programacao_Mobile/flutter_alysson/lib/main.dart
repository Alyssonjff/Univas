import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'screens/home_screen.dart';
import 'screens/create_project_screen.dart';
import 'screens/projects_created_screen.dart';
import 'screens/search_projects_screen.dart';
import 'screens/user_info_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  final SharedPreferences prefs = await SharedPreferences.getInstance();
  runApp(MyApp(prefs: prefs));
}

class MyApp extends StatelessWidget {
  final SharedPreferences prefs;

  MyApp({required this.prefs});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Gestão de Pesquisa Escolar',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      initialRoute: '/',
      onGenerateRoute: (settings) {
        switch (settings.name) {
          case '/':
            return MaterialPageRoute(
              builder: (context) => HomeScreen(prefs: prefs),
            );
          case '/create-project':
            return MaterialPageRoute(
              builder: (context) => CreateProjectScreen(prefs: prefs),
            );
          case '/projects-created':
            return MaterialPageRoute(
              builder: (context) => ProjectsCreatedScreen(prefs: prefs),
            );
          case '/search-projects':
            return MaterialPageRoute(
              builder: (context) => SearchProjectsScreen(prefs: prefs),
            );
          case '/user-info':
            return MaterialPageRoute(
              builder: (context) => UserInfoScreen(),
            );
          default:
            return MaterialPageRoute(
              builder: (context) => HomeScreen(prefs: prefs),
            );
        }
      },
    );
  }
}