

'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/* Complete the 'doubleSize' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. LONG_INTEGER_ARRAY arr
 *  2. LONG_INTEGER b
 */

/*
Note: Maximum value of b when sorted in ascending order BUT this
means we need a comparator type function like in Java for numbers
otherwise we can't guarantee ascending order because they are treated like String values!
*/

function doubleSize(arr, b) {
    // Write your code here
    arr.sort((a, b) => {return a-b});
    for(let i = 0; i < arr.length; i++) {
        if(arr[i] == b) {
           b = 2*b;
        }
    }
    return b;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const arrCount = parseInt(readLine().trim(), 10);

    let arr = [];

    for (let i = 0; i < arrCount; i++) {
        const arrItem = parseInt(readLine().trim(), 10);
        arr.push(arrItem);
    }

    const b = parseInt(readLine().trim(), 10);

    const result = doubleSize(arr, b);

    ws.write(result + '\n');

    ws.end();
}

