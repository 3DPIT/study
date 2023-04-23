export function map(list, iteratee){
    var new_list = [];
    for(var i =0; i<list.length;i++){
        new_list.push(iteratee(list[i]));
    }

    return new_list;
}