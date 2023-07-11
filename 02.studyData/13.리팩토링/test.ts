// enum TrafficLight {
//   RED,
//   YELLOW,
//   GREEM,
// }

// const CYCLE = [TrafficLight.RED, TrafficLight.YELLOW, TrafficLight.GREEM];

// function updateCarForLight(current: TrafficLight) {
//   if (current === TrafficLight.RED) {
//     car.stop();
//   } else car.drive();
// }

// interface TrafficLight2 {
//   isRed(): boolean;
//   isYellow(): boolean;
//   isGreen(): boolean;
// }
// class Red implements TrafficLight2{
//     isRed(){return true;}
//     isYellow(){return false;}
//     isGreen(){return false;}
// }

// class Yellow implements TrafficLight2{
//     isRed(){return false;}
//     isYellow(){return true;}
//     isGreen(){return false;}
// }

// class Green implements TrafficLight2{
//     isRed(){return false;}
//     isYellow(){return false;}
//     isGreen(){return true;}
// }

// class Right implements Input{
//     //...
//     handleInput(){
//         if(this.isLeft())
//             moveHorizontal(-1);
//         else if (this.isRight())
//             moveHorizontal(1);
//         else if (this.isUp())
//             moveVertical(-1)
//         else if(this.isDown())
//             moveVertical(1)
//     }
// }

//새로운 인터페이스
// interface Input{
//     handle():void
// }

// class Right implements Input{
//     //...
//     handleInput(){
//         moveHorizontal(1);
//     }
// }

// class Right implements Input{
//     //...
//     handle(){
//         moveHorizontal(1);
//     }
// }

// function handleInput(input:Input){
//     input.handle();
// }

// 리팩터링 패턴
interface TrafficLight{
    isRed():boolean
    isYellow():boolean
    isGreen():boolean

    updateCar(): boolean
}

// class Red implements TrafficLight{
//     isRed() {return true;}
//     isYello() {return false;}
//     isGreen(){return false;} 
// }

// class Red implements TrafficLight{

//     updateCarForLight(){
//         if(this.isRed()) car.stop();
//         else car.drive();
//     }
// }
class Red implements TrafficLight{
    updateCar(){car.stop();}
}


// class Yellow implements TrafficLight{
//     isRed() {return false;}
//     isYello() {return true;}
//     isGreen(){return false;} 
// }

// class Yellow implements TrafficLight{

//     updateCarForLight(){
//         if(this.isYellow()) car.stop();
//         else car.drive();
//     }
// }

class Yellow implements TrafficLight{
    updateCar(){car.drive();}
}


// class Green implements TrafficLight{
//     isRed() {return false;}
//     isYello() {return false;}
//     isGreen(){return true;} 
// }
// class Green implements TrafficLight{

//     updateCarForLight(){
//         if(this.isGreen()) car.stop();
//         else car.drive();
//     }
// }

class Green implements TrafficLight{
    updateCar(){car.drive();}
}
// function updateCarForLight (current: TrafficLight){
//     if(current.isRed())
//         car.stop();
//     else   
//         car.drive();
// }

function updateCarForLight(current: TrafficLight){
    current.updateCar();
}


function transfer( from: string, to:string, amount:number){
    deposit(from, -amount);
    deposit(to,amount);
}

function transfer(from : string, to : string , amount: number){
    let fromAccountId = database.find(from);
    database.updateOne(fromAccountId,
    {$inc: {balance: -amount}};
    
    let toAcoountId = database.find(to);
    database.updateOne(toAccountId,
        {$inc: {balance:amount}});
}