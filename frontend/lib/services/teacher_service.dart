import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/teacher.dart';

class TeacherService {
  static const String baseUrl = 'http://localhost:8080/api/teachers';

  Future<List<Teacher>> getAllTeachers() async {
    final response = await http.get(Uri.parse(baseUrl));
    if (response.statusCode == 200) {
      List jsonResponse = json.decode(response.body);
      return jsonResponse.map((teacher) => Teacher.fromJson(teacher)).toList();
    } else {
      throw Exception('Failed to load teachers');
    }
  }

  Future<Teacher> getTeacherById(int id) async {
    final response = await http.get(Uri.parse('$baseUrl/$id'));
    if (response.statusCode == 200) {
      return Teacher.fromJson(json.decode(response.body));
    } else {
      throw Exception('Failed to load teacher');
    }
  }

  Future<Teacher> createTeacher(Teacher teacher) async {
    final response = await http.post(
      Uri.parse(baseUrl),
      headers: {'Content-Type': 'application/json'},
      body: json.encode(teacher.toJson()),
    );
    if (response.statusCode == 201) {
      return Teacher.fromJson(json.decode(response.body));
    } else {
      throw Exception('Failed to create teacher');
    }
  }

  Future<void> deleteTeacher(int id) async {
    final response = await http.delete(Uri.parse('$baseUrl/$id'));
    if (response.statusCode != 204) {
      throw Exception('Failed to delete teacher');
    }
  }
}
