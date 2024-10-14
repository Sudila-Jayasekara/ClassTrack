import 'package:flutter/material.dart';
import 'package:frontend/models/menu_model.dart';

class SideMenuData {
  final menu = const <MenuModel>[
    MenuModel(icon: Icons.home, title: 'Dashboard'),
    MenuModel(icon: Icons.person, title: 'Profile'),
    MenuModel(icon: Icons.settings, title: 'Settings'),
    MenuModel(icon: Icons.notifications, title: 'Notifications'),
    MenuModel(icon: Icons.history, title: 'History'),
    MenuModel(icon: Icons.help, title: 'Help'),
  ];
}
