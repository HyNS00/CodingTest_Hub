const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim();

function solution(str) {
    let tmp = str.toLowerCase();
    const countAlpha = {};

    // 각 알파벳의 빈도를 계산
    for (let char of tmp) {
        if (!countAlpha[char]) {
            countAlpha[char] = 0;
        }
        countAlpha[char]++;
    }

    let maxChar = '';
    let maxCount = 0;
    let isTie = false;
    
    // 최대 빈도수와 그 알파벳을 찾기
    for (let char in countAlpha) {
        if (countAlpha[char] > maxCount) {
            maxChar = char;
            maxCount = countAlpha[char];
            isTie = false;
        } else if (countAlpha[char] === maxCount) {
            isTie = true;
        }
    }

    // 동률인지 체크하여 결과 반환
    return isTie ? '?' : maxChar.toUpperCase();
}

console.log(solution(input));