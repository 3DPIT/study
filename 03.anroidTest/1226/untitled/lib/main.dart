import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

void main() {
  runApp(const MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
          appBar: AppBar(title: Text('앱임'),),
          body: Align(
            alignment: Alignment.bottomCenter,
            child: Container(
            width: double.infinity, height: 50, color: Colors.blue,
            ),
          ),
        )
    );
  }
}