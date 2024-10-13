import 'package:flutter/material.dart';
import '../models/teacher.dart';
import '../services/teacher_service.dart';

class TeacherDetailScreen extends StatelessWidget {
  final int teacherId;

  TeacherDetailScreen({required this.teacherId});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Teacher Details'),
      ),
      body: FutureBuilder<Teacher>(
        future: TeacherService().getTeacherById(teacherId),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData) {
            return Center(child: Text('Teacher not found'));
          } else {
            final teacher = snapshot.data!;
            return Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('Name: ${teacher.firstName} ${teacher.lastName}', style: TextStyle(fontSize: 20)),
                  SizedBox(height: 8),
                  Text('Email: ${teacher.email}', style: TextStyle(fontSize: 16)),
                  SizedBox(height: 8),
                  Text('Phone: ${teacher.phone}', style: TextStyle(fontSize: 16)),
                ],
              ),
            );
          }
        },
      ),
    );
  }
}
