import 'package:flutter/material.dart';
import 'package:frontend/const/constant.dart';

class CustomCard extends StatelessWidget {
  final Widget child;
  final Color? color;
  final EdgeInsetsGeometry? padding;

  const CustomCard({super.key, required this.child, this.color, this.padding});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        borderRadius: const BorderRadius.all(Radius.circular(10)),
        color: color ?? cardBackgroundColor,
      ),
      child: Padding(padding: padding ?? const EdgeInsets.all(12), child: child),
    );
  }
}