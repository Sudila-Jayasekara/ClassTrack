import 'package:flutter/material.dart';
import 'package:frontend/widgets/activity_details_card.dart';
import 'package:frontend/widgets/header_widget.dart';

class DashbordWidget extends StatefulWidget {
  const DashbordWidget({super.key});

  @override
  State<DashbordWidget> createState() => _DashbordWidgetState();
}

class _DashbordWidgetState extends State<DashbordWidget> {
  @override
  Widget build(BuildContext context) {
    return const Column(
      children: [
         SizedBox(height: 20),
         HeaderWidget(),
         SizedBox(height: 20),
         ActivityDetailsCard(),

      ],
    );
  }
}