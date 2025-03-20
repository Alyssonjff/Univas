import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:flutter_alysson/main.dart';

void main() {
  testWidgets('Testa navegação e presença de widgets', (
    WidgetTester tester,
  ) async {
    // Build nossa aplicação e aciona um frame.
    await tester.pumpWidget(const MyApp());

    // Verifique se a tela inicial contém o título "Gestão de Pesquisa Escolar".
    expect(find.text('Gestão de Pesquisa Escolar'), findsOneWidget);

    // Verifique se a lista de tarefas está visível.
    expect(find.text('To-Do List'), findsOneWidget);
    expect(find.text('Criar trabalho 1'), findsOneWidget);
    expect(find.text('Revisar trabalho 2'), findsOneWidget);

    // Toque no ícone de usuário para navegar até a tela de informações do usuário.
    await tester.tap(find.byIcon(Icons.account_circle));
    await tester.pumpAndSettle();

    // Verifique se a tela de informações do usuário contém os textos esperados.
    expect(find.text('Informações do Usuário'), findsOneWidget);
    expect(find.text('Nome: João da Silva'), findsOneWidget);
    expect(find.text('E-mail: joao@example.com'), findsOneWidget);
  });
}
