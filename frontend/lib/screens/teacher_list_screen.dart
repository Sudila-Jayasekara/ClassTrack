import 'package:flutter/material.dart';
import '../models/teacher.dart';
import '../services/teacher_service.dart';
import '../widgets/teacher_card.dart';

class TeacherListScreen extends StatefulWidget {
  @override
  _TeacherListScreenState createState() => _TeacherListScreenState();
}

class _TeacherListScreenState extends State<TeacherListScreen> {
  late Future<List<Teacher>> futureTeachers;

  @override
  void initState() {
    super.initState();
    futureTeachers = TeacherService().getAllTeachers();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Teachers'),
      ),
      body: FutureBuilder<List<Teacher>>(
        future: futureTeachers,
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return Center(child: Text('No teachers found'));
          } else {
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (context, index) {
                return TeacherCard(teacher: snapshot.data![index]);
              },
            );
          }
        },
      ),
    );
  }
}
