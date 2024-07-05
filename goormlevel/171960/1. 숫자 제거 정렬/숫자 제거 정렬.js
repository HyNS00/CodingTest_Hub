// Run by Node.js
const readline = require('readline');
function solution(n,data){
	data = [...new Set(data)];
	data.sort((a,b) => Number(a) - Number(b));
	console.log(data.join(" ").concat('\n'));
}
(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let input = [];
	for await (const line of rl) {
		input.push(line.trim());
	}
	rl.close();
	let N = +input[0];
	let data = input[1].split(' ').map(Number);
	solution(N,data);
	process.exit();
})();
