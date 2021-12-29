import 'package:flutter/material.dart';

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
          body: Container(
            height: 150,
            padding: EdgeInsets.all(10),
            child: Row(
              children: [
                Image.asset('youtube.jpg',width:150,),
               Expanded(child: Container(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('카메라 팜',),
                      Text('금호동 3가'),
                      Text('7000원'),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.end,
                        children: [
                          Icon(Icons.favorite),
                          Text('4'),
                        ],
                      )
                    ],
                  ),
                )
               )
              ],
            ),
          )
        )
    );
  }
}