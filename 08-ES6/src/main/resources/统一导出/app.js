// import * as m1 from './module.js'
//
// console.log(m1.PI)
// console.log(m1.PI2)
// console.log(m1.sum(10, 20))
//
// let person = new m1.Person("张三", 10)
// person.sayHello()

import {PI, PI as pi, sum, Person} from './module.js'

console.log(PI)
console.log(pi)
console.log(sum(10, 20))

let person = new Person("张三", 10)
person.sayHello()