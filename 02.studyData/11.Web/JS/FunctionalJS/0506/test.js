//개선해보기 1
function updateTaxDom() {
  setTaxDom(shoppingCartTotal * 0.1);
}
//2
function updateTaxDom() {
  setTaxDom(clacTax());
}
function calcTax() {
  return shoppingCartTotal * 0.1;
}
//3

function updateTaxDom() {
  setTaxDom(calcTax(shoppingCartTotal));
}
function calcTax(amount) {
  return amount * 0.1;
} //이것을 결제팀이 사용 가능해짐

//개선해보기 2
function updateShoppingIcons() {
  var buyButtons = getBuyButtonsDom();
  for (var i = 0; i < buyButtons.length; i++) {
    var button = buyButtons[i];
    var item = button.item;
    if (item.price + shoppingCartTotal >= 20)
      //빼내려고 하는 비즈니스 규칙
      button.showFreeShippingIcon();
    else button.hideFreeShippingIcon();
  }
}

//직접 개선 해보기1
function updateShoppingIcons() {
  var buyButtons = getBuyButtonsDom();
  for (var i = 0; i < buyButtons.length; i++) {
    var button = buyButtons[i];
    var item = button.item;
    if (itemFinalCost())
      //빼내려고 하는 비즈니스 규칙
      button.showFreeShippingIcon();
    else button.hideFreeShippingIcon();
  }
}

function itemFinalCost() {
  return item.price + shoppingCartTotal >= 20;
}
//직접 개선해보기 2
function updateShoppingIcons() {
  var buyButtons = getBuyButtonsDom();
  for (var i = 0; i < buyButtons.length; i++) {
    var button = buyButtons[i];
    var item = button.item;
    if (itemFinalCost(item.price, shoppingCartTotal))
      //빼내려고 하는 비즈니스 규칙
      button.showFreeShippingIcon();
    else button.hideFreeShippingIcon();
  }
}

function itemFinalCost(itemPrice, amount) {
  return price + amount >= 20;
}

// 정답
//위와 거의 일치
function updateShoppingIcons() {
  var buyButtons = getBuyButtonsDom();
  for (var i = 0; i < buyButtons.length; i++) {
    var button = buyButtons[i];
    var item = button.item;
    if (getsFreeShipping(item.price, shoppingCartTotal))
      //빼내려고 하는 비즈니스 규칙
      button.showFreeShippingIcon();
    else button.hideFreeShippingIcon();
  }
}

function getsFreeShipping(itemPrice, total) {
  return price + total >= 20;
}

//93p
function addItemToCart(name, price) {}
function calcCartTotal(cart) {
  const total = calcTotal(cart);
  setCartTotalDom(total);
  updateShippingIcons(cart);
  updateTaxDom(total);
}

function setCartTotalDom(total) {}

function updateTaxDom(total) {
  setTaxDom(calcTax(total));
}

//계산 분류
/*
 C : cart에 대한 동작
 I : item에 대한 동작
 B : 비즈니스 규칙
 A : 배열 유틸리티
 */
function addElementLast(array, elem) { //A
  var newArray = array.slice();
  newArray.push(elem);
  return newArray;
}

function addItem(cart, item) { //C
  return addElementLast(cart, item);
}

function makeCartItem(name, price) { //I
  return {
    naem: name,
    price: price,
  };
}

function clacTotal(cart) { // C I B
  var total = 0;
  for (var i = 0; i < cart.length; i++) {
    var item = cart[i];
    total += item.price;
  }
  return total;
}

function getsFreeShipping(cart) { // B
  return calcTotal(cart) >= 20;
}
function calcTax(amount) { // B
  return amount * 0.1;
}

//작은 함수와 많은 계산
/*
A : 액션
C : 계산
D : 데이터
*/

var shoppingCart = []; //A

function addItemToCart(name, price){
    var item = makeCartItem(name, price);
    shoppingCart = addItem(shoppingCart, item); //A
    var total = clacTotal(shoppingCart);
    setCartTotalDom(total);
    updateShippingIcons(shoppingCart);
    updateTaxDom(total);
}

function updateShippingIcon(cart){
    var buttons = getBuyButtonsDom();
    for(var i =0; i< buttons.length;i++){
        var button  = buttons[i];
        var item = button.item;
        var newCart = addItem(cart,item);
        if(getsFreeShipping(new cart))
            button.showFreeShippingIcon(); //A
        else 
            button.hideFreeShippingIcon();
    }
}

function updateTaxDom(total){
    setTaxDom(calcTax(total)); //A
}

function addElementLast(array, elem){
    var newArray = array.slice();
    newArray.push(elem); //C
    return newArray;
}

function addItem(cart, item){
    return addElementLast(cart, item); //C
}

function makeCartItem(name, price){ 
    return {
        name: name, // C
        price: price
    };
}

function clacTotal(cart){
    var total = 0;
    for(var i =0;i<cart.length;i++){
        var item = cart[i]; // C
        total += item.price;
    }
}

function getsFreeShipping(cart){
    return calcTotal(cart) >= 20; //C
}

function calcTax(amount){
    return amount * 0.10; // C
}

