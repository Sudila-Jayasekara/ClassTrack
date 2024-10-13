import 'package:flutter/material.dart';
import '../models/teacher.dart';
import '../screens/teacher_detail_screen.dart';

class TeacherCard extends StatelessWidget {
  final Teacher teacher;

  TeacherCard({required this.teacher});

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        title: Text('${teacher.firstName} ${teacher.lastName}'),
        subtitle: Text(teacher.email),
        onTap: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => TeacherDetailScreen(teacherId: teacher.id),
            ),
          );
        },
      ),
    );
  }
}
