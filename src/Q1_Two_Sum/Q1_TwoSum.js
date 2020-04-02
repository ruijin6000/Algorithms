console.log("test");
//
// let twoSum = function(nums, target) {
//     for( let i= 0; i <nums.length; i++) {
//         for(let j=i+1; j<nums.length; j++) {
//             if(nums[i] +nums[j] == target) {
//                 return [i,j] ;
//             }
//         }
//     }
//     return null;
// };

const twoSum = (nums, target) => {
    const map = {};

    for (let i = 0; i < nums.length; i++) {
        const another = target - nums[i];

        if (another in map) {
            return [map[another], i];
        }

        map[nums[i]] = i;

    }
   console.log(map);
    return null;
};


const twoSum2 = function(nums, target) {
    let map = new Map;
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (map.has(complement)) {
            return [map.get(complement), i]
        }
        map.set(nums[i], i);
    }
    map.
    console.log(map);
};



let nums = [2,7,11,5];
console.log(twoSum2(nums,100));
