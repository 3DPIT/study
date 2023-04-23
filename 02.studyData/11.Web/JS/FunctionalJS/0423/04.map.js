import { users } from "./data.js";
import { filter } from "./filter.js";
import { map } from "./map.js";

//filter 사용

// 4
var users_under_30 = filter(users,function(user){return user.age<30});
console.log(users_under_30.length);

//[ 25, 28, 27, 24 ]
var ages = map(users_under_30,function(user){return user.age;});
console.log(ages);


//3
var users_over_30 = filter(users,function(user){return user.age>30});
console.log(users_over_30.length);


//[ 'ID', 'BJ', 'JM' ]
var names = map(users_over_30, function (user){return user.name;});
console.log(names);