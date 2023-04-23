// import { users } from "./data.js";

import { users } from "./data.js";
import { filter } from "./filter.js";

// function filter(list, predicate) {
//   var newList = [];
//   for (var i = 0; i < list.length; i++) {
//     if (predicate(list[i])) newList.push(list[i]);
//   }

//   return newList;
// }

function log_length(value) {
  console.log(value);
  return value;
}

// function map(list, iteratee) {
//   var newList = [];
//   for (var i = 0; i < list.length; i++) {
//     newList.push(iteratee(list[i]));
//   }

//   return newList;
// }

// console.log(
//   log_length(
//     map(
//       filter(users, (u) => u.age < 30),
//       (u) => u.age
//     )
//   )
// );

// var ages = list => map(list, v=> v.age);
// var naems = list => map(list, v=>v.name);

// console.log(log_length(ages(filter(users, u=>u.age<30))));

// function bvalue(key){
//     return function(obj){
//         return obj[key];
//     }
// }
// var bbvalue =  key => list => map(list, v=>v[key]);

// bvalue('a')({a:'hi',b:'hello'});

// console.log(log_length(map(filter(users, function(user){return user.age<30}),
// bvalue('age')
// )))

// console.log(log_length(map(filter(users,function(user){return user.age>30}),
// bvalue('name'))))
function bvalue(key) {
  return function (obj) {
    return obj[key];
  };
}

var bvalue1 = (key) => (list) => map(list, (v) => v[key]);

function bvalue2(key) {
  return function (list) {
    return map(list, function (v) {
      return v[key];
    });
  };
}

function bvalue3(key) {
  var value = bvalue3(key);
  return function (list) {
    return map(list, value);
  };
}

var ages = bvalue("age");
var ages1 = bvalue1("age");
var ages2 = bvalue2("age");
//var ages3 = bvalue3('age');

var under_30 = function (u) {
  return u.age < 30;
};

console.log(log_length(ages(filter(users, under_30))));
