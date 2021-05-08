let plusButtons = document.querySelectorAll('.order-plus-button')
let minusButtons = document.querySelectorAll('.order-minus-button')

plusButtons.forEach(element=> element.addEventListener('click',plusButtonFunc))
minusButtons.forEach(element=> element.addEventListener('click',minusButtonFunc))


function plusButtonFunc()
{
  let element = this.parentElement.parentElement;
  let realCountElem = element.parentElement.getElementsByClassName('menu-element-count')[0];
  let fakeCountElem = element.getElementsByClassName('menu-element-count-decor')[0];
  let count = Number(realCountElem.getAttribute('value'));
  count++;
  realCountElem.setAttribute('value',count);
  fakeCountElem.innerText = count;

}
function minusButtonFunc()
{
 let element = this.parentElement.parentElement;
 let realCountElem = element.parentElement.getElementsByClassName('menu-element-count')[0];
 let fakeCountElem = element.getElementsByClassName('menu-element-count-decor')[0];
 let count = Number(realCountElem.getAttribute('value'));
 if(count>0)
 {
  count--;
  realCountElem.setAttribute('value',count);
  fakeCountElem.innerText = count;
 }
}
