import 'package:flutter/material.dart';
import 'package:frontend/const/constant.dart';
import 'package:frontend/data/side_menu_data.dart';

class SideMenuWidget extends StatefulWidget {
  //can change status over time
  const SideMenuWidget({super.key}); //constructor for sidemenu widget

  @override
  State<SideMenuWidget> createState() => _SideMenuWidgetState();
}

class _SideMenuWidgetState extends State<SideMenuWidget> {
  int selectedIndex = 0; //initialize selectedIndex to 0

  @override
  Widget build(BuildContext context) {
    final data = SideMenuData(); //create instance of SideMenuData
    return Container(
      padding: const EdgeInsets.symmetric(vertical: 50, horizontal: 20),
      child: ListView.builder(
        //create Scrollable list of widgets
        itemCount: data.menu.length, //number of items in the list
        itemBuilder: (context, index) => buildMenuEntry(data, index),
      ),
    );
  }

  Widget buildMenuEntry(SideMenuData data, int index) {
    final isSelected = selectedIndex == index; //check if index is selected

    return Container(
      margin: const EdgeInsets.only(bottom: 10),
      decoration: BoxDecoration(
        borderRadius: const BorderRadius.all(Radius.circular(6)),
        color: isSelected ? selectionColor : Colors.transparent,
      ),
      child: InkWell(
        onTap: () => setState(() => selectedIndex = index),
        child: Row(
          children: [
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 13, vertical: 7),
              child: Icon(
                data.menu[index].icon,
                color: isSelected ? Colors.black : Colors.grey,
              ),
            ),
            Text(data.menu[index].title,
                style: TextStyle(
                    fontSize: 16,
                    color: isSelected ? Colors.black : Colors.grey,
                    fontWeight: FontWeight.bold)),
          ],
        ),
      ),
    );
  }
}
