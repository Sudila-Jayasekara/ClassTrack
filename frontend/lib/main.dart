import 'package:flutter/material.dart';
import 'screens/teacher_list_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'ClassTrack',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: TeacherListScreen(),
    );
  }
}
