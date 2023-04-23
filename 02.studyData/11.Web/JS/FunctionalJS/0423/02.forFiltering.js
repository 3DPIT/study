import { users } from "./data.js";

// 4
var temp_user = [];
for (var i = 0; i < users.length; i++) {
  if (users[i].age < 30) temp_user.push(users[i]);
}

console.log(temp_user.length);

// [ 25, 28, 27, 24 ]
var ages = [];
for (var i = 0; i < temp_user.length; i++) {
  ages.push(temp_user[i].age);
}

console.log(ages);

// 3
var temp_users = [];
for (var i = 0; i < users.length; i++) {
  if (users[i].age >= 30) temp_users.push(users[i]);
}

console.log(temp_users.length);

// [ 'ID', 'BJ', 'JM' ]
var names = [];
for (var i = 0; i < temp_users.length; i++) {
  names.push(temp_users[i].name);
}

console.log(names);
