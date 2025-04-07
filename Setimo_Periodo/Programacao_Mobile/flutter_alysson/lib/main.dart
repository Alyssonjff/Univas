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

class AppRoutes {
  static const home = '/';
  static const createProject = '/create-project';
  static const projectsCreated = '/projects-created';
  static const searchProjects = '/search-projects';
  static const userInfo = '/user-info';
}

class MyApp extends StatelessWidget {
  final SharedPreferences prefs;

  MyApp({required this.prefs});

  ThemeData _buildTheme() {
    return ThemeData(
      brightness: Brightness.light,
      primarySwatch: Colors.blue,
      visualDensity: VisualDensity.adaptivePlatformDensity,
      appBarTheme: AppBarTheme(backgroundColor: Color(0xFF00CED1)),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Gestão de Pesquisa Escolar',
      theme: _buildTheme(),
      darkTheme: ThemeData(
        brightness: Brightness.dark,
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      themeMode: ThemeMode.system,
      initialRoute: AppRoutes.home,
      onGenerateRoute: (settings) {
        switch (settings.name) {
          case AppRoutes.home:
            return MaterialPageRoute(
              builder: (context) => HomeScreen(prefs: prefs),
            );
          case AppRoutes.createProject:
            return MaterialPageRoute(
              builder: (context) => CreateProjectScreen(prefs: prefs),
            );
          case AppRoutes.projectsCreated:
            return MaterialPageRoute(
              builder: (context) => ProjectsCreatedScreen(prefs: prefs),
            );
          case AppRoutes.searchProjects:
            return MaterialPageRoute(
              builder: (context) => SearchProjectsScreen(prefs: prefs),
            );
          case AppRoutes.userInfo:
            return MaterialPageRoute(builder: (context) => UserInfoScreen());
          default:
            return MaterialPageRoute(
              builder: (context) => HomeScreen(prefs: prefs),
            );
        }
      },
    );
  }
}
