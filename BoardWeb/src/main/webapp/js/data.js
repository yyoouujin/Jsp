/**
 * 
 */


//배열선언
const myMembers = [
	{ id: 'user01', name: '채유진', phone: '010-9483-2184', point: 90 }, //new Object();
	{ id: 'user02', name: '이동건', phone: '010-4218-3158', point: 40 },
	{ id: 'user03', name: '정재민', phone: '010-4468-7113', point: 80 }

]; //new Array(); 배열선언


const json = `[{"id":1,"first_name":"Esra","last_name":"Dace","email":"edace0@google.cn","gender":"Male","salary":6267},
{"id":2,"first_name":"Mateo","last_name":"Ellsbury","email":"mellsbury1@accuweather.com","gender":"Male","salary":4280},
{"id":3,"first_name":"Ernesta","last_name":"Croot","email":"ecroot2@163.com","gender":"Female","salary":3104},
{"id":4,"first_name":"Hermann","last_name":"Sloper","email":"hsloper3@jiathis.com","gender":"Male","salary":7249},
{"id":5,"first_name":"Jordan","last_name":"Fipp","email":"jfipp4@google.pl","gender":"Male","salary":7930},
{"id":6,"first_name":"Burnard","last_name":"Hugnet","email":"bhugnet5@ning.com","gender":"Male","salary":6640},
{"id":7,"first_name":"Sib","last_name":"Pigny","email":"spigny6@gnu.org","gender":"Female","salary":4304},
{"id":8,"first_name":"Sorcha","last_name":"Gantzman","email":"sgantzman7@ucsd.edu","gender":"Female","salary":5953},
{"id":9,"first_name":"Leigha","last_name":"Pooly","email":"lpooly8@tumblr.com","gender":"Female","salary":4530},
{"id":10,"first_name":"Torrey","last_name":"Wikey","email":"twikey9@usnews.com","gender":"Male","salary":5236},
{"id":11,"first_name":"Boone","last_name":"L' Anglois","email":"blangloisa@livejournal.com","gender":"Male","salary":3368},
{"id":12,"first_name":"Valentijn","last_name":"Klement","email":"vklementb@sakura.ne.jp","gender":"Male","salary":7766},
{"id":13,"first_name":"Rianon","last_name":"Killford","email":"rkillfordc@soundcloud.com","gender":"Female","salary":5648},
{"id":14,"first_name":"Sophia","last_name":"Swatten","email":"sswattend@hhs.gov","gender":"Female","salary":5501},
{"id":15,"first_name":"Mandel","last_name":"Peegrem","email":"mpeegreme@cpanel.net","gender":"Male","salary":7621}]`

const employees = JSON.parse(json);