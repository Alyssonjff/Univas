import 'package:flutter/material.dart';

class UserInfoScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final Map<String, String> user = {
      'name': 'Alysson Ferreira',
      'email': 'Alyssonjfranca@gmail.com',
      'role': 'Aluno',
    };

    return Scaffold(
      backgroundColor: Color(0xFF40E0D0),
      appBar: PreferredSize(
        preferredSize: Size.fromHeight(80.0),
        child: Container(
          color: Color(0xFF00CED1),
          child: Center(
            child: Text(
              'Informações do Usuário',
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
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Nome: ${user['name']}',
              style: TextStyle(color: Colors.white, fontSize: 18),
            ),
            SizedBox(height: 10),
            Text(
              'Email: ${user['email']}',
              style: TextStyle(color: Colors.white, fontSize: 18),
            ),
            SizedBox(height: 10),
            Text(
              'Função: ${user['role']}',
              style: TextStyle(color: Colors.white, fontSize: 18),
            ),
          ],
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