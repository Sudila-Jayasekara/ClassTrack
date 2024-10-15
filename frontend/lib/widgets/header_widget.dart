import 'package:flutter/material.dart';
import 'package:frontend/const/constant.dart';

class HeaderWidget extends StatelessWidget {
  const HeaderWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return const TextField(
      decoration: InputDecoration(
        filled: true,
        fillColor: cardBackgroundColor,
        enabledBorder: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.transparent),
          borderRadius: BorderRadius.all(Radius.circular(10)),
        ),
        border: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.transparent),
          borderRadius: BorderRadius.all(Radius.circular(10)),
        ),
        focusedBorder: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.transparent),
          borderRadius: BorderRadius.all(Radius.circular(10)),
        ),
        contentPadding: EdgeInsets.symmetric(
          vertical: 5,
        ),
        hintText: 'Search',
        prefixIcon: Icon(
          Icons.search,
          color: Colors.grey,
          size: 21,
        ),
      ),
    );
  }
}
