function solution(seoul) {
    // forEach 는 undefined를 반환
    // find 는 해당하는 요소
    // findIndex는 해당하는 요소의 인덱스
    // 단 find는 요소의 첫 번째를 가져온다.
    
    const idx = seoul.findIndex((ele) => ele === "Kim");
    const str =`김서방은 ${idx}에 있다`;
    return str;
}
