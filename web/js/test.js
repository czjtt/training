/**
 * Created by czj on 2017/1/13.
 */
var k = 0;
var save = new Array();
var list = new Array();

for(var i=0;i<list.length;i++) {
    if (typeof save[k] !== 'undefined' && save[k].length > 0) {
        if (save[k][0].name == list[i].name) {
            save[k].push(list[i]);
        } else {
            k++;
            save[k] = new Array();
            save[k].push(list[i]);
        }
    }else{
        save[k] = new Array();
        save[k].push(list[i]);
    }
}