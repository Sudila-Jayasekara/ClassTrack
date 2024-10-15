import 'package:flutter/material.dart';
import 'package:frontend/const/constant.dart';
import 'package:frontend/screens/main_screen.dart';
import 'package:frontend/screens/teacher_list_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'ClassTrack',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        scaffoldBackgroundColor: backgroundColor,
        brightness: Brightness.dark,
      ),
      home: MainScreen(),
    );
  }
}
