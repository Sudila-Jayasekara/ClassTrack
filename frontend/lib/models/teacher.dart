class Teacher {
  final int id;
  final String firstName;
  final String lastName;
  final String email;
  final String password;
  final String phone;

  Teacher({
    required this.id,
    required this.firstName,
    required this.lastName,
    required this.email,
    required this.password,
    required this.phone,
  });

  // Factory constructor to handle JSON
  factory Teacher.fromJson(Map<String, dynamic> json) {
    return Teacher(
      id: json['id'] ?? 0,  // Default value in case 'id' is null
      firstName: json['firstName'] ?? '',  // Default value for string
      lastName: json['lastName'] ?? '',
      email: json['email'] ?? '',
      password: json['password'] ?? '',
      phone: json['phone'] ?? '',
    );
  }

  // Convert Teacher instance back to JSON
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'firstName': firstName,
      'lastName': lastName,
      'email': email,
      'password': password,
      'phone': phone,
    };
  }
}
