import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
          appBar: AppBar(),
          body: ListView(
            children: [
              UserItem(),
              UserItem(),
              UserItem(),
            ],
        ),
          bottomNavigationBar: BottomAppBar(
            child: Container(
              alignment: Alignment.center,
              width: 100,
               height: 50,
               child: Row(
                 mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                 children: [
               PhoneIcon(),
               MessageIcon(),
               AddIcon(),
                ],
               ),
          ),
         ),
      )
    );
  }
}

class UserItem extends StatelessWidget {
  const UserItem({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.all(5),
      child:Row(
        children: [
           Icon(Icons.account_box_rounded ),
           Text('홍길동'),
        ],
      ),
    );
  }
}

class PhoneIcon extends StatelessWidget {
  const PhoneIcon({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Icon(Icons.call);
  }
}

class MessageIcon extends StatelessWidget {
  const MessageIcon({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Icon(Icons.message);
  }
}

class AddIcon extends StatelessWidget {
  const AddIcon({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Icon(Icons.add_box_rounded);
  }
}
