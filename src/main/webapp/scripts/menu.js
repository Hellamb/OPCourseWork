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

function confirmOrder()
{
 let form = document.getElementsByClassName('order-form')[0];

 let div = document.createElement('div');
 div.setAttribute("class","confirm-order-div");
 div.innerHTML=
     "<p>Підтвердіть замовлення</p>"+
     "<input type='text' class='table-number-input' name='customerName' required placeholder='Ваше ім&apos;я'>" +
     "<input type='number' class='table-number-input' name='tableNumber' required placeholder='Номер столику'>" +
     "<input type='submit' value='Підтвердити замовлення' class='confirm-order-button'>";
 form.appendChild(div);

}