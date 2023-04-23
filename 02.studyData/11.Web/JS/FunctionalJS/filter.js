export function filter(list, predicate){
    var new_list= [];
    for(var i =0; i<list.length;i++){
        if(predicate(list[i])) new_list.push(list[i]);
    }
    return new_list;
}

