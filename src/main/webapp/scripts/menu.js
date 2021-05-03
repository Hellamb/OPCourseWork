let menuElements = document.querySelectorAll('.menu-element-main')

menuElements.forEach(element=> element.addEventListener('click',openCloseMenu))

function openCloseMenu()
{
 let element = this.parentElement;
 if(element.getAttribute("extended") =="true")
 {
   element.lastChild.remove();
   element.setAttribute("extended","false");
 }
 else
 {
   let div = document.createElement('div');
   div.setAttribute("class","extendedMenuElement");
   div.innerHTML=
      "<button type='button' class='order-minus-button'>-</button>"+
      "<p class='menu-element-count-decor'>0</p>"+
      "<button type='button' class='order-plus-button'>+</button>";
   element.appendChild(div);
   element.setAttribute("extended","true");
   let count = element.getElementsByClassName('menu-element-count')[0].getAttribute('value')
   element.getElementsByClassName('menu-element-count-decor')[0].innerText = Number(count)
   element.getElementsByClassName('order-minus-button')[0].addEventListener('click',minusButtonFunc)
   element.getElementsByClassName('order-plus-button')[0].addEventListener('click',plusButtonFunc)
 }
}
function plusButtonFunc()
{
  let element = this.parentElement;
  let realCountElem = element.parentElement.getElementsByClassName('menu-element-count')[0];
  let fakeCountElem = element.getElementsByClassName('menu-element-count-decor')[0];
  let count = Number(realCountElem.getAttribute('value'));
  count++;
  realCountElem.setAttribute('value',count);
  fakeCountElem.innerText = count;

}
function minusButtonFunc()
{
 let element = this.parentElement;
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