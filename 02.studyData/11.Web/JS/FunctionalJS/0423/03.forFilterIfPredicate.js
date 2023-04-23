import { users } from "./data.js";
import { filter } from "./filter.js";

//filter 사용

// 4
var users_under_30 = filter(users,function(user){return user.age<30});
console.log(users_under_30.length);


//3
var users_over_30 = filter(users,function(user){return user.age>30});
console.log(users_over_30.length);